import React from "react";
import store from "REDUX/store";
import { API, MaterialIconNames, generateRandomId } from "UTILITIES";
import { ModalContentTypes } from "CORE";

// redux
import {
	getUser,
	getSelectedDrillId,
	setSelectedDrill,
	addRoleToTemplate,
	addTaskToTemplate,
	deleteRoleFromTemplate,
	showModal,
	closeModal
} from "REDUX";

export const getRoleMenuOptions = (isTemplate, roleId, roleName) => {
	const selectedDrillId = getSelectedDrillId(store.getState());
	const user = getUser(store.getState());
	const role = {
		roleId,
		roleName
	};
	return [
		{
			name: "Add Role",
			menuAction: () => {
				isTemplate ? addSubordinateTemplate(role) : addSubordinate(selectedDrillId, role, user);
			}
		},
		{
			name: "Delete Role",
			menuAction: () => {
				isTemplate ? deleteRoleTemplate(role) : deleteRole(selectedDrillId, role, user);
			}
		},
		{
			name: "Add Task",
			menuAction: () => {
				isTemplate ? addTaskTemplate(role) : addTask(selectedDrillId, role, user);
			}
		},
		{
			name: "Configure Tasks",
			menuAction: () => {
				isTemplate ? configureTaskTemplate(role) : configureTask(selectedDrillId, role, user);
			}
		}
	];
};

const addSubordinateTemplate = (parentRole) => {
	store.dispatch(
		showModal(ModalContentTypes.NEW_ROLE, {
			title: `Add New Role`,
			icon: MaterialIconNames.ACCOUNT,
			fromTemplate: true,
			fromPalette: false,
			parentRole: parentRole.roleName,
			parentId: parentRole.roleId,
			action: ({ roleId, roleName, parentId }) => {
				store.dispatch(addRoleToTemplate({ roleId: parseInt(roleId), roleName, parentId }));
				store.dispatch(closeModal());
			}
		})
	);
};

const addSubordinate = (drillId, parentRole, user) => {
	store.dispatch(
		showModal(ModalContentTypes.NEW_ROLE, {
			title: `Add New Role`,
			icon: MaterialIconNames.ACCOUNT,
			fromPalette: false,
			parentRole: parentRole.roleName,
			parentId: parentRole.roleId,
			action: ({ roleId }) => {
				const requestBody = {
					roleId, // retrieved from drop down selection
					drillId,
					parentId: parentRole.roleId, // role in this case is the parent role that has a subordinate being added to
					user
				};

				API.addRoleToDrill(requestBody, () => {
					// successfully added a subordinate
					API.getDrillById(drillId, {}, (drill) => {
						// successfully updated selected drill
						store.dispatch(setSelectedDrill(drill));
					});
				});
				store.dispatch(closeModal());
			}
		})
	);
};

const addTask = (drillId, role, user) => {
	store.dispatch(
		showModal(ModalContentTypes.NEW_TASK, {
			title: `Add New Task`,
			icon: MaterialIconNames.TASK,
			fromPalette: false,
			parentId: role.roleId,
			action: ({ description, roleId }) => {
				const requestBody = {
					drillId,
					description,
					roleId,
					user
				};

				API.addTaskToRole(requestBody, () => {
					API.getDrillById(drillId, {}, (drill) => {
						store.dispatch(setSelectedDrill(drill));
					});
				});
				store.dispatch(closeModal());
			}
		})
	);
};

const addTaskTemplate = (role) => {
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
					roleId: role.roleId
				};
				store.dispatch(addTaskToTemplate(obj));
				store.dispatch(closeModal());
			}
		})
	);
};

const configureTaskTemplate = (role) => {
	store.dispatch(
		showModal(ModalContentTypes.CONFIGURE_TASKS, {
			title: `Configure Tasks`,
			icon: MaterialIconNames.TASK,
			fromTemplate: true,
			fromPalette: false,
			role,
			action: () => {
				console.log(`testing configuring tasks of template drill`);
			}
		})
	);
};

const configureTask = (drillId, role, user) => {
	store.dispatch(
		showModal(ModalContentTypes.CONFIGURE_TASKS, {
			title: `Configure Tasks`,
			icon: MaterialIconNames.TASK,
			fromTemplate: true,
			fromPalette: false,
			role,
			action: () => {
				console.log(`testing configuring tasks of drill ${drillId}`);
			}
		})
	);
};

const deleteRole = (drillId, role, user) => {
	store.dispatch(
		showModal(ModalContentTypes.CONFIRMATION, {
			title: `Delete Role`,
			description: `Deleting this role will delete all of its subordinates and associated tasks. Are you sure you want to delete ${role.roleName}?`,
			icon: MaterialIconNames.DELETE,
			action: () => {
				const requestBody = {
					roleId: role.roleId,
					drillId,
					user
				};
				API.deleteRoleFromDrill(requestBody, () => {
					// successfully deleted role
					API.getDrillById(drillId, {}, (drill) => {
						// successfully updated selected drill
						store.dispatch(setSelectedDrill(drill));
					});
				});
				store.dispatch(closeModal());
			}
		})
	);
};

const deleteRoleTemplate = (role) => {
	store.dispatch(
		showModal(ModalContentTypes.CONFIRMATION, {
			title: `Delete Role`,
			description: `Deleting this role will delete all of its subordinates and associated tasks. Are you sure you want to delete this role?`,
			icon: MaterialIconNames.DELETE,
			action: () => {
				store.dispatch(deleteRoleFromTemplate(role.roleId));
				store.dispatch(closeModal());
			}
		})
	);
};
