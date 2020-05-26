import React, { useState, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { DrillData, ActiveDrills, CompletedDrills } from "../index";
import { API, MaterialIconNames, getElapsedTime, DrillState, Routes } from "UTILITIES/index";
import { ModalContentTypes } from "CORE/index";
import {
	getSelectedDrill,
	getPreviousActiveDrills,
	getActiveDrills,
	getPreviousCompletedDrills,
	getCompletedDrills,
	getUser
} from "REDUX/index";
import {
	setSelectedDrill,
	resetSelectedDrill,
	showModal,
	closeModal,
	updateAllDrills,
	updateActiveDrills,
	updateCompletedDrills,
	pendingUpdateActiveDrills,
	pendingUpdateCompletedDrills,
	revertActiveDrillOrder,
	revertCompletedDrillOrder,
	setCurrentView
} from "REDUX/index";
import "./OverviewContainer.scss";

const OPTIONS = {
	TIMER_INTERVAL: 1000 //1 second
};

const OverviewContainer = () => {
	const [elapsedTime, setElapsedTime] = useState("");
	let timeTicker = null;

	const dispatch = useDispatch();

	const selectedDrill = useSelector(getSelectedDrill);
	const previousActive = useSelector(getPreviousActiveDrills);
	const previousCompleted = useSelector(getPreviousCompletedDrills);
	const activeDrills = useSelector(getActiveDrills).slice();
	const completedDrills = useSelector(getCompletedDrills).slice();
	const user = useSelector(getUser);

	useEffect(() => {
		dispatch(setCurrentView(Routes.OVERVIEW));

		API.all(
			{},
			(response) => {
				const { active } = response;
				dispatch(updateAllDrills(response));
				if (selectedDrill.name === undefined) {
					if (Array.isArray(active) && active.length) {
						API.getDrillByName(active[0], {}, (res) => {
							if (res !== null) {
								dispatch(setSelectedDrill(res));
							}
						});
					}
				}
			},
			(err) => {
				console.error(err);
			}
		);
	}, []);

	useEffect(() => {
		updateElapsedTime();
		timeTicker = setInterval(() => {
			updateElapsedTime();
		}, OPTIONS.TIMER_INTERVAL);

		return () => {
			clearInterval(timeTicker);
		};
	}, [selectedDrill]);

	const updateElapsedTime = () => {
		if (typeof selectedDrill !== "undefined") {
			const { startTime, endTime } = selectedDrill;
			if ((startTime && !endTime) || (startTime && endTime)) {
				const newElapsedTime = getElapsedTime(startTime, endTime);
				if (elapsedTime !== newElapsedTime) {
					setElapsedTime(getElapsedTime(startTime, endTime));
				}
			} else {
				if (elapsedTime !== "N/A") {
					setElapsedTime("N/A");
				}
			}
		}
	};

	const startDrill = (drillName) => {
		API.startDrill(drillName, user, (response) => {
			API.getDrillByName(drillName, {}, (response) => {
				dispatch(setSelectedDrill(response));
			});
		});
	};

	const stopDrill = (drillName) => {
		API.stopDrill(drillName, user, (response) => {
			dispatch(setSelectedDrill(response));
			// remove this later and just transfer active drill to completed in Redux
			API.all({}, (res) => {
				dispatch(updateAllDrills(res));
			});
		});
	};

	const onDrillClick = (itemName) => {
		API.getDrillByName(itemName, {}, (response) => {
			dispatch(setSelectedDrill(response));
		});
	};

	const deleteDrill = () => {
		dispatch(
			showModal(ModalContentTypes.CONFIRMATION, {
				title: `Delete "${selectedDrill.name}"?`,
				icon: MaterialIconNames.DELETE,
				action: () => {
					API.deleteDrill(
						selectedDrill.name,
						{ ...user },
						(response) => {
							// perform redux store update here
							const { active } = response;
							dispatch(updateAllDrills(response));
							if (Array.isArray(active) && active.length) {
								API.getDrillByName(active[0], {}, (res) => {
									if (res !== null) {
										dispatch(setSelectedDrill(res));
									}
								});
							} else {
								dispatch(resetSelectedDrill());
							}
							dispatch(closeModal());
						},
						(err) => {
							console.log("delete failed", err);
						}
					);
				}
			})
		);
	};

	const reorderDrillsError = (type, err) => {
		dispatch(
			showModal(ModalContentTypes.CONFIRMATION, {
				title: `Reorder ${type} Drills`,
				icon: MaterialIconNames.ERROR,
				description: `Drill reorder failed ${err}`,
				singleButton: true
			})
		);
		type === DrillState.ACTIVE ? dispatch(revertActiveDrillOrder()) : dispatch(revertCompletedDrillOrder());
	};

	return (
		<>
			<div className="overview-container">
				<div className="card main-card-1">
					<div className="card-title">Drill Information and Actions</div>
					{typeof selectedDrill === "undefined" ||
					(Object.entries(selectedDrill).length === 0 && selectedDrill.constructor === Object) ? (
						<></>
					) : (
						<div className="card-content">
							<DrillData
								drillInfo={selectedDrill}
								startDrill={startDrill}
								stopDrill={stopDrill}
								activeDrills={activeDrills}
								elapsedTime={elapsedTime}
								deleteDrill={deleteDrill}
							/>
						</div>
					)}
				</div>
				<div className="card main-card-2">
					<ActiveDrills
						activeDrills={activeDrills}
						onDrillClick={onDrillClick}
						selectedDrill={selectedDrill.name}
						user={user}
						previousActive={previousActive}
						updateActiveDrillOrder={(drills) => {
							dispatch(updateActiveDrills(drills));
						}}
						pendingUpdateActiveDrills={(drills) => {
							dispatch(pendingUpdateActiveDrills(drills));
						}}
						reorderDrillsError={reorderDrillsError}
					/>
				</div>
				<div className="card main-card-3">
					<div className="card-title">Completed Drills</div>
					<CompletedDrills
						completedDrills={completedDrills}
						onDrillClick={onDrillClick}
						selectedDrill={selectedDrill.name}
						user={user}
						previousCompleted={previousCompleted}
						updateCompletedDrillOrder={(drills) => {
							dispatch(updateCompletedDrills(drills));
						}}
						pendingUpdateCompletedDrills={(drills) => {
							dispatch(pendingUpdateCompletedDrills(drills));
						}}
						reorderDrillsError={reorderDrillsError}
					/>
				</div>
			</div>
		</>
	);
};

export default OverviewContainer;
