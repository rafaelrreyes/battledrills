import React, { useState, useEffect, useRef } from "react";
import { useSelector, useDispatch } from "react-redux";
import ReactDOM from "react-dom";

import $ from "jquery";
import Shapes from "../../../joint/Shapes";
import "./TemplateEditorDiagram.scss";
import joint from "jointjs/index";

import {
	getSelectedTemplate,
	getSelectedTaskTemplate,
	getPastEdits,
	editRoleCoordinatesTemplate,
	editTaskCoordinatesTemplate
} from "REDUX";

// TODO move this to another directory also change it in DiagramViewContainer
// import "./joint.css";

// TODO change this
const DEFAULTS = {
	GRID_SIZE: 1,
	WINDOW_WIDTH: 1920,
	WINDOW_HEIGHT: 1080
};

const TemplateEditorDiagram = ({ diagram, graph }) => {
	const diagramViewElementz = useRef(null);

	const [width, setWidth] = useState(DEFAULTS.WINDOW_WIDTH);
	const [height, setHeight] = useState(DEFAULTS.WINDOW_HEIGHT);

	let activeElement = {};

	const selectedTemplate = useSelector(getSelectedTemplate);
	const selectedTaskTemplate = useSelector(getSelectedTaskTemplate);
	const past = useSelector(getPastEdits);
	const dispatch = useDispatch();

	let paper;

	useEffect(() => {
		if (typeof paper === "undefined") {
			paper = new joint.dia.Paper({
				el: ReactDOM.findDOMNode(diagramViewElementz.current),
				model: graph,
				width,
				height,
				gridSize: DEFAULTS.GRID_SIZE,
				background: {
					color: "rgb(200, 200, 200)"
				},
				restrictTranslate: true
			});
			setupEventHandlers();
		}

		if (selectedTemplate !== null || typeof selectedTemplate !== "undefined") {
			diagram.createBattleDrill(selectedTemplate, selectedTaskTemplate, true);
		}

		return () => {
			// TODO unbind events
			paper.off("element:mouseenter");
			paper.off("element:mouseleave");
			paper.off("element:pointerup");
		};
	}, [selectedTemplate, selectedTaskTemplate]);

	useEffect(() => {
		if (selectedTemplate !== null || typeof selectedTemplate !== "undefined") {
			diagram.createBattleDrill(selectedTemplate, selectedTaskTemplate, true);
		}
	}, [past]);

	const setupEventHandlers = () => {
		let tempPosition;
		let lastElementInteracted = null;

		paper.on("element:mouseenter", (element) => {
			const elementClass = element.$box.attr("class");
			if (elementClass === "action-items-container") {
				element.$box.css("z-index", 999999);
				element.$box.children().css("z-index", 999999);
			} else {
				element.$box.css("z-index", 999999);
				element.$box.children().css("z-index", 999999);
			}
		});

		paper.on("element:mouseleave", (element) => {
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

		paper.on("element:pointerup", (element) => {
			// TODO disable diagram, show a loading wheel to block it off until the API request is complete

			if (typeof tempPosition === "undefined") {
				return;
			}

			const { owner, coordinateType } = element.model.get("attrs").diagramData;

			if (coordinateType === "self") {
				dispatch(editRoleCoordinatesTemplate(owner, { x: tempPosition.x, y: tempPosition.y }));
			} else {
				dispatch(editTaskCoordinatesTemplate(owner, { x: tempPosition.x, y: tempPosition.y }));
			}
		});
	};

	return (
		<div className="diagram-view-div">
			<div className="diagram" id="templateDiagram" ref={diagramViewElementz} />
		</div>
	);
};

export default TemplateEditorDiagram;
