export const getPreviousActiveDrills = (store) => {
	return store.AllDrills.previousActive;
};

export const getActiveDrills = (store) => {
	return store.AllDrills.active;
};

export const getPreviousCompletedDrills = (store) => {
	return store.AllDrills.previousCompleted;
};

export const getCompletedDrills = (store) => {
	return store.AllDrills.completed;
};

export const getAllDrills = (store) => {
	return {
		active: store.AllDrills.active,
		completed: store.AllDrills.completed
	};
};
