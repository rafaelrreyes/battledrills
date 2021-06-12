import React, { useEffect, useRef } from "react";
import { useSelector, useDispatch } from "react-redux";
import ReactDOM from "react-dom";
import $ from "jquery";
import Shapes from "JOINT/Shapes";
import joint from "jointjs/index";

import {
	getSelectedTemplate,
	getSelectedTaskTemplate,
	getPastEdits,
	editRoleCoordinatesTemplate,
	editTaskCoordinatesTemplate
} from "REDUX";

import "./TemplateEditorDiagram.scss";

const DiagramDefaults = {
	GRID_SIZE: 10,
	GRID_OPTIONS: {
		thickness: 2,
		color: "rgb(125, 125, 125)"
	}
};

const TemplateEditorDiagram = ({ diagram, graph, isGridEnabled = false }) => {
	const diagramViewElementz = useRef(null);

	// need to set the paper to a ref to persist the paper through renders
	let paper;
	const paperRef = useRef(paper);

	let activeElement = {};

	const selectedTemplate = useSelector(getSelectedTemplate);
	const selectedTaskTemplate = useSelector(getSelectedTaskTemplate);
	const past = useSelector(getPastEdits);
	const dispatch = useDispatch();

	useEffect(() => {
		if (typeof paper === "undefined") {
			paperRef.current = new joint.dia.Paper({
				el: ReactDOM.findDOMNode(diagramViewElementz.current),
				model: graph,
				width: document.documentElement.clientWidth,
				height: document.documentElement.clientHeight,
				gridSize: DiagramDefaults.GRID_SIZE,
				drawGrid: isGridEnabled ? DiagramDefaults.GRID_OPTIONS : false,
				background: {
					color: "rgb(200, 200, 200)"
				},
				restrictTranslate: true
			});

			setupEventHandlers();
			window.addEventListener("resize", resizeWindowHandler);
		}

		if (selectedTemplate !== null || typeof selectedTemplate !== "undefined") {
			diagram.createBattleDrill(selectedTemplate, selectedTaskTemplate, true);
		}

		return () => {
			window.removeEventListener("resize", resizeWindowHandler);
			paperRef.current.off("element:mouseenter");
			paperRef.current.off("element:mouseleave");
			paperRef.current.off("element:pointerup");
			graph.off("change:position");
		};
	}, [selectedTemplate, selectedTaskTemplate]);

	useEffect(() => {
		if (selectedTemplate !== null || typeof selectedTemplate !== "undefined") {
			diagram.createBattleDrill(selectedTemplate, selectedTaskTemplate, true);
		}
	}, [past]);

	useEffect(() => {
		if (typeof paperRef.current !== "undefined") {
			if (!isGridEnabled) {
				paperRef.current.clearGrid();
			} else {
				paperRef.current.drawGrid(DiagramDefaults.GRID_OPTIONS);
			}
		}
	}, [isGridEnabled]);

	const resizeWindowHandler = () => {
		const { clientWidth, clientHeight } = document.documentElement;
		paperRef.current.setDimensions(clientWidth, clientHeight);
	};

	const setupEventHandlers = () => {
		let tempPosition;
		let lastElementInteracted = null;

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

		graph.on("change:position", (element, position) => {
			tempPosition = position;
		});

		paperRef.current.on("element:pointerup", (element) => {
			// TODO disable diagram, show a loading wheel to block it off until the API request is complete

			if (typeof tempPosition === "undefined") {
				return;
			}

			const { roleId, coordinateType } = element.model.get("attrs").diagramData;

			if (coordinateType === "self") {
				dispatch(editRoleCoordinatesTemplate(roleId, { x: tempPosition.x, y: tempPosition.y }));
			} else {
				dispatch(editTaskCoordinatesTemplate(roleId, { x: tempPosition.x, y: tempPosition.y }));
			}
		});
	};

	return (
		<div className="diagram-view">
			<div className="diagram" id="templateDiagram" ref={diagramViewElementz} />
		</div>
	);
};

export default TemplateEditorDiagram;
