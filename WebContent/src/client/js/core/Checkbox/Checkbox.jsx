import React, { useState, useEffect, useRef } from "react";
import { MaterialIconNames } from "UTILITIES";
import { Icon } from "CORE";
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
	const initialRender = useRef(true);
	useEffect(() => {
		// dont call onchangehandler on initial render
		if (initialRender.current) {
			initialRender.current = false;
		} else {
			onChangeHandler(checked);
		}
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
		return <Icon className="md-24">{MaterialIconNames.CHECK_BOX}</Icon>;
	} else {
		return <Icon className="md-24">{MaterialIconNames.CHECK_BOX_OUTLINE_BLANK}</Icon>;
	}
};
