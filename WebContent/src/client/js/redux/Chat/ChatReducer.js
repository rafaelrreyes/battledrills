import { ChatConstants } from "./ChatConstants";
import moment from "moment";

const initialState = {
	chats: []
};

export default function (state = initialState, action) {
	const { type, payload } = action;
	switch (type) {
		case ChatConstants.ADD_CHAT: {
			const { senderId, receiverId, receiverName, message, timestampMillis } = payload;
			let withMessageObj = {};
			if (typeof message !== "undefined") {
				withMessageObj = { senderId, receiverId, message, timestampMillis, receiverName };
			}
			// check if message is also added to this chat, then add it to messages array if necessary (this could b when someone else messages you
			// through websocket )
			const { chats } = state;

			// if chats are greater than 4, swap out one of the opened ones
			if (chats.length > 4) {
			}
			return {
				...state,
				chats: [
					...chats,
					{
						receiverName,
						minimized: false,
						notifications: 0,
						receiverId: receiverId,
						messages: message ? [withMessageObj] : []
					}
				]
			};
		}
		case ChatConstants.SWAP_CHATS: {
			const { chats } = state;
			const updatedChats = swapChats(payload, chats);
			return {
				...state,
				chats: [...updatedChats]
			};
		}
		case ChatConstants.UPDATE_CHAT: {
			const messageObj = payload;
			const { chats } = state;
			const updatedChats = deepUpdateChat(messageObj, chats);
			return {
				...state,
				chats: [...updatedChats]
			};
		}
		case ChatConstants.TOGGLE_CHAT_DISPLAY: {
			const { chats } = state;
			const chat = payload.chat;
			const updatedChats = chats.map((currentChat) => {
				if (currentChat.receiverId === chat.receiverId) {
					if (payload.forceOpen) {
						currentChat.minimized = false;
					} else {
						currentChat.minimized = !currentChat.minimized;
						currentChat.notifications = 0;
					}
				}

				return currentChat;
			});
			return {
				...state,
				chats: [...updatedChats]
			};
		}
		case ChatConstants.REMOVE_CHAT: {
			const { chats } = state;
			const chat = payload;
			const filteredChats = chats.filter((currentChat) => {
				return currentChat.receiverId !== chat.receiverId;
			});

			return {
				...state,
				chats: [...filteredChats]
			};
		}
		default:
			return state;
	}
}

const deepUpdateChat = (messageObj, chats) => {
	const targetChat = chats.find((currentChat) => {
		return (
			currentChat.receiverId === messageObj.receiverId ||
			(currentChat.receiverId === messageObj.senderId && messageObj.receiverId !== "*")
		);
	});
	if (targetChat.minimized) {
		targetChat.notifications++;
	}
	targetChat.messages.push(messageObj);
	return chats;
};

const addChat = (payload) => {
	//check if state has 4 or more chats,
};

const swapChats = (payload, chats) => {
	let randomOpenChatIndex = Math.floor(Math.random() * payload.max_size);
	let targetIndex = payload.index;
	let tempChats = chats.slice();
	let temp = Object.assign({}, tempChats[randomOpenChatIndex]);
	tempChats[randomOpenChatIndex] = Object.assign({}, tempChats[targetIndex]);
	tempChats[targetIndex] = temp;
	return tempChats;
};
