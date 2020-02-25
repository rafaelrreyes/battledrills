import { ModalConstants } from "./ModalConstants";

/**
 * Used to open a modal that takes over the screen view.
 * contentData is an object that requires an "action" key and can have any other number of key/values.
 * Ex.  contentData: {
 * 		 	action: () => {},
 * 			singleButton: true
 *		}
 * For the above example, "action" is required and is what occurs when the "submit" button is clicked.
 * "singleButton" is an optional key that is used in ModalContainer.jsx to render one or two buttons (OK or Cancel/Submit).
 * Any other keys that are needed can be passed in contentData to give to Modal.jsx or any ModalContent.
 * @param {ModalContentType} contentType (defined at the bottom of ModalContainer.jsx)
 * @param {Object} contentData
 *
 * @return Object returned to the Reducer
 */
export const showModal = (contentType, contentData) => {
	return {
		type: ModalConstants.SHOW_MODAL,
		payload: {
			contentType,
			contentData
		}
	};
};

export const closeModal = () => {
	return {
		type: ModalConstants.CLOSE_MODAL
	};
};

export const updateModal = (update) => {
	return {
		type: ModalConstants.UPDATE_MODAL,
		payload: update
	};
};
