import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import { List, ListSizes, ScrollableTabs, TooltipPlacement } from "CORE";

import "./TemplateEditorTemplatesView.scss";

import { getSelectedTemplate, getUser, setSelectedTemplate, getPastEdits, getFutureEdits } from "REDUX";
import { API, parseType, undoParsedType, MaterialIconNames } from "UTILITIES";
import { promptCurrentEditSave, saveTemplate } from "../TemplateEditorHelper";

const TabOptions = {
	DEFAULT: "Default",
	CUSTOM: "Custom"
};

const TemplateEditorTemplatesView = ({ showTemplates }) => {
	const [defaultTemplates, setDefaultTemplates] = useState([]);
	const [customTemplates, setCustomTemplates] = useState([]);
	const [overwrittenTemplates, setOverwrittenTemplates] = useState({});

	const [selectedTab, setSelectedTab] = useState(TabOptions.DEFAULT);

	const dispatch = useDispatch();

	const selectedTemplate = useSelector(getSelectedTemplate);
	const pastEdits = useSelector(getPastEdits);
	const futureEdits = useSelector(getFutureEdits);
	const user = useSelector(getUser);

	useEffect(() => {
		API.types({}, (response) => {
			setDefaultTemplates(response.default);
			setOverwrittenTemplates(response.overwritten);
			setCustomTemplates(response.custom);
		});
	}, [selectedTemplate]);

	const renderDefaultList = () => {
		const itemHeader = "Type";

		// maybe add a revert all button?
		const listCommands = [
			{
				label: "Revert All",
				callback: () => {
					console.log("reverting all overwritten default drills");
				}
			}
		];

		// we don't wanna allow deleting of default templates right now
		// will add this support later
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

		const derivedItems = defaultTemplates.map((defaultItem) => {
			const derivedItem = {
				id: parseType(defaultItem)
			};

			// check to see if any of the default templates has been overwritten
			// then enable the revert button
			if (overwrittenTemplates.hasOwnProperty(defaultItem)) {
				derivedItem.enabledCommands = ["revert"];
			}

			return derivedItem;
		});

		return (
			<List
				size={ListSizes.FILL}
				itemHeader={itemHeader}
				selectedItem={
					selectedTemplate !== null && typeof selectedTemplate.type !== "undefined"
						? parseType(selectedTemplate.type)
						: ""
				}
				selectHandler={onTemplateSelect}
				itemCommands={itemCommands}
				items={derivedItems}
			/>
		);
	};

	const renderCustomList = () => {
		const itemHeader = "Type";

		// call back for deleting checked row items
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

		const derivedItems = customTemplates.map((customItem) => {
			const derivedItem = {
				id: parseType(customItem),
				enabledCommands: ["delete"]
			};

			return derivedItem;
		});

		return (
			<List
				size={ListSizes.FILL}
				itemHeader={itemHeader}
				itemCommands={itemCommands}
				selectHandler={onTemplateSelect}
				items={derivedItems}
				allowDeletion={true}
				deleteHandler={deleteHandler}
			/>
		);
	};

	const renderList = () => {
		return selectedTab === TabOptions.DEFAULT ? renderDefaultList() : renderCustomList();
	};

	const onTabSelect = (value) => {
		setSelectedTab(value.selectedName);
	};

	const onTemplateSelect = (id, successfulSelectCallback) => {
		// Prompt user if they want to save current changes before selecting new template
		if (selectedTemplate !== null && pastEdits.length !== 0) {
			promptCurrentEditSave(() => {
				saveTemplate(() => {
					const requestParams = {
						type: undoParsedType(id)
					};
					API.getTemplate(requestParams, (response) => {
						if (response !== null) {
							dispatch(setSelectedTemplate(response));
							successfulSelectCallback();
						}
					});
				});
			});
		} else {
			const requestParams = {
				type: undoParsedType(id)
			};

			API.getTemplate(requestParams, (response) => {
				if (response !== null) {
					dispatch(setSelectedTemplate(response));
					successfulSelectCallback();
				}
			});
		}
	};

	return (
		<div className="template-editor-templates-view">
			<span className="template-editor-tabs">
				<ScrollableTabs
					tabValues={[TabOptions.DEFAULT, TabOptions.CUSTOM]}
					onActiveTabSelected={onTabSelect}
					selectedItem={selectedTab}
					tooltipPlacement={TooltipPlacement.BOTTOM}
				/>
			</span>
			{renderList()}
		</div>
	);
};

export default TemplateEditorTemplatesView;
