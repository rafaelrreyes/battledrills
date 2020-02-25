import { ViewConstants } from "./ViewConstants";

const initialState = {
	view: {}
};

export default function(state = initialState, action) {
	const { payload, type } = action;

	switch (type) {
		case ViewConstants.SET_CURRENT_VIEW:
			return {
				...state,
				view: payload
			};
		default:
			return state;
	}
}
