import { DiagramEditorConstants } from "./DiagramEditorConstants";

export const setLinkStyle = (payload) => {
	return {
		type: DiagramEditorConstants.SET_LINK_STYLE,
		payload
	};
};

export const setLinkSmoothness = (payload) => {
	return {
		type: DiagramEditorConstants.SET_LINK_SMOOTHNESS,
		payload
	};
};

export const setSelectedTaskTemplate = (payload) => {
	return {
		type: DiagramEditorConstants.SET_SELECTED_TASK_TEMPLATE,
		payload
	};
};

export const setSelectedTemplate = (payload) => {
	return {
		type: DiagramEditorConstants.SET_SELECTED_TEMPLATE,
		payload
	};
};

export const resetSelectedTaskTemplate = () => {
	return {
		type: DiagramEditorConstants.RESET_SELECTED_TASK_TEMPLATE
	};
};

export const addRoleToTemplate = ({ role, parent }) => {
	return {
		type: DiagramEditorConstants.ADDED_ROLE_TO_TEMPLATE,
		payload: {
			role,
			parent
		}
	};
};

export const addTaskToTemplate = ({ task, owner }) => {
	return {
		type: DiagramEditorConstants.ADDED_TASK_TO_TEMPLATE,
		payload: {
			task,
			owner
		}
	};
};

export const deleteRoleFromTemplate = (role) => {
	return {
		type: DiagramEditorConstants.DELETED_ROLE_FROM_TEMPLATE,
		payload: role
	};
};

export const editTaskDescriptionTemplate = ({ id, description }) => {
	return {
		type: DiagramEditorConstants.EDITED_TASK_DESCRIPTION_TEMPLATE,
		payload: {
			id,
			description
		}
	};
};

export const editTaskCoordinatesTemplate = (role, coordinates) => {
	return {
		type: DiagramEditorConstants.EDITED_TASK_COORDINATES_TEMPLATE,
		payload: { role, coordinates }
	};
};

export const editRoleCoordinatesTemplate = (role, coordinates) => {
	return {
		type: DiagramEditorConstants.EDITED_ROLE_COORDINATES_TEMPLATE,
		payload: { role, coordinates }
	};
};

export const clearAllFromTemplate = () => {
	return {
		type: DiagramEditorConstants.CLEAR_ALL_FROM_TEMPLATE
	};
};

export const undoTemplateEdit = () => {
	return {
		type: DiagramEditorConstants.UNDO_LAST_TEMPLATE_EDIT
	};
};

export const redoTemplateEdit = () => {
	return {
		type: DiagramEditorConstants.REDO_LAST_TEMPLATE_EDIT
	};
};
