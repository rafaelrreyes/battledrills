import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useLocation } from "react-router-dom";
import { DetailedViewContainer } from "COMPONENTS";
import DiagramView from "./DiagramView/DiagramView";
import DiagramPaletteView from "./DiagramPaletteView/DiagramPaletteView";
import joint from "jointjs/index";
import BattleDrillDiagram from "JOINT/BattleDrillDiagram";
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

// scss
import "./DiagramContainer.scss";

const DiagramContainer = () => {
	const location = useLocation();

	const graph = new joint.dia.Graph();
	const diagram = new BattleDrillDiagram(graph);

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
				if (
					typeof selectedDrill.id === "undefined" ||
					!activeDrills
						.map((activeDrill) => {
							return activeDrill.id;
						})
						.includes(selectedDrill.id)
				) {
					if (Array.isArray(active) && active.length) {
						API.getDrillById(active[0].id, {}, (response) => {
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
					API.getDrillById(selectedDrill.id, {}, (response) => {
						if (response !== null) {
							dispatch(setSelectedDrill(response));
						}
					});
				}
			} else if (location.pathname === Routes.COMPLETED_DIAGRAM) {
				// only need to select a drill if none is selected on mount
				// TODO:
				if (
					typeof selectedDrill.id === "undefined" ||
					!completedDrills
						.map((completedDrill) => {
							return completedDrill.id;
						})
						.includes(selectedDrill.id)
				) {
					if (Array.isArray(completed) && completed.length) {
						API.getDrillById(completed[0].id, {}, (response) => {
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

	const tabSelectedHandler = ({ selected }) => {
		API.getDrillById(selected, {}, (response) => {
			dispatch(setSelectedDrill(response));
			dispatch(resetSelectedTask());
		});
	};

	const collapseDetailsHandler = () => {
		dispatch(resetSelectedTask());
	};

	const renderDetailedView = () => {
		return Object.keys(selectedTask).length === 0 ? (
			<></>
		) : (
			<>
				<div className="detailed-view-side-bar-button" onClick={collapseDetailsHandler}>
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
					onActiveTabSelected={tabSelectedHandler}
					selectedItem={selectedDrill.id}
					tooltipPlacement={TooltipPlacement.BOTTOM}
				/>
			</div>
			{location.pathname === Routes.ACTIVE_DIAGRAM && (
				<div className="diagram-view-bar">
					<DiagramPaletteView diagram={diagram} />
				</div>
			)}
			<div className="diagram-detailed-flex-box">
				<DiagramView graph={graph} diagram={diagram} />
				{renderDetailedView()}
			</div>
		</div>
	);
};

export default DiagramContainer;
