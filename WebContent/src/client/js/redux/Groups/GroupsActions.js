import { GroupsConstants } from "./GroupsConstants";

export const setGroups = (groups) => {
	return {
		type: GroupsConstants.SET_GROUPS,
		payload: groups
	};
};

export const editGroup = (group) => {
	return {
		type: GroupsConstants.EDIT_GROUP,
		payload: group
	};
};

export const deleteGroup = (groupId) => {
	return {
		type: GroupsConstants.DELETE_GROUP,
		payload: groupId
	};
};
