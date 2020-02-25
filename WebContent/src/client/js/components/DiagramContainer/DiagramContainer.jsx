import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useLocation } from "react-router-dom";
import { DiagramViewContainer, DetailedViewContainer } from "../index";
import { TaskPriorityContainer } from "../index";
import { getSelectedDrill, getActiveDrills, getCompletedDrills, getSelectedTask } from "REDUX/index";
import {
	setSelectedDrill,
	resetSelectedTask,
	resetSelectedDrill,
	resetActiveTasks,
	updateAllDrills,
	setCurrentView
} from "REDUX/index";
import { ScrollableTabs, TooltipPlacement } from "CORE/index";
import { API, MaterialIconNames, Routes } from "UTILITIES/index";
//css
import "./DiagramContainer.scss";

const DiagramContainer = () => {
	const location = useLocation();

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
				}
			} else {
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
			}
		});
		// on unmount, reset active tasks
		return () => {
			dispatch(resetSelectedTask());
			dispatch(resetActiveTasks());
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
					<i className="material-icons">{MaterialIconNames.ARROW_RIGHT}</i>
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
				<div className="task-priority-flex-box">
					<TaskPriorityContainer />
				</div>
			)}
			<div className="diagram-detailed-flex-box">
				<DiagramViewContainer />
				{renderDetailedView()}
			</div>
		</div>
	);
};

export default DiagramContainer;
