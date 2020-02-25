export const getWebsocketData = (store) => {
	return store.Websocket.data;
};

export const getToasts = (store) => {
	return store.Websocket.toasts;
};

export const getUnreadNotificationsCount = (store) => {
	return store.Websocket.unread;
};
