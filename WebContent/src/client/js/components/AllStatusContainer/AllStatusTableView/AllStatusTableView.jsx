import React, { Component } from "react";
import AllStatusItemView from "./AllStatusItemView";
import { useLocalStorage } from "HOOKS";
import "./AllStatusTableView.scss";
import { FilterDropdownDefaults } from "CORE";

const AllStatusTableView = ({ roles, drills, statuses, onTaskLinkClick, showRolesWithoutTasks }) => {
	const [showStatusKeys, setShowStatusKeys] = useLocalStorage("show-tasks-status-keys", {});

	const onUpdateShowTaskStorage = (role, drillId, showTasks) => {
		const localStorageKeys = { ...showStatusKeys };
		if (!showTasks) {
			delete localStorageKeys[`${role.id}_${drillId}`];
		} else {
			localStorageKeys[`${role.id}_${drillId}`] = showTasks;
		}
		setShowStatusKeys(localStorageKeys);
	};

	const renderDrillHeaders = (drills) => {
		return [
			<div className="all-status-empty-header" key={`emptyRoleHeader`}>
				Roles
			</div>,
			drills.map((drill, index) => {
				return (
					<div key={`${drill.id}-${index}`} className="all-status-header-item">
						{drill.name}
					</div>
				);
			})
		];
	};

	const renderStatuses = (roles, drills, statuses, onTaskLinkClick) => {
		return roles.map((role, index) => {
			if (!showRolesWithoutTasks && typeof statuses[role.id] === "undefined") {
				return null;
			}

			if (role.id !== "*") {
				return (
					<div key={`status-item-${role.id}-${index}`} className="all-status-role-row">
						<div className="all-status-role-name">{role.name}</div>
						{renderTasksItem(role, drills, statuses, onTaskLinkClick)}
					</div>
				);
			}
		});
	};

	const renderTasksItem = (role, drills, statuses, onTaskLinkClick) => {
		return drills.map((drill, index) => {
			return (
				<div key={`tasks-item-${role.id + index}`} className="all-status-drill-column">
					{renderTasksCell(role, drill, statuses, onTaskLinkClick)}
				</div>
			);
		});
	};

	const renderTasksCell = (role, drill, statuses, onTaskLinkClick) => {
		const { id } = drill;
		if (typeof statuses[role.id] !== "undefined") {
			if (typeof statuses[role.id][id] !== "undefined") {
				let tasks = statuses[role.id][id];
				return (
					<div className="all-status-tasks-cell">
						<AllStatusItemView
							isShowing={showStatusKeys[`${role.id}_${id}`] ? showStatusKeys[`${role.id}_${id}`] : false}
							role={role}
							drillId={id}
							tasks={tasks}
							onTaskLinkClick={onTaskLinkClick}
							onShowTasks={onUpdateShowTaskStorage}
						/>
					</div>
				);
			}
		}
		return <div />;
	};

	return (
		<>
			<div className="all-status-headers">{renderDrillHeaders(drills, roles)}</div>
			<div className="all-status-table">
				<div className="all-status-table-body">{renderStatuses(roles, drills, statuses, onTaskLinkClick)}</div>
			</div>
		</>
	);
};

export default AllStatusTableView;
