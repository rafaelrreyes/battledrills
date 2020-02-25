import { BilletConstants } from "./BilletConstants";

export const editActiveBillet = (drillName, updatedTask) => {
	return {
		type: BilletConstants.EDIT_BILLET,
		payload: { drillName, updatedTask }
	};
};

export const setActiveBillet = (billet) => {
	return {
		type: BilletConstants.SET_ACTIVE_BILLET,
		payload: billet
	};
};
