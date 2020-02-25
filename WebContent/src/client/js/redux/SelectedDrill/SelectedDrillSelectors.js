export const getSelectedDrill = (store) => {
	return store.SelectedDrill.selectedDrill;
};

export const getSelectedDrillName = (store) => {
	return store.SelectedDrill.selectedDrill.name;
};
