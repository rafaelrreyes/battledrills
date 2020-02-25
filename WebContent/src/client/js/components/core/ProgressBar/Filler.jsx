//import React, { Component } from "react";
import React from "react";
import "./ProgressBar.scss";

const Filler = ({ completedTasks, allTasks, labelType }) => {
	let percentage = (completedTasks / allTasks) * 100;

	// helper method returns task progress as a percentage or fraction
	const selectLabel = (labelType, completedTasks, allTasks) => {
		let percentage = (completedTasks / allTasks) * 100;
		percentage = Math.ceil(percentage);

		if (labelType === "fraction") {
			return `${completedTasks}/${allTasks}`;
		} else {
			return `${percentage}%`;
		}
	};

	/**
	 * if taks completion is 100 then generate a green colored prog bar
	 * if task completion is greater than 25% display progress on the left side
	 * 		of progress bar filler
	 * otherwise progress wil be displayed on the center of the progress bar
	 * note that several cases were made to account for CSS padding adjustments
	 */
	if (percentage === 100) {
		return (
			<div className="progress-bar-filler-container">
				<div className="progress-bar-filler" style={{ width: `100%`, background: `green` }}>
					{selectLabel(labelType, completedTasks, allTasks)}
				</div>
			</div>
		);
	} else if (percentage > 25 && percentage < 100) {
		return (
			<div className="progress-bar-filler-container">
				<div className="progress-bar-filler" style={{ width: `${percentage}%` }}>
					{selectLabel(labelType, completedTasks, allTasks)}
				</div>
			</div>
		);
	} else if (percentage > 0 && percentage <= 25) {
		return (
			<div className="progress-bar-filler-container">
				<div className="progress-bar-filler" style={{ width: `${percentage}%`, paddingRight: 0 }} />
				<div className="progress-bar-filler-percentage" style={{ justifyContent: "center" }}>
					{selectLabel(labelType, completedTasks, allTasks)}
				</div>
			</div>
		);
	} else if (percentage === 0) {
		return (
			<div className="progress-bar-filler-container">
				<div className="progress-bar-filler" style={{ width: `${percentage}`, paddingRight: 0 }} />
				<div className="progress-bar-filler-percentage" style={{ justifyContent: "center" }}>
					{selectLabel(labelType, completedTasks, allTasks)}
				</div>
			</div>
		);
	}
};

export default Filler;
