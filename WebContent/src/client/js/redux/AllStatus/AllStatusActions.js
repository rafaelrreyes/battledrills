import { AllStatusConstants } from "./AllStatusConstants";

export const updateStatuses = (statuses) => {
	return {
		type: AllStatusConstants.UPDATE_STATUSES,
		payload: statuses
	};
};

export const setAllStatuses = (statuses) => {
	return {
		type: AllStatusConstants.SET_ALL_STATUSES,
		payload: statuses
	};
};

export const setRolesFilters = (filters) => {
	return {
		type: AllStatusConstants.SET_ROLES_FILTERS,
		payload: filters
	};
};

/**
 * Resets roles to include all roles.
 */
export const resetRoleFilter = () => {
	return {
		type: AllStatusConstants.RESET_ROLE_FILTER
	};
};

/**
 * Clears entire roles array.
 */
export const clearRoleFilter = () => {
	return {
		type: AllStatusConstants.CLEAR_ROLE_FILTER
	};
};

export const deleteRoleFilter = (role) => {
	return {
		type: AllStatusConstants.DELETE_ROLE_FILTER,
		payload: role
	};
};
