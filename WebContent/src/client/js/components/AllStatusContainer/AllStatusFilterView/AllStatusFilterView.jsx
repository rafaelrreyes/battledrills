import React from "react";
import { UserConfiguration, MaterialIconNames } from "UTILITIES";
import { Dropdown, DropdownSizes, DropdownTypes, FilterDropdown, Icon } from "CORE";

import "./AllStatusFilterView.scss";

const DRILL_FILTER_TYPES = ["Active", "Completed"];

const AllStatusFilterView = ({ roles_filter, onFilterChange, onFilterDelete, onDrillsTypeChange }) => {
	return (
		<div className="all-status-filter-view">
			{renderFilterOptions(roles_filter, onDrillsTypeChange, onFilterChange)}
			<span className="all-status-filter-roles-container">
				<ul className="all-status-filter-roles-list">{renderFilteredRoles(roles_filter, onFilterDelete)}</ul>
			</span>
		</div>
	);
};

const renderFilteredRoles = (roles_filter, onFilterDelete) => {
	let filters = Array.from(roles_filter);
	if (filters.length === 0) {
		return <span className="all-status-filter-role-item">No filters active</span>;
	}

	// In the case that the filters is equal to the amount in the defined role set or more, set the filter to show ALL
	if (
		filters.length === UserConfiguration.DEFINED_ROLES.length + 1 ||
		filters.length === UserConfiguration.DEFINED_ROLES.length
	) {
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

const renderFilterOptions = (roles_filter, onDrillsTypeChange, onFilterChange) => {
	return (
		<>
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
				allFilters={UserConfiguration.DEFINED_ROLES}
				selectedFilters={roles_filter}
				handleCheckboxChange={(newFilters) => {
					onFilterChange(newFilters);
				}}
			/>
		</>
	);
};

export default AllStatusFilterView;
