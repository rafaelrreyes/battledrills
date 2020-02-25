import React, { useState, useEffect } from "react";
import { MaterialIconNames } from "UTILITIES/index";
import "./Checkbox.scss";

export const CheckboxPlacement = {
	LEFT: "left",
	RIGHT: "right"
};

export const Checkbox = ({
	onChangeHandler,
	label = "",
	boxPosition = CheckboxPlacement.LEFT,
	initChecked = false
}) => {
	const [checked, setChecked] = useState(initChecked);

	useEffect(() => {
		onChangeHandler(checked);
	}, [checked]);

	return (
		<label className="generic-checkbox">
			{boxPosition === CheckboxPlacement.LEFT && (
				<>
					{getCheckmarkIcon(checked)}
					{label !== "" && <span className="checkbox-label-right">{label}</span>}
				</>
			)}
			{boxPosition === CheckboxPlacement.RIGHT && (
				<>
					{label !== "" && <span className="checkbox-label-left">{label}</span>}
					{getCheckmarkIcon(checked)}
				</>
			)}

			<input
				type="checkbox"
				checked={checked}
				value={label}
				onChange={() => {
					setChecked(!checked);
				}}
			/>
		</label>
	);
};

const getCheckmarkIcon = (checked) => {
	if (checked) {
		return <i className="material-icons md-24">{MaterialIconNames.CHECK_BOX}</i>;
	} else {
		return <i className="material-icons md-24">{MaterialIconNames.CHECK_BOX_OUTLINE_BLANK}</i>;
	}
};
