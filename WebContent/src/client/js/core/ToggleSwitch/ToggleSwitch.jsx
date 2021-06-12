import React, { useState, useEffect } from "react";
import PropTypes from "prop-types";
import Switch from "react-switch";

import "./ToggleSwitch.scss";

export const ToggleSwitch = ({ label, defaultToggle = false, onToggleProp, disabled = false }) => {
	const [checked, setChecked] = useState(defaultToggle);

	const onToggle = (checked) => {
		setChecked(checked);
		if (typeof onToggleProp === "function") {
			onToggleProp(checked);
		}
	};

	return (
		<label className="toggle-switch-container">
			{label !== "" && <span>{label}</span>}
			<Switch
				checked={checked}
				onChange={onToggle}
				onColor="#00bcd4"
				onHandleColor="#FFFFFF"
				handleDiameter={20}
				uncheckedIcon={false}
				checkedIcon={false}
				boxShadow="0px 1px 5px rgba(0, 0, 0, 0.6)"
				activeBoxShadow="0px 0px 1px 10px rgba(0, 0, 0, 0.2)"
				height={14}
				width={32}
				className="react-switch"
				disabled={disabled}
			/>
		</label>
	);
};

ToggleSwitch.propTypes = {
	label: PropTypes.string,
	defaultToggle: PropTypes.bool,
	onToggleProp: PropTypes.func,
	disabled: PropTypes.bool
};
