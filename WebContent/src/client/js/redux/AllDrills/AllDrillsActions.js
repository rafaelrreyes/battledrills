import { AllDrillsConstants } from "./AllDrillsConstants";

export const updateAllDrills = (allDrills) => {
	return {
		type: AllDrillsConstants.UPDATE_DRILLS,
		payload: allDrills
	};
};

export const pendingUpdateActiveDrills = (activeDrills) => {
	return {
		type: AllDrillsConstants.PENDING_UPDATE_ACTIVE_DRILLS,
		payload: activeDrills
	};
};

export const updateActiveDrills = (activeDrills) => {
	return {
		type: AllDrillsConstants.UPDATE_ACTIVE_DRILLS,
		payload: activeDrills
	};
};

export const revertActiveDrillOrder = () => {
	return {
		type: AllDrillsConstants.REVERT_ACTIVE_DRILL_ORDER
	};
};

export const pendingUpdateCompletedDrills = (completedDrills) => {
	return {
		type: AllDrillsConstants.PENDING_UPDATE_COMPLETED_DRILLS,
		payload: completedDrills
	};
};

export const updateCompletedDrills = (completedDrills) => {
	return {
		type: AllDrillsConstants.UPDATE_COMPLETED_DRILLS,
		payload: completedDrills
	};
};

export const revertCompletedDrillOrder = () => {
	return {
		type: AllDrillsConstants.REVERT_COMPLETED_DRILL_ORDER
	};
};
