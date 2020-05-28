import React, { forwardRef, useState, useEffect } from "react";
import PropTypes from "prop-types";
import { InputErrorIcon } from "./InputErrorIcon";
import "./Input.scss";

export const InputSizes = {
	XXSMALL: "xxs",
	XSMALL: "xs",
	SMALL: "sm",
	MEDIUM: "md",
	LARGE: "lg",
	FILL: "fill"
};

export const InputTypes = {
	REGULAR: "regular",
	GREY: "grey",
	ERROR: "error"
};

const getInputClass = (size, type) => {
	let returnClassname = "c2pc-input-";
	switch (type) {
		case InputTypes.GREY:
			returnClassname = "c2pc-input-grey-";
			break;
		case InputTypes.ERROR:
			returnClassname = "c2pc-input-error-";
			break;
	}
	if (
		size === InputSizes.XXSMALL ||
		size === InputSizes.XSMALL ||
		size === InputSizes.SMALL ||
		size === InputSizes.MEDIUM ||
		size === InputSizes.LARGE ||
		size === InputSizes.FILL
	) {
		return returnClassname + size;
	}
	return returnClassname + InputSizes.MEDIUM;
};

const getInputDivClass = (size, type, error) => {
	let returnClassname = "input-flex-container-";
	switch (type) {
		case InputTypes.GREY:
			returnClassname = "input-flex-container-grey-";
			break;
	}
	if (error.isError) {
		returnClassname = "input-flex-container-error-";
	}
	if (
		size === InputSizes.XXSMALL ||
		size === InputSizes.XSMALL ||
		size === InputSizes.SMALL ||
		size === InputSizes.MEDIUM ||
		size === InputSizes.LARGE ||
		size === InputSizes.FILL
	) {
		return returnClassname + size;
	}
	return returnClassname + InputSizes.MEDIUM;
};

const errorDefault = {
	isError: false,
	tooltipAttached: true
};

export const Input = forwardRef(
	(
		{
			inputType,
			inputSize,
			focus = false,
			placeholder = "",
			onChange,
			submit,
			error = errorDefault,
			initValue = "",
			disabled = false
		},
		ref
	) => {
		const [value, setValue] = useState(initValue);

		useEffect(() => {
			setValue(initValue);
		}, [initValue]);

		const onInputChange = (e) => {
			setValue(e.target.value);
			onChange(e.target.value);
		};

		// hacky way to set box shadow on a div when the input inside is focused
		// selector :focus-within on the div to set boxShadow works, but not for IE or Edge
		const onFocus = (e) => {
			e.target.parentNode.style.boxShadow = "0 0 0.3125em rgba(255, 255, 255, 0.35)";
		};

		const onBlur = (e) => {
			e.target.parentNode.style.boxShadow = null;
		};

		const onKeyPress = (e) => {
			if (e.key === "Enter" && submit) {
				submit();
			}
		};

		// defaults to 'medium' size and 'regular' type
		return (
			<div className={getInputDivClass(inputSize, inputType, error)} ref={ref} disabled={disabled}>
				<input
					className={getInputClass(inputSize, inputType)}
					value={typeof value !== "undefined" || value === "" ? value : initValue}
					onChange={onInputChange}
					onKeyPress={onKeyPress}
					autoFocus={focus}
					onFocus={onFocus}
					onBlur={onBlur}
					placeholder={placeholder}
					disabled={disabled}
				/>
				{error.isError && (
					<InputErrorIcon
						errorMessage={error.message}
						placement={error.placement}
						tooltipAttached={error.tooltipAttached}
					/>
				)}
			</div>
		);
	}
);

Input.propTypes = {
	onChange: PropTypes.func.isRequired,
	focus: PropTypes.bool,
	inputSize: PropTypes.oneOf([
		InputSizes.XXSMALL,
		InputSizes.XSMALL,
		InputSizes.SMALL,
		InputSizes.MEDIUM,
		InputSizes.LARGE,
		InputSizes.FILL
	]),
	inputType: PropTypes.oneOf([InputTypes.GREY, InputTypes.REGULAR, InputTypes.ERROR])
};
