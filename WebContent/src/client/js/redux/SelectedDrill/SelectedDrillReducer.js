import { SelectedDrillConstants } from "./SelectedDrillConstants";
import { CoordinateTypes } from "UTILITIES/index";
import { editDrillAttachment } from "./SelectedDrillActions";

const initialState = {
	selectedDrill: {}
};

export default function (state = initialState, action) {
	const { type, payload } = action;
	switch (type) {
		case SelectedDrillConstants.SET_SELECTED_DRILL: {
			return {
				...state,
				selectedDrill: payload
			};
		}
		case SelectedDrillConstants.RESET_SELECTED_DRILL: {
			return {
				...state,
				selectedDrill: {}
			};
		}
		case SelectedDrillConstants.EDIT_TASK: {
			const { data } = state.selectedDrill;
			return {
				...state,
				selectedDrill: {
					...state.selectedDrill,
					data: deepTaskUpdate(data, payload.updatedData, payload.targetTaskId)
				}
			};
		}
		case SelectedDrillConstants.EDIT_COORDINATES: {
			const { data } = state.selectedDrill;
			return {
				...state,
				selectedDrill: {
					...state.selectedDrill,
					data: deepCoordinateUpdate(data, payload.roleId, payload.coordinateType, payload.updatedCoordinates)
				}
			};
		}
		case SelectedDrillConstants.ADD_DRILL_ATTACHMENT: {
			const attachment = payload;

			if (typeof state.selectedDrill.attachments === "undefined") {
				return {
					...state,
					selectedDrill: {
						...state.selectedDrill,
						attachments: [
							{
								...attachment
							}
						]
					}
				};
			}

			return {
				...state,
				selectedDrill: {
					...state.selectedDrill,
					attachments: [
						...state.selectedDrill.attachments,
						{
							...attachment
						}
					]
				}
			};
		}
		case SelectedDrillConstants.DELETE_DRILL_ATTACHMENT: {
			const attachmentName = payload;
			let filteredAttachments = [];
			if (state.selectedDrill.attachments !== "undefined") {
				filteredAttachments = state.selectedDrill.attachments.filter((attachment) => {
					return attachment.filename !== attachmentName;
				});
			}
			return {
				...state,
				selectedDrill: {
					...state.selectedDrill,
					attachments: filteredAttachments
				}
			};
		}
		case SelectedDrillConstants.EDIT_DRILL_ATTACHMENT: {
			const updatedAttachment = payload;
			return {
				...state,
				selectedDrill: {
					...state.selectedDrill,
					attachments: editDrillAttachment(updatedAttachment)
				}
			};
		}
		default:
			return state;
	}
}

/**
 * Updates a deep task nested inside of drill data object.
 * Simply replaces object with a new one.
 * @param {*} node Battle drill
 * @param {*} updatedNode
 * @param {*} targetTaskId
 */
const deepTaskUpdate = (node, updatedNode, targetTaskId) => {
	let updatedData = Object.assign({}, node);
	function recursiveUpdate(node, updatedNode, targetTaskId) {
		if (node && typeof node.tasks !== "undefined") {
			for (var i = 0; i < node.tasks.length; i++) {
				if (node.tasks[i].taskId === targetTaskId) {
					node.tasks[i] = { ...updatedNode };
					break;
				}
			}
		}

		if (node && typeof node.children !== "undefined") {
			node.children.forEach((childNode) => {
				recursiveUpdate(childNode, updatedNode, targetTaskId);
			});
		}
	}

	recursiveUpdate(updatedData, updatedNode, targetTaskId);
	return updatedData;
};

/**
 * Updates a deep coordinate nested inside of a drill data object.
 * Simply replaces the coordinates (tasks or role/self) coordinates.
 * @param {Object} drillData
 * @param {String} roleId
 * @param {String} coordinateType
 * @param {Object} updatedCoordinates
 */
const deepCoordinateUpdate = (drillData, roleId, coordinateType, updatedCoordinates) => {
	const updatedData = Object.assign({}, drillData);
	function recursiveUpdate(node) {
		if (typeof node !== "undefined") {
			if (node.roleId === roleId) {
				switch (coordinateType) {
					case CoordinateTypes.SELF:
						node.self_coordinates = { ...updatedCoordinates };
						break;
					case CoordinateTypes.TASKS:
						node.tasks_coordinates = { ...updatedCoordinates };
						break;
					default:
						break;
				}
				return;
			}
		}

		if (typeof node.children !== "undefined") {
			node.children.forEach((childNode) => {
				recursiveUpdate(childNode);
			});
		}
	}

	recursiveUpdate(updatedData);
	return updatedData;
};
