import React from "react";
import store from "REDUX/store";
import { addToast, setSelectedDrill } from "REDUX";
import {
	API,
	Routes,
	isNewDrill,
	isDrillReorder,
	isNewNote,
	isDeletedDrill,
	isTaskStatusUpdate,
	selectTask,
	isAttachmentUpload,
	AttachmentTypes,
	isAttachmentDelete,
	isTaskDescriptionEdit,
	isTaskDelete,
	NoteTypes,
	isStartedDrill,
	isStoppedDrill,
	isCreatedAndStartedDrill
} from "UTILITIES/";
import { Button, ButtonSizes, ButtonTypes } from "CORE";

import "./ToastHelper.scss";

export const ToastConstants = {
	MAXIMUM: 5,
	MINIMUM: 0,
	ENTER_DELAY: 10000,
	EXIT_DELAY: 500,
	GENERIC: "generic",
	SUCCESS: "success",
	ERROR: "error"
};

const ToastFactory = {
	// can perform factory type shit here if needed, but for now, just return
	// a generic toast

	createToast: (websocketResponse) => {
		return {
			...websocketResponse,
			toastType: ToastConstants.GENERIC,
			message: getToastMessageString(websocketResponse)
		};
	}
};

/**
 * Gets a user friendly toast message from the given websocket response.
 * @param {object} websocketResponse - can be different depending on what object/operation type the websocket is
 * @returns {JSX} toast message in HTML for styling
 */
export const getToastMessageHtml = (props) => {
	const { user, drillName, taskData } = props;

	if (isTaskStatusUpdate(props)) {
		const { taskDescription, currentStatus } = taskData;
		const splitDescription = taskDescription.split(" ");
		const shortenedTaskDesc =
			splitDescription.length > 3
				? splitDescription.slice(0, 3).join(" ") + "..."
				: splitDescription.slice(0, 3).join(" ");
		const message = (
			<>
				{`${user.role} changed status of task "${shortenedTaskDesc}" to: `}
				<span className={`toast-status-label ${currentStatus.toLowerCase()}`}>
					{currentStatus.replace("-", " ")}
				</span>
			</>
		);
		return message;
	}

	if (isTaskDescriptionEdit(props)) {
		const message = <>{`${user.role} edited description of a task in drill "${drillName}"`}</>;
		return message;
	}

	if (isTaskDelete(props)) {
		const message = <>{`${user.role} deleted a task from drill ${drillName}`}</>;
		return message;
	}

	return <>{getToastMessageString(props)}</>;
};

/**
 * Gets a user friendly toast message from the given websocket response.
 * @param {object} websocketResponse - can be different depending on what object/operation type the websocket is
 * @returns {String} toast message unstyled
 */
export const getToastMessageString = (props) => {
	const { drillName, user } = props;

	if (isNewDrill(props)) {
		return `New drill created by ${user.role}: ${drillName}`;
	}

	if (isStartedDrill(props)) {
		return `${user.role} started the drill: ${drillName}`;
	}

	if (isStoppedDrill(props)) {
		return `${user.role} stopped the drill: ${drillName}`;
	}

	if (isNewNote(props)) {
		const { note } = props;
		return note.type === NoteTypes.USER
			? `Note added by user ${note.user.role}: ${note.noteText}`
			: `${note.noteText}`;
	}

	if (isDrillReorder(props)) {
		return `Drills reordered`;
	}

	if (isDeletedDrill(props)) {
		return `Drill deleted: ${drillName}`;
	}

	if (isTaskStatusUpdate(props)) {
		const { taskDescription, currentStatus } = props.taskData;
		return `${user.role} changed status of task "${taskDescription}" to: ${currentStatus.replace("-", " ")}`;
	}

	if (isAttachmentUpload(props)) {
		const { attachmentName, attachmentType, taskData } = props;

		const id = attachmentType === AttachmentTypes.DRILL ? drillName : taskData.taskDescription;
		return `${user.role} uploaded attachment "${attachmentName}" to ${attachmentType} "${id}"`;
	}

	if (isAttachmentDelete(props)) {
		const { attachmentName, attachmentType, taskData } = props;
		const id = attachmentType === AttachmentTypes.DRILL ? drillName : taskData.taskDescription;
		return `${user.role} deleted attachment "${attachmentName}" from ${attachmentType} "${id}"`;
	}

	if (isTaskDescriptionEdit(props)) {
		const { drillName } = props;
		return `${user.role} edited description of a task in drill "${drillName}"`;
	}

	if (isTaskDelete(props)) {
		const { drillName } = props;
		return `${user.role} deleted a task from drill ${drillName}`;
	}
};

export const getNotificationLink = (props) => {
	if (
		isTaskStatusUpdate(props) ||
		isNewNote(props) ||
		isNewDrill(props) ||
		isStartedDrill(props) ||
		isStoppedDrill(props) ||
		isAttachmentUpload(props) ||
		isAttachmentDelete(props) ||
		isTaskDescriptionEdit(props)
	) {
		const link = (
			<Button
				buttonSize={ButtonSizes.XSMALL}
				buttonType={ButtonTypes.GREY}
				onClick={() => {
					onNotificationClick(props);
				}}
			>
				View
			</Button>
		);
		return link;
	}
};

/**
 * Async method that sets the selected drill (and task if applicable)
 *
 * @param {} props
 */
export const onNotificationClick = (props) => {
	const { drillName, setVisible, history } = props;

	if (
		isTaskStatusUpdate(props) ||
		isNewNote(props) ||
		isNewDrill(props) ||
		isTaskDescriptionEdit(props) ||
		isStartedDrill
	) {
		const { taskData } = props;

		// this stuff is run after the navigation to /active_diagram because of the request being async
		API.getDrillByName(drillName, {}, (response) => {
			store.dispatch(setSelectedDrill(response));
			// if the toast is for notes/task updates then select the task
			if (isTaskStatusUpdate(props) || isNewNote(props)) {
				selectTask(taskData);
			}
			// this is called for popup toasts, make them disappear when clicking "View"
			// in the Notification window, toggleNotificationList is sent as setVisible
			setVisible(false);
			history.push(Routes.ACTIVE_DIAGRAM);
		});
	} else if (isStoppedDrill(props)) {
		API.getDrillByName(drillName, {}, (response) => {
			store.dispatch(setSelectedDrill(response));
			setVisible(false);
			history.push(Routes.COMPLETED_DIAGRAM);
		});
	}
};

/**
 * Dispatches a toast notification on all subscribed clients.
 * @param {object} websocketResponse
 */
export const dispatchToastNotification = (websocketResponse) => {
	const newToast = ToastFactory.createToast(websocketResponse);
	store.dispatch(addToast(newToast));
};
