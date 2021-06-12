import store from "REDUX/store";
import { API, parseType, MaterialIconNames } from "UTILITIES/";
import { ModalContentTypes } from "CORE/";

import { showModal, closeModal, getSelectedDrill, getUser, setSelectedDrill } from "REDUX/";

export const saveTemplateByDrillId = () => {
	const selectedDrill = getSelectedDrill(store.getState());
	const drillId = selectedDrill.id;
	const user = getUser(store.getState());

	store.dispatch(
		showModal(ModalContentTypes.SAVE_TEMPLATE, {
			defaultValue: parseType(selectedDrill.type),
			icon: MaterialIconNames.SAVE,
			action: (type) => {
				const requestBody = {
					type,
					drillId,
					user
				};

				API.saveTemplateByDrillId(requestBody, () => {
					// successfully saved template
					API.getDrillById(drillId, {}, (drill) => {
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
