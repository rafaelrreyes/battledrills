import { SelectedDrillConstants } from "./SelectedDrillConstants";

export const setSelectedDrill = (drill) => {
	return {
		type: SelectedDrillConstants.SET_SELECTED_DRILL,
		payload: drill
	};
};

export const resetSelectedDrill = () => {
	return {
		type: SelectedDrillConstants.RESET_SELECTED_DRILL
	};
};

export const editTask = (selectedDrill, updatedData, targetTaskId) => {
	return {
		type: SelectedDrillConstants.EDIT_TASK,
		payload: {
			selectedDrill,
			updatedData,
			targetTaskId
		}
	};
};

export const editCoordinates = (roleId, coordinateType, updatedCoordinates) => {
	return {
		type: SelectedDrillConstants.EDIT_COORDINATES,
		payload: {
			roleId,
			coordinateType,
			updatedCoordinates
		}
	};
};

export const addDrillAttachment = (attachment) => {
	return {
		type: SelectedDrillConstants.ADD_DRILL_ATTACHMENT,
		payload: attachment
	};
};

export const deleteDrillAttachment = (attachmentName) => {
	return {
		type: SelectedDrillConstants.DELETE_DRILL_ATTACHMENT,
		payload: attachmentName
	};
};

export const editDrillAttachment = (attachment) => {
	return {
		type: SelectedDrillConstants.EDIT_DRILL_ATTACHMENT,
		payload: attachment
	};
};
