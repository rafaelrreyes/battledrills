import React from "react";
import store from "REDUX/store";
import { API, MaterialIconNames, generateRandomId } from "UTILITIES";
import { ModalContentTypes } from "CORE";

// redux
import {
	getUser,
	getSelectedDrillName,
	setSelectedDrill,
	addRoleToTemplate,
	addTaskToTemplate,
	deleteRoleFromTemplate,
	showModal,
	closeModal
} from "REDUX";

export const getOwnerMenuActions = (isTemplate, owner) => {
	const selectedDrillName = getSelectedDrillName(store.getState());
	const user = getUser(store.getState());
	return [
		{
			name: "Add Subordinate",
			menuAction: () => {
				isTemplate ? addSubordinateTemplate(owner) : addSubordinate(selectedDrillName, owner, user);
			}
		},
		{
			name: "Add Task",
			menuAction: () => {
				isTemplate ? addTaskTemplate(owner) : addTask(selectedDrillName, owner, user);
			}
		},
		{
			name: "Delete",
			menuAction: () => {
				isTemplate ? deleteRoleTemplate(owner) : deleteRole(selectedDrillName, owner, user);
			}
		}
	];
};

const addSubordinateTemplate = (parentRole) => {
	store.dispatch(
		showModal(ModalContentTypes.NEW_OWNER, {
			title: `Add New Role`,
			icon: MaterialIconNames.ACCOUNT,
			fromTemplate: true,
			fromPalette: false,
			parentRole,
			action: ({ role, parent }) => {
				store.dispatch(addRoleToTemplate({ role, parent }));
				store.dispatch(closeModal());
			}
		})
	);
};

const addSubordinate = (drillName, owner, user) => {
	store.dispatch(
		showModal(ModalContentTypes.NEW_OWNER, {
			title: `Add New Role`,
			icon: MaterialIconNames.ACCOUNT,
			fromPalette: false,
			parentRole: owner,
			action: (role) => {
				const requestBody = {
					owner: role, // retrieved from drop down selection
					drillName,
					parent: owner, // owner in this case is the owner that has a subordinate being added to
					user
				};

				API.addSubordinateToOwner(requestBody, () => {
					// successfully added a subordinate
					API.getDrillByName(drillName, {}, (drill) => {
						// successfully updated selected drill
						store.dispatch(setSelectedDrill(drill));
					});
				});
				store.dispatch(closeModal());
			}
		})
	);
};

const addTask = (drillName, owner, user) => {
	store.dispatch(
		showModal(ModalContentTypes.NEW_TASK, {
			title: `Add New Task`,
			icon: MaterialIconNames.TASK,
			fromPalette: false,
			parentRole: owner,
			action: ({ description }) => {
				const requestBody = {
					drillName,
					description,
					owner,
					user
				};

				API.addTaskToOwner(requestBody, () => {
					API.getDrillByName(drillName, {}, (drill) => {
						store.dispatch(setSelectedDrill(drill));
					});
				});
				store.dispatch(closeModal());
			}
		})
	);
};

const addTaskTemplate = (owner) => {
	store.dispatch(
		showModal(ModalContentTypes.NEW_TASK, {
			title: `Add New Task`,
			icon: MaterialIconNames.TASK,
			fromTemplate: true,
			fromPalette: false,
			action: ({ description }) => {
				const obj = {
					task: {
						taskId: `task-${generateRandomId()}`,
						description
					},
					owner
				};
				store.dispatch(addTaskToTemplate(obj));
				store.dispatch(closeModal());
			}
		})
	);
};

const deleteRole = (drillName, owner, user) => {
	store.dispatch(
		showModal(ModalContentTypes.CONFIRMATION, {
			title: `Delete Role`,
			description: `Deleting this role will delete all of its subordinates and associated tasks. Are you sure you want to delete ${owner}?`,
			icon: MaterialIconNames.DELETE,
			action: () => {
				const requestBody = {
					owner,
					drillName,
					user
				};
				API.deleteOwner(requestBody, () => {
					// successfully deleted owner
					API.getDrillByName(drillName, {}, (drill) => {
						// successfully updated selected drill
						store.dispatch(setSelectedDrill(drill));
					});
				});
				store.dispatch(closeModal());
			}
		})
	);
};

const deleteRoleTemplate = (owner) => {
	store.dispatch(
		showModal(ModalContentTypes.CONFIRMATION, {
			title: `Delete Role`,
			description: `Deleting this role will delete all of its subordinates and associated tasks. Are you sure you want to delete ${owner}?`,
			icon: MaterialIconNames.DELETE,
			action: () => {
				store.dispatch(deleteRoleFromTemplate(owner));
				store.dispatch(closeModal());
			}
		})
	);
};
