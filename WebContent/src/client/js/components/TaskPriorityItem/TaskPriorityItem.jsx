import React, { useState, useEffect } from "react";
import axios from "axios";
import "./TaskPriorityItem.scss";
import { DetailedTimer } from "../index";
import { API, TASK_DESCRIPTION_PLACEHOLDER } from "UTILITIES/";

const TaskPriorityItem = ({ task, onTaskClick, isSelected }) => {
	const { description, owner, taskId } = task;
	const [startTime, setStartTime] = useState(0);

	// initialize start time based on persisted start time data
	useEffect(() => {
		// source.token needs to be passed as a config to axios, not as request parameters
		const source = axios.CancelToken.source();
		API.getTaskById(taskId, { cancelToken: source.token }, (response) => {
			if (response.start) {
				setStartTime(response.start);
			}
		});
		return () => {
			// cancel API request because when switching between Active and Completed diagrams,
			// the component needs to unmount and close async requests
			source.cancel();
		};
	}, []);

	return (
		<li
			className={`active-task-item-view ${isSelected ? "active-task-item" : ""}`}
			onClick={(e) => {
				e.stopPropagation();
				onTaskClick(task);
			}}
		>
			<label className="active-task-item-owner-label">{owner}</label>
			<div className="active-task-item-container">
				<p className="description">{description ? description : TASK_DESCRIPTION_PLACEHOLDER}</p>
				<div className="timer">{startTime !== 0 ? <DetailedTimer start={startTime} /> : null}</div>
			</div>
		</li>
	);
};

const onCompleteClick = (task, onClick) => {
	const updatedTask = {
		...task,
		end: new Date().getTime()
	};
	onClick(updatedTask);
};

export default TaskPriorityItem;
