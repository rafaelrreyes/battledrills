import store from "REDUX/store";
import { getIcon } from "./ShapesHelper";
import { MaterialIconNames, Routes, TASK_DESCRIPTION_PLACEHOLDER } from "UTILITIES/";
import { getCurrentView, getSelectedDrill } from "REDUX/";

export const getTaskItemStyle = (task, selectedTask) => {
	const { status } = task.currentStatus;
	const icon = getIcon(status);
	const description = `<span class="task-description">${
		task.description ? task.description : TASK_DESCRIPTION_PLACEHOLDER
	}</span>`;
	const options = `<div class="task-option-icon-flex-container"><i class="material-icons md-18 task-option-icon">${MaterialIconNames.MORE_VERT}</i><div class="filler-div"></div></div>`;
	let classes = ["action-item", "task-flex-container"];
	// check view, if the view is on /completed_diagram, don't render the options on the diagram
	const currentView = getCurrentView(store.getState());
	const { prioritizedTasks } = getSelectedDrill(store.getState());

	if (task.taskId === selectedTask.taskId) {
		classes.push("selected");
	}

	if (typeof prioritizedTasks !== "undefined" || prioritizedTasks.length > 0) {
		for (let i = 0; i < prioritizedTasks.length; i++) {
			if (prioritizedTasks[i].taskId === task.taskId) {
				classes.push("queued");
				break;
			}
		}
	}

	return `<li class="${classes.join(" ")}" taskId="${task.taskId}">${icon + description}${
		currentView === Routes.ACTIVE_DIAGRAM ? options : ""
	}</li>`;
};

/**
 * ONLY USE THIS WHEN DOING EVENTS ON THE LIST ELEMENTS IN THE DIAGRAM
 */
export const getLiElement = (element) => {
	let liElement = element;
	while (true) {
		if (liElement.getAttribute("taskId")) {
			return liElement;
		}
		liElement = liElement.parentElement;
	}
};
