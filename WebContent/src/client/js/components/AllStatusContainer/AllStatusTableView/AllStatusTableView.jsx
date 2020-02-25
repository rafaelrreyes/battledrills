import React, { Component } from "react";
import { AllStatusItemView } from "../../index";
import "./AllStatusTableView.scss";
import { FILTER_DROPDOWN_CONSTANTS } from "CORE/FilterDropdown/FilterDropdown";

const AllStatusTableView = ({ roles, drills, statuses, onTaskLinkClick }) => {
	return (
		<>
			<div className="all-status-headers">{renderDrillHeaders(drills, roles)}</div>
			<div className="all-status-table">
				<div className="all-status-table-body">{renderStatuses(roles, drills, statuses, onTaskLinkClick)}</div>
			</div>
		</>
	);
};

const renderDrillHeaders = (drills, roles) => {
	return [
		<div className="all-status-empty-header" key={`emptyRoleHeader`}>
			Roles
		</div>,
		drills.map((drill, index) => {
			return (
				<div key={drill + index} className="all-status-header-item">
					{drill}
				</div>
			);
		})
	];
};

const renderStatuses = (roles, drills, statuses, onTaskLinkClick) => {
	return roles.map((role, index) => {
		if (role !== FILTER_DROPDOWN_CONSTANTS.ALL) {
			return (
				<div key={role + index} className="all-status-role-row">
					<div className="all-status-role-name">{role}</div>
					{renderTasksItem(role, drills, statuses, onTaskLinkClick)}
				</div>
			);
		}
	});
};

const renderTasksItem = (role, drills, statuses, onTaskLinkClick) => {
	return drills.map((drill, index) => {
		return (
			<div key={role + index} className="all-status-drill-column">
				{renderTasksCell(role, drill, statuses, onTaskLinkClick)}
			</div>
		);
	});
};

const renderTasksCell = (role, drill, statuses, onTaskLinkClick) => {
	if (typeof statuses[role] !== "undefined") {
		if (typeof statuses[role][drill] !== "undefined") {
			let tasks = statuses[role][drill];
			return (
				<div className="all-status-tasks-cell">
					<AllStatusItemView drillName={drill} tasks={tasks} onTaskLinkClick={onTaskLinkClick} />
				</div>
			);
		}
	}
	return <div />;
};

export default AllStatusTableView;
