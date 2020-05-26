import { getTask } from "./DiagramReducerHelper";

export const getLinkStyle = (store) => {
	return store.DiagramEditor.linkStyle;
};

export const getLinkSmoothness = (store) => {
	return store.DiagramEditor.linkSmoothness;
};

export const getSelectedTemplate = (store) => {
	return store.DiagramEditor.selectedTemplate;
};

export const getSelectedTaskTemplate = (store) => {
	return store.DiagramEditor.selectedTaskTemplate;
};

export const getPastEdits = (store) => {
	return store.DiagramEditor.past;
};

export const getFutureEdits = (store) => {
	return store.DiagramEditor.future;
};

export const getTaskTemplate = (store, id) => {
	return getTask(store.DiagramEditor.selectedTemplate, id);
};
