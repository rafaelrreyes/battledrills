import store from "REDUX/store";
import { API, AttachmentTypes } from "UTILITIES/";
import { getSelectedDrillName, getRole, getSelectedTask, getSelectedDrill, getAllChats } from "REDUX/index";
import {
	setActiveBillet,
	setAllStatuses,
	setSelectedDrill,
	editTask,
	setSelectedTask,
	editSelectedTaskNotes,
	updateAllDrills,
	resetSelectedDrill,
	addChat,
	updateChat,
	setSessionId
} from "REDUX/index";
import {
	createDrillUpdate,
	createDrillUpdateMyDrillsView,
	createDrillUpdateStatusView
} from "CORE/Modal/ModalContent/index";
import { getCurrentView } from "REDUX/index";
import { Routes } from "./Constants";

export const newDrillCreated = (websocketReponse) => {
	const { drillName } = websocketReponse;

	createDrillUpdate(drillName);
	createDrillUpdateMyDrillsView();
	createDrillUpdateStatusView();
};

export const drillStarted = (websocketReponse) => {
	const { drillName } = websocketReponse;
	const selectedDrill = getSelectedDrillName(store.getState());
	if (drillName === selectedDrill) {
		API.getDrillByName(drillName, {}, (response) => {
			store.dispatch(setSelectedDrill(response));
		});
	}
};

export const drillStopped = (websocketReponse) => {
	const { drillName } = websocketReponse;
	const selectedDrill = getSelectedDrillName(store.getState());
	const location = getCurrentView(store.getState());
	// drill was completed while on overview or status view
	switch (location) {
		case Routes.OVERVIEW:
		case Routes.STATUS:
			API.all(
				{},
				(response) => {
					// moves drill to completed side
					store.dispatch(updateAllDrills(response));
				},
				(err) => {
					console.error(err);
				}
			);
			break;
		case Routes.MY_DRILLS:
			// drill completed on my_drills view
			const role = getRole(store.getState()).toUpperCase();
			API.getOwnerBillet(
				role,
				{},
				(response) => {
					let drills = [];
					for (var key in response) {
						drills.push({
							[key]: response[key]
						});
					}
					store.dispatch(setActiveBillet(drills));
				},
				(err) => {
					console.error(err);
				}
			);
			break;
		case Routes.ACTIVE_DIAGRAM:
			// drill completed on active_diagram view
			// completed drill was selected, auto select first of remaining drills
			if (drillName === selectedDrill) {
				API.all(
					{},
					(res) => {
						// select first in list of active drills
						if (res.active.length > 0) {
							API.getDrillByName(res.active[0], {}, (response) => {
								store.dispatch(setSelectedDrill(response));
							});
						} else {
							store.dispatch(resetSelectedDrill());
						}
						store.dispatch(updateAllDrills(res));
					},
					(err) => {
						console.error(err);
					}
				);
			} else {
				API.all(
					{},
					(res) => {
						store.dispatch(updateAllDrills(res));
					},
					(err) => {
						console.error(err);
					}
				);
			}
			break;
		case Routes.COMPLETED_DIAGRAM:
			// drill completed on completed_diagram view
			API.all(
				{},
				(res) => {
					store.dispatch(updateAllDrills(res));
				},
				(err) => {
					console.error(err);
				}
			);
			break;
	}
};

export const drillsReordered = (websocketReponse) => {
	const { orderedBattleDrills } = websocketReponse;
	store.dispatch(updateAllDrills(orderedBattleDrills));
};

export const drillDeleted = (websocketReponse) => {
	const { orderedBattleDrills, drillName } = websocketReponse;
	store.dispatch(updateAllDrills(orderedBattleDrills));
	// updates all drills for all clients, but will check if the deleted drill was selected
	// if it was selected, it will select the top level active drill or reset if there is no active drills
	if (drillName === getSelectedDrillName(store.getState())) {
		const { active } = orderedBattleDrills;
		if (Array.isArray(active) && active.length) {
			API.getDrillByName(active[0], {}, (response) => {
				if (response !== null) {
					store.dispatch(setSelectedDrill(response));
				}
			});
		} else {
			store.dispatch(resetSelectedDrill());
		}
	}
};

/**
 * When a new note is added, update subscriber clients selected task notes.
 * This assumes subscriber client is looking at the same task that is updated.
 * @param {object} websocketResponse
 */
export const newNoteAdded = (websocketResponse) => {
	const { note, taskData } = websocketResponse;
	const selectedTask = getSelectedTask(store.getState());
	selectedTask.taskId === taskData.taskId && store.dispatch(editSelectedTaskNotes(note));
};

/**
 * When a task is updated, update subscriber client's corresponding task.
 * This means that owner billet, status, and diagram view all need to be updated.
 * @param {object} websocketResponse
 */
export const taskUpdated = (websocketResponse) => {
	const { taskData, drillName, noteId, timestamp, user } = websocketResponse;

	const role = getRole(store.getState()).toUpperCase();
	const selectedDrill = getSelectedDrill(store.getState());
	const selectedTask = getSelectedTask(store.getState());

	API.getOwnerBillet(role, {}, (data) => {
		store.dispatch(setActiveBillet(data));
	});

	API.getMetrics({}, (response) => {
		store.dispatch(setAllStatuses(response));
	});

	// none of this needs to be called if the drill selected for a subscriber is not the one being updated by the websocket
	if (drillName === selectedDrill.name) {
		API.getDrillByName(
			selectedDrill.name,
			{},
			(response) => {
				if (response !== null) {
					// this makes sense because the selected drill should be updated on
					// subscriber client assuming theyre looking at the same drill as person
					// who updated
					store.dispatch(setSelectedDrill(response));
					// now update the task that was updated on subscriber clients redux stores
					API.getTaskById(taskData.taskId, {}, (task) => {
						const updatedSelectedDrill = getSelectedDrill(store.getState());

						store.dispatch(editTask(updatedSelectedDrill, task, taskData.taskId));
						// doesn't need to be run if the task changed is not the one being viewed
						if (taskData.taskId === selectedTask.taskId) {
							const automatedNote = {
								id: noteId,
								noteText: taskData.currentStatus,
								timestampMillis: timestamp,
								type: "auto",
								user: user.role
							};

							store.dispatch(editSelectedTaskNotes(automatedNote));
							// this is pretty much just updating top-level end time, but uses the whole response from getTaskById to do so
							store.dispatch(setSelectedTask(task));
						}
					});
				}
			},
			(err) => {
				console.log("err", err);
			}
		);
	}
};

export const taskDeleted = (websocketResponse) => {
	const { taskData } = websocketResponse;

	const role = getRole(store.getState()).toUpperCase();
	const selectedTask = getSelectedTask(store.getState());

	API.getOwnerBillet(role, {}, (data) => {
		store.dispatch(setActiveBillet(data));
	});

	API.getMetrics({}, (response) => {
		store.dispatch(setAllStatuses(response));
	});

	if (taskData.taskId === selectedTask.taskId) {
		store.dispatch(resetSelectedTask());
	}
};

export const taskDescriptionUpdated = (websocketResponse) => {
	const { taskData, drillName, noteId, timestamp, user } = websocketResponse;

	const role = getRole(store.getState()).toUpperCase();
	const selectedDrill = getSelectedDrill(store.getState());
	const selectedTask = getSelectedTask(store.getState());

	API.getOwnerBillet(role, {}, (data) => {
		store.dispatch(setActiveBillet(data));
	});

	API.getMetrics({}, (response) => {
		store.dispatch(setAllStatuses(response));
	});

	// none of this needs to be called if the drill selected for a subscriber is not the one being updated by the websocket
	if (drillName === selectedDrill.name) {
		API.getDrillByName(
			selectedDrill.name,
			{},
			(response) => {
				if (response !== null) {
					// this makes sense because the selected drill should be updated on
					// subscriber client assuming theyre looking at the same drill as person
					// who updated
					store.dispatch(setSelectedDrill(response));
					// now update the task that was updated on subscriber clients redux stores
					API.getTaskById(taskData.taskId, {}, (task) => {
						const updatedSelectedDrill = getSelectedDrill(store.getState());

						store.dispatch(editTask(updatedSelectedDrill, task, taskData.taskId));
						// doesn't need to be run if the task changed is not the one being viewed
						if (taskData.taskId === selectedTask.taskId) {
							const automatedNote = {
								id: noteId,
								noteText: taskData.currentStatus,
								timestampMillis: timestamp,
								type: "auto",
								user: user.role
							};

							store.dispatch(editSelectedTaskNotes(automatedNote));
							// this is pretty much just updating top-level end time, but uses the whole response from getTaskById to do so
							store.dispatch(setSelectedTask(task));
						}
					});
				}
			},
			(err) => {
				console.log("err", err);
			}
		);
	}
};

/**
 * When a chat message is received from another subscribed client, handle.
 * @param {object} websocketResponse
 */
export const chatMessageReceived = (websocketResponse) => {
	const chats = getAllChats(store.getState());
	let role = getRole(store.getState()).toUpperCase();
	let { sender, target, message, timestampMillis } = websocketResponse.message;

	target = target.toUpperCase();
	sender = sender.toUpperCase();

	// checks to see if the chat socket is already open between sender and target
	let alreadyOpened = chats.find((currentChat) => {
		let currentChatRole = currentChat.role.toUpperCase();
		return currentChatRole === target || (currentChatRole === sender && target !== "ALL");
	});

	// chat is already open, just update chat reducer
	if (typeof alreadyOpened !== "undefined") {
		if (target === role || (target === "ALL" && sender !== role)) {
			store.dispatch(updateChat({ sender, target, message, timestampMillis }));
		}

		// add a new chat if isn't open yet
	} else {
		if (target === role || target === "ALL") {
			store.dispatch(
				addChat({
					sender,
					target: target === "ALL" ? "All" : sender,
					message,
					timestampMillis
				})
			);
		}
	}
};

// update clients that currently have the task or drill selected that had an attachment uploaded to or deleted from them
export const attachmentManipulated = (websocketResponse) => {
	const { attachmentType } = websocketResponse;

	if (attachmentType === AttachmentTypes.DRILL) {
		const { drillName } = websocketResponse;
		if (drillName === getSelectedDrillName(store.getState())) {
			API.getDrillByName(drillName, {}, (response) => {
				if (response !== null) {
					store.dispatch(setSelectedDrill(response));
				}
			});
		}
	} else if (attachmentType === AttachmentTypes.TASK) {
		const { taskData } = websocketResponse;
		if (
			taskData !== null ||
			(taskData.taskId !== "undefined" && taskData.taskId === getSelectedTask(store.getState()).taskId)
		) {
			API.getTaskById(taskData.taskId, {}, (response) => {
				if (response !== null) {
					store.dispatch(setSelectedTask(response));
				}
			});
		}
	}
};

export const websocketOpened = (websocketResponse) => {
	store.dispatch(setSessionId(websocketResponse.user.sessionId));
};
