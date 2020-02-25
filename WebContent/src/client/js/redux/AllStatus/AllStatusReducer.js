import { AllStatusConstants } from "./AllStatusConstants";
import { UserConfiguration } from "UTILITIES/index";

const initialState = {
	statuses: {},
	roles_filter: new Set(["ALL", ...UserConfiguration.DEFINED_ROLES])
};

export default function(state = initialState, action) {
	switch (action.type) {
		case AllStatusConstants.UPDATE_STATUSES:
			break;
		case AllStatusConstants.SET_ALL_STATUSES:
			const statuses = action.payload;
			return {
				...state,
				statuses: { ...statuses }
			};
		case AllStatusConstants.SET_ROLES_FILTERS:
			const filters = action.payload;
			return {
				...state,
				roles_filter: filters
			};
		case AllStatusConstants.DELETE_ROLE_FILTER:
			const { roles_filter } = state;
			const targetRole = action.payload;
			const updatedFilters = new Set([...roles_filter]);
			if (updatedFilters.has(targetRole)) {
				updatedFilters.delete(targetRole);
			} else {
				return {
					...state,
					roles_filter: new Set(["ALL", ...UserConfiguration.DEFINED_ROLES])
				};
			}

			return {
				...state,
				roles_filter: new Set([...updatedFilters])
			};
		case AllStatusConstants.CLEAR_ROLE_FILTER:
			return {
				...state,
				roles_filter: []
			};
		case AllStatusConstants.RESET_ROLE_FILTER:
			return {
				...state,
				roles_filter: [...UserConfiguration.DEFINED_ROLES]
			};
		default:
			return state;
	}
}

//deep update status
const deepUpdateStatus = (statusToUpdate, newStatus) => {};
