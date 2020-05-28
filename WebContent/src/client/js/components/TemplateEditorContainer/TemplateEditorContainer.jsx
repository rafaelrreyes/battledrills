import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import joint from "jointjs/index";
import BattleDrillDiagram from "JOINT/BattleDrillDiagram";
import { useDispatch, useSelector } from "react-redux";
import TemplateEditorDiagram from "./TemplateEditorDiagram/TemplateEditorDiagram";
import TemplateEditorTemplatesView from "./TemplateEditorTemplatesView/TemplateEditorTemplatesView";
import TemplateEditorPaletteView from "./TemplateEditorPaletteView/TemplateEditorPaletteView";
import TemplateEditorTaskView from "./TemplateEditorTaskView/TemplateEditorTaskView";
import { useLocalStorage } from "HOOKS";

import "./TemplateEditorContainer.scss";

import { setCurrentView, setSelectedTaskTemplate, getSelectedTaskTemplate, getSelectedTemplate } from "REDUX";

const TemplateEditorContainer = () => {
	const location = useLocation();
	const graph = new joint.dia.Graph();
	const diagram = new BattleDrillDiagram(graph);

	const [showTemplates, setShowTemplates] = useState(true);
	const [isGridEnabled, setIsGridEnabled] = useLocalStorage("template_grid_mode", false);

	const selectedTemplate = useSelector(getSelectedTemplate);
	const selectedTaskTemplate = useSelector(getSelectedTaskTemplate);

	const dispatch = useDispatch();

	useEffect(() => {
		dispatch(setCurrentView(location.pathname));
	}, [location]);

	const renderDetailedView = () => {
		return selectedTaskTemplate !== null && typeof selectedTaskTemplate !== "undefined" ? (
			<TemplateEditorTaskView />
		) : (
			<TemplateEditorTemplatesView
				isGridEnabled={isGridEnabled}
				onToggleGrid={() => {
					toggleGridHandler();
				}}
			/>
		);
	};

	const toggleGridHandler = () => {
		setIsGridEnabled(!isGridEnabled);
	};

	const toggleTemplatesHandler = () => {
		dispatch(setSelectedTaskTemplate(null));
	};

	return (
		<div className="template-editor-container">
			<div className="template-palette-bar">
				<TemplateEditorPaletteView
					diagram={diagram}
					isGridEnabled={isGridEnabled}
					onToggleGrid={() => {
						toggleGridHandler();
					}}
					onViewTemplates={toggleTemplatesHandler}
				/>
			</div>
			<div className="template-main-container">
				<TemplateEditorDiagram isGridEnabled={isGridEnabled} graph={graph} diagram={diagram} />
				{renderDetailedView()}
			</div>
		</div>
	);
};

export default TemplateEditorContainer;
