import React, { useState } from "react";
import PropTypes from "prop-types";
import Checkbox from "./Checkbox/Checkbox";
import "./FilterDropdown.scss";

export const FilterDropdownDefaults = {
	ALL: "ALL"
};

export const FilterDropdown = ({ allFilters, selectedFilters, handleCheckboxChange }) => {
	const [isDropdownVisible, setIsDropdownVisible] = useState(false);

	return (
		<div
			className="filter-dropdown"
			onClick={(e) => {
				onDropdownClick(e, isDropdownVisible, setIsDropdownVisible);
			}}
		>
			<span className="filter-dropdown-default">Select Filters</span>
			{renderFilterItems(
				allFilters,
				selectedFilters,
				isDropdownVisible,
				setIsDropdownVisible,
				handleCheckboxChange
			)}
		</div>
	);
};

/**
 * Handles toggling display of dropdown.
 * @param {event object} e Eventing object from click
 * @param {boolean} isDropdownVisible State param
 * @param {function} setIsDropdownVisible State hook setter
 */
const onDropdownClick = (e, isDropdownVisible, setIsDropdownVisible) => {
	e.stopPropagation();
	setIsDropdownVisible(!isDropdownVisible);
};

/**
 * Renders all the filter items in the dropdown, including the ALL filter.
 * @param {Array of Strings} allFilters All possible filters, checked or unchecked in the entire dropdown
 * @param {Set of Strings} selectedFilters Filters that are currently checked
 * @param {boolean} isDropdownVisible State param
 * @param {function} handleCheckboxChange Callback that returns the new set of filters
 */
const renderFilterItems = (
	allFilters,
	selectedFilters,
	isDropdownVisible,
	setIsDropdownVisible,
	handleCheckboxChange
) => {
	if (isDropdownVisible) {
		let items = allFilters.map((filter) => {
			return (
				<li className="filter-item" key={filter}>
					<span className="filter-item-label">
						<Checkbox
							label={filter}
							selectedFilters={selectedFilters}
							onChangeHandler={(newFilter, checked) => {
								onCheckboxChecked(
									newFilter,
									checked,
									selectedFilters,
									allFilters,
									handleCheckboxChange
								);
							}}
						/>
					</span>
				</li>
			);
		});

		return (
			<ul
				className="filter-list"
				onClick={(e) => e.stopPropagation()}
				onMouseLeave={() => {
					setIsDropdownVisible(false);
				}}
			>
				{/* need to change this key to be dynamic */}
				<li className="filter-item" key={"selectAllFilterKey"}>
					<span className="filter-item-label">
						{/* Render ALL filter */}
						<Checkbox
							label={FilterDropdownDefaults.ALL}
							selectedFilters={selectedFilters}
							onChangeHandler={(newFilter, checked) => {
								onCheckboxChecked(
									newFilter,
									checked,
									selectedFilters,
									allFilters,
									handleCheckboxChange
								);
							}}
						/>
					</span>
				</li>
				{items}
			</ul>
		);
	}
	return null;
};

/**
 * Handler for whenever any Checkbox is checked, including the ALL filter.
 * @param {string} filter The filter being checked
 * @param {boolean} checked Flag that holds whether current checkbox is already checked
 * @param {Set of Strings} selectedFilters Filters that are currently checked
 * @param {Array of Strings} allFilters All possible filters, checked or unchecked in the entire dropdown
 * @param {function} handleCheckboxChange Callback that returns the new set of filters
 */
const onCheckboxChecked = (filter, checked, selectedFilters, allFilters, handleCheckboxChange) => {
	let currentFilters = new Set([...selectedFilters]);
	// set the current filters to all items including the all checkbox if it was not checked yet
	if (filter === FilterDropdownDefaults.ALL && !checked) {
		currentFilters.add(FilterDropdownDefaults.ALL);
		handleCheckboxChange(new Set([...currentFilters, ...allFilters]));
		return;
	}
	// ALL checkbox being unchecked, clear all filters
	else if (filter === FilterDropdownDefaults.ALL && checked) {
		currentFilters.clear();
	}
	// handle all other checkbox toggles
	else {
		// if any other checkbox is unchecked when ALL filter was on, remove ALL filter
		if (checked && currentFilters.has(FilterDropdownDefaults.ALL)) {
			currentFilters.delete(FilterDropdownDefaults.ALL);
		}

		// remove existing filter if being unchecked
		if (currentFilters.has(filter)) {
			currentFilters.delete(filter);

			// add new filter that is being checked
		} else {
			currentFilters.add(filter);
		}

		if (currentFilters.size === allFilters.length) {
			currentFilters.add(FilterDropdownDefaults.ALL);
		}
	}

	// send new set of filters to parent component
	handleCheckboxChange(currentFilters);
};

FilterDropdown.defaultProps = {
	allFilters: [],
	selectedFilters: new Set()
};

FilterDropdown.propTypes = {
	allFilters: PropTypes.array.isRequired,
	// object must be of type Set
	selectedFilters: PropTypes.object.isRequired,
	handleCheckboxChange: PropTypes.func.isRequired
};
