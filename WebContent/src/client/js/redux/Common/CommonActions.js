import { CommonConstants } from "./CommonConstants";

export const setEditMode = (payload) => {
	return {
		type: CommonConstants.SET_EDIT_MODE,
		payload
	};
};
