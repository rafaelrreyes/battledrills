export const getTasks = (store) => {
	return store.Tasks.tasks;
};

export const getSelectedTask = (store) => {
	return store.Tasks.selectedTask;
};
