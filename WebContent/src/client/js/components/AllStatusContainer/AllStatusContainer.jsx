import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { DROPDOWN_DEFAULT, Spinner } from "CORE";
import { API, selectTask, Routes } from "UTILITIES";
import { getAllStatus, setAllStatuses, updateAllDrills, getAllDrills, setCurrentView, setSelectedDrill } from "REDUX";
import { useLocalStorage } from "HOOKS";

import AllStatusTableView from "./AllStatusTableView/AllStatusTableView";
import AllStatusFilterView from "./AllStatusFilterView/AllStatusFilterView";
import AllStatusFooterView from "./AllStatusFooterView/AllStatusFooterView";
import "./AllStatusContainer.scss";

const DEFAULT_MAX_COLUMNS = 5;
const DEFAULT_DISPLAY_INDEX = 0;
const DEFAULT_ACTIVE_INDEX = 1;

const AllStatusContainer = () => {
	const [isLoading, setIsLoading] = useState(false);
	const [displayIndex, setDisplayIndex] = useState(DEFAULT_DISPLAY_INDEX);
	const [activePageIndex, setActivePageIndex] = useState(DEFAULT_ACTIVE_INDEX);
	const [drillsType, setDrillsType] = useState(DROPDOWN_DEFAULT);
	const [showRolesWithoutTasks, setShowRolesWithoutTasks] = useLocalStorage("show-roles-without-tasks", false);

	const [filteredRoles, setFilteredRoles] = useState([]);
	const dispatch = useDispatch();

	// redux selectors
	const statuses = useSelector(getAllStatus);
	const drills = useSelector(getAllDrills);

	useEffect(() => {
		setIsLoading(true);
		API.getRoles((roles) => {
			const mappedRoles = roles
				.map(({ id, name }) => {
					return { id, name };
				})
				.sort((a, b) => {
					let nameA = a.name.toUpperCase();
					let nameB = b.name.toUpperCase();

					if (nameA < nameB) {
						return -1;
					}

					if (nameA > nameB) {
						return 1;
					}

					return 0;
				});
			setFilteredRoles([...mappedRoles]);
			setIsLoading(false);
		});
	}, []);

	useEffect(() => {
		dispatch(setCurrentView(Routes.STATUS)); // only do this on mount
	}, []);

	useEffect(() => {
		API.getMetrics({}, (successResponse) => {
			dispatch(setAllStatuses(successResponse));
		});

		API.all({}, (successResponse) => {
			dispatch(updateAllDrills(successResponse));
		});
	}, [drillsType]);

	const onSetRolesFilters = (filters) => {
		setFilteredRoles(
			filters.sort((a, b) => {
				let nameA = a.name.toUpperCase();
				let nameB = b.name.toUpperCase();

				if (nameA < nameB) {
					return -1;
				}

				if (nameA > nameB) {
					return 1;
				}

				return 0;
			})
		);
	};

	const onDeleteRoleFilter = (role) => {
		// TODO: remove redux
		// dispatch(deleteRoleFilter(role));
	};

	const onChangeDrillsType = (type) => {
		setDrillsType(type);
	};

	const onDrillsPage = (option) => {
		let newIndex = displayIndex;
		let newActivePageIndex = 0;

		if (Number.isInteger(option)) {
			newIndex = option * DEFAULT_MAX_COLUMNS - DEFAULT_MAX_COLUMNS;
			newActivePageIndex = option;
		} else if (option === "LEFT") {
			// do not go negative
			if (displayIndex !== 0) {
				newIndex = newIndex - DEFAULT_MAX_COLUMNS;
				newActivePageIndex = Math.floor((newIndex + DEFAULT_MAX_COLUMNS) / DEFAULT_MAX_COLUMNS);
			}
		} else if (option === "RIGHT") {
			// do not exceed beyond final index
			if (displayIndex < getDrillsByType().length - DEFAULT_MAX_COLUMNS) {
				newIndex = newIndex + DEFAULT_MAX_COLUMNS;
				newActivePageIndex = Math.floor((newIndex + DEFAULT_MAX_COLUMNS) / DEFAULT_MAX_COLUMNS);
			}
		}

		setActivePageIndex(newActivePageIndex);
		setDisplayIndex(newIndex);
	};

	const onTaskLinkClick = (drillId, task) => {
		API.getDrillById(drillId, {}, (response) => {
			dispatch(setSelectedDrill(response));
			selectTask(task);
		});
	};

	const getSlicedDrills = () => {
		return getDrillsByType().slice(displayIndex, displayIndex + DEFAULT_MAX_COLUMNS);
	};

	const getDrillsByType = () => {
		const { active, completed } = drills;
		let uppercasedDrillsType = drillsType.toUpperCase();
		let filteredDrills = [];
		if (uppercasedDrillsType === DROPDOWN_DEFAULT) {
			filteredDrills = [...active, ...completed];
		} else if (uppercasedDrillsType === "ACTIVE") {
			filteredDrills = active;
		} else if (uppercasedDrillsType === "COMPLETED") {
			filteredDrills = completed;
		}
		return filteredDrills;
	};

	const renderView = () => {
		if (isLoading) {
			return (
				<div className="loading-status-placeholder">
					<Spinner size="xl" />
				</div>
			);
		} else {
			const tableView =
				drills.length === 0 ? (
					<div className="all-status-no-drills">No drills.</div>
				) : (
					<AllStatusTableView
						statuses={statuses}
						drills={getSlicedDrills()}
						roles={filteredRoles}
						onTaskLinkClick={onTaskLinkClick}
						showRolesWithoutTasks={showRolesWithoutTasks}
					/>
				);

			return (
				<>
					<AllStatusFilterView
						onFilterChange={onSetRolesFilters}
						onFilterDelete={onDeleteRoleFilter}
						onDrillsTypeChange={onChangeDrillsType}
						roles_filter={filteredRoles}
						onShowRolesWithoutTasks={(value) => {
							setShowRolesWithoutTasks(value);
						}}
						showRolesWithoutTasks={showRolesWithoutTasks}
					/>
					{tableView}
					<AllStatusFooterView
						numDrills={getDrillsByType().length}
						maxPerPage={DEFAULT_MAX_COLUMNS}
						displayIndex={displayIndex}
						drillWindowSize={getSlicedDrills().length}
						onDrillsPage={onDrillsPage}
						activePageIndex={activePageIndex}
					/>
					;
				</>
			);
		}
	};

	return <div className="all-status-container">{renderView()}</div>;
};

export default AllStatusContainer;
