import { CommonConstants } from "./CommonConstants";

const initialState = {
	editMode: false
};

export default function(state = initialState, action) {
	const { type, payload } = action;
	switch (type) {
		case CommonConstants.SET_EDIT_MODE:
			return {
				...state,
				editMode: payload
			};
		default:
			return state;
	}
}
