import React, { useState, useEffect } from "react";
import { MaterialIconNames } from "UTILITIES";
import { Checkbox, Icon, TooltipPlacement } from "CORE";
import "./List.scss";

export const ListSizes = {
	SMALL: "sm",
	MEDIUM: "md",
	LARGE: "lg",
	XLARGE: "xl",
	FILL: "fill"
};

export const List = ({
	title = "",
	size = ListSizes.MEDIUM,
	itemHeader = "",
	selectedItem = "",
	items = [],
	itemCommands = [],
	listCommands = [],
	allowDeletion = false,
	deleteHandler = () => {},
	selectHandler
}) => {
	const [itemsToDelete, setItemsToDelete] = useState([]);

	// TODO default to nothing
	const [selectedItemId, setSelectedItemId] = useState(selectedItem ? selectedItem : "");

	const renderTopLevelCommands = () => {
		// can add to this component later
		// for now, we just need delete all selected

		const getAdditionalCommands = () => {
			return listCommands.map((listCommand, index) => {
				const { label, icon, callback, tooltip } = listCommand;
				return (
					<span key={index} className="command-button" onClick={callback}>
						<Icon tooltip={tooltip} tooltipPlacement={TooltipPlacement.LEFT}>
							{icon}
						</Icon>
						<label className="command-button-label">{label}</label>
					</span>
				);
			});
		};

		return (
			<div className="list-top-level-commands">
				{listCommands.length !== 0 && getAdditionalCommands()}
				{allowDeletion && (
					<span
						className={`command-button ${itemsToDelete.length === 0 ? "disable" : ""}`}
						onClick={onDeleteSelected}
					>
						<Icon>{MaterialIconNames.DELETE}</Icon>
					</span>
				)}
			</div>
		);
	};

	const renderListHeaders = () => {
		return (
			<span className="list-headers">
				{/* insert delete column if allowed */}
				{allowDeletion && items.length !== 0 && <span className="list-header-delete-filler"></span>}
				<span className="list-header-item list-header-main">{itemHeader}</span>
				{/* add actions if they are defined in props */}
				{itemCommands.length !== 0 && <span className="list-header-actions">Actions</span>}
			</span>
		);
	};

	const renderListItems = () => {
		return items.map((item, index) => {
			const { enabledCommands, id } = item;

			return (
				<li
					key={id + index}
					className={`list-row-item ${selectedItemId === id ? "selected" : ""}`}
					onClick={() => {
						onItemSelected(id);
					}}
				>
					{/* // insert delete checkbox column */}
					{allowDeletion && (
						<span className="list-column-item-checkbox">
							<Checkbox
								onChangeHandler={(toggled) => {
									toggled ? addItemToDelete(id) : removeItemFromDelete(id);
								}}
							/>
						</span>
					)}
					<span className="list-column-item-main">
						<div className="list-column-item-container">{id}</div>
					</span>
					{itemCommands.length !== 0 && (
						<span className="list-column-item-commands">
							{renderCommands(itemCommands, id, enabledCommands)}
						</span>
					)}
				</li>
			);
		});
	};

	const renderCommands = (itemCommands, itemId, enabledCommands) => {
		if (typeof enabledCommands !== "undefined") {
			return itemCommands.map((itemCommand, index) => {
				const { icon, type, label, callback, tooltip } = itemCommand;
				if (enabledCommands.indexOf(type) !== -1) {
					return (
						<span
							key={index}
							className="command-button"
							onClick={() => {
								callback(itemId);
							}}
						>
							{icon && (
								<Icon tooltip={tooltip} tooltipPlacement={TooltipPlacement.LEFT}>
									{icon}
								</Icon>
							)}
							{label && <label className="command-button-label">{label}</label>}
						</span>
					);
				} else {
					return null;
				}
			});
		}
	};

	const onItemSelected = (id) => {
		// set selected item on callback
		if (typeof selectHandler !== "undefined" && typeof selectHandler === "function") {
			selectHandler(id, () => {
				setSelectedItemId(id);
			});
		} else {
			setSelectedItemId(id);
		}
	};
	const onDeleteSelected = () => {
		deleteHandler(itemsToDelete);
		setItemsToDelete([]);
	};

	const addItemToDelete = (item) => {
		setItemsToDelete([...itemsToDelete, item]);
	};

	const removeItemFromDelete = (removedItem) => {
		const filteredItems = itemsToDelete.filter((item) => {
			return item !== removedItem;
		});
		setItemsToDelete(filteredItems);
	};

	return (
		<div className={`list-component-${size}`}>
			{renderListHeaders()}
			{title && <span className="list-title">{title}</span>}
			<div className="list-table">
				<ul className="list-items">{renderListItems()}</ul>
			</div>
			{renderTopLevelCommands()}
		</div>
	);
};
