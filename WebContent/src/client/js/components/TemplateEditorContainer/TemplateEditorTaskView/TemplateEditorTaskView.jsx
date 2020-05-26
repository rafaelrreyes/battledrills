import React, { useState, useEffect } from "react";
import store from "REDUX/store";
import { useDispatch, useSelector } from "react-redux";

import {
	getSelectedTaskTemplate,
	editTaskDescriptionTemplate,
	setSelectedTaskTemplate,
	getSelectedTemplate,
	getTaskTemplate
} from "REDUX";
import { Input, InputTypes, InputSizes, Icon } from "CORE";
import { MaterialIconNames, TASK_DESCRIPTION_PLACEHOLDER } from "UTILITIES";

import "./TemplateEditorTaskView.scss";

// TODO extract this and one in DetailedViewContainer.jsx
const MAX_TASK_DESCRIPTION_LENGTH = 150;

const TemplateEditorTaskView = () => {
	const selectedTemplate = useSelector(getSelectedTemplate);
	const selectedTaskTemplate = useSelector(getSelectedTaskTemplate);
	const { description, taskId } = selectedTaskTemplate !== null ? selectedTaskTemplate : {};

	const dispatch = useDispatch();

	const [editDescription, setEditDescription] = useState(false);
	const [newDescription, setNewDescription] = useState("");

	useEffect(() => {
		setNewDescription(selectedTaskTemplate.description);
	}, [selectedTaskTemplate]);

	useEffect(() => {
		const { taskId } = selectedTaskTemplate;
		const taskFound = getTaskTemplate(store.getState(), taskId);
		dispatch(setSelectedTaskTemplate(taskFound));
		cancelEditDescription();
	}, [selectedTemplate]);

	const renderDescription = () => {
		if (editDescription) {
			const { description } = selectedTaskTemplate;
			const disabled = description === newDescription;
			return (
				<>
					<Icon className="cancel-edit-description-icon" onClick={cancelEditDescription}>
						{MaterialIconNames.BLOCK}
					</Icon>
					<Icon
						className={`edit-description-icon ${disabled ? "disabled" : ""}`}
						onClick={toggleEditDescription}
					>
						{MaterialIconNames.SAVE}
					</Icon>
					<span className="task-description">
						<Input
							inputType={InputTypes.REGULAR}
							inputSize={InputSizes.FILL}
							initValue={description}
							onChange={onDescriptionChange}
							submit={toggleEditDescription}
							focus={true}
							placeholder="Description"
							maxlength={MAX_TASK_DESCRIPTION_LENGTH}
						/>
					</span>
				</>
			);
		} else {
			return (
				<>
					<Icon onClick={toggleEditDescription}>{MaterialIconNames.EDIT}</Icon>
					<span className="task-description">
						{newDescription ? newDescription : TASK_DESCRIPTION_PLACEHOLDER}
					</span>
				</>
			);
		}
	};

	const onDescriptionChange = (value) => {
		setNewDescription(value);
	};

	const cancelEditDescription = () => {
		setEditDescription(false);
		setNewDescription(description);
	};

	const toggleEditDescription = () => {
		if (editDescription) {
			dispatch(editTaskDescriptionTemplate({ id: taskId, description: newDescription }));
		}
		setEditDescription(!editDescription);
	};

	const onViewTemplates = () => {
		dispatch(setSelectedTaskTemplate(null));
	};

	return (
		<div className="template-editor-task-view">
			<div className="alt-card-title">
				<label>Edit Task</label>
				<span className="templates-button">
					<Icon onClick={onViewTemplates}>{MaterialIconNames.BACK}</Icon>
				</span>
			</div>
			<div className="alt-card-content">
				<div className="data-flex-container">
					<div className="task-description-container">{renderDescription()}</div>
				</div>
			</div>
		</div>
	);
};

export default TemplateEditorTaskView;
