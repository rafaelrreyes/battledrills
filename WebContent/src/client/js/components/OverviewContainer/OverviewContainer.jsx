import React, { useState, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { DrillData, ActiveDrills, CompletedDrills } from "../";
import { API, MaterialIconNames, getElapsedTime, DrillState, Routes } from "UTILITIES";
import { ModalContentTypes, Icon } from "CORE";
import {
	getSelectedDrill,
	getPreviousActiveDrills,
	getActiveDrills,
	getPreviousCompletedDrills,
	getCompletedDrills,
	getUser,
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
} from "REDUX";

import "./OverviewContainer.scss";

const Options = {
	TIMER_INTERVAL: 1000 //1 second
};

const OverviewContainer = () => {
	const [elapsedTime, setElapsedTime] = useState("");
	const [isEditingDrill, setIsEditingDrill] = useState(false);
	const [drillName, setDrillName] = useState("");
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
						API.getDrillById(active[0].id, {}, (res) => {
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
		}, Options.TIMER_INTERVAL);

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

	const startDrillHandler = (id) => {
		API.startDrill(id, user, () => {
			API.getDrillById(id, {}, (response) => {
				dispatch(setSelectedDrill(response));
			});
		});
	};

	const stopDrillHandler = (id) => {
		API.stopDrill(id, user, (response) => {
			dispatch(setSelectedDrill(response));
			// remove this later and just transfer active drill to completed in Redux
			API.all({}, (res) => {
				dispatch(updateAllDrills(res));
			});
		});
	};

	const drillClickHandler = (id) => {
		API.getDrillById(id, {}, (response) => {
			dispatch(setSelectedDrill(response));
		});
	};

	const toggleDrillEditDrill = () => {
		if (isEditingDrill) {
			if (drillName.trim() === "") {
				// TODO validator for empty drill name field, maybe disable save button for now?
				return;
			} else {
				const requestBody = {
					name: drillName
				};
				API.editDrillNameById(
					selectedDrill.id,
					requestBody,
					(response) => {
						dispatch(setSelectedDrill(response));
						API.all({}, (res) => {
							const { active } = res;
							dispatch(updateAllDrills(res));
						});
					},
					() => {
						console.error("Error occurred when attempting to edit drill name");
					}
				);
			}
		}

		setIsEditingDrill(!isEditingDrill);
	};

	const onDrillNameChangeHandler = (name) => {
		setDrillName(name);
	};

	const deleteDrillHandler = () => {
		dispatch(
			showModal(ModalContentTypes.CONFIRMATION, {
				title: `Delete "${selectedDrill.name}"?`,
				icon: MaterialIconNames.DELETE,
				action: () => {
					API.deleteDrillById(
						selectedDrill.id,
						{ ...user },
						(response) => {
							// perform redux store update here
							const { active } = response;
							dispatch(updateAllDrills(response));
							if (Array.isArray(active) && active.length) {
								API.getDrillById(active[0].id, {}, (res) => {
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

	const renderEditDrillButton = () => {
		return typeof selectedDrill.id !== "undefined" ? (
			<Icon
				className="md-20"
				tooltip={`${isEditingDrill ? "Save" : "Edit"}`}
				onClick={() => {
					toggleDrillEditDrill();
				}}
			>
				{isEditingDrill ? MaterialIconNames.SAVE : MaterialIconNames.EDIT}
			</Icon>
		) : null;
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
					<div className="card-title">
						<span className="drill-info-header">Drill Information</span>
						<span className="edit-drill-button">{renderEditDrillButton()}</span>
					</div>
					{typeof selectedDrill === "undefined" ||
					(Object.entries(selectedDrill).length === 0 && selectedDrill.constructor === Object) ? (
						<></>
					) : (
						<div className="card-content">
							<DrillData
								isEditingDrill={isEditingDrill}
								onDrillNameChange={onDrillNameChangeHandler}
								drillInfo={selectedDrill}
								startDrill={startDrillHandler}
								stopDrill={stopDrillHandler}
								activeDrills={activeDrills}
								elapsedTime={elapsedTime}
								deleteDrill={deleteDrillHandler}
							/>
						</div>
					)}
				</div>
				<div className="card main-card-2">
					<ActiveDrills
						activeDrills={activeDrills}
						onDrillClick={drillClickHandler}
						selectedDrill={selectedDrill}
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
						onDrillClick={drillClickHandler}
						selectedDrill={selectedDrill}
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
