import React, { useState } from "react";
import Filler from "./Filler";
import "./ProgressBar.scss";

const LABEL_TYPES = {
	FRACTION: "fraction",
	PERCENT: "percent"
};

/**
 * Progress Bar contains a dynamic div that changes as completed tasks increase
 */
export const ProgressBar = ({ allTasks, completedTasks }) => {
	const [label, setLabel] = useState(LABEL_TYPES.FRACTION);

	const handleProgressBarClick = () => {
		switch (label) {
			case LABEL_TYPES.FRACTION:
				setLabel(LABEL_TYPES.PERCENT);
				break;
			case LABEL_TYPES.PERCENT:
				setLabel(LABEL_TYPES.FRACTION);
				break;
			default:
				break;
		}
	};

	return (
		<div
			className="progress-bar"
			onClick={() => {
				handleProgressBarClick();
			}}
		>
			<Filler completedTasks={completedTasks} allTasks={allTasks} labelType={label} />
		</div>
	);
};
