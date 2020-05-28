import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { DROPDOWN_DEFAULT } from "CORE";
import { API, selectTask, Routes } from "UTILITIES";
import {
	getAllStatus,
	getRolesFilter,
	setAllStatuses,
	updateAllDrills,
	getAllDrills,
	setRolesFilters,
	deleteRoleFilter,
	setCurrentView,
	setSelectedDrill
} from "REDUX";

import AllStatusTableView from "./AllStatusTableView/AllStatusTableView";
import AllStatusFilterView from "./AllStatusFilterView/AllStatusFilterView";
import AllStatusFooterView from "./AllStatusFooterView/AllStatusFooterView";
import "./AllStatusContainer.scss";

const DEFAULT_MAX_COLUMNS = 5;
const DEFAULT_DISPLAY_INDEX = 0;
const DEFAULT_ACTIVE_INDEX = 1;

const AllStatusContainer = () => {
	const [displayIndex, setDisplayIndex] = useState(DEFAULT_DISPLAY_INDEX);
	const [activePageIndex, setActivePageIndex] = useState(DEFAULT_ACTIVE_INDEX);
	const [drillsType, setDrillsType] = useState(DROPDOWN_DEFAULT);
	const dispatch = useDispatch();

	// redux selectors
	const statuses = useSelector(getAllStatus);
	const roles_filter = useSelector(getRolesFilter);
	const drills = useSelector(getAllDrills);

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
		dispatch(setRolesFilters(filters));
	};

	const onDeleteRoleFilter = (role) => {
		dispatch(deleteRoleFilter(role));
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

	const onTaskLinkClick = (drillName, task) => {
		API.getDrillByName(drillName, {}, (response) => {
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

	return (
		<div className="all-status-container">
			<AllStatusFilterView
				onFilterChange={onSetRolesFilters}
				onFilterDelete={onDeleteRoleFilter}
				onDrillsTypeChange={onChangeDrillsType}
				roles_filter={roles_filter}
			/>
			{drills.length === 0 ? (
				<div className="all-status-no-drills">No drills.</div>
			) : (
				<AllStatusTableView
					statuses={statuses}
					drills={getSlicedDrills()}
					roles={Array.from(roles_filter).sort()}
					onTaskLinkClick={onTaskLinkClick}
				/>
			)}
			<AllStatusFooterView
				numDrills={getDrillsByType().length}
				maxPerPage={DEFAULT_MAX_COLUMNS}
				displayIndex={displayIndex}
				drillWindowSize={getSlicedDrills().length}
				onDrillsPage={onDrillsPage}
				activePageIndex={activePageIndex}
			/>
		</div>
	);
};

export default AllStatusContainer;
