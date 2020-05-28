import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { List, ModalContentTypes, Icon } from "CORE";
import { API, parseType, MaterialIconNames } from "UTILITIES";
import { getUser, showModal, closeModal } from "REDUX";

import "./ManageTemplatesContainer.scss";

const ManageTemplatesContainer = ({ title, icon }) => {
	const [defaultTemplates, setDefaultTemplates] = useState([]);
	const [customTemplates, setCustomTemplates] = useState([]);
	const [overwrittenTemplates, setOverwrittenTemplates] = useState({});

	const dispatch = useDispatch();

	const user = useSelector(getUser);

	useEffect(() => {
		API.types({}, (response) => {
			setDefaultTemplates(response.default);
			setOverwrittenTemplates(response.overwritten);
			setCustomTemplates(response.custom);
		});
	}, []);

	const renderDefaultList = () => {
		const itemHeader = "Type";
		const title = "Default";

		// maybe we want to add a revert all button?
		const listCommands = [
			{
				label: "Revert All",
				callback: () => {
					console.log("reverting all overwritten default drills");
				}
			}
		];

		// we don't wanna allow deleting of default templates do we?
		// TODO extract this to outside the component
		const itemCommands = [
			{
				label: "Revert",
				type: "revert",
				icon: MaterialIconNames.UNDO,
				callback: (type) => {
					const requestBody = {
						type,
						user
					};
					API.revertDrillTemplate(requestBody, () => {
						API.types({}, (response) => {
							setOverwrittenTemplates(response.overwritten);
							setDefaultTemplates(response.default);
						});
					});
				}
			}
		];

		// Convert each default item in defaultItems string array into an object
		// Each object should have TODO
		const derivedItems = defaultTemplates.map((defaultItem) => {
			const derivedItem = {
				id: parseType(defaultItem)
			};

			if (overwrittenTemplates.hasOwnProperty(defaultItem)) {
				derivedItem.enabledCommands = ["revert"];
			}

			return derivedItem;
		});

		return <List title={title} itemHeader={itemHeader} itemCommands={itemCommands} items={derivedItems} />;
	};

	const renderCustomList = () => {
		const itemHeader = "Type";
		const title = "Custom";

		const deleteHandler = (templates) => {
			const requestBody = {
				templates,
				user
			};

			API.deleteDrillTemplates(requestBody, () => {
				API.types({}, (response) => {
					setCustomTemplates(response.custom);
				});
			});
		};

		const listCommands = [
			{
				label: "Create New",
				icon: MaterialIconNames.ADD,
				callback: () => {
					dispatch(
						showModal(ModalContentTypes.CREATE_TEMPLATE, {
							title: `Create New Template`,
							icon: MaterialIconNames.ADD,
							templates: {
								default: defaultTemplates,
								custom: customTemplates
							},
							action: (type) => {
								const requestBody = {
									type,
									user
								};

								API.createDrillTemplate(requestBody, () => {
									openManagerModal();
								});
							},
							cancelAction: () => {
								openManagerModal();
							}
						})
					);
				}
			}
		];

		// we don't wanna allow deleting of default templates do we?
		// TODO extract this to outside the component
		const itemCommands = [
			{
				label: "Delete",
				type: "delete",
				icon: MaterialIconNames.DELETE,
				callback: (type) => {
					const requestBody = {
						type,
						user
					};
					API.deleteDrillTemplate(requestBody, () => {
						API.types({}, (response) => {
							setCustomTemplates(response.custom);
						});
					});
				}
			}
		];

		// Convert each default item in customs string array into an object
		const derivedItems = customTemplates.map((customItem) => {
			const derivedItem = {
				id: parseType(customItem),
				enabledCommands: ["delete"]
			};

			return derivedItem;
		});

		return (
			<List
				title={title}
				itemHeader={itemHeader}
				listCommands={listCommands}
				itemCommands={itemCommands}
				items={derivedItems}
				allowDeletion={true}
				deleteHandler={deleteHandler}
			/>
		);
	};

	const openManagerModal = () => {
		// Go back to Manage templates modal

		dispatch(
			showModal(ModalContentTypes.MANAGE_TEMPLATES, {
				title: `Manage Templates`,
				singleButton: true,
				action: () => {
					dispatch(closeModal());
				}
			})
		);
	};

	return (
		<div className="manage-templates-container">
			{icon && <Icon className="md-36">{icon}</Icon>}
			{title && <div className="modal-title">{title}</div>}
			<div className="manage-templates-list-containers">
				{renderDefaultList()}
				{renderCustomList()}
			</div>
		</div>
	);
};

export default ManageTemplatesContainer;
