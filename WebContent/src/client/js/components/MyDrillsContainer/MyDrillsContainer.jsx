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
	getUser,
	getSelectedTask
} from "REDUX";
import "./MyDrillsContainer.scss";

const MyDrillsContainer = () => {
	const dispatch = useDispatch();

	// redux selectors
	const selectedDrill = useSelector(getSelectedDrill);
	const selectedTask = useSelector(getSelectedTask);
	const billet = useSelector(getActiveBillet);
	const role = useSelector(getUser);

	useEffect(() => {
		dispatch(setCurrentView(Routes.MY_DRILLS)); // only do this on mount
	}, []);

	useEffect(() => {
		dispatch(resetSelectedTask());

		//temporary
		if (typeof role.id === "undefined") {
			dispatch(setUser({ username: "WO", name: "WO", id: 15 }));
		}

		// TODO
		if (typeof role.id !== "undefined" && role.id !== 0) {
			getNewRoleReportHandler(role);
		}
	}, [role]);

	const getNewRoleReportHandler = (role) => {
		API.getBilletByRoleId(role.id, {}, (data) => {
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
						<div className="drill-role-table">
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
