import { BilletConstants } from "./BilletConstants";

export const editActiveBillet = (drillId, updatedTask) => {
	return {
		type: BilletConstants.EDIT_BILLET,
		payload: { drillId, updatedTask }
	};
};

export const setActiveBillet = (billet) => {
	return {
		type: BilletConstants.SET_ACTIVE_BILLET,
		payload: billet
	};
};
