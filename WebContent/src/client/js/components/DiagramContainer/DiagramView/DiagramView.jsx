import React, { useState, useEffect, useRef } from "react";
import { useSelector, useDispatch } from "react-redux";
import ReactDOM from "react-dom";
import $ from "jquery";
import Shapes from "JOINT/Shapes";
import joint from "jointjs/index";
import { getSelectedDrill, getSelectedTask, editCoordinates } from "REDUX";
import { API } from "UTILITIES";

import "./DiagramView.scss";

const DiagramView = ({ diagram, graph }) => {
	const diagramViewElement = useRef(null);

	let activeElement = {};

	const selectedDrill = useSelector(getSelectedDrill);
	const selectedTask = useSelector(getSelectedTask);
	const dispatch = useDispatch();

	let paper;
	const paperRef = useRef(paper);

	useEffect(() => {
		if (typeof paper === "undefined") {
			paperRef.current = new joint.dia.Paper({
				el: ReactDOM.findDOMNode(diagramViewElement.current),
				model: graph,
				width: document.documentElement.clientWidth,
				height: document.documentElement.clientHeight,
				background: {
					color: "rgb(200,200,200)"
				},
				restrictTranslate: true
			});
			setupEventHandlers();
			window.addEventListener("resize", resizeWindowHandler);
		}

		if (selectedDrill !== null || typeof selectedDrill !== "undefined") {
			diagram.createBattleDrill(selectedDrill, selectedTask);
		}

		resizeWindowHandler();

		return () => {
			window.removeEventListener("resize", resizeWindowHandler);
			paperRef.current.off("element:mouseenter");
			paperRef.current.off("element:mouseleave");
			paperRef.current.off("blank:pointerup");
			paperRef.current.off("element:pointerdblclick");
			graph.off("change:position");
		};
	}, [selectedDrill, selectedTask]);

	const resizeWindowHandler = () => {
		const { clientWidth, clientHeight } = document.documentElement;
		paperRef.current.setDimensions(clientWidth, clientHeight);
	};

	const setupEventHandlers = () => {
		let tempPosition;
		let lastElementInteracted = null;

		paperRef.current.on("element:mouseenter", (element) => {
			// hide the icon of the last visited role element
			if (lastElementInteracted !== null) {
				const editRoleIcon = lastElementInteracted.$box.find("span.role-title").find("i.edit-role-icon");
				editRoleIcon.css("display", "none");
			}

			// set the current element being hovered over to the current
			lastElementInteracted = element;

			// get the dom element of the current
			const editRoleIcon = element.$box.find("span.role-title").find("i.edit-role-icon");

			// show the edit icon on hover
			editRoleIcon.css("display", "inline");

			// on hover, enable pointer events
			editRoleIcon.hover(() => {
				editRoleIcon.css("display", "inline");
				element.$box.find("div.role-container").css("pointer-events", "auto");
			});
		});

		// hide the edit icon when leaving element
		paperRef.current.on("element:mouseleave", (element) => {
			const editRoleIcon = element.$box.find("span.role-title").find("i.edit-role-icon");
			editRoleIcon.css("display", "none");
			element.$box.find("div.role-container").css("pointer-events", "auto");
		});

		// hide the edit of last element hovered if clicking on the blank area of diagram
		paperRef.current.on("blank:pointerup", () => {
			if (lastElementInteracted !== null) {
				const editRoleIcon = lastElementInteracted.$box.find("span.role-title").find("i.edit-role-icon");
				editRoleIcon.css("display", "none");
			}
		});

		paperRef.current.on("element:pointerdblclick", (element) => {
			if (typeof activeElement.model === "undefined") {
				activeElement = element;
			}

			// remove current active element outline
			if (activeElement.id !== element.id) {
				activeElement.model.attr("body/filter", {
					name: "outline",
					args: {
						color: "green",
						width: 0,
						opacity: 0,
						margin: 0
					}
				});

				// set new active element
				activeElement = element;
			}

			// highlight new element double clicked
			if (typeof activeElement.model !== "undefined") {
				activeElement.model.attr("body/filter", {
					name: "outline",
					args: {
						color: "green",
						width: 3,
						opacity: 1,
						margin: 3
					}
				});
			}

			// TODO: clicking on a role will only display that roles tree
		});

		// we need to use the position that is tracked here in the element in the listener for element:pointerup
		graph.on("change:position", (element, position) => {
			tempPosition = position;
		});

		paperRef.current.on("element:mouseenter", (element) => {
			const elementClass = element.$box.attr("class");
			if (elementClass === "action-items-container") {
				element.$box.css("z-index", 999999);
				element.$box.children().css("z-index", 999999);
			} else {
				element.$box.css("z-index", 999999);
				element.$box.children().css("z-index", 999999);
			}
		});

		paperRef.current.on("element:mouseleave", (element) => {
			const elementClass = element.$box.attr("class");
			if (elementClass === "action-items-container") {
				element.$box.css("z-index", 2);
				element.$box.children().css("z-index", 2);
			} else {
				element.$box.css("z-index", 3);
				element.$box.children().css("z-index", 3);
			}
		});

		// using x and y parameters here refers to the pointer, which we do not want. we want the position of the element
		// which does not have exclusive variables for x and y, unless you extract them from a transform string which is too hacky.
		paperRef.current.on("element:pointerup", (element) => {
			// TODO: disable diagram, show a loading wheel to block it off until the API request is complete.
			if (typeof tempPosition === "undefined") {
				return;
			}

			const { roleId, coordinateType } = element.model.get("attrs").diagramData;
			const requestBody = {
				drillId: selectedDrill.id,
				roleId,
				coordinateType,
				x: tempPosition.x,
				y: tempPosition.y
			};
			// need to update the diagram coords in reducer
			API.updateDiagramCoordinates(requestBody, () => {
				dispatch(editCoordinates(roleId, coordinateType, { x: tempPosition.x, y: tempPosition.y }));
			});
		});
	};

	return (
		<div className="diagram-view">
			<div className="diagram" id="diagram" ref={diagramViewElement} />
		</div>
	);
};

export default DiagramView;
