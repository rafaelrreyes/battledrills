import React from "react";
import { DraggableList } from "CORE/index";
import { API, areArraysEqual, DrillState } from "UTILITIES/index";

const CompletedDrills = ({
	completedDrills,
	onDrillClick,
	selectedDrill,
	user,
	previousCompleted,
	updateCompletedDrillOrder,
	pendingUpdateCompletedDrills,
	reorderDrillsError
}) => {
	const backendUpdate = (completedDrills) => {
		// if the reorder is the same as it before, don't send a POST
		if (areArraysEqual(previousCompleted, completedDrills)) {
			return;
		}
		const requestBody = {
			orderedCompletedDrills: completedDrills,
			user
		};
		API.reorder(
			requestBody,
			() => {
				updateCompletedDrillOrder(completedDrills);
			},
			(err) => {
				reorderDrillsError(DrillState.COMPLETED, err);
			}
		);
	};

	return (
		<DraggableList
			items={completedDrills}
			viewUpdate={pendingUpdateCompletedDrills}
			backendUpdate={backendUpdate}
			itemClick={onDrillClick}
			selectedItem={selectedDrill}
		/>
	);
};

export default CompletedDrills;
