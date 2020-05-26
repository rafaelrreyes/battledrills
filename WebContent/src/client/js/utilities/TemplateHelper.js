import store from "REDUX/store";
import { API, parseType, MaterialIconNames } from "UTILITIES/";
import { ModalContentTypes } from "CORE/";

import { showModal, closeModal, getSelectedDrill, getUser, setSelectedDrill } from "REDUX/";

export const saveTemplateByDrillName = () => {
	const selectedDrill = getSelectedDrill(store.getState());
	const drillName = selectedDrill.name;
	const user = getUser(store.getState());

	store.dispatch(
		showModal(ModalContentTypes.SAVE_TEMPLATE, {
			defaultValue: parseType(selectedDrill.type),
			icon: MaterialIconNames.SAVE,
			action: (type) => {
				const requestBody = {
					type,
					drillName,
					user
				};

				API.saveTemplateByDrillName(requestBody, () => {
					// successfully saved template
					API.getDrillByName(drillName, {}, (drill) => {
						// successfully updated selected drill
						store.dispatch(setSelectedDrill(drill));
					});
				});
				store.dispatch(closeModal());
			}
		})
	);
};

export const openTemplateManager = () => {
	store.dispatch(
		showModal(ModalContentTypes.MANAGE_TEMPLATES, {
			title: `Manage Templates`,
			singleButton: true,
			action: () => {
				store.dispatch(closeModal());
			}
		})
	);
};
