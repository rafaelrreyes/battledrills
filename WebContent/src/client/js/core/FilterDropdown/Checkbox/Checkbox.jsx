import React, { useState, useEffect } from "react";
import { MaterialIconNames } from "UTILITIES";
import { Icon } from "CORE";
import "./Checkbox.scss";

const Checkbox = ({ isChecked = false, onChangeHandler = () => {}, label = "", value = 0 }) => {
	const [checked, setChecked] = useState(isChecked);

	return (
		<label className="checkbox-component">
			{getCheckmarkIcon(isChecked)}
			<span className="checkbox-label">{label}</span>
			<input
				type="checkbox"
				checked={isChecked}
				onChange={() => {
					setChecked(!checked);
					onChangeHandler(value, !checked);
				}}
			/>
		</label>
	);
};

export default Checkbox;

const getCheckmarkIcon = (checked) => {
	return checked ? (
		<Icon>{MaterialIconNames.CHECK_BOX}</Icon>
	) : (
		<Icon>{MaterialIconNames.CHECK_BOX_OUTLINE_BLANK}</Icon>
	);
};
