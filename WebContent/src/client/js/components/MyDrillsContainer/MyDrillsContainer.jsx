import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { DetailedViewContainer } from "COMPONENTS";
import MyDrillsView from "./MyDrillsView/MyDrillsView";
import MyDrillsStatistics from "./MyDrillsStatistics/MyDrillsStatistics";
import { API, MaterialIconNames, Routes } from "UTILITIES";
import { Icon } from "CORE";
import {
	setActiveBillet,
	setUser,
	resetSelectedTask,
	setCurrentView,
	getSelectedDrill,
	getActiveBillet,
	getRole,
	getSelectedTask
} from "REDUX";
import "./MyDrillsContainer.scss";

const MyDrillsContainer = () => {
	const dispatch = useDispatch();

	// redux selectors
	const selectedDrill = useSelector(getSelectedDrill);
	const selectedTask = useSelector(getSelectedTask);
	const billet = useSelector(getActiveBillet);
	const role = useSelector(getRole);

	useEffect(() => {
		dispatch(setCurrentView(Routes.MY_DRILLS)); // only do this on mount
	}, []);

	useEffect(() => {
		dispatch(resetSelectedTask());

		//temporary
		if (typeof role === "undefined") {
			dispatch(setUser({ username: "WO", role: "WO" }));
		}

		getNewOwnerReportHandler(role);
	}, [role]);

	const getNewOwnerReportHandler = (role) => {
		API.getOwnerBillet(role, {}, (data) => {
			dispatch(setActiveBillet(data));
		});
	};

	const renderDetailedView = () => {
		return Object.keys(selectedTask).length === 0 ? (
			<></>
		) : (
			<>
				<div
					className="detailed-view-side-bar-button"
					onClick={() => {
						dispatch(resetSelectedTask());
					}}
				>
					<Icon>{MaterialIconNames.ARROW_RIGHT}</Icon>
				</div>
				<DetailedViewContainer selectedDrill={selectedDrill} />
			</>
		);
	};

	return (
		<>
			<div className="drill-reports-container">
				<div className="drill-reports-main">
					<div className="drill-reports-left">
						<MyDrillsStatistics drills={billet} role={role} />
						<div className="drill-owner-table">
							<MyDrillsView drills={billet} />
						</div>
					</div>
					{renderDetailedView()}
				</div>
			</div>
		</>
	);
};

export default MyDrillsContainer;
