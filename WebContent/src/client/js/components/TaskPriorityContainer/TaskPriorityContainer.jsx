import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { getSelectedTask, getSelectedDrill } from "REDUX/index";
import { TaskPriorityItem } from "../index";
import { TransitionGroup, CSSTransition } from "react-transition-group";
import { selectTask } from "UTILITIES/index";
import "./TaskPriorityContainer.scss";

const TaskPriorityContainer = () => {
	const dispatch = useDispatch();

	// redux selectors
	const selectedTask = useSelector(getSelectedTask);
	const selectedDrill = useSelector(getSelectedDrill);
	const { prioritizedTasks } = selectedDrill;

	const renderPrioritizedTasks = () => {
		if (typeof prioritizedTasks === "undefined" || prioritizedTasks.length === 0) {
			return null;
		}

		return prioritizedTasks.map((task) => {
			return (
				<CSSTransition key={task.taskId} classNames="example" timeout={{ enter: 100, exit: 100 }}>
					<TaskPriorityItem
						task={task}
						isSelected={task.taskId === selectedTask.taskId}
						onTaskClick={() => {
							selectTask(task);
						}}
					/>
				</CSSTransition>
			);
		});
	};
	return (
		<TransitionGroup className="active-task-list" component="ul">
			{renderPrioritizedTasks()}
		</TransitionGroup>
	);
};

export default TaskPriorityContainer;
