import React, { Fragment, useState, useRef, useEffect } from "react";
import { WS, MaterialIconNames } from "UTILITIES";
import { ArrowTooltip, TooltipTypes, TooltipPlacement, Icon } from "CORE";
import ChatTextbox from "./ChatTextbox/ChatTextbox";
import moment from "moment";

//scss
import "./ChatItemView.scss";

const ChatItemView = ({ user, chat, onUpdateChat, onRemoveChat, onToggleChat }) => {
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
				onToggleChat={onToggleChat}
				messagesListRef={messagesListRef}
				onRemoveChat={onRemoveChat}
			/>
		);
	} else {
		return (
			<ChatItemViewOpen
				targetRole={targetRole}
				currentRole={currentRole}
				chat={chat}
				onUpdateChat={onUpdateChat}
				onToggleChat={onToggleChat}
				messagesListRef={messagesListRef}
				onRemoveChat={onRemoveChat}
			/>
		);
	}
};

const ChatItemViewMinimized = ({ targetRole, chat, onToggleChat, onRemoveChat, messagesListRef }) => {
	return (
		<div className="open-chats-view-item-minimized-container">
			<div
				className="open-chats-view-item-minimized"
				key={targetRole}
				onClick={() => {
					onToggleChat(chat);
				}}
			>
				<span className="open-chats-view-item-minimized-target">
					{/* TODO this can eventually be a mini icon of their saved profile picture */}
					<Icon>{MaterialIconNames.ACCOUNT}</Icon>
					<label className="role-label">{targetRole}</label>
				</span>
				<span className="open-chats-view-item-minimized-commands">
					{chat.notifications > 0 ? (
						<span className="open-chats-view-item-minimized-notification">{chat.notifications}</span>
					) : (
						<></>
					)}
					<Icon
						className="open-chats-view-item-close-button"
						onClick={() => {
							onRemoveChat(chat);
						}}
					>
						{MaterialIconNames.CLOSE}
					</Icon>
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
	onUpdateChat,
	onToggleChat,
	onRemoveChat,
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
			timestampMillis: moment().unix(moment().valueOf()).valueOf()
		};

		WS().send(
			messageObj,
			// success
			() => {
				onUpdateChat(messageObj);
				setClearMessage(true);
			}
		);
	};

	return (
		<div className="open-chats-view-item">
			<div className="open-chats-view-item-header">
				<span className="open-chats-view-item-target">
					<Icon>{MaterialIconNames.ACCOUNT}</Icon>
					<label className="role-label">{targetRole}</label>
				</span>
				<span className="open-chats-view-item-commands">
					<Icon
						className="open-chats-view-item-minimize"
						onClick={() => {
							onToggleChat(chat);
						}}
					>
						{MaterialIconNames.REMOVE}
					</Icon>
					<Icon
						className="open-chats-view-item-close"
						onClick={() => {
							onRemoveChat(chat);
						}}
					>
						{MaterialIconNames.CLOSE}
					</Icon>
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
