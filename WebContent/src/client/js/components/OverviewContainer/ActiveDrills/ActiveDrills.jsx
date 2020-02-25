import React from "react";
import { DraggableList, openCreateDrillModal } from "CORE/index";
import { API, MaterialIconNames, areArraysEqual, DrillState } from "UTILITIES/index";

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
					Active Drills
					<button className="no-button active-drill-create-icon" onClick={openCreateDrillModal}>
						<i className="material-icons md-20">{MaterialIconNames.ADD_CIRCLE_OUTLINE}</i>
					</button>
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
