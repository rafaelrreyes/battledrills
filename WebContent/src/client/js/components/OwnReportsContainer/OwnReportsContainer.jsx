import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { DetailedViewContainer, OwnReportsDrills, OwnReportsStatistics } from "../";
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
import "./OwnReportsContainer.scss";

const OwnReportsContainer = () => {
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

		getNewOwnerReport(role);
	}, [role]);

	const getNewOwnerReport = (role) => {
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
						<OwnReportsStatistics drills={billet} role={role} />
						<div>
							<div className="drill-owner-table">
								<OwnReportsDrills drills={billet} />
							</div>
						</div>
					</div>
					{renderDetailedView()}
				</div>
			</div>
		</>
	);
};

export default OwnReportsContainer;
