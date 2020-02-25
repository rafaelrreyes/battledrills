import React, { useState } from "react";
import { useSelector } from "react-redux";
import { TaskActionsMenu, AttachmentsView } from "COMPONENTS/";
import { AttachmentTypes } from "UTILITIES/";
import "./DetailedViewContainer.scss";

// views
import { NotesView } from "../index";

// redux
import { getSelectedTask, getUser, getCurrentView } from "REDUX/index";

import { MaterialIconNames, Routes } from "UTILITIES/index";

const DetailedViewContainer = () => {
	// state
	const [displayActionButtons, setDisplayActionButtons] = useState(false);

	// redux selectors
	const selectedTask = useSelector(getSelectedTask);
	const { taskId, description, notes } = selectedTask;
	const user = useSelector(getUser);
	const currentView = useSelector(getCurrentView);

	const showActionsButton = () => {
		setDisplayActionButtons(true);
	};

	const hideActionsButtons = () => {
		setDisplayActionButtons(false);
	};

	const renderActionsButtons = () => {
		if (displayActionButtons) {
			return (
				<>
					<TaskActionsMenu
						className="task-commands"
						closeMenu={() => {
							hideActionsButtons();
						}}
						taskId={taskId}
					/>
				</>
			);
		}

		return null;
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

	return (
		<div className="detailed-view">
			<div className="alt-card-title">Task Information</div>
			<div className="alt-card-content">
				<div className="data-flex-container">
					<div className="data-info">
						<div className="data-key">Description</div>
						<div className="data-value">{description}</div>
					</div>
					{currentView !== Routes.COMPLETED_DIAGRAM && (
						<div className="detailed-view-actions">
							<div className="detailed-view-actions-button" onClick={showActionsButton}>
								<i className="material-icons">{MaterialIconNames.COMMANDS}</i>
								<span className="detailed-view-actions-button-label">ACTIONS</span>
							</div>
							{renderActionsButtons()}
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
