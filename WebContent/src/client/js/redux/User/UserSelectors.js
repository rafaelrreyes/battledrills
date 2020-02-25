export const getUser = (store) => {
	return store.User;
};

export const getUsername = (store) => {
	return store.User.username;
};

export const getRole = (store) => {
	return store.User.role;
};

export const getSessionId = (store) => {
	return store.User.sessionId;
};
