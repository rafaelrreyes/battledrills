import { WebsocketConstants } from "./WebsocketConstants";

export const setWebsocketData = (message) => {
	return {
		type: WebsocketConstants.SET_WEBSOCKET_DATA,
		payload: message
	};
};

export const addToast = (toast) => {
	return {
		type: WebsocketConstants.ADD_TOAST,
		payload: toast
	};
};

export const removeToast = (toastId) => {
	return {
		type: WebsocketConstants.REMOVE_TOAST,
		payload: toastId
	};
};

export const markAllRead = () => {
	return {
		type: WebsocketConstants.MARK_ALL_READ
	};
};
