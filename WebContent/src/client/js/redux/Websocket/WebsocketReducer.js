import { WebsocketConstants } from "./WebsocketConstants";
import { ToastConstants } from "CORE/index";

const MAX_NOTIFICATIONS = 20;

const initialState = {
	data: {},
	toasts: [],
	unread: 0
};

let toastId = 0;

export default function(state = initialState, action) {
	const { type, payload } = action;
	switch (type) {
		case WebsocketConstants.SET_WEBSOCKET_DATA: {
			return {
				...state,
				data: {
					...payload
				}
			};
		}
		case WebsocketConstants.ADD_TOAST: {
			const newUnreadCount = state.unread <= MAX_NOTIFICATIONS ? state.unread + 1 : MAX_NOTIFICATIONS;
			if (state.unread <= MAX_NOTIFICATIONS) {
			}
			return {
				...state,
				toasts: addToast(payload, state.toasts),
				unread: newUnreadCount
			};
		}
		case WebsocketConstants.REMOVE_TOAST: {
			return {
				...state,
				toasts: [...state.toasts.filter((toast) => toast.toastId !== payload)]
			};
		}
		case WebsocketConstants.MARK_ALL_READ: {
			return {
				...state,
				unread: 0
			};
		}
		default:
			return state;
	}
}

const addToast = (payload, toasts) => {
	const enterDelay = ToastConstants.ENTER_DELAY;
	const exitDelay = ToastConstants.EXIT_DELAY;
	const newToast = { ...payload, enterDelay, exitDelay, toastId };
	toastId++;
	const currentToasts = toasts.slice();

	if (currentToasts.length >= MAX_NOTIFICATIONS) {
		currentToasts.shift();
	}

	currentToasts.push(newToast);
	return currentToasts;
};
