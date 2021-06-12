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

export const addRoleToTemplate = ({ roleId, roleName, parentId }) => {
	return {
		type: DiagramEditorConstants.ADDED_ROLE_TO_TEMPLATE,
		payload: {
			roleId,
			parentId,
			roleName
		}
	};
};

export const addTaskToTemplate = ({ task, roleId }) => {
	return {
		type: DiagramEditorConstants.ADDED_TASK_TO_TEMPLATE,
		payload: {
			task,
			roleId
		}
	};
};

export const deleteRoleFromTemplate = (roleId) => {
	return {
		type: DiagramEditorConstants.DELETED_ROLE_FROM_TEMPLATE,
		payload: roleId
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

export const editTaskCoordinatesTemplate = (roleId, coordinates) => {
	return {
		type: DiagramEditorConstants.EDITED_TASK_COORDINATES_TEMPLATE,
		payload: { roleId, coordinates }
	};
};

export const editRoleCoordinatesTemplate = (roleId, coordinates) => {
	return {
		type: DiagramEditorConstants.EDITED_ROLE_COORDINATES_TEMPLATE,
		payload: { roleId, coordinates }
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

export const openBlankTemplate = () => {
	return {
		type: DiagramEditorConstants.OPEN_NEW_TEMPLATE
	};
};
