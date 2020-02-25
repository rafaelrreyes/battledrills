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
	 */
	createBattleDrill(selectedDrill, selectedTask = {}, activeTasks = []) {
		if (typeof selectedDrill === "undefined") {
			return;
		}

		const { data } = selectedDrill;
		const currentDrillElements = this.battleDrillElements;
		//clear the graph everytime a new drill is created or rendered
		this.resetDiagramData();

		//create the root owner
		if (data) {
			const owner = currentDrillElements.addContributorRectangle({
				title: data.title,
				self_coordinates: data.self_coordinates
			});

			//create root owner and its children/action items recursively
			this.createChildren(owner, data.children, selectedTask, activeTasks);
			// this.createTaskItems(owner, data.tasks);
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
	createChildren(parentNode, children = [], selectedTask = {}, activeTasks = []) {
		const { battleDrillElements } = this;
		if (children === undefined || children.length === 0) {
			return;
		}

		if (children && children.length > 0) {
			children.forEach((child) => {
				const currentChild = child;
				const childRectangle = battleDrillElements.addContributorRectangle({
					title: currentChild.title,
					self_coordinates: currentChild.self_coordinates
				});
				battleDrillElements.createLink(parentNode, childRectangle);
				this.createChildren(childRectangle, currentChild.children, selectedTask, activeTasks);
				this.createTaskItems(
					childRectangle,
					currentChild.tasks,
					currentChild.tasks_coordinates,
					selectedTask,
					activeTasks
				);
			});
		}
	}

	/**
	 * Creates task items for the given contributor.
	 * @param {Object} parentNode
	 * @param {Array} taskItems
	 */
	createTaskItems(parentNode, taskItems = [], tasks_coordinates = {}, selectedTask = {}, activeTasks = []) {
		if (taskItems === undefined || taskItems.length === 0) {
			return;
		}

		const taskBlock = this.battleDrillElements.addTaskItemsBlock(
			parentNode,
			taskItems,
			tasks_coordinates,
			selectedTask,
			activeTasks
		);
		this.battleDrillElements.createTaskLink(parentNode, taskBlock);
	}

	/**
	 * Configures the jointjs graph for settings like spacing between the elements, etc.
	 */
	layoutDirectedGraph() {
		joint.layout.DirectedGraph.layout(this.graph, {
			setLinkVertices: false,
			nodeSep: 60,
			edgeSep: 40,
			rankSep: 40,
			rankDir: "TB",
			ranker: "network-simplex",
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
