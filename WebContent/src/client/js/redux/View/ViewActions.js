import { ViewConstants } from "./ViewConstants";

export const setCurrentView = (view) => {
	return {
		type: ViewConstants.SET_CURRENT_VIEW,
		payload: view
	};
};
