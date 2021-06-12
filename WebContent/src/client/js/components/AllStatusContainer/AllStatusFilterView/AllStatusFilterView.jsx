import React, { useEffect, useState } from "react";
import { UserConfiguration, MaterialIconNames, API } from "UTILITIES";
import { Dropdown, DropdownSizes, DropdownTypes, FilterDropdown, Icon, ToggleSwitch } from "CORE";

import "./AllStatusFilterView.scss";

const DRILL_FILTER_TYPES = ["Active", "Completed"];

const AllStatusFilterView = ({
	roles_filter,
	onFilterChange,
	onFilterDelete,
	onDrillsTypeChange,
	onShowRolesWithoutTasks,
	showRolesWithoutTasks
}) => {
	const [allPossibleRoles, setAllPossibleRoles] = useState([]);

	useEffect(() => {
		API.getRoles((roles) => {
			const queriedRoles = roles
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

			setAllPossibleRoles(queriedRoles);
		});
	}, []);

	const renderFilterOptions = (roles_filter, onDrillsTypeChange) => {
		return (
			<div className="filter-options">
				<div className="filter-options-main">
					<span className="drill-dropdown">
						<Dropdown
							dropdownType={DropdownTypes.REGULAR}
							dropdownSize={DropdownSizes.LARGE}
							options={DRILL_FILTER_TYPES}
							onChange={onDrillsTypeChange}
							firstOption={"All Drills"}
						/>
					</span>
					<FilterDropdown
						allFilters={allPossibleRoles}
						selectedFilters={roles_filter}
						handleCheckboxChange={onFilterChange}
					/>
				</div>
				<div className="filter-options-optional">
					<label className="filter-options-label">Show Roles Without Tasking</label>
					<ToggleSwitch
						defaultToggle={showRolesWithoutTasks}
						onToggleProp={(value) => {
							onShowRolesWithoutTasks(value);
						}}
					></ToggleSwitch>
				</div>
			</div>
		);
	};

	return (
		<div className="all-status-filter-view">
			{renderFilterOptions(roles_filter, onDrillsTypeChange)}

			<span className="all-status-filter-roles-container">
				<ul className="all-status-filter-roles-list">
					{/* {renderFilteredRoles(allRoles, roles_filter, onFilterDelete)} */}
				</ul>
			</span>
		</div>
	);
};

const renderFilteredRoles = (allRoles, roles_filter, onFilterDelete) => {
	let filters = Array.from(roles_filter);
	if (filters.length === 0) {
		return <span className="all-status-filter-role-item">No filters active</span>;
	}

	// In the case that the filters is equal to the amount in the defined role set or more, set the filter to show ALL
	if (filters.length === allRoles.length + 1) {
		return <span className="all-status-filter-role-item">ALL</span>;
	}

	return filters.map((role, index) => {
		return (
			<span className="all-status-filter-role-item" key={role + index}>
				{role}
				<Icon
					className="all-status-filter-delete"
					onClick={() => {
						onFilterDelete(role);
					}}
				>
					{MaterialIconNames.CLOSE}
				</Icon>
			</span>
		);
	});
};

export default AllStatusFilterView;
