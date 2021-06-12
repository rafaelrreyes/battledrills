import store from "REDUX/store";
import { ModalContentTypes } from "CORE";
import { MaterialIconNames, API, parseType, undoParsedType } from "UTILITIES";
import { showModal, closeModal, getSelectedTemplate, setSelectedTemplate } from "REDUX";
/**
 * Prompts the user if they want to save the current template they are editting in the case they
 * navigate to another template while working on a template or attempt to create a new one while editting a template.
 * Invokes the callback method if confirmed.
 */

export const promptCurrentEditSave = (callback) => {
	const selectedTemplate = getSelectedTemplate(store.getState());
	if (selectedTemplate !== null && typeof selectedTemplate.type !== "undefined") {
		store.dispatch(
			showModal(ModalContentTypes.CONFIRMATION, {
				description: `Do you want to save your changes to the current template?`,
				icon: MaterialIconNames.SAVE,
				action: () => {
					// TODO perform template save here via api
					// then do callback to proceed
					callback();
				}
			})
		);
	}
};

/**
 * Perform callback after successful save.
 * @param {Function} callback
 */
export const saveTemplate = (callback = () => {}) => {
	// TODO get available names and show error message on save template modal
	// getAvailableName();
	const selectedTemplate = getSelectedTemplate(store.getState());
	store.dispatch(
		showModal(ModalContentTypes.SAVE_TEMPLATE, {
			title: `Save Template`,
			icon: MaterialIconNames.SAVE,
			defaultValue: selectedTemplate.type ? parseType(selectedTemplate.type) : "",
			action: (value) => {
				// change the type of the selectedTemplate, but create a clone without mutating the immutable
				// in reducer
				const templateObj = Object.assign({}, selectedTemplate);
				templateObj.type = undoParsedType(value);
				const requestBody = {
					template: JSON.stringify(templateObj)
				};

				API.saveTemplate(requestBody, (response) => {
					store.dispatch(setSelectedTemplate(templateObj));
					callback();
				});
				store.dispatch(closeModal());
			}
		})
	);
};

export const getAvailableName = async () => {
	let templates = [];
	await API.types({}, (response) => {
		templates = [...response.default, ...response.custom];
	});

	console.log(templates);
};
