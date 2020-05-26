import { ShapesConstants } from "./ShapesHelper";
import { CoordinateTypes } from "UTILITIES";
import { getLinkStyle, getLinkSmoothness } from "REDUX";
import joint from "jointjs/";
import store from "REDUX/store";

export default class BattleDrillElements {
	constructor() {
		this.elements = [];
		this.links = [];
	}

	/**
	 * Creates and adds a contributor diagram element. A contributor is an officer or unique role in the context of Battle Drills.
	 * @param {Object} data
	 * @returns {Object} contributor element object
	 */
	addContributorRectangle(data = {}) {
		if (typeof data.title === "undefined") {
			return;
		}
		const width = data.title.length * ShapesConstants.CONTRIBUTOR_WIDTH_MULTIPLIER + 25;
		const height = ShapesConstants.CONTRIBUTOR_HEIGHT;
		const { self_coordinates } = data;

		const contributorRect = new joint.shapes.html.OwnerBlock({
			size: {
				width,
				height
			},
			attrs: {
				title: data.title,
				diagramData: {
					owner: data.title,
					coordinateType: CoordinateTypes.SELF,
					isTemplate: data.isTemplate
				},
				// removes the default square
				body: {
					strokeWidth: 0
				}
			}
		});

		if (self_coordinates) {
			if (typeof self_coordinates.x !== "undefined" && typeof self_coordinates.y !== "undefined") {
				contributorRect.position(self_coordinates.x, self_coordinates.y);
			}
		}

		this.elements.push(contributorRect);
		return contributorRect;
	}

	/**
	 * Creates and adds a tasks diagram element which is made up of an array of tasks. These are the tasks associated with each officer or contributor
	 * in the context of Battle Drills.
	 * @param {Array} tasks
	 * @returns {Object} tasks element object
	 */
	addTaskItemsBlock(
		ownerNode,
		tasks = [],
		tasks_coordinates = { x: 0, y: 0 },
		selectedTask = {},
		isTemplate = false
	) {
		if (tasks.length === 0) {
			return null;
		}

		const taskBlock = new joint.shapes.html.ActionBlock({
			size: {
				width: ShapesConstants.ACTION_BLOCK_WIDTH,
				height: ShapesConstants.ACTION_BLOCK_HEIGHT
			},
			attrs: {
				list: tasks,
				selectedTask,
				body: {
					strokeWidth: 0
				},
				diagramData: {
					owner: ownerNode.get("attrs").diagramData.owner,
					coordinateType: CoordinateTypes.TASKS,
					isTemplate
				}
			}
		});

		if (tasks_coordinates) {
			if (typeof tasks_coordinates.x !== "undefined" && typeof tasks_coordinates.y !== "undefined") {
				taskBlock.position(tasks_coordinates.x, tasks_coordinates.y);
			}
		}

		this.elements.push(taskBlock);
		return taskBlock;
	}

	/**
	 * Creates a default solid link relationship line between two nodes, usually a contributor to contributor.
	 * @param {Object} node1
	 * @param {Object} node2
	 * @returns {Object} link element object
	 */
	createLink(node1, node2) {
		const linkStyle = getLinkStyle(store.getState()).toLowerCase();
		const linkSmoothness = getLinkSmoothness(store.getState()).toLowerCase();
		const link = new joint.shapes.standard.Link({
			source: node1,
			target: node2,
			router: {
				name: linkStyle,
				args: {
					startDirections: ["bottom", "right", "left"],
					endDirections: ["top", "right", "left"]
				}
			}
		});
		link.connector(linkSmoothness);

		this.links.push(link);
		return link;
	}

	/**
	 * Creates a task link relationship between a contributor to tasks block.
	 * @param {*} node1
	 * @param {*} node2
	 */
	createTaskLink(node1, node2) {
		const linkStyle = getLinkStyle(store.getState()).toLowerCase();
		const linkSmoothness = getLinkSmoothness(store.getState()).toLowerCase();
		const taskLink = new joint.shapes.standard.Link({
			source: node1,
			target: node2,
			router: {
				name: linkStyle,
				args: {
					startDirections: ["bottom"],
					endDirections: ["top", "left", "right"]
				}
			}
		});

		taskLink.connector(linkSmoothness);

		// taskLink.attr({
		//     line: {
		//         stroke: 'gray',
		//         strokeWidth: 3,
		//         strokeDasharray: '5 5'
		//     }
		// })

		this.links.push(taskLink);
		return taskLink;
	}

	resetData() {
		this.elements = [];
		this.links = [];
	}

	getElements() {
		return this.elements;
	}

	getLinks() {
		return this.links;
	}
}
