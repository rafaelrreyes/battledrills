import {
	newDrillCreated,
	drillsReordered,
	drillDeleted,
	newNoteAdded,
	taskUpdated,
	chatMessageReceived,
	websocketOpened,
	attachmentManipulated,
	taskDescriptionUpdated
} from "./WebsocketActions";

import { dispatchToastNotification } from "CORE/index";

export const WebsocketTypes = {
	OBJECT_TYPES: {
		DRILL: "drill",
		TASK: "task",
		NOTE: "note",
		CHAT: "chat",
		LOG: "log",
		ATTACHMENT: "attachment",
		WEBSOCKET: "websocket",
		TOAST: "toast"
	},
	OPERATION_TYPES: {
		CREATE: "create",
		EDIT: "edit",
		DELETE: "delete",
		REORDER: "reorder",
		READ: "read"
	}
};

const TaskEditKeys = {
	STATUS: "status",
	DESCRIPTION: "description"
};

/**
 * Uses data from the backend Notification classes to determine what to do.
 * The backend determines which clients should be receiving an update via websockets
 * Also determines whether the websocket should be added as a toast (two separate notifications)
 * @param {object} json
 */
export const dispatchWebsocket = (json) => {
	isWebsocketOpened(json) && websocketOpened(json);
	isToast(json) && dispatchToastNotification(json.notification);
	isChatMessage(json) && chatMessageReceived(json);
	isNewNote(json) && newNoteAdded(json);
	isTaskStatusUpdate(json) && taskUpdated(json);
	isNewDrill(json) && newDrillCreated(json);
	isDeletedDrill(json) && drillDeleted(json);
	isDrillReorder(json) && drillsReordered(json);
	isAttachmentUpload(json) && attachmentManipulated(json);
	isAttachmentDelete(json) && attachmentManipulated(json);
	isTaskDescriptionEdit(json) && taskDescriptionUpdated(json);
};

export const isWebsocketOpened = ({ objectType, operationType }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.WEBSOCKET) {
		if (operationType === WebsocketTypes.OPERATION_TYPES.CREATE) {
			return true;
		}
	}
	return false;
};

export const isNewDrill = ({ objectType, operationType }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.DRILL) {
		if (operationType === WebsocketTypes.OPERATION_TYPES.CREATE) {
			return true;
		}
	}
	return false;
};

export const isDeletedDrill = ({ objectType, operationType }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.DRILL) {
		if (operationType === WebsocketTypes.OPERATION_TYPES.DELETE) {
			return true;
		}
	}
	return false;
};

export const isNewNote = ({ objectType, operationType }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.NOTE) {
		if (operationType === WebsocketTypes.OPERATION_TYPES.CREATE) {
			return true;
		}
	}
	return false;
};

export const isDrillReorder = ({ objectType, operationType }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.DRILL) {
		if (operationType === WebsocketTypes.OPERATION_TYPES.REORDER) {
			return true;
		}
	}
	return false;
};

export const isTaskStatusUpdate = ({ objectType, operationType, edittedKey }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.TASK) {
		if (operationType === WebsocketTypes.OPERATION_TYPES.EDIT && edittedKey === TaskEditKeys.STATUS) {
			return true;
		}
	}
	return false;
};

export const isAttachmentUpload = ({ objectType, operationType }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.ATTACHMENT) {
		if (operationType === WebsocketTypes.OPERATION_TYPES.CREATE) {
			return true;
		}
	}
	return false;
};

export const isAttachmentDelete = ({ objectType, operationType }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.ATTACHMENT) {
		if (operationType === WebsocketTypes.OPERATION_TYPES.DELETE) {
			return true;
		}
	}
	return false;
};

export const isTaskDescriptionEdit = ({ objectType, operationType, edittedKey }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.TASK) {
		if (operationType === WebsocketTypes.OPERATION_TYPES.EDIT && edittedKey === TaskEditKeys.DESCRIPTION) {
			return true;
		}
	}
	return false;
};

export const isChatMessage = ({ objectType, operationType }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.CHAT) {
		if (operationType === WebsocketTypes.OPERATION_TYPES.CREATE) {
			return true;
		}
	}

	return false;
};

export const isToast = ({ objectType, operationType }) => {
	if (objectType === WebsocketTypes.OBJECT_TYPES.TOAST) {
		switch (operationType) {
			case WebsocketTypes.OPERATION_TYPES.CREATE:
			case WebsocketTypes.OPERATION_TYPES.DELETE:
			case WebsocketTypes.OPERATION_TYPES.EDIT:
				return true;
			default:
				return false;
		}
	}
};
