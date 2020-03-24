import store from "REDUX/store";
import { 
	getSelectedTask, 
	setSelectedTask, 
	setSelectedDrill,
	resetSelectedTask, 
	getUser, 
	getCurrentView, 
	showModal, 
	closeModal, 
	getSelectedDrillName,
	setActiveBillet
} from "REDUX/";
import { API, Routes, MaterialIconNames } from "UTILITIES/";
import { ModalContentTypes } from "CORE/";

export const selectTask = (task) => {
	// used to check if the newly selected drill is the same as the currently selected
	const currentSelectedTask = getSelectedTask(store.getState());

	// if a task is already selected, clicking the same task does nothing
	if (task.taskId === currentSelectedTask.taskId) {
		return;
	}

	API.getTaskById(task.taskId, {}, (response) => {
		const selectedTask = { ...response, selected: true };
		store.dispatch(setSelectedTask(selectedTask));
	});
};

export const deleteTask = (taskId) => {

	const user = getUser(store.getState());
	const currentView = getCurrentView(store.getState());
	const selectedDrillName = getSelectedDrillName(store.getState());

	store.dispatch(
		showModal(ModalContentTypes.CONFIRMATION, {
			title: `Are you sure you want to delete this task?`,
			icon: MaterialIconNames.DELETE,
			action: () => {
				const requestBody = {
					user,
					taskId
				};

				// delete task and update
				API.deleteTaskById(requestBody, () => {
					API.getDrillByName(selectedDrillName, {}, (drill) => {
						store.dispatch(setSelectedDrill(drill));
						store.dispatch(resetSelectedTask());
					});

					if (currentView === Routes.MY_REPORT) {
						API.getOwnerBillet(user.role, {}, (data) => {
							store.dispatch(setActiveBillet(data));
						});
					}

					store.dispatch(closeModal());
				});
			}
		})
	);
};
