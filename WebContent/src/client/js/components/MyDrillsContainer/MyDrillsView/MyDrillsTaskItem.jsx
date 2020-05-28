import React from "react";
import { StatusIcon } from "CORE";
import { useSelector, useDispatch } from "react-redux";
import { setSelectedTask, setSelectedDrill, getSelectedTask } from "REDUX";
import { API, TASK_DESCRIPTION_PLACEHOLDER } from "UTILITIES";
import "./MyDrillsTaskItem.scss";

const MyDrillsTaskItem = ({ drillName, task }) => {
	// destructured props
	const { taskId, description, currentStatus } = task;

	const dispatch = useDispatch();

	// redux selectors
	const selectedTask = useSelector(getSelectedTask);

	const onTaskClick = (clickedTaskId) => {
		// do nothing if selectedTask is already selected
		if (selectedTask.taskId === clickedTaskId) {
			return;
		}

		API.getTaskById(clickedTaskId, {}, (response) => {
			if (response !== null) {
				dispatch(setSelectedTask(response));
			}
		});

		API.getDrillByName(drillName, {}, (response) => {
			if (response !== null) {
				dispatch(setSelectedDrill(response));
			}
		});
	};

	return (
		<li
			className={`task-report-item ${selectedTask.taskId === taskId ? "active-task-report-item" : ""}`}
			key={taskId}
			onClick={() => {
				onTaskClick(taskId);
			}}
		>
			<span className="task-report-status">
				<StatusIcon type={currentStatus.status} size={36} />
			</span>
			<span className="task-report-description">{description ? description : TASK_DESCRIPTION_PLACEHOLDER}</span>
		</li>
	);
};

export default MyDrillsTaskItem;
