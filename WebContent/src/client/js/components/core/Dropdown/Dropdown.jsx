import React, { Component } from "react";
import PropTypes from "prop-types";
import "./Dropdown.scss";

export const DROPDOWN_SIZES = {
	XXSMALL: "xxs",
	XSMALL: "xs",
	SMALL: "sm",
	MEDIUM: "md",
	LARGE: "lg",
	FILL: "fill"
};

export const DROPDOWN_TYPES = {
	REGULAR: "regular",
	GREY: "grey"
};

const getDropdownClass = (size, type, showError) => {
	let returnClassname = "c2pc-dropdown-";
	if (type === DROPDOWN_TYPES.GREY) {
		returnClassname = "c2pc-dropdown-grey-";
	}
	if (showError.isError) {
		returnClassname = "c2pc-dropdown-error-";
	}
	if (
		size === DROPDOWN_SIZES.XXSMALL ||
		size === DROPDOWN_SIZES.XSMALL ||
		size === DROPDOWN_SIZES.SMALL ||
		size === DROPDOWN_SIZES.MEDIUM ||
		size === DROPDOWN_SIZES.LARGE ||
		size === DROPDOWN_SIZES.FILL
	) {
		return returnClassname + size;
	}
	return returnClassname + DROPDOWN_SIZES.MEDIUM;
};

export class Dropdown extends Component {
	constructor(props) {
		super(props);

		this.state = {
			value: props.defaultOption ? props.defaultOption : "Select an option"
		};
	}

	onChange = (e) => {
		this.setState(
			{
				value: e.target.value
			},
			() => {
				this.props.onChange(this.state.value);
			}
		);
	};

	renderOptions = () => {
		const { options } = this.props;
		return options.map((option, index) => {
			return (
				<option key={index} value={option}>
					{option}
				</option>
			);
		});
	};

	render = () => {
		const { value } = this.state;
		// extract self-defined props and the rest put into tooltipProps to spread on <select>
		// tooltipProps is used for the tooltips to work for components correctly
		const {
			dropdownSize,
			dropdownType,
			showError,
			defaultValid,
			defaultOption,
			onChange,
			options,
			...toolTipProps
		} = this.props;
		// defaults to 'medium' size and 'regular' type
		return (
			<select
				{...toolTipProps}
				required
				value={value}
				onChange={this.onChange}
				className={getDropdownClass(dropdownSize, dropdownType, showError)}
			>
				<option value={defaultValid ? defaultOption : ""}>{defaultOption}</option>
				{this.renderOptions()}
			</select>
		);
	};
}

Dropdown.defaultProps = {
	showError: false,
	defaultValid: true,
	defaultOption: "Select an option"
};

Dropdown.propTypes = {
	options: PropTypes.array.isRequired,
	onChange: PropTypes.func.isRequired,
	defaultOption: PropTypes.string,
	dropdownSize: PropTypes.oneOf([
		DROPDOWN_SIZES.XXSMALL,
		DROPDOWN_SIZES.XSMALL,
		DROPDOWN_SIZES.SMALL,
		DROPDOWN_SIZES.MEDIUM,
		DROPDOWN_SIZES.LARGE,
		DROPDOWN_SIZES.FILL
	]),
	dropdownType: PropTypes.oneOf([DROPDOWN_TYPES.GREY, DROPDOWN_TYPES.REGULAR])
};
