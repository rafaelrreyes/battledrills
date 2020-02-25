import { ChatConstants } from "./ChatConstants";

export const addChat = (chat) => {
	return {
		type: ChatConstants.ADD_CHAT,
		payload: chat
	};
};

export const toggleChatDisplay = (chat, forceOpen) => {
	return {
		type: ChatConstants.TOGGLE_CHAT_DISPLAY,
		payload: { chat, forceOpen }
	};
};

export const swapChats = (index, max_size) => {
	return {
		type: ChatConstants.SWAP_CHATS,
		payload: { index, max_size }
	};
};

export const updateChat = (messageObj) => {
	return {
		type: ChatConstants.UPDATE_CHAT,
		payload: messageObj
	};
};

export const removeChat = (chat) => {
	return {
		type: ChatConstants.REMOVE_CHAT,
		payload: chat
	};
};
