import { DiagramEditorConstants } from "./DiagramEditorConstants";
import { LinkStyles, LinkSmoothness, deepClone, generateRandomId } from "UTILITIES";

import {
	addRole,
	addTask,
	editTaskDescription,
	editRoleCoordinates,
	editTaskCoordinates,
	deleteRoleFromTemplate
} from "./DiagramReducerHelper";

const initialState = {
	linkStyle: LinkStyles.MANHATTAN,
	linkSmoothness: LinkSmoothness.NORMAL,
	selectedTemplate: null,
	selectedTaskTemplate: null,
	past: [],
	future: []
};

export default function (state = initialState, action) {
	const { type, payload } = action;

	let roleId, roleName, parentId, task;

	// make a copy of the state to add to past container before running through reducer
	const templateBeforeEdit = state.selectedTemplate !== null ? deepClone(state.selectedTemplate) : null;
	switch (type) {
		case DiagramEditorConstants.SET_LINK_STYLE:
			return {
				...state,
				linkStyle: payload
			};
		case DiagramEditorConstants.SET_LINK_SMOOTHNESS:
			return {
				...state,
				linkSmoothness: payload
			};
		case DiagramEditorConstants.SET_SELECTED_TEMPLATE:
			return {
				...state,
				selectedTemplate: payload,
				past: [],
				future: []
			};
		case DiagramEditorConstants.SET_SELECTED_TASK_TEMPLATE:
			return {
				...state,
				selectedTaskTemplate: payload
			};
		case DiagramEditorConstants.RESET_SELECTED_TASK_TEMPLATE:
			return {
				...state,
				selectedTaskTemplate: null
			};
		case DiagramEditorConstants.ADDED_ROLE_TO_TEMPLATE:
			if (typeof payload !== "undefined") {
				roleId = payload.roleId;
				roleName = payload.roleName;
				parentId = payload.parentId;
			}
			return {
				...state,
				past: [...state.past, { ...templateBeforeEdit }],
				selectedTemplate: {
					...state.selectedTemplate,
					participants: [...state.selectedTemplate.participants, roleId],
					data: addRole(state.selectedTemplate, roleId, roleName, parentId)
				}
			};
		case DiagramEditorConstants.ADDED_TASK_TO_TEMPLATE:
			if (typeof payload !== "undefined") {
				roleId = payload.roleId;
				task = payload.task;
			}
			return {
				...state,
				past: [...state.past, { ...templateBeforeEdit }],
				selectedTemplate: {
					...state.selectedTemplate,
					data: addTask(state.selectedTemplate, task, roleId)
				}
			};
		case DiagramEditorConstants.EDITED_TASK_DESCRIPTION_TEMPLATE:
			return {
				...state,
				past: [...state.past, { ...templateBeforeEdit }],
				selectedTaskTemplate: {
					...state.selectedTaskTemplate,
					description: payload.description
				},
				selectedTemplate: {
					...state.selectedTemplate,
					data: editTaskDescription(state.selectedTemplate, payload.id, payload.description)
				}
			};
		case DiagramEditorConstants.UNDO_LAST_TEMPLATE_EDIT:
			// for safety, but gui should check for this and disable button
			if (state.past.length === 0) {
				return state;
			}

			const pastCopy = deepClone(state.past);

			// pop() removes the top item from past container
			const pastTemplate = pastCopy.pop();

			return {
				...state,
				past: [...pastCopy],
				selectedTaskTemplate: null,
				future: [...state.future, deepClone(state.selectedTemplate)],
				selectedTemplate: pastTemplate
			};
		case DiagramEditorConstants.REDO_LAST_TEMPLATE_EDIT:
			// for safety, but gui should check for this and disable button
			if (state.future.length === 0) {
				return state;
			}

			const futureCopy = deepClone(state.future);

			// pop() removes the top item from future container
			const futureTemplate = futureCopy.pop();

			return {
				...state,
				past: [...state.past, deepClone(state.selectedTemplate)],
				selectedTaskTemplate: null,
				future: [...futureCopy],
				selectedTemplate: futureTemplate
			};
		case DiagramEditorConstants.CLEAR_ALL_FROM_TEMPLATE:
			return {
				...state,
				past: [...state.past, { ...templateBeforeEdit }],
				selectedTaskTemplate: null,
				selectedTemplate: {
					type: state.selectedTemplate.type,
					participants: [],
					data: {}
				}
			};
		case DiagramEditorConstants.DELETED_ROLE_FROM_TEMPLATE:
			return {
				...state,
				past: [...state.past, { ...templateBeforeEdit }],
				selectedTaskTemplate: null,
				selectedTemplate: deleteRoleFromTemplate(state.selectedTemplate, payload)
			};
		case DiagramEditorConstants.EDITED_ROLE_COORDINATES_TEMPLATE:
			return {
				...state,
				past: [...state.past, { ...templateBeforeEdit }],
				selectedTemplate: {
					...state.selectedTemplate,
					data: editRoleCoordinates(state.selectedTemplate, payload.roleId, payload.coordinates)
				}
			};
		case DiagramEditorConstants.EDITED_TASK_COORDINATES_TEMPLATE:
			return {
				...state,
				past: [...state.past, { ...templateBeforeEdit }],
				selectedTemplate: {
					...state.selectedTemplate,
					data: editTaskCoordinates(state.selectedTemplate, payload.roleId, payload.coordinates)
				}
			};
		case DiagramEditorConstants.OPEN_NEW_TEMPLATE:
			return {
				...state,
				selectedTemplate: {
					type: `template-${generateRandomId()}`,
					participants: [],
					data: {}
				},
				selectedTaskTemplate: null,
				past: [],
				future: []
			};
		default:
			return state;
	}
}
