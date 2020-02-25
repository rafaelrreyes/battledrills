import { TasksConstants } from "./TasksConstants";
import { API } from "UTILITIES/API";
import { STATUS_TYPES } from "UTILITIES/index";

const initialState = {
	tasks: [],
	activeTasks: [],
	selectedTask: {}
};

export default function(state = initialState, action) {
	const { type, payload } = action;
	const activeTasks = state.activeTasks.slice();
	switch (type) {
		case TasksConstants.GET_NEXT_ACTIVE_TASK:
			const { node, lastCompletedTask } = payload;
			return {
				...state,
				activeTasks: getActiveTasks(node, lastCompletedTask, activeTasks)
			};
		case TasksConstants.SET_SELECTED_TASK:
			return {
				...state,
				selectedTask: payload
			};
		case TasksConstants.EDIT_SELECTED_TASK_NOTES:
			let notes = [];

			if (typeof state.selectedTask.notes !== "undefined") {
				notes = state.selectedTask.notes;
			}

			return {
				...state,
				selectedTask: {
					...state.selectedTask,
					notes: [
						...notes,
						{
							...payload
						}
					]
				}
			};
		case TasksConstants.RESET_SELECTED_TASK:
			return {
				...state,
				selectedTask: {}
			};
		case TasksConstants.RESET_ACTIVE_TASKS:
			return {
				...state,
				activeTasks: []
			};
		case TasksConstants.ADD_TASK_ATTACHMENT: {
			const attachment = payload;

			// attachments is empty on backend, create an empty array list here
			if (typeof state.selectedTask.attachments === "undefined") {
				return {
					...state,
					selectedTask: {
						...state.selectedTask,
						attachments: [
							{
								...attachment
							}
						]
					}
				}
			}

			// or add the new attachment to the end of array list
			return {
				...state,
				selectedTask: {
					...state.selectedTask,
					attachments: [
						...state.selectedTask.attachments,
						{
							...attachment
						}
					]
				}
			};
		}
		case TasksConstants.DELETE_TASK_ATTACHMENT: {
			const attachmentName = payload;

			// filter out the attachment being deleted
			return {
				...state,
				selectedTask: {
					...state.selectedTask,
					attachments: state.selectedTask.attachments.filter((attachment) => {
						return attachment.filename !== attachmentName;
					})
				}
			};
		}
		default:
			return state;
	}
}

const getActiveTasks = (node, lastTaskCompleted = null, activeTasks) => {
	if (typeof node === "undefined") {
		return [];
	}
	let targetActiveTasks =
		lastTaskCompleted !== null ? editActiveTasks(lastTaskCompleted, activeTasks.slice()) : activeTasks.slice();

	// let targetActiveTasks = activeTasks.slice();
	function recursiveTaskSearch(node, targetActiveTasks) {
		if (typeof node.children !== "undefined") {
			if (node.children.length === 0) {
			} else {
				node.children.forEach((child) => {
					let incompleteTask = getFirstIncompleteTask(child);
					//add incomplete task here if one is found
					//also check if tasks is already active
					//also make sure that the max active tasks is limited
					if (
						typeof incompleteTask !== "undefined" &&
						!isAlreadyActive(incompleteTask, targetActiveTasks) &&
						targetActiveTasks.length !== TasksConstants.MAX_ACTIVE_TASKS
					) {
						// this could be put in another function
						incompleteTask.owner = child.title;
						if (incompleteTask.start === -1) {
							incompleteTask.start = parseInt(new Date().getTime() / 1000);
							API.startTask(incompleteTask.taskId);
						}
						targetActiveTasks.push(incompleteTask);
					}

					if (typeof incompleteTask === "undefined") {
						recursiveTaskSearch(child, targetActiveTasks);
					}
				});
			}
		}

		if (typeof node.tasks !== "undefined") {
			if (node.tasks.length === 0) {
			} else {
				let incompleteTask = getFirstIncompleteTask(node);
				if (
					typeof incompleteTask !== "undefined" &&
					!isAlreadyActive(incompleteTask, targetActiveTasks) &&
					targetActiveTasks.length !== TasksConstants.MAX_ACTIVE_TASKS
				) {
					// this could be put in another function
					incompleteTask.owner = node.title;
					if (incompleteTask.start === -1) {
						incompleteTask.start = parseInt(new Date().getTime() / 1000);
						API.startTask(incompleteTask.taskId);
					}
					targetActiveTasks.push(incompleteTask);
				}
			}
		}
	}

	recursiveTaskSearch(node, targetActiveTasks);
	return targetActiveTasks;
};

const getFirstIncompleteTask = (node) => {
	if (typeof node.tasks !== "undefined") {
		return node.tasks.find((task) => task.end === -1 && task.currentStatus.status !== STATUS_TYPES.COMPLETED);
	}
};

const editActiveTasks = (task, activeTasks) => {
	return activeTasks.filter((activeTask) => task.taskId !== activeTask.taskId);
};

const isAlreadyActive = (task, activeTasks) => {
	if (activeTasks.length === 0) {
		return false;
	}

	let alreadyActive = activeTasks.find((activeTask) => task.taskId === activeTask.taskId);

	if (typeof alreadyActive === "undefined") {
		return false;
	}

	return true;
};
