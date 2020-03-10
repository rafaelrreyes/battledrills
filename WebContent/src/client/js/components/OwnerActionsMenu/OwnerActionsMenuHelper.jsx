import React from "react";
import store from "REDUX/store";
import { API, MaterialIconNames } from "UTILITIES/";
import { ModalContentTypes } from "CORE/";

// redux
import { getUser, getSelectedDrillName, setSelectedDrill, showModal, closeModal } from "REDUX/";

export const getOwnerMenuActions = (owner) => {
	const selectedDrillName = getSelectedDrillName(store.getState());
	const user = getUser(store.getState());
	return [
		{
			name: "Add Subordinate",
			menuAction: () => {
				addSubordinate(selectedDrillName, owner, user);
			}
		},
		{
			name: "Add Task",
			menuAction: () => {
				addTask(selectedDrillName, owner, user);
			}
		},
		{
			name: "Delete",
			menuAction: () => {
				deleteOwner(selectedDrillName, owner, user);
			}
		}
	];
};

const addSubordinate = (drillName, owner, user) => {
	store.dispatch(
		showModal(ModalContentTypes.NEW_OWNER, {
			fromPalette: false,
			action: (role) => {
				const requestBody = {
					owner: role, // retrieved from drop down selection
					drillName,
					parent: owner, // owner in this case is the owner that has a subordinate being added to
					user
				};

				API.addSubordinateToOwner(
					requestBody,
					() => {
						// successfully added a subordinate
						API.getDrillByName(
							drillName,
							{},
							(drill) => {
								// successfully updated selected drill
								store.dispatch(setSelectedDrill(drill));
							},
							(err) => {
								console.error(`Error when updating selected drill while adding new subordinate.`);
							}
						);
					},
					(err) => {
						console.error(`Error when adding a subordinate role to ${owner}`);
					}
				);
				store.dispatch(closeModal());
			}
		})
	);
};

const addTask = (drillName, owner, user) => {
	store.dispatch(
		showModal(ModalContentTypes.NEW_TASK, {
			fromPalette: false,
			action: (description) => {
				const requestBody = {
					drillName,
					description,
					owner,
					user
				};

				API.addTaskToOwner(
					requestBody,
					() => {
						API.getDrillByName(drillName, {}, (drill) => {
							store.dispatch(setSelectedDrill(drill));
						});
					},
					(error) => {
						console.error(error);
					}
				);
				store.dispatch(closeModal());
			}
		})
	);
};

const deleteOwner = (drillName, owner, user) => {
	store.dispatch(
		showModal(ModalContentTypes.CONFIRMATION, {
			title: `Deleting this role will delete all of its subordinates and associated tasks. Are you sure you want to delete ${owner}?`,
			icon: MaterialIconNames.DELETE,
			action: () => {
				const requestBody = {
					owner,
					drillName,
					user
				};
				API.deleteOwner(
					requestBody,
					() => {
						// successfully deleted owner
						API.getDrillByName(
							drillName,
							{},
							(drill) => {
								// successfully updated selected drill
								store.dispatch(setSelectedDrill(drill));
							},
							(err) => {
								console.error(`Error when updating selected drill when deleting role ${owner}.`);
							}
						);
					},
					(err) => {
						console.error(`Error when deleting role ${owner}.`);
					}
				);
				store.dispatch(closeModal());
			}
		})
	);
};
