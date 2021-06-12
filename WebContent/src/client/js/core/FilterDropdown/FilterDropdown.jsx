import React, { useState } from "react";
import PropTypes from "prop-types";
import Checkbox from "./Checkbox/Checkbox";
import "./FilterDropdown.scss";

export const FilterDropdownDefaults = {
	ALL: "ALL"
};

export const FilterDropdown = ({ allFilters = [], selectedFilters = [], handleCheckboxChange = () => {} }) => {
	const [isDropdownVisible, setIsDropdownVisible] = useState(false);

	/**
	 * Handles toggling display of dropdown.
	 * @param {event object} e Eventing object from click
	 */
	const onDropdownClick = (e) => {
		e.preventDefault();
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
	const renderFilterItems = () => {
		if (isDropdownVisible) {
			let items = allFilters.map((filter) => {
				let id,
					name = filter;

				if (typeof filter === "object") {
					id = filter.id;
					name = filter.name;
				}

				const found = selectedFilters.find((filter) => {
					return filter.id === id;
				});

				return (
					<li className="filter-item" key={`filter-dropdown-option-${id}`}>
						<span className="filter-item-label">
							<Checkbox
								isChecked={typeof found !== "undefined"}
								label={name}
								value={id}
								onChangeHandler={onCheckboxChecked}
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

					{items}
				</ul>
			);
		}
		return null;
	};

	/**
	 * Handler for whenever any Checkbox is checked, including the ALL filter.
	 * @param {string} filterId The filter value being checked
	 * @param {boolean} checked Flag that holds whether current checkbox is already checked
	 * @param {Set of Strings} selectedFilters Filters that are currently checked
	 * @param {Array of Strings} allFilters All possible filters, checked or unchecked in the entire dropdown
	 * @param {function} handleCheckboxChange Callback that returns the new set of filters
	 */
	const onCheckboxChecked = (filterId, checked) => {
		let currentFilters = [...selectedFilters];
		// set the current filters to all items including the all checkbox if it was not checked yet
		if (filterId === "*" && !checked) {
			// const allFiltered = [{ id: "*", name: FilterDropdownDefaults.ALL }, ...allFilters];
			// handleCheckboxChange(allFiltered);
			// return;
		}
		// ALL checkbox being unchecked, clear all filters
		else if (filterId === "*" && checked) {
			// currentFilters = [];
		}
		// handle all other checkbox toggles
		else {
			// if any other checkbox is unchecked when ALL filter was on, remove ALL filter
			// if (checked && currentFilters[0].id === "*" && filterId !== "*") {
			// 	currentFilters.shift();
			// }

			// remove existing filter if being unchecked
			const hasFilterIndex = currentFilters.findIndex((filter) => {
				return filter.id === filterId;
			});

			if (hasFilterIndex !== -1) {
				currentFilters.splice(hasFilterIndex, 1);

				if (currentFilters[0].id === "*") {
					currentFilters.shift();
				}

				// add new filter that is being checked
			} else {
				const newFilter = allFilters.find((filter) => {
					return filter.id === filterId;
				});
				currentFilters.push({ id: newFilter.id, name: newFilter.name });

				// if (currentFilters.length === allFilters.length) {
				// 	currentFilters.unshift({ id: "*", name: "ALL" });
				// }
			}
		}

		// send new set of filters to parent component
		handleCheckboxChange(currentFilters);
	};

	return (
		<div
			className="filter-dropdown"
			onClick={(e) => {
				onDropdownClick(e);
			}}
		>
			<span className="filter-dropdown-default">Select Filters</span>
			{renderFilterItems()}
		</div>
	);
};

FilterDropdown.defaultProps = {
	allFilters: [],
	selectedFilters: []
};

FilterDropdown.propTypes = {
	allFilters: PropTypes.array.isRequired,
	// object must be of type Set
	selectedFilters: PropTypes.array.isRequired,
	handleCheckboxChange: PropTypes.func.isRequired
};
