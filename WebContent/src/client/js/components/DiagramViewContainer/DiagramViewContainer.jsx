import React, { useState, useEffect, useRef } from "react";
import { useSelector, useDispatch } from "react-redux";
import ReactDOM from "react-dom";
import joint from "jointjs/index";
import Shapes from "../../joint/Shapes";
import BattleDrillDiagram from "../../joint/BattleDrillDiagram";
import "./DiagramViewContainer.scss";
import "./joint.css";
import { getSelectedDrill, getSelectedTask, editCoordinates } from "REDUX/";
import { API } from "UTILITIES/index";

const DEFAULTS = {
	GRID_SIZE: 1,
	WINDOW_WIDTH: 1920, // works for now
	WINDOW_HEIGHT: 1080 // works for now
};

const DiagramViewContainer = () => {
	const diagramViewElement = useRef(null);
	const [width, setWidth] = useState(DEFAULTS.WINDOW_WIDTH); // can set the width/height of the paper and graph in later features
	const [height, setHeight] = useState(DEFAULTS.WINDOW_HEIGHT);

	let activeElement = {};

	const selectedDrill = useSelector(getSelectedDrill);
	const selectedTask = useSelector(getSelectedTask);
	const dispatch = useDispatch();

	const graph = new joint.dia.Graph();
	const battleDrillDiagram = new BattleDrillDiagram(graph);

	let paper;

	useEffect(() => {
		if (typeof paper === "undefined") {
			paper = new joint.dia.Paper({
				el: ReactDOM.findDOMNode(diagramViewElement.current),
				model: graph,
				width,
				height,
				gridSize: DEFAULTS.GRID_SIZE,
				background: {
					color: "rgb(200,200,200)"
				},
				restrictTranslate: true
			});

			setupEventHandlers();
		}

		if (selectedDrill !== null || typeof selectedDrill !== "undefined") {
			battleDrillDiagram.createBattleDrill(selectedDrill, selectedTask);
		}
	}, [selectedDrill, selectedTask]);

	useEffect(() => {
		// in future, if width or height is changed, we can change the width of the rendering area, hence the width and height being
		// dependencies in the useEffect hook
		paper.setDimensions(width, height);
	}, [width, height]);

	const setupEventHandlers = () => {
		let tempPosition;

		paper.on("element:pointerdblclick", (element) => {
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

		// using x and y parameters here refers to the pointer, which we do not want. we want the position of the element
		// which does not have exclusive variables for x and y, unless you extract them from a transform string which is too hacky.
		paper.on("element:pointerup", (element) => {
			// TODO: disable diagram, show a loading wheel to block it off until the API request is complete.
			if (typeof tempPosition === "undefined") {
				return;
			}

			const { owner, coordinateType } = element.model.get("attrs").diagramData;
			const requestBody = {
				battleDrillName: selectedDrill.name,
				owner,
				coordinateType,
				x: tempPosition.x,
				y: tempPosition.y
			};
			// need to update the diagram coords in reducer
			API.updateDiagramCoordinates(requestBody, () => {
				dispatch(editCoordinates(owner, coordinateType, { x: tempPosition.x, y: tempPosition.y }));
			});
		});
	};

	return (
		<div className="diagram-view-div">
			<div className="diagram" id="diagram" ref={diagramViewElement} />
		</div>
	);
};

export default DiagramViewContainer;
