import React from "react";
import store from "REDUX/store";
import { StatusIcon } from "CORE/index";
import { API, STATUS_TYPES } from "UTILITIES/index";
import { getUser, getSelectedDrill, editTask, resetSelectedTask, editActiveBillet } from "REDUX/index";
import { setSelectedDrill } from "REDUX/index";

export const getAvailableActions = (status, selectedTask) => {
	const start = {
		icon: <StatusIcon type={STATUS_TYPES.IN_PROGRESS} size={18} />,
		name: "Start",
		menuAction: () => {
			changeTaskState(STATUS_TYPES.IN_PROGRESS, selectedTask);
		}
	};
	const block = {
		icon: <StatusIcon type={STATUS_TYPES.BLOCKED} size={18} />,
		name: "Block",
		menuAction: () => {
			changeTaskState(STATUS_TYPES.BLOCKED, selectedTask);
		}
	};
	const complete = {
		icon: <StatusIcon type={STATUS_TYPES.COMPLETED} size={18} />,
		name: "Complete",
		menuAction: () => {
			changeTaskState(STATUS_TYPES.COMPLETED, selectedTask);
		}
	};

	switch (status) {
		case STATUS_TYPES.IN_PROGRESS:
			return [block, complete];
		case STATUS_TYPES.BLOCKED:
			return [start, complete];
		case STATUS_TYPES.COMPLETED:
			return [start, block];
		default:
			return [start, block, complete];
	}
};

export const changeTaskState = (status, selectedTask) => {
	const selectedDrill = getSelectedDrill(store.getState());
	const user = getUser(store.getState()); // change to username when we implement
	const updatedSelectedTask = {
		taskId: selectedTask.taskId,
		user,
		currentStatus: { status }
	};

	API.updateTaskStatus(updatedSelectedTask, (response) => {
		store.dispatch(editTask(selectedDrill, response, response.taskId));
		store.dispatch(editActiveBillet(selectedDrill.name, response));
		store.dispatch(resetSelectedTask());
		API.getDrillByName(selectedDrill.name, {}, (drill) => {
			store.dispatch(setSelectedDrill(drill));
		});
	});
};
