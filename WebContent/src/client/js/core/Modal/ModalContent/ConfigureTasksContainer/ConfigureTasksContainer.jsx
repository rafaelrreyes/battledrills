import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { DragDropContext, Droppable, Draggable } from "react-beautiful-dnd";
import { getSelectedTemplate } from "REDUX";
import { Icon, TooltipPlacement } from "CORE";
import { API, MaterialIconNames } from "UTILITIES";
import "./ConfigureTasksContainer.scss";

const reorderList = (list, startIndex, endIndex) => {
	const result = Array.from(list);
	const [removed] = result.splice(startIndex, 1);
	result.splice(endIndex, 0, removed);
	return result;
};

const moveItem = (source, destination, droppableSource, droppableDestination) => {
	const sourceCloneArray = Array.from(source);
	const destinationCloneArray = Array.from(destination);

	// remove from source array
	const [removed] = sourceCloneArray.splice(droppableSource.index, 1);
	destinationCloneArray.splice(droppableDestination.index, 0, removed);

	const result = {};
	result[droppableSource.droppableId] = sourceCloneArray;
	result[droppableDestination.droppableId] = destinationCloneArray;

	return result;
};

const droppableListIds = {
	favoritedTasks: "favoritedTasks",
	templateTasks: "templateTasks",
	currentTasks: "currentTasks"
};

const ConfigureTasksContainer = ({ role, updateData, submit, title, icon }) => {
	const [currentTasks, setCurrentTasks] = useState([]);
	const [templateTasks, setTaskTemplates] = useState([]);
	const [favoritedTasks, setTaskFavorites] = useState([]);

	const [isLoading, setIsLoading] = useState(false);

	const selectedTemplate = useSelector(getSelectedTemplate);
	console.log(role);

	useEffect(() => {
		const requestBody = {
			type: selectedTemplate.type
		};

		API.getTasksByRoleId(role.roleId, requestBody, (tasks) => {
			setCurrentTasks(tasks);
		});

		API.getTaskTemplates((data) => {
			console.log(data);
			setTaskTemplates(data.templates);
			setTaskFavorites(data.favorites);
		});
	}, []);

	console.log(selectedTemplate);

	const getTasksById = (listId) => {
		switch (listId) {
			case droppableListIds.currentTasks:
				return currentTasks;
			case droppableListIds.favoritedTasks:
				return favoritedTasks;
			case droppableListIds.templateTasks:
				return templateTasks;
			default:
				return [];
		}
	};

	const onDragEnd = (result) => {
		const { source, destination } = result;

		if (!destination) {
			return;
		}

		// drop in the same list
		if (source.droppableId === destination.droppableId) {
			const reordered = reorderList(getTasksById(source.droppableId), source.index, destination.index);

			if (source.droppableId === droppableListIds.currentTasks) {
				setCurrentTasks(reordered);
			} else if (source.droppableId === droppableListIds.favoritedTasks) {
				setTaskFavorites(reordered);
			} else if (source.droppableId === droppableListIds.templateTasks) {
				setTaskTemplates(reordered);
			}
		} else {
			// moving task from one list to another
			const manipulatedLists = moveItem(
				getTasksById(source.droppableId),
				getTasksById(destination.droppableId),
				source,
				destination
			);

			if (
				source.droppableId === droppableListIds.currentTasks ||
				destination.droppableId === droppableListIds.currentTasks
			) {
				setCurrentTasks(manipulatedLists[droppableListIds.currentTasks]);
			}

			if (
				source.droppableId === droppableListIds.favoritedTasks ||
				destination.droppableId === droppableListIds.favoritedTasks
			) {
				setTaskFavorites(manipulatedLists[droppableListIds.favoritedTasks]);
			}

			if (
				source.droppableId === droppableListIds.templateTasks ||
				destination.droppableId === droppableListIds.templateTasks
			) {
				setTaskTemplates(manipulatedLists[droppableListIds.templateTasks]);
			}
		}
	};

	const CurrentTask = ({ task, index }) => {
		console.log("current task: ", task);
		return (
			<Draggable draggableId={`current-task-draggable-${task.taskId}`} index={index}>
				{(provided) => {
					return (
						<div
							ref={provided.innerRef}
							{...provided.draggableProps}
							{...provided.dragHandleProps}
							className="current-task-list-item"
						>
							<span className="task-list-item-description">{task.description}</span>
							<Icon
								tooltip="Delete Task"
								tooltipPlacement={TooltipPlacement.TOP}
								onClick={() => {
									console.log("clicked current task icon");
									// onAddAvailableGroupHandler(group.id, index);
								}}
								hasCircledBackground={true}
							>
								{MaterialIconNames.DELETE}
							</Icon>
						</div>
					);
				}}
			</Draggable>
		);
	};

	const FavoritedTask = ({ task, index }) => {
		return (
			<Draggable draggableId={`favorited-task-draggable-${index}`} index={index}>
				{(provided) => {
					return (
						<div
							ref={provided.innerRef}
							{...provided.draggableProps}
							{...provided.dragHandleProps}
							className="favorited-task-list-item"
						>
							<span className="task-list-item-description">{task}</span>
							<span className="task-list-item-commands">
								<Icon
									tooltip="Remove from Favorites"
									tooltipPlacement={TooltipPlacement.TOP}
									onClick={() => {
										console.log("clicked favorited task delete icon");
										// onAddAvailableGroupHandler(group.id, index);
									}}
									hasCircledBackground={true}
								>
									{MaterialIconNames.UNFAVORITE}
								</Icon>
								<Icon
									tooltip="Add Task"
									tooltipPlacement={TooltipPlacement.TOP}
									onClick={() => {
										console.log("clicked favorited task add icon");
										// onAddAvailableGroupHandler(group.id, index);
									}}
									hasCircledBackground={true}
								>
									{MaterialIconNames.ADD}
								</Icon>
							</span>
						</div>
					);
				}}
			</Draggable>
		);
	};

	const TemplateTask = ({ task, index }) => {
		return (
			<Draggable draggableId={`template-task-draggable-${index}`} index={index}>
				{(provided) => {
					return (
						<div
							ref={provided.innerRef}
							{...provided.draggableProps}
							{...provided.dragHandleProps}
							className="template-task-list-item"
						>
							<span className="task-list-item-description">{task}</span>
							<span className="task-list-item-commands">
								<Icon
									tooltip="Add to Favorites"
									tooltipPlacement={TooltipPlacement.TOP}
									onClick={() => {
										console.log("clicked template task favorite icon");
										// onAddAvailableGroupHandler(group.id, index);
									}}
									hasCircledBackground={true}
								>
									{MaterialIconNames.FAVORITE}
								</Icon>
								<Icon
									tooltip="Add Task"
									tooltipPlacement={TooltipPlacement.TOP}
									onClick={() => {
										console.log("clicked template task add icon");
										// onAddAvailableGroupHandler(group.id, index);
									}}
									hasCircledBackground={true}
								>
									{MaterialIconNames.ADD}
								</Icon>
							</span>
						</div>
					);
				}}
			</Draggable>
		);
	};

	const TaskList = ({ tasks, type }) => {
		if (isLoading) {
			return (
				<div className="loading-wheel">
					<Spinner size="md" />
				</div>
			);
		}

		return tasks.map((task, index) => {
			if (type === "current") {
				return <CurrentTask index={index} task={task} key={`current-task-item-${index}`} />;
			} else if (type === "favorited") {
				return <FavoritedTask index={index} task={task} key={`favorited-task-item-${index}`} />;
			} else if (type === "template") {
				return <TemplateTask index={index} task={task} key={`template-task-item-${index}`} />;
			}
		});
	};

	const renderDraggableLists = () => {
		return (
			<div className="drag-drop-container">
				<DragDropContext onDragEnd={onDragEnd}>
					<div className="task-list-container">
						<div className="task-list-header">Assigned Tasks ({currentTasks.length})</div>
						<Droppable droppableId={droppableListIds.currentTasks}>
							{(provided) => {
								return (
									<div {...provided.droppableProps} ref={provided.innerRef} className="task-list">
										<TaskList tasks={currentTasks} type={"current"} />
										{provided.placeholder}
									</div>
								);
							}}
						</Droppable>
					</div>
					<div className="task-list-container">
						<div className="task-list-header">Favorites ({favoritedTasks.length})</div>
						<Droppable droppableId={droppableListIds.favoritedTasks}>
							{(provided) => {
								return (
									<div {...provided.droppableProps} ref={provided.innerRef} className="task-list">
										<TaskList tasks={favoritedTasks} type={"favorited"} />
										{provided.placeholder}
									</div>
								);
							}}
						</Droppable>
					</div>
					<div className="task-list-container">
						<div className="task-list-header">Available ({templateTasks.length})</div>
						<Droppable droppableId={droppableListIds.templateTasks}>
							{(provided) => {
								return (
									<div {...provided.droppableProps} ref={provided.innerRef} className="task-list">
										<TaskList tasks={templateTasks} type={"template"} />
										{provided.placeholder}
									</div>
								);
							}}
						</Droppable>
					</div>
				</DragDropContext>
			</div>
		);
	};

	return (
		<div className="configure-tasks-container">
			{icon && <Icon className="md-36">{icon}</Icon>}
			{title && <div className="modal-title">{title}</div>}
			<div className="configure-tasks-header">
				<div className="configure-tasks-role-name">Role: {role.roleName}</div>
				<div className="configure-tasks-drill-name">Drill: {selectedTemplate.type}</div>
			</div>
			<div className="configure-tasks-view">{renderDraggableLists()}</div>
		</div>
	);
};

export default ConfigureTasksContainer;
