import React, { useState, useEffect } from "react";
import { MaterialIconNames } from "UTILITIES";
import { Icon } from "CORE";
import "./Checkbox.scss";

const Checkbox = ({ selectedFilters, onChangeHandler, label }) => {
	const [checked, setChecked] = useState(selectedFilters.has(label));

	useEffect(() => {
		setChecked(selectedFilters.has(label));
	}, [selectedFilters]);

	return (
		<label className="checkbox-component">
			{getCheckmarkIcon(checked)}
			<span className="checkbox-label">{label}</span>
			<input
				type="checkbox"
				checked={checked}
				value={label}
				onChange={() => {
					setChecked(!checked);
					onChangeHandler(label, checked);
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
