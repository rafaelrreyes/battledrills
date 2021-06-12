import joint from "jointjs/index";
import BattleDrillElements from "./BattleDrillElements";
import "./diagram.scss";

export default class BattleDrillDiagram {
	constructor(graph) {
		this.graph = graph;
		this.cells = [];
		this.battleDrillElements = new BattleDrillElements();
	}

	/**
	 * Creates an entirely new battle drill from scratch by first removing the existing one in the jointjs paper.
	 * @param {Object} selectedDrill
	 * @param {Object} selectedTask
	 * @param {boolean} isTemplate
	 */
	createBattleDrill(selectedDrill = null, selectedTask = null, isTemplate = false) {
		if (selectedDrill === null) {
			return;
		}

		const { data } = selectedDrill;
		const currentDrillElements = this.battleDrillElements;
		//clear the graph everytime a new drill is created or rendered
		this.resetDiagramData();

		//create the root role
		if (data && typeof data.roleId !== "undefined") {
			const role = currentDrillElements.addContributorRectangle({
				roleName: data.roleName,
				roleId: data.roleId,
				self_coordinates: data.self_coordinates,
				isTemplate
			});

			//create root role and its children/action items recursively
			this.createChildren(role, data.children, selectedTask, isTemplate);
			this.createTaskItems(role, data.tasks, data.tasks_coordinates, selectedTask, isTemplate);
		}

		this.cells = currentDrillElements.getElements().concat(currentDrillElements.getLinks());
		this.graph.resetCells(this.cells);

		// christopher, this function forces jointjs diagrams to render the tree structures with an
		// internal algorithm
		// this.layoutDirectedGraph();
	}

	/**
	 * Recursively creates children nodes (contributors and tasks blocks) for each contributor.
	 * @param {Object} parentNode
	 * @param {Array} children
	 */
	createChildren(parentNode, children = [], selectedTask = {}, isTemplate) {
		const { battleDrillElements } = this;
		if (children === undefined || children.length === 0) {
			return;
		}

		if (children && children.length > 0) {
			children.forEach((child) => {
				const currentChild = child;
				const childRectangle = battleDrillElements.addContributorRectangle({
					roleId: currentChild.roleId,
					roleName: currentChild.roleName,
					self_coordinates: currentChild.self_coordinates,
					isTemplate
				});
				battleDrillElements.createLink(parentNode, childRectangle);
				this.createChildren(childRectangle, currentChild.children, selectedTask, isTemplate);
				this.createTaskItems(
					childRectangle,
					currentChild.tasks,
					currentChild.tasks_coordinates,
					selectedTask,
					isTemplate
				);
			});
		}
	}

	/**
	 * Creates task items for the given contributor.
	 * @param {Object} parentNode
	 * @param {Array} taskItems
	 */
	createTaskItems(parentNode, taskItems = [], tasks_coordinates = {}, selectedTask = {}, isTemplate) {
		if (taskItems === undefined || taskItems.length === 0) {
			return;
		}

		const taskBlock = this.battleDrillElements.addTaskItemsBlock(
			parentNode,
			taskItems,
			tasks_coordinates,
			selectedTask,
			isTemplate
		);
		this.battleDrillElements.createTaskLink(parentNode, taskBlock);
	}

	/**
	 * Configures the jointjs graph for settings like spacing between the elements, etc.
	 */
	layoutDirectedGraph() {
		joint.layout.DirectedGraph.layout(this.graph, {
			setLinkVertices: false,
			marginX: 20,
			marginY: 20
		});
	}

	resetDiagramData() {
		this.battleDrillElements.resetData();
		this.cells = [];
		this.graph.clear();
	}
}
