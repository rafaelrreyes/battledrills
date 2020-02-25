import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { getActiveTasks } from "REDUX/index";
import { getNextActiveTask, resetActiveTasks, getSelectedTask, getSelectedDrill } from "REDUX/index";
import { TaskPriorityItem } from "../index";
import { TransitionGroup, CSSTransition } from "react-transition-group";
import { selectTask } from "UTILITIES/index";
import "./TaskPriorityContainer.scss";

const TaskPriorityContainer = () => {
	const dispatch = useDispatch();

	// redux selectors
	const selectedTask = useSelector(getSelectedTask);
	const activeTasks = useSelector(getActiveTasks);
	const selectedDrill = useSelector(getSelectedDrill);

	useEffect(() => {
		if (typeof selectedDrill.name === "undefined") {
			dispatch(resetActiveTasks());
			return;
		}

		if (typeof selectedDrill.data !== "undefined") {
			dispatch(resetActiveTasks());
			dispatch(getNextActiveTask(selectedDrill.data));
		}
	}, [selectedDrill.name]);

	const renderActiveTasks = () => {
		if (activeTasks.length === 0) {
			return null;
		}

		return activeTasks.map((task) => {
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
			{renderActiveTasks()}
		</TransitionGroup>
	);
};

export default TaskPriorityContainer;
