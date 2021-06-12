import React, { useState, useEffect, forwardRef } from "react";
import PropTypes from "prop-types";
import "./Dropdown.scss";

export const DropdownSizes = {
	XXSMALL: "xxs",
	XSMALL: "xs",
	SMALL: "sm",
	MEDIUM: "md",
	LARGE: "lg",
	FILL: "fill"
};

export const DropdownTypes = {
	REGULAR: "regular",
	GREY: "grey"
};

export const DROPDOWN_DEFAULT = "*";

const getDropdownClass = (size, type, showError) => {
	let returnClassname = "c2pc-dropdown-";
	if (type === DropdownTypes.GREY) {
		returnClassname = "c2pc-dropdown-grey-";
	}
	if (showError) {
		returnClassname = "c2pc-dropdown-error-";
	}
	if (
		size === DropdownSizes.XXSMALL ||
		size === DropdownSizes.XSMALL ||
		size === DropdownSizes.SMALL ||
		size === DropdownSizes.MEDIUM ||
		size === DropdownSizes.LARGE ||
		size === DropdownSizes.FILL
	) {
		return returnClassname + size;
	}
	return returnClassname + DropdownSizes.MEDIUM;
};

// extract self-defined props and the rest put into tooltipProps to spread on <select>
// tooltipProps is used for the tooltips to work for components correctly
// forwardRef needed for tooltips with functional components
export const Dropdown = forwardRef(
	(
		{
			dropdownSize,
			dropdownType,
			showError = false,
			firstValid = true,
			firstOption = "Select an option",
			defaultSelect = DROPDOWN_DEFAULT,
			onChange,
			options,
			groups,
			...tooltipProps
		},
		ref
	) => {
		const [value, setValue] = useState(firstOption);

		const onDropdownChange = (e) => {
			setValue(e.target.value);
			onChange(e.target.value);
		};

		useEffect(() => {
			if (defaultSelect !== undefined) {
				setValue(defaultSelect);
			}
		}, [defaultSelect]);

		const renderOptions = () => {
			return options.map((option, index) => {
				// if options items are arrays, then they are grouped
				if (typeof option === "object") {
					return (
						<option key={option.id + index} value={option.id}>
							{option.name}
						</option>
					);
				}
				if (Array.isArray(option)) {
					return (
						<optgroup key={groups[index] + index} className="c2pc-dropdown-opt-label" label={groups[index]}>
							{option.map((groupOption) => {
								return (
									<option key={groupOption + index} value={groupOption}>
										{groupOption}
									</option>
								);
							})}
						</optgroup>
					);
				} else {
					return (
						<option key={option + index} value={option}>
							{option}
						</option>
					);
				}
			});
		};

		// defaults to 'medium' size and 'regular' type
		return (
			<select
				ref={ref}
				{...tooltipProps}
				required
				value={value}
				onChange={onDropdownChange}
				className={getDropdownClass(dropdownSize, dropdownType, showError)}
			>
				<option value={DROPDOWN_DEFAULT} disabled={!firstValid}>
					{firstOption}
				</option>
				{renderOptions()}
			</select>
		);
	}
);

Dropdown.propTypes = {
	options: PropTypes.array.isRequired,
	onChange: PropTypes.func.isRequired,
	groups: PropTypes.array,
	firstOption: PropTypes.string,
	firstValid: PropTypes.bool,
	showError: PropTypes.bool,
	defaultSelect: PropTypes.string,
	dropdownSize: PropTypes.oneOf([
		DropdownSizes.XXSMALL,
		DropdownSizes.XSMALL,
		DropdownSizes.SMALL,
		DropdownSizes.MEDIUM,
		DropdownSizes.LARGE,
		DropdownSizes.FILL
	]),
	dropdownType: PropTypes.oneOf([DropdownTypes.GREY, DropdownTypes.REGULAR])
};
