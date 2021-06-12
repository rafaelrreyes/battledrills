import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { TaskActionsMenu, AttachmentsView } from "COMPONENTS";
import { Input, InputSizes, InputTypes, Button, ButtonSizes, ButtonTypes, Icon } from "CORE";
import { API, AttachmentTypes, Routes, MaterialIconNames, TASK_DESCRIPTION_PLACEHOLDER, deleteTask } from "UTILITIES";

// views
import { NotesView } from "COMPONENTS";

// redux
import {
	getSelectedTask,
	getUser,
	getCurrentView,
	getSelectedDrillId,
	setSelectedDrill,
	setSelectedTask,
	setActiveBillet
} from "REDUX";

import "./DetailedViewContainer.scss";

const MAX_TASK_DESCRIPTION_LENGTH = 150;
const DetailedViewContainer = () => {
	const dispatch = useDispatch();

	// redux selectors
	const selectedTask = useSelector(getSelectedTask);
	const selectedDrillId = useSelector(getSelectedDrillId);
	const { taskId, description, notes, roleId } = selectedTask;
	const user = useSelector(getUser);
	const currentView = useSelector(getCurrentView);

	// state
	const [displayActionButtons, setDisplayActionButtons] = useState(false);
	const [editDescription, setEditDescription] = useState(false);
	const [newDescription, setNewDescription] = useState(description);

	useEffect(() => {
		cancelEditHandler();
	}, [selectedTask]);

	const showActionsButton = () => {
		setDisplayActionButtons(true);
	};

	const hideActionsButtons = () => {
		setDisplayActionButtons(false);
	};

	const toggleEditHandler = () => {
		if (editDescription) {
			const requestBody = {
				roleId,
				description: newDescription,
				taskId,
				user
			};

			API.editTask(requestBody, () => {
				API.getDrillById(selectedDrillId, {}, (drill) => {
					dispatch(setSelectedDrill(drill));
				});

				API.getTaskById(taskId, {}, (task) => {
					dispatch(setSelectedTask(task));
				});

				if (currentView === Routes.MY_REPORT) {
					API.getBilletByRoleId(roleId, {}, (data) => {
						dispatch(setActiveBillet(data));
					});
				} else if (currentView === Routes.ACTIVE_DIAGRAM) {
					API.getTaskById(taskId, {}, (task) => {
						dispatch(setSelectedTask(task));
					});
				}
			});
		}
		setEditDescription(!editDescription);
	};

	const cancelEditHandler = () => {
		setEditDescription(false);
		setNewDescription(description);
	};

	const renderActionsMenu = () => {
		return (
			displayActionButtons && (
				<TaskActionsMenu
					className="task-commands"
					closeMenu={() => {
						hideActionsButtons();
					}}
					taskId={taskId}
				/>
			)
		);
	};

	const renderActionsButton = () => {
		return (
			<span>
				<Button buttonSize={ButtonSizes.MEDIUM} buttonType={ButtonTypes.REGULAR} onClick={showActionsButton}>
					<Icon>{MaterialIconNames.COMMANDS}</Icon>Actions
				</Button>
				{renderActionsMenu()}
			</span>
		);
	};

	const renderAttachments = () => {
		return (
			<div className="attachments-container">
				<AttachmentsView selectedObject={selectedTask} type={AttachmentTypes.TASK} isCollapsible={true} />
			</div>
		);
	};

	if (!taskId) {
		return <div className="detailed-view" />;
	}

	const renderDescription = () => {
		if (editDescription) {
			return (
				<Input
					inputType={InputTypes.REGULAR}
					inputSize={InputSizes.FILL}
					initValue={description}
					onChange={descriptionChangeHandler}
					submit={toggleEditHandler}
					focus={true}
					placeholder="Description"
					initValue={description}
					maxlength={MAX_TASK_DESCRIPTION_LENGTH}
				/>
			);
		} else {
			return newDescription ? newDescription : TASK_DESCRIPTION_PLACEHOLDER;
		}
	};

	const renderDeleteButton = () => {
		return (
			<Button buttonSize={ButtonSizes.MEDIUM} buttonType={ButtonTypes.REGULAR} onClick={deleteTaskHandler}>
				<Icon>{MaterialIconNames.DELETE}</Icon>
			</Button>
		);
	};

	const deleteTaskHandler = () => {
		deleteTask(taskId);
	};

	const descriptionChangeHandler = (value) => {
		setNewDescription(value);
	};

	const renderSaveButton = () => {
		// only allow saving if description has changed
		let disabled = description === newDescription;
		return (
			<Icon
				onClick={toggleEditHandler}
				className={`edit-description-icon ${disabled && editDescription ? "disabled" : ""}`}
			>
				{editDescription ? MaterialIconNames.SAVE : MaterialIconNames.EDIT}
			</Icon>
		);
	};

	return (
		<div className="detailed-view">
			<div className="alt-card-title">Task Information</div>
			<div className="alt-card-content">
				<div className="data-flex-container">
					<div className="detailed-task-description-container">
						{renderSaveButton()}
						{editDescription ? (
							<Icon className="cancel-edit-description-icon" onClick={cancelEditHandler}>
								{MaterialIconNames.BLOCK}
							</Icon>
						) : null}
						<span className="detailed-task-description">{renderDescription()}</span>
					</div>
					{currentView !== Routes.COMPLETED_DIAGRAM && (
						<div className="detailed-view-container">
							<span className="detailed-view-actions">
								{renderActionsButton()}
								{renderDeleteButton()}
							</span>
							{renderAttachments()}
						</div>
					)}
				</div>
			</div>
			<div className="alt-card-content notes-content">
				<NotesView
					taskId={taskId}
					user={user}
					notes={notes}
					showTextbox={currentView !== Routes.COMPLETED_DIAGRAM}
				/>
			</div>
		</div>
	);
};

export default DetailedViewContainer;
