import { UserConstants } from "./UserConstants";

const initialState = {
	username: "",
	name: "",
	id: 0,
	sessionId: ""
};

export default function (state = initialState, action) {
	const { payload, type } = action;

	switch (type) {
		case UserConstants.SET_USER:
			return {
				...state,
				...payload
			};
		case UserConstants.SET_USERNAME:
			return {
				...state,
				username: payload
			};
		case UserConstants.SET_ROLE:
			return {
				...state,
				role: payload
			};
		case UserConstants.SET_SESSION_ID:
			return {
				...state,
				sessionId: payload
			};
		default:
			return state;
	}
}
