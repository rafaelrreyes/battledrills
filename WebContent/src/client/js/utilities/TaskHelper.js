import store from "REDUX/store";
import { getSelectedTask } from "REDUX/index";
import { setSelectedTask } from "REDUX/index";
import { API } from "UTILITIES/index";

export const selectTask = (task) => {
	// used to check if the newly selected drill is the same as the currently selected
	const currSelectedTask = getSelectedTask(store.getState());

	// if a task is already selected, clicking the same task does nothing
	if (task.taskId === currSelectedTask.taskId) {
		return;
	}

	API.getTaskById(task.taskId, {}, (response) => {
		const selectedTask = { ...response, selected: true };
		store.dispatch(setSelectedTask(selectedTask));
	});
};
