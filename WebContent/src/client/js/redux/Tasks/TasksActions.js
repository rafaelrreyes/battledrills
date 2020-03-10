import { TasksConstants } from "./TasksConstants";

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
