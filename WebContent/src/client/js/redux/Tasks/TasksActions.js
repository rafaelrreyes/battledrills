import { TasksConstants } from "./TasksConstants";

export const getNextActiveTask = (node, lastCompletedTask) => {
	return {
		type: TasksConstants.GET_NEXT_ACTIVE_TASK,
		payload: { node, lastCompletedTask }
	};
};

export const setSelectedTask = (selectedTask) => {
	return {
		type: TasksConstants.SET_SELECTED_TASK,
		payload: selectedTask
	};
};

export const resetSelectedTask = () => {
	return {
		type: TasksConstants.RESET_SELECTED_TASK
	};
};

export const editSelectedTaskNotes = (newNotes) => {
	return {
		type: TasksConstants.EDIT_SELECTED_TASK_NOTES,
		payload: newNotes
	};
};

export const resetActiveTasks = () => {
	return {
		type: TasksConstants.RESET_ACTIVE_TASKS
	};
};

export const addTaskAttachment = (attachment) => {
	return {
		type: TasksConstants.ADD_TASK_ATTACHMENT,
		payload: attachment
	};
};

export const deleteTaskAttachment = (attachmentName) => {
	return {
		type: TasksConstants.DELETE_TASK_ATTACHMENT,
		payload: attachmentName
	};
};