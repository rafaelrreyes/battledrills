import { ModalConstants } from "./ModalConstants";

const initialState = {
	contentType: null,
	contentData: null
};

export default function(state = initialState, action) {
	const { type, payload } = action;
	switch (type) {
		case ModalConstants.SHOW_MODAL:
			return showModal(payload);
		case ModalConstants.CLOSE_MODAL:
			return closeModal();
		case ModalConstants.UPDATE_MODAL:
			return updateModal(state, payload);
		default:
			return state;
	}
}

function showModal(payload) {
	return {
		contentType: payload.contentType,
		contentData: payload.contentData
	};
}

function closeModal() {
	return initialState;
}

function updateModal(state, payload) {
	return {
		contentType: state.contentType,
		contentData: {
			...state.contentData,
			...payload
		}
	};
}
