import React, { Component } from "react";
import PropTypes from "prop-types";
import "./Button.scss";

export const ButtonSizes = {
	XXSMALL: "xxs",
	XSMALL: "xs",
	SMALL: "sm",
	MEDIUM: "md",
	LARGE: "lg",
	FILL: "fill"
};

export const ButtonTypes = {
	REGULAR: "regular",
	GREY: "grey"
};

export const LabelAlignment = {
	LEFT: "left",
	RIGHT: "right",
	CENTER: "center"
};

export const LabelSizes = {
	SMALL: "sm",
	MEDIUM: "md",
	LARGE: "lg"
};

const getButtonClass = (size, type, alignment = LabelAlignment.CENTER, labelSize = LabelSizes.MEDIUM) => {
	let returnClassname = `c2pc-button-`;
	if (type === ButtonTypes.GREY) {
		returnClassname = "c2pc-button-grey-";
	}
	if (
		size === ButtonSizes.XXSMALL ||
		size === ButtonSizes.XSMALL ||
		size === ButtonSizes.SMALL ||
		size === ButtonSizes.MEDIUM ||
		size === ButtonSizes.LARGE ||
		size === ButtonSizes.FILL
	) {
		return returnClassname + size + ` label-${alignment} label-size-${labelSize}`;
	}

	return returnClassname + ButtonSizes.MEDIUM;
};

export const Button = ({ children, onClick, isDisabled, buttonSize, buttonType, alignLabel, labelSize }) => {
	// defaults to 'medium' size and 'regular' type
	return (
		<button
			disabled={isDisabled}
			onClick={onClick}
			className={getButtonClass(buttonSize, buttonType, alignLabel, labelSize)}
		>
			{children}
		</button>
	);
};

Button.propTypes = {
	onClick: PropTypes.func.isRequired,
	children: PropTypes.oneOfType([PropTypes.string, PropTypes.array]),
	isDisabled: PropTypes.bool,
	buttonSize: PropTypes.oneOf([
		ButtonSizes.XXSMALL,
		ButtonSizes.XSMALL,
		ButtonSizes.SMALL,
		ButtonSizes.MEDIUM,
		ButtonSizes.LARGE,
		ButtonSizes.FILL
	]),
	buttonType: PropTypes.oneOf([ButtonTypes.GREY, ButtonTypes.REGULAR]),
	labelAlign: PropTypes.oneOf([LabelAlignment.CENTER, LabelAlignment.LEFT, LabelAlignment.RIGHT])
};
