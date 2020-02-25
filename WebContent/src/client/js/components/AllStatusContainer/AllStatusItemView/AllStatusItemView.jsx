import React, { useState } from "react";
import { ProgressBar, StatusIcon, Hyperlink, HyperlinkTypes } from "CORE/index";
import { MaterialIconNames, STATUS_TYPES, Routes } from "UTILITIES/index";
import "./AllStatusItemView.scss";

/**
 * component renders Progress Bar and Tasks
 */

const AllStatusItemView = ({ drillName, tasks, onTaskLinkClick }) => {
	const [showTasks, setShowTasks] = useState(false);

	const handleTasksListClick = () => {
		setShowTasks(!showTasks);
	};

	return (
		<div className="all-status-items-container">
			<div className="all-status-items">
				<ProgressBar completedTasks={countCompletedTasks(tasks)} allTasks={tasks.length} />
				<i className="material-icons task-display-button" onClick={handleTasksListClick}>
					{MaterialIconNames.TASK_LIST}
				</i>
			</div>
			{showTasks && (
				<ul className="all-status-tasks-list">{renderTaskList(drillName, tasks, onTaskLinkClick)}</ul>
			)}
		</div>
	);
};

const renderTaskList = (drillName, tasks, onTaskLinkClick) => {
	return tasks.map((task, index) => {
		return (
			<Hyperlink
				key={task + index}
				type={HyperlinkTypes.TEXT}
				addClass={"all-status-task-item-link"}
				to={Routes.ACTIVE_DIAGRAM}
				hyperlinkRef={(node) => {
					if (node) {
						node.addEventListener("click", (event) => {
							onTaskLinkClick(drillName, task);
						});
					}
				}}
			>
				<li className="all-status-tasks-item">
					<StatusIcon type={task.currentStatus.status} />
					<span className="all-status-item-text">{task.description}</span>
				</li>
			</Hyperlink>
		);
	});
};

const countCompletedTasks = (tasks) => {
	return tasks.filter((task) => task.currentStatus.status === STATUS_TYPES.COMPLETED).length;
};

export default AllStatusItemView;
