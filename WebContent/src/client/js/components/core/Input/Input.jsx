import React, { Component, Fragment } from "react";
import PropTypes from "prop-types";
import { InputErrorIcon } from "./InputErrorIcon";
import "./Input.scss";

export const INPUT_SIZES = {
	XXSMALL: "xxs",
	XSMALL: "xs",
	SMALL: "sm",
	MEDIUM: "md",
	LARGE: "lg",
	FILL: "fill"
};

export const INPUT_TYPES = {
	REGULAR: "regular",
	GREY: "grey",
	ERROR: "error"
};

const getInputClass = (size, type) => {
	let returnClassname = "c2pc-input-";
	switch (type) {
		case INPUT_TYPES.GREY:
			returnClassname = "c2pc-input-grey-";
			break;
		case INPUT_TYPES.ERROR:
			returnClassname = "c2pc-input-error-";
			break;
	}
	if (
		size === INPUT_SIZES.XXSMALL ||
		size === INPUT_SIZES.XSMALL ||
		size === INPUT_SIZES.SMALL ||
		size === INPUT_SIZES.MEDIUM ||
		size === INPUT_SIZES.LARGE ||
		size === INPUT_SIZES.FILL
	) {
		return returnClassname + size;
	}
	return returnClassname + INPUT_SIZES.MEDIUM;
};

const getInputDivClass = (size, type, showError) => {
	let returnClassname = "input-flex-container-";
	switch (type) {
		case INPUT_TYPES.GREY:
			returnClassname = "input-flex-container-grey-";
			break;
	}
	if (showError) {
		returnClassname = "input-flex-container-error-";
	}
	if (
		size === INPUT_SIZES.XXSMALL ||
		size === INPUT_SIZES.XSMALL ||
		size === INPUT_SIZES.SMALL ||
		size === INPUT_SIZES.MEDIUM ||
		size === INPUT_SIZES.LARGE ||
		size === INPUT_SIZES.FILL
	) {
		return returnClassname + size;
	}
	return returnClassname + INPUT_SIZES.MEDIUM;
};

export class Input extends Component {
	constructor(props) {
		super(props);

		this.state = {
			value: ""
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

	// hacky way to set box shadow on a div when the input inside is focused
	// selector :focus-within on the div to set boxShadow works, but not for IE or Edge
	onFocus = (e) => {
		e.target.parentNode.style.boxShadow = "0 0 0.3125em rgba(255, 255, 255, 0.35)";
	};

	onBlur = (e) => {
		e.target.parentNode.style.boxShadow = null;
	};

	onKeyPress = (e) => {
		if (e.key === "Enter" && this.props.submit) {
			this.props.submit();
		}
	};

	render = () => {
		const { inputType, inputSize, focus, placeholder, showError } = this.props;
		const { value } = this.state;
		// defaults to 'medium' size and 'regular' type
		return (
			<div className={getInputDivClass(inputSize, inputType, showError.isError)}>
				<input
					className={getInputClass(inputSize, inputType)}
					value={value}
					onChange={this.onChange}
					onKeyPress={this.onKeyPress}
					autoFocus={focus}
					onFocus={(e) => {
						this.onFocus(e);
					}}
					onBlur={(e) => {
						this.onBlur(e);
					}}
					placeholder={placeholder}
				/>
				{showError.isError && (
					<InputErrorIcon
						errorMessage={showError.message}
						placement={showError.placement}
						tooltipAttached={showError.tooltipAttached}
					/>
				)}
			</div>
		);
	};
}

Input.defaultProps = {
	focus: false,
	placeholder: "",
	showError: {
		isError: false,
		tooltipAttached: true
	}
};

Input.propTypes = {
	onChange: PropTypes.func.isRequired,
	focus: PropTypes.bool,
	inputSize: PropTypes.oneOf([
		INPUT_SIZES.XXSMALL,
		INPUT_SIZES.XSMALL,
		INPUT_SIZES.SMALL,
		INPUT_SIZES.MEDIUM,
		INPUT_SIZES.LARGE,
		INPUT_SIZES.FILL
	]),
	inputType: PropTypes.oneOf([INPUT_TYPES.GREY, INPUT_TYPES.REGULAR, INPUT_TYPES.ERROR])
};
