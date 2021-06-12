import React from "react";
import store from "REDUX/store";
import { StatusIcon } from "CORE";
import { API, StatusTypes } from "UTILITIES";
import { getUser, getSelectedDrill, editTask, resetSelectedTask, editActiveBillet, setSelectedDrill } from "REDUX";

export const getAvailableActions = (status, selectedTask) => {
	const start = {
		icon: <StatusIcon type={StatusTypes.IN_PROGRESS} size={18} />,
		name: "Start",
		menuAction: () => {
			changeTaskState(StatusTypes.IN_PROGRESS, selectedTask);
		}
	};
	const block = {
		icon: <StatusIcon type={StatusTypes.BLOCKED} size={18} />,
		name: "Block",
		menuAction: () => {
			changeTaskState(StatusTypes.BLOCKED, selectedTask);
		}
	};
	const complete = {
		icon: <StatusIcon type={StatusTypes.COMPLETED} size={18} />,
		name: "Complete",
		menuAction: () => {
			changeTaskState(StatusTypes.COMPLETED, selectedTask);
		}
	};

	switch (status) {
		case StatusTypes.IN_PROGRESS:
			return [block, complete];
		case StatusTypes.BLOCKED:
			return [start, complete];
		case StatusTypes.COMPLETED:
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
		status
	};

	API.updateTaskStatus(updatedSelectedTask, (response) => {
		store.dispatch(editTask(selectedDrill, response, response.taskId));
		store.dispatch(editActiveBillet(selectedDrill.id, response));
		store.dispatch(resetSelectedTask());
		API.getDrillById(selectedDrill.id, {}, (drill) => {
			store.dispatch(setSelectedDrill(drill));
		});
	});
};
