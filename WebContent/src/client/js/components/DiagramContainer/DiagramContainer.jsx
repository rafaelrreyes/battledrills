import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useLocation } from "react-router-dom";
import { DiagramViewContainer, DetailedViewContainer } from "../";
import { DrillEditorView } from "../";
import joint from "jointjs/index";
import BattleDrillDiagram from "../../joint/BattleDrillDiagram";
import {
	setSelectedDrill,
	resetSelectedTask,
	resetSelectedDrill,
	updateAllDrills,
	setCurrentView,
	getSelectedDrill,
	getActiveDrills,
	getCompletedDrills,
	getSelectedTask
} from "REDUX";
import { ScrollableTabs, TooltipPlacement, Icon } from "CORE";
import { API, MaterialIconNames, Routes } from "UTILITIES";
//css
import "./DiagramContainer.scss";

const DiagramContainer = () => {
	const location = useLocation();

	const graph = new joint.dia.Graph();
	const battleDrillDiagram = new BattleDrillDiagram(graph);

	// redux dispatchers
	const dispatch = useDispatch();

	// redux selectors
	const selectedTask = useSelector(getSelectedTask);
	const selectedDrill = useSelector(getSelectedDrill);
	const activeDrills = useSelector(getActiveDrills);
	const completedDrills = useSelector(getCompletedDrills);

	useEffect(() => {
		dispatch(setCurrentView(location.pathname));
		API.all({}, (response) => {
			const { active, completed } = response;
			dispatch(updateAllDrills(response));
			if (location.pathname === Routes.ACTIVE_DIAGRAM) {
				// only need to select a drill if none is selected on mount
				if (typeof selectedDrill.name === "undefined" || !activeDrills.includes(selectedDrill.name)) {
					if (Array.isArray(active) && active.length) {
						API.getDrillByName(active[0], {}, (response) => {
							if (response !== null) {
								dispatch(setSelectedDrill(response));
							}
						});
					} else {
						dispatch(resetSelectedDrill());
					}
				} else {
					// have to make this extra call because for some reason, without doing it,
					// its causing the link style and smoothness to not work when navigating back from
					// another view unless clicking on a drill tab
					// After all, this would essentially update the selected drill to be from the backend, which is good in the case that it
					// is updated from any other clients
					API.getDrillByName(selectedDrill.name, {}, (response) => {
						if (response !== null) {
							dispatch(setSelectedDrill(response));
						}
					});
				}
			} else if (location.pathname === Routes.COMPLETED_DIAGRAM) {
				// only need to select a drill if none is selected on mount
				if (typeof selectedDrill.name === "undefined" || !completedDrills.includes(selectedDrill.name)) {
					if (Array.isArray(completed) && completed.length) {
						API.getDrillByName(completed[0], {}, (response) => {
							if (response !== null) {
								dispatch(setSelectedDrill(response));
							}
						});
					} else {
						dispatch(resetSelectedDrill());
					}
				}
			} else {
			}
		});
		// on unmount, reset active tasks
		return () => {
			dispatch(resetSelectedTask());
		};
	}, [location]);

	const onSetSelectedDrill = ({ selectedName }) => {
		API.getDrillByName(selectedName, {}, (response) => {
			dispatch(setSelectedDrill(response));
			dispatch(resetSelectedTask());
		});
	};

	const toggleCollapseDetails = () => {
		dispatch(resetSelectedTask());
	};

	const renderDetailedView = () => {
		return Object.keys(selectedTask).length === 0 ? (
			<></>
		) : (
			<>
				<div className="detailed-view-side-bar-button" onClick={toggleCollapseDetails}>
					<Icon>{MaterialIconNames.ARROW_RIGHT}</Icon>
				</div>
				<DetailedViewContainer />
			</>
		);
	};

	return (
		<div className="diagram-view-container">
			<div className="tab-flex-box">
				<ScrollableTabs
					tabValues={location.pathname === Routes.ACTIVE_DIAGRAM ? activeDrills : completedDrills}
					onActiveTabSelected={onSetSelectedDrill}
					selectedItem={selectedDrill.name}
					tooltipPlacement={TooltipPlacement.BOTTOM}
				/>
			</div>
			{location.pathname === Routes.ACTIVE_DIAGRAM && (
				<div className="diagram-view-bar">
					<DrillEditorView battleDrillDiagram={battleDrillDiagram} />
				</div>
			)}
			<div className="diagram-detailed-flex-box">
				<DiagramViewContainer graph={graph} battleDrillDiagram={battleDrillDiagram} />
				{renderDetailedView()}
			</div>
		</div>
	);
};

export default DiagramContainer;
