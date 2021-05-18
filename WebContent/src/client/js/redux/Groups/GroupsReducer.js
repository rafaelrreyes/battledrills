import { GroupsConstants } from "./GroupsConstants";

const initialState = {
	groups: []
};

export default function (state = initialState, action) {
	const { payload, type } = action;

	switch (type) {
		case GroupsConstants.SET_GROUPS:
			return {
				...state,
				groups: [...payload]
			};
		case GroupsConstants.EDIT_GROUP:
			return {
				...state,
				groups: editGroup(state.groups, payload)
			};
		case GroupsConstants.DELETE_GROUP:
			return {
				...state,
				groups: state.groups.filter((group) => {
					return group.id !== payload;
				})
			};
		default:
			return state;
	}
}

const editGroup = (groups, edittedGroup) => {
	const { id, name } = edittedGroup;
	const modified = [...groups];
	modified.forEach((group) => {
		if (group.id === id) {
			group = { ...edittedGroup };
		}
	});

	return modified;
};
