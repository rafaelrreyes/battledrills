import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { MaterialIconNames, generateRandomId } from "UTILITIES";
import { ModalContentTypes, Icon, TooltipPlacement } from "CORE";
import "./TemplateEditorPaletteView.scss";
import {
	showModal,
	closeModal,
	addRoleToTemplate,
	getSelectedTemplate,
	addTaskToTemplate,
	undoTemplateEdit,
	redoTemplateEdit,
	setSelectedTemplate,
	getPastEdits,
	getFutureEdits,
	clearAllFromTemplate,
	resetSelectedTaskTemplate
} from "REDUX";

import { saveTemplate, promptCurrentEditSave } from "../TemplateEditorHelper";

const TemplateEditorPaletteView = ({ diagram, onViewTemplates }) => {
	const selectedTemplate = useSelector(getSelectedTemplate);
	const pastEdits = useSelector(getPastEdits);
	const futureEdits = useSelector(getFutureEdits);

	const dispatch = useDispatch();

	const toggleViewTemplates = () => {
		onViewTemplates();
	};

	const createNewTemplate = () => {
		if (selectedTemplate !== null && pastEdits.length !== 0) {
			promptCurrentEditSave(() => {
				saveTemplate(() => {
					dispatch(
						setSelectedTemplate({
							type: `template-${generateRandomId()}`,
							participants: [],
							data: {}
						})
					);
				});
			});
		} else {
			dispatch(
				setSelectedTemplate({
					type: `template-${generateRandomId()}`,
					participants: [],
					data: {}
				})
			);
			dispatch(
				showModal(ModalContentTypes.NEW_OWNER, {
					title: `Add Root Role`,
					icon: MaterialIconNames.ACCOUNT,
					fromTemplate: true,
					fromPalette: true,
					action: ({ role, parent }) => {
						dispatch(addRoleToTemplate({ role, parent }));
						dispatch(closeModal());
					}
				})
			);
		}
	};

	const addRole = () => {
		dispatch(
			showModal(ModalContentTypes.NEW_OWNER, {
				title: `Add New Role`,
				icon: MaterialIconNames.ACCOUNT,
				fromTemplate: true,
				fromPalette: true,
				action: ({ role, parent }) => {
					dispatch(addRoleToTemplate({ role, parent }));
					dispatch(closeModal());
				}
			})
		);
	};

	const addTask = () => {
		dispatch(
			showModal(ModalContentTypes.NEW_TASK, {
				title: `Add New Task`,
				icon: MaterialIconNames.TASK,
				fromTemplate: true,
				fromPalette: true,
				action: ({ description, role }) => {
					const obj = {
						task: {
							taskId: `task-${generateRandomId()}`,
							description
						},
						owner: role
					};
					dispatch(addTaskToTemplate(obj));
					dispatch(closeModal());
				}
			})
		);
	};

	const undo = () => {
		dispatch(undoTemplateEdit());
	};

	const redo = () => {
		dispatch(redoTemplateEdit());
	};

	const clearAll = () => {
		dispatch(clearAllFromTemplate());
		dispatch(resetSelectedTaskTemplate());
	};

	const saveTemplateHandler = () => {
		saveTemplate();
	};

	const renderUndoButton = () => {
		const disabled = pastEdits.length === 0;
		return (
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={undo}>
				<Icon tooltip="Undo" tooltipPlacement={TooltipPlacement.BOTTOM}>
					{MaterialIconNames.UNDO}
				</Icon>
			</div>
		);
	};

	const renderRedoButton = () => {
		const disabled = futureEdits.length === 0;
		return (
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={redo}>
				<Icon tooltip="Redo" tooltipPlacement={TooltipPlacement.BOTTOM}>
					{MaterialIconNames.REDO}
				</Icon>
			</div>
		);
	};

	const renderAddAccountButton = () => {
		const disabled = selectedTemplate === null;
		return (
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={addRole}>
				<Icon>{MaterialIconNames.ADD}</Icon>
				<Icon>{MaterialIconNames.ACCOUNT}</Icon>
				<label className="editor-button-label">Role</label>
			</div>
		);
	};

	const renderAddTaskButton = () => {
		const disabled = selectedTemplate === null;
		return (
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={addTask}>
				<Icon>{MaterialIconNames.ADD}</Icon>
				<Icon>{MaterialIconNames.TASK}</Icon>
				<label className="editor-button-label">Task</label>
			</div>
		);
	};

	const renderDeleteAllButton = () => {
		// can only delete if a template is selected, or if selected template actually has data to clear
		const disabled = selectedTemplate === null || !selectedTemplate.data.hasOwnProperty("title");
		return (
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={clearAll}>
				<Icon tooltip="Delete All" tooltipPlacement={TooltipPlacement.BOTTOM}>
					{MaterialIconNames.DELETE_FOREVER}
				</Icon>
			</div>
		);
	};

	const renderSaveButton = () => {
		const disabled = pastEdits.length === 0;
		return (
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={saveTemplateHandler}>
				<Icon tooltip="Save" tooltipPlacement={TooltipPlacement.BOTTOM}>
					{MaterialIconNames.SAVE}
				</Icon>
			</div>
		);
	};

	return (
		<div className="template-editor-palette-view">
			<div className="template-editor-palette-commands">
				{/* // TODO maybe we want to combine "ADD and CREATE into a dropdown or are" */}
				<div className="editor-button" onClick={createNewTemplate}>
					<Icon>{MaterialIconNames.ADD}</Icon>
					<label className="editor-button-label">New Template</label>
				</div>
				{renderAddAccountButton()}
				{renderAddTaskButton()}
				{renderUndoButton()}
				{renderRedoButton()}
				{renderDeleteAllButton()}
				{renderSaveButton()}
				<div className="editor-button" onClick={toggleViewTemplates}>
					<Icon tooltip="View Templates" tooltipPlacement={TooltipPlacement.BOTTOM}>
						{MaterialIconNames.LIST}
					</Icon>
				</div>
			</div>
		</div>
	);
};

export default TemplateEditorPaletteView;
