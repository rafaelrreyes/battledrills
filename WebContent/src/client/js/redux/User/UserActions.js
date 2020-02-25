import { UserConstants } from "./UserConstants";

export const setUser = (user) => {
	return {
		type: UserConstants.SET_USER,
		payload: user
	};
};

export const setUsername = (username) => {
	return {
		type: UserConstants.SET_USERNAME,
		payload: username
	};
};

export const setRole = (role) => {
	return {
		type: UserConstants.SET_ROLE,
		payload: role
	};
};

export const setSessionId = (sessionId) => {
	return {
		type: UserConstants.SET_SESSION_ID,
		payload: sessionId
	};
};
