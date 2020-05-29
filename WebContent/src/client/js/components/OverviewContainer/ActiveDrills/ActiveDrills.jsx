import React, { useState } from "react";
import { DraggableList, Icon, MenuDropdown, openCreateDrillModal } from "CORE";
import { API, MaterialIconNames, areArraysEqual, DrillTypes } from "UTILITIES";

import "./ActiveDrills.scss";

const menuOptions = [
	{
		name: "Create Drill",
		menuAction: () => {
			openCreateDrillModal(DrillTypes.DEFAULT);
		}
	},
	{
		name: "Create Custom Drill",
		menuAction: () => {
			openCreateDrillModal(DrillTypes.CUSTOM);
		}
	}
];

const ActiveDrills = ({
	activeDrills,
	onDrillClick,
	selectedDrill,
	user,
	previousActive,
	updateActiveDrillOrder,
	pendingUpdateActiveDrills,
	reorderDrillsError
}) => {
	const [showMenu, setShowMenu] = useState(false);

	const showMenuHandler = () => {
		setShowMenu(!showMenu);
	};

	const backendUpdate = (activeDrills) => {
		// if the reorder is the same as it before, don't send a POST
		if (areArraysEqual(previousActive, activeDrills)) {
			return;
		}
		const requestBody = {
			orderedActiveDrills: activeDrills,
			user
		};
		API.reorder(
			requestBody,
			() => {
				updateActiveDrillOrder(activeDrills);
			},
			(err) => {
				reorderDrillsError(DrillState.ACTIVE, err);
			}
		);
	};

	return (
		<>
			<div className="card-title">
				<div className="active-drill-title-container">
					<span className="active-drill-header">Active Drills</span>
					<Icon className="create-drill-button" tooltip="Create New Drill" onClick={showMenuHandler}>
						{MaterialIconNames.ADD}
					</Icon>
					<div className="create-drill-menu">
						{showMenu && <MenuDropdown menuOptions={menuOptions} closeMenu={showMenuHandler} />}
					</div>
				</div>
			</div>
			<DraggableList
				items={activeDrills}
				// pending update used to preserve state before submitting to backend
				// it allows user to see where the list item will be dropped
				viewUpdate={pendingUpdateActiveDrills}
				backendUpdate={backendUpdate}
				itemClick={onDrillClick}
				selectedItem={selectedDrill}
			/>
		</>
	);
};

export default ActiveDrills;
