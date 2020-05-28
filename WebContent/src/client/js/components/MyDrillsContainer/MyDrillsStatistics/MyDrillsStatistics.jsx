import React from "react";
import { StatusTypes } from "UTILITIES/index";
import { StatusIcon } from "CORE/index";
import "./MyDrillsStatistics.scss";

const MyDrillsStatistics = ({ drills, role }) => {
	return (
		<div className="tasks-reports-statistics">
			<span className="tasks-reports-statistics-user badge">{role}</span>
			{renderStatistics(drills)}
		</div>
	);
};

const renderStatistics = (drills) => {
	let totalTasks = 0;
	let totalDrills = 0;
	let pendingTasks = 0;
	let inProgressTasks = 0;
	let blockedTasks = 0;
	let completedTasks = 0;

	drills.forEach((drill) => {
		let tasks = Object.values(drill)[0];
		totalDrills++;
		tasks.forEach((task) => {
			const { status } = task.currentStatus;
			switch (status) {
				case StatusTypes.PENDING:
					pendingTasks++;
					break;
				case StatusTypes.IN_PROGRESS:
					inProgressTasks++;
					break;
				case StatusTypes.BLOCKED:
					blockedTasks++;
					break;
				case StatusTypes.COMPLETED:
					completedTasks++;
					break;
				default:
					break;
			}
			totalTasks++;
		});
	});

	return (
		<ul className="tasks-reports-total">
			<li className="tasks-reports-total-item">
				<StatusIcon type={StatusTypes.PENDING} size={24} />
				<span className="tasks-reports-item-label">
					{pendingTasks}/{totalTasks}
				</span>
			</li>
			<li className="tasks-reports-total-item">
				<StatusIcon type={StatusTypes.IN_PROGRESS} size={24} />
				<span className="tasks-reports-item-label">
					{inProgressTasks}/{totalTasks}
				</span>
			</li>
			<li className="tasks-reports-total-item">
				<StatusIcon type={StatusTypes.BLOCKED} size={24} />
				<span className="tasks-reports-item-label">
					{blockedTasks}/{totalTasks}
				</span>
			</li>
			<li className="tasks-reports-total-item">
				<StatusIcon type={StatusTypes.COMPLETED} size={24} />
				<span className="tasks-reports-item-label">
					{completedTasks}/{totalTasks}
				</span>
			</li>
			<li className="tasks-reports-totals-item">
				<span className="badge">{totalDrills} drills</span>
				<span className="badge">{totalTasks} tasks</span>
			</li>
		</ul>
	);
};

export default MyDrillsStatistics;
