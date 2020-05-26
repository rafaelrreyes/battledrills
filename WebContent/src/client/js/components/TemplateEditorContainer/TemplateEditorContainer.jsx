import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import joint from "jointjs/index";
import BattleDrillDiagram from "../../joint/BattleDrillDiagram";
import { useDispatch, useSelector } from "react-redux";
import { MaterialIconNames } from "UTILITIES";
import TemplateEditorDiagram from "./TemplateEditorDiagram/TemplateEditorDiagram";
import TemplateEditorTemplatesView from "./TemplateEditorTemplatesView/TemplateEditorTemplatesView";
import TemplateEditorPaletteView from "./TemplateEditorPaletteView/TemplateEditorPaletteView";
import TemplateEditorTaskView from "./TemplateEditorTaskView/TemplateEditorTaskView";

import "./TemplateEditorContainer.scss";

import { setCurrentView, setSelectedTaskTemplate, getSelectedTaskTemplate, getSelectedTemplate } from "REDUX";

const TemplateEditorContainer = () => {
	const location = useLocation();
	const graph = new joint.dia.Graph();
	const diagram = new BattleDrillDiagram(graph);

	const [showTemplates, setShowTemplates] = useState(true);

	const selectedTemplate = useSelector(getSelectedTemplate);
	const selectedTaskTemplate = useSelector(getSelectedTaskTemplate);

	const dispatch = useDispatch();

	useEffect(() => {
		dispatch(setCurrentView(location.pathname));
	}, [location]);

	const renderDetailedView = () => {
		return selectedTaskTemplate !== null ? <TemplateEditorTaskView /> : <TemplateEditorTemplatesView />;
	};

	const toggleViewTemplates = () => {
		dispatch(setSelectedTaskTemplate(null));
	};

	return (
		<div className="template-editor-container">
			<div className="template-palette-bar">
				<TemplateEditorPaletteView diagram={diagram} onViewTemplates={toggleViewTemplates} />
			</div>
			<div className="template-main-container">
				<TemplateEditorDiagram graph={graph} diagram={diagram} />
				{renderDetailedView()}
			</div>
		</div>
	);
};

export default TemplateEditorContainer;
