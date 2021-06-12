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
		const { name, tasks } = drill;

		let elementToRender = (
			<span className="drill-report-title" ref={drillNameRefCallback}>
				{name}
			</span>
		);
		elementToRender = conditionalTooltipRender(elementToRender, drillNameRef, name);

		return (
			<div className="drill-report-item" key={name}>
				<div className="drill-report-header">
					{elementToRender}
					<span className="drill-report-counters">
						<span className="drill-report-counter">{getCompletedTasksCount(tasks)}</span>
					</span>
				</div>
				<ul className="drill-report-column">{renderDrillTable(drill)}</ul>
			</div>
		);
	});
};

const getCompletedTasksCount = (tasks) => {
	// technical debt, address and make this better, could make counting completed tasks a helper inside status.js cause it is used alot
	let completedTasks = 0;

	if (tasks === null) {
		return null;
	}

	tasks.forEach((task) => {
		const { status } = task.currentStatus;
		if (status === StatusTypes.COMPLETED) {
			completedTasks++;
		}
	});

	if (completedTasks === 0 && tasks.length === 0) {
		return null;
	}

	return `${completedTasks}/${tasks.length}`;
};

const renderDrillTable = (drill) => {
	const { id, tasks } = drill;
	if (tasks === null || typeof tasks === "undefined" || tasks.length === 0) {
		return <div className="drill-report-item-no-tasks-label">No tasks.</div>;
	}

	return tasks.map((task) => {
		return <MyDrillsTaskItem task={task} key={task.taskId} drillId={id} />;
	});
};

export default MyDrillsView;
