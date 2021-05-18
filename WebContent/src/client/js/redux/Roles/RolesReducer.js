import { RolesConstants } from "./RolesConstants";

const initialState = {
	roles: []
};

export default function (state = initialState, action) {
	const { payload, type } = action;

	switch (type) {
		case RolesConstants.SET_ROLES:
			return {
				...state,
				roles: [...payload]
			};
		case RolesConstants.EDIT_ROLE:
			return {
				...state,
				roles: editRole(state.roles, payload)
			};
		case RolesConstants.DELETE_ROLE:
			return {
				...state,
				roles: state.roles.filter((role) => {
					return role.id !== payload;
				})
			};
		default:
			return state;
	}
}

const editRole = (roles, edittedRole) => {
	const { id, name } = edittedRole;
	roles.forEach((role) => {
		if (role.id === id) {
			role = { ...edittedRole };
		}
	});

	return roles;
};
