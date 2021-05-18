import { RolesConstants } from "./RolesConstants";

export const setRoles = (roles) => {
	return {
		type: RolesConstants.SET_ROLES,
		payload: roles
	};
};

export const editRole = (role) => {
	return {
		type: RolesConstants.EDIT_ROLE,
		payload: role
	};
};

export const deleteRole = (roleId) => {
	return {
		type: RolesConstants.DELETE_ROLE,
		payload: roleId
	};
};
