import React, { Fragment, useState, useRef, useEffect } from "react";
import { WS, MaterialIconNames } from "UTILITIES/index";
import { ArrowTooltip, TooltipTypes, TooltipPlacement } from "CORE/index";
import ChatTextbox from "./ChatTextbox/ChatTextbox";
import moment from "moment";

//scss
import "./ChatItemView.scss";

const ChatItemView = ({ user, chat, updateChat, removeChat, toggleChatDisplay }) => {
	const currentRole = user.role;
	const targetRole = chat.role;
	const messagesListRef = useRef();

	useEffect(() => {
		messagesListRef.current.scrollTop = messagesListRef.current.scrollHeight;
	});

	if (chat.minimized) {
		return (
			<ChatItemViewMinimized
				targetRole={targetRole}
				chat={chat}
				toggleChatDisplay={toggleChatDisplay}
				messagesListRef={messagesListRef}
				removeChat={removeChat}
			/>
		);
	} else {
		return (
			<ChatItemViewOpen
				targetRole={targetRole}
				currentRole={currentRole}
				chat={chat}
				updateChat={updateChat}
				toggleChatDisplay={toggleChatDisplay}
				messagesListRef={messagesListRef}
				removeChat={removeChat}
			/>
		);
	}
};

const ChatItemViewMinimized = ({ targetRole, chat, toggleChatDisplay, removeChat, messagesListRef }) => {
	return (
		<div className="open-chats-view-item-minimized-container">
			<div
				className="open-chats-view-item-minimized"
				key={targetRole}
				onClick={() => {
					toggleChatDisplay(chat);
				}}
			>
				<span className="open-chats-view-item-minimized-target">{targetRole}</span>
				<span className="open-chats-view-item-minimized-commands">
					{chat.notifications > 0 ? (
						<span className="open-chats-view-item-minimized-notification">{chat.notifications}</span>
					) : (
						<></>
					)}
					<i
						className="material-icons open-chats-view-item-close-button"
						onClick={() => {
							removeChat(chat);
						}}
					>
						{MaterialIconNames.CLOSE}
					</i>
				</span>
			</div>
			<div ref={messagesListRef} />
		</div>
	);
};

const ChatItemViewOpen = ({
	targetRole,
	currentRole,
	chat,
	updateChat,
	toggleChatDisplay,
	removeChat,
	messagesListRef
}) => {
	const [clearMessage, setClearMessage] = useState(false);

	const onSubmitMessage = (message) => {
		// cannot send white space
		if (message.trim() === "") {
			return;
		}

		const messageObj = {
			sender: currentRole,
			target: targetRole,
			message,
			timestampMillis: moment()
				.unix(moment().valueOf())
				.valueOf()
		};

		WS().send(
			messageObj,
			// success
			() => {
				updateChat(messageObj);
				setClearMessage(true);
			},
			// error
			() => {
				console.error(`Failed when sending message to user: ${messageObj.target}`);
			}
		);
	};

	return (
		<div className="open-chats-view-item">
			<div className="open-chats-view-item-header">
				<span className="open-chats-view-item-target">{targetRole}</span>
				<span className="open-chats-view-item-commands">
					<i
						className="material-icons open-chats-view-item-minimize"
						onClick={() => {
							toggleChatDisplay(chat);
						}}
					>
						{MaterialIconNames.REMOVE}
					</i>
					<i
						className="material-icons open-chats-view-item-close"
						onClick={() => {
							removeChat(chat);
						}}
					>
						{MaterialIconNames.CLOSE}
					</i>
				</span>
			</div>
			<div className="open-chats-view-item-messages">
				<div className="message" ref={messagesListRef}>
					<div className="grid-message">{renderChatMessages(chat.messages, currentRole)}</div>
				</div>
			</div>
			<ChatTextbox
				clearMessage={clearMessage}
				onSubmitMessage={onSubmitMessage}
				onClearMessage={() => {
					setClearMessage(false);
				}}
			/>
		</div>
	);
};

const renderChatMessages = (messages, currentRole) => {
	if (messages.length === 0) {
		return <span>No messages</span>;
	}

	let arrayToRender = [];
	let combinedMessages = [];
	let currentSender = messages[0].sender;
	let messageBlockIndex = 0;

	let wrapperClass = currentSender === currentRole ? "col-message-sent" : "col-message-received";
	let isSender = currentSender === currentRole;

	messages.forEach((currentMessage, messageIndex) => {
		const { sender } = currentMessage;
		// a message not from the current message block is sent/received
		// if the previous sender, currentSender, === currentRole, the previous message block was sent by the sender
		// there will be no label for "senders" so label is set to a Fragment <></>
		// otherwise, the message was "received" so a label for role/user is set
		if (currentSender !== sender) {
			const label =
				currentSender === currentRole ? <></> : <div className="receive-username">{currentSender}</div>;
			// specifically using Fragment instead of <></> allows you to add a key to it :)
			arrayToRender.push(
				<Fragment key={`${currentSender + messageBlockIndex}`}>
					{label}
					<div className={wrapperClass}>{combinedMessages.slice()}</div>
				</Fragment>
			);
			// this is used as a key for each block of messages, eg. WO1, BAS1, WO2, BAS2, etc. during a chat chain
			messageBlockIndex++;
			combinedMessages = [];
			currentSender = sender;
			wrapperClass = currentSender === currentRole ? "col-message-sent" : "col-message-received";
			isSender = currentSender === currentRole;
		}
		// this is used as a key for each individual message within each block, eg. 1, 2, 3, 4, etc.
		combinedMessages.push(getMessage(currentMessage, messageIndex, isSender));
	});

	const label = currentSender === currentRole ? <></> : <div className="receive-username">{currentSender}</div>;
	arrayToRender.push(
		<Fragment key={`${currentSender + messageBlockIndex}`}>
			{label}
			<div className={wrapperClass}>{combinedMessages.slice()}</div>
		</Fragment>
	);

	return arrayToRender;
};

const getMessage = (currentMessage, messageIndex, isSender) => {
	const { message, timestampMillis } = currentMessage;
	const timestamp = moment.unix(timestampMillis).format("HH:mm");
	const className = isSender ? "message-sent" : "message-received";
	const timestampPlacement = isSender ? TooltipPlacement.RIGHT : TooltipPlacement.LEFT;
	return (
		<ArrowTooltip title={timestamp} type={TooltipTypes.INFO} placement={timestampPlacement} key={messageIndex}>
			<div className={className}>
				<p>{message}</p>
			</div>
		</ArrowTooltip>
	);
};

export default ChatItemView;
