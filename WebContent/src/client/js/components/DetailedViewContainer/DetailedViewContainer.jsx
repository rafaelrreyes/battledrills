import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { TaskActionsMenu, AttachmentsView } from "COMPONENTS/";
import { Input, INPUT_SIZES, INPUT_TYPES, Button, ButtonSizes, ButtonTypes } from "CORE/";
import { API, AttachmentTypes, Routes, MaterialIconNames, TASK_DESCRIPTION_PLACEHOLDER, deleteTask } from "UTILITIES/";
import "./DetailedViewContainer.scss";

// views
import { NotesView } from "../index";

// redux
import {
	getSelectedTask,
	getUser,
	getCurrentView,
	getSelectedDrillName,
	setSelectedDrill,
	setSelectedTask,
	setActiveBillet
} from "REDUX/";

const MAX_TASK_DESCRIPTION_LENGTH = 150;
const DetailedViewContainer = () => {
	// state
	const [displayActionButtons, setDisplayActionButtons] = useState(false);
	const [editDescription, setEditDescription] = useState(false);

	const dispatch = useDispatch();

	// redux selectors
	const selectedTask = useSelector(getSelectedTask);
	const selectedDrillName = useSelector(getSelectedDrillName);
	const { taskId, description, notes, owner } = selectedTask;
	const user = useSelector(getUser);
	const currentView = useSelector(getCurrentView);

	const [newDescription, setNewDescription] = useState(description);

	useEffect(() => {
		cancelEditDescription();
	}, [selectedTask]);

	const showActionsButton = () => {
		setDisplayActionButtons(true);
	};

	const hideActionsButtons = () => {
		setDisplayActionButtons(false);
	};

	const toggleEditDescription = () => {
		if (editDescription) {
			const requestBody = {
				owner,
				description: newDescription,
				taskId,
				user
			};

			API.editTask(
				requestBody,
				() => {
					API.getDrillByName(selectedDrillName, {}, (drill) => {
						dispatch(setSelectedDrill(drill));
					});

					API.getTaskById(taskId, {}, (task) => {
						dispatch(setSelectedTask(task));
					});

					if (currentView === Routes.MY_REPORT) {
						API.getOwnerBillet(owner, {}, (data) => {
							dispatch(setActiveBillet(data));
						});
					} else if (currentView === Routes.ACTIVE_DIAGRAM) {
						API.getTaskById(taskId, {}, (task) => {
							dispatch(setSelectedTask(task));
						});
					}
				},
				(error) => {
					console.error(`Error when editing task: ${taskId}`);
				}
			);
		}
		setEditDescription(!editDescription);
	};

	const cancelEditDescription = () => {
		setEditDescription(false);
		setNewDescription(description);
	};

	const renderActionsMenu = () => {
		if (displayActionButtons) {
			return (
				<TaskActionsMenu
					className="task-commands"
					closeMenu={() => {
						hideActionsButtons();
					}}
					taskId={taskId}
				/>
			);
		}

		return null;
	};

	const renderActionsButton = () => {
		return (
			<span>
				<Button buttonSize={ButtonSizes.MEDIUM} buttonType={ButtonTypes.REGULAR} onClick={showActionsButton}>
					<i className="material-icons">{MaterialIconNames.COMMANDS}</i>Actions
				</Button>
				{renderActionsMenu()}
			</span>
		);
	};

	const renderAttachments = () => {
		return (
			<div className="attachments-container">
				<AttachmentsView selectedObject={selectedTask} type={AttachmentTypes.TASK} collapsible={true} />
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
					inputType={INPUT_TYPES.REGULAR}
					inputSize={INPUT_SIZES.FILL}
					defaultValue={description}
					onChange={onDescriptionChange}
					submit={toggleEditDescription}
					focus={true}
					placeholder="Description"
					maxlength={MAX_TASK_DESCRIPTION_LENGTH}
				/>
			);
		} else {
			return newDescription ? newDescription : TASK_DESCRIPTION_PLACEHOLDER;
		}
	};

	const renderDeleteButton = () => {
		return (
			<Button buttonSize={ButtonSizes.MEDIUM} buttonType={ButtonTypes.REGULAR} onClick={onDeleteTask}>
				<i className="material-icons">{MaterialIconNames.DELETE}</i>Delete
			</Button>
		);
	};

	const onDeleteTask = () => {
		deleteTask(taskId);
	};

	const onDescriptionChange = (value) => {
		setNewDescription(value);
	};

	return (
		<div className="detailed-view">
			<div className="alt-card-title">Task Information</div>
			<div className="alt-card-content">
				<div className="data-flex-container">
					<div className="detailed-task-description-container">
						<i className="material-icons edit-description-icon" onClick={toggleEditDescription}>
							{editDescription ? MaterialIconNames.SAVE : MaterialIconNames.EDIT}
						</i>
						{editDescription ? (
							<i className="material-icons cancel-edit-description-icon" onClick={cancelEditDescription}>
								{MaterialIconNames.BLOCK}
							</i>
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
