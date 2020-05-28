import React, { useState, useCallback } from "react";
import MyDrillsTaskItem from "./MyDrillsTaskItem";
import { conditionalTooltipRender } from "CORE";
import { StatusTypes } from "UTILITIES";
import "./MyDrillsView.scss";

const MyDrillsView = ({ drills, onDrillColumnClose }) => {
	const [drillNameRef, setDrillNameRef] = useState(null);

	// not using useRef here because the object ref doesn't notify about changes to the current ref value
	// in this case, you could use useRef, but I use the callback for an example (:
	const drillNameRefCallback = useCallback((node) => {
		if (node !== null) {
			setDrillNameRef(node);
		}
	}, []);

	if (drills.length === 0) {
		return null;
	}

	return drills.map((drill) => {
		let drillname = Object.keys(drill)[0];

		let elementToRender = (
			<span className="drill-report-title" ref={drillNameRefCallback}>
				{drillname}
			</span>
		);
		elementToRender = conditionalTooltipRender(elementToRender, drillNameRef, drillname);

		return (
			<div className="drill-report-item" key={drillname}>
				<div className="drill-report-header">
					{elementToRender}
					<span className="drill-report-counters">
						<span className="drill-report-counter">{getCompletedTasksCount(drill)}</span>
					</span>
				</div>
				<ul className="drill-report-column">{renderDrillTable(drill)}</ul>
			</div>
		);
	});
};

const getCompletedTasksCount = (drill) => {
	// technical debt, address and make this better, could make counting completed tasks a helper inside status.js cause it is used alot
	let completedTasks = 0;
	let tasks = Object.values(drill)[0];
	tasks.forEach((task) => {
		const { status } = task.currentStatus;
		if (status === StatusTypes.COMPLETED) {
			completedTasks++;
		}
	});
	return `${completedTasks}/${Object.values(drill)[0].length}`;
};

const renderDrillTable = (drill) => {
	const tasks = Object.values(drill)[0];
	const drillName = Object.keys(drill)[0];
	if (tasks.length === 0) {
		return <div className="drill-report-item-no-tasks-label">No tasks.</div>;
	}
	return tasks.map((task) => {
		return <MyDrillsTaskItem task={task} key={task.taskId} drillName={drillName} />;
	});
};

export default MyDrillsView;
