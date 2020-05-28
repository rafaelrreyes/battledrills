import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { MaterialIconNames, generateRandomId } from "UTILITIES";
import { ModalContentTypes, Icon, TooltipPlacement } from "CORE";
import {
	showModal,
	closeModal,
	addRoleToTemplate,
	getSelectedTemplate,
	addTaskToTemplate,
	undoTemplateEdit,
	redoTemplateEdit,
	openBlankTemplate,
	getPastEdits,
	getFutureEdits,
	clearAllFromTemplate,
	resetSelectedTaskTemplate
} from "REDUX";

import { saveTemplate, promptCurrentEditSave } from "../TemplateEditorHelper";

import "./TemplateEditorPaletteView.scss";

const TemplateEditorPaletteView = ({ onViewTemplates, onToggleGrid, isGridEnabled = false }) => {
	const selectedTemplate = useSelector(getSelectedTemplate);
	const pastEdits = useSelector(getPastEdits);
	const futureEdits = useSelector(getFutureEdits);

	const dispatch = useDispatch();

	const toggleViewTemplatesHandler = () => {
		onViewTemplates();
	};

	const openBlankTemplateHandler = () => {
		dispatch(openBlankTemplate());
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
	};

	const createNewTemplate = () => {
		if (selectedTemplate !== null && pastEdits.length !== 0) {
			promptCurrentEditSave(() => {
				saveTemplate(() => {
					openBlankTemplateHandler();
				});
			});
		} else {
			openBlankTemplateHandler();
		}
	};

	const addRoleHandler = () => {
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

	const addTaskHandler = () => {
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

	const undoHandler = () => {
		dispatch(undoTemplateEdit());
	};

	const redoHandler = () => {
		dispatch(redoTemplateEdit());
	};

	const clearAllHandler = () => {
		dispatch(clearAllFromTemplate());
		dispatch(resetSelectedTaskTemplate());
	};

	const saveTemplateHandler = () => {
		saveTemplate();
	};

	const gridButtonHandler = () => {
		onToggleGrid();
	};

	const renderUndoButton = () => {
		const disabled = pastEdits.length === 0;
		return (
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={undoHandler}>
				<Icon tooltip="Undo" tooltipPlacement={TooltipPlacement.BOTTOM}>
					{MaterialIconNames.UNDO}
				</Icon>
			</div>
		);
	};

	const renderRedoButton = () => {
		const disabled = futureEdits.length === 0;
		return (
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={redoHandler}>
				<Icon tooltip="Redo" tooltipPlacement={TooltipPlacement.BOTTOM}>
					{MaterialIconNames.REDO}
				</Icon>
			</div>
		);
	};

	const renderAddAccountButton = () => {
		const disabled = selectedTemplate === null;
		return (
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={addRoleHandler}>
				<Icon>{MaterialIconNames.ADD}</Icon>
				<Icon>{MaterialIconNames.ACCOUNT}</Icon>
				<label className="editor-button-label">Role</label>
			</div>
		);
	};

	const renderAddTaskButton = () => {
		const disabled = selectedTemplate === null;
		return (
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={addTaskHandler}>
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
			<div className={`editor-button ${disabled ? "disabled" : ""}`} onClick={clearAllHandler}>
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

	const renderNewTemplateButton = () => {
		return (
			<div className="editor-button" onClick={createNewTemplate}>
				<Icon>{MaterialIconNames.ADD}</Icon>
				<label className="editor-button-label">New Template</label>
			</div>
		);
	};

	const renderViewTemplatesButton = () => {
		return (
			<div className="editor-button" onClick={toggleViewTemplatesHandler}>
				<Icon tooltip="View Templates" tooltipPlacement={TooltipPlacement.BOTTOM}>
					{MaterialIconNames.LIST}
				</Icon>
			</div>
		);
	};

	const renderGridButton = () => {
		if (isGridEnabled) {
			return (
				<div className="editor-button" onClick={gridButtonHandler}>
					<Icon tooltip="Turn Grid Off" tooltipPlacement={TooltipPlacement.BOTTOM}>
						{MaterialIconNames.GRID_ON}
					</Icon>
				</div>
			);
		} else {
			return (
				<div className="editor-button" onClick={gridButtonHandler}>
					<Icon tooltip="Turn Grid On" tooltipPlacement={TooltipPlacement.BOTTOM}>
						{MaterialIconNames.GRID_OFF}
					</Icon>
				</div>
			);
		}
	};

	return (
		<div className="template-editor-palette-view">
			<div className="template-editor-palette-commands">
				{/* // TODO maybe we want to combine "ADD and CREATE into a dropdown or are" */}
				{renderNewTemplateButton()}
				{renderAddAccountButton()}
				{renderAddTaskButton()}
				{renderUndoButton()}
				{renderRedoButton()}
				{renderDeleteAllButton()}
				{renderGridButton()}
				{renderSaveButton()}
				{renderViewTemplatesButton()}
			</div>
		</div>
	);
};

export default TemplateEditorPaletteView;
