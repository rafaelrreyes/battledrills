import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { UserConfiguration, MaterialIconNames } from "UTILITIES/index";
import { ChatItemView, Input, INPUT_SIZES, INPUT_TYPES } from "../index";
import { addChat, toggleChatDisplay, swapChats, updateChat, removeChat, getUser } from "REDUX/index";

import "./ChatContainer.scss";
import { getAllChats } from "REDUX/index";

const DEFAULT_MAX_CHATS = 3;
// magic number to find best number of chats/screen
// may change if we scale the whole textbox instead of just number of boxes
const SCREEN_WIDTH_CONSTANT = 300;

const getWidth = () => {
	return Math.max(
		document.body.scrollWidth,
		document.documentElement.scrollWidth,
		document.body.offsetWidth,
		document.documentElement.offsetWidth,
		document.documentElement.clientWidth
	);
};

let resizeTimeout = false;

const ChatContainer = () => {
	const [showContactsList, setShowContactsList] = useState(false);
	const [userSearchString, setUserSearchString] = useState("");
	const [displayExtraChats, setDisplayExtraChats] = useState(false);
	const [maxChats, setMaxChats] = useState(Math.floor(getWidth() / SCREEN_WIDTH_CONSTANT));
	const chats = useSelector(getAllChats);
	const user = useSelector(getUser);
	const dispatch = useDispatch();

	useEffect(() => {
		window.addEventListener("resize", handleResize);
		return () => {
			window.removeEventListener("resize", handleResize);
		};
	}, []);

	const handleResize = () => {
		clearTimeout(resizeTimeout);
		resizeTimeout = setTimeout(() => {
			setMaxChats(Math.floor(getWidth() / SCREEN_WIDTH_CONSTANT));
		}, 200);
	};

	const renderContactsList = () => {
		if (showContactsList) {
			return (
				<div className="contacts-view">
					<div className="contacts-list-header-container">
						<span className="contacts-list-header">Contacts</span>
						<i
							className="material-icons contacts-view-minimize-button"
							onClick={() => {
								toggleContactsList();
							}}
						>
							{MaterialIconNames.REMOVE}
						</i>
					</div>
					<ul className="contacts-list">{getContacts()}</ul>
					<div className="contacts-list-search-input">
						<Input
							inputType={INPUT_TYPES.REGULAR}
							inputSize={INPUT_SIZES.FILL}
							onChange={onContactSearchChange}
							submit={() => {}}
							focus={false}
							placeholder="Search..."
						/>
					</div>
				</div>
			);
		} else {
			return (
				<span
					className="chat-button"
					onClick={(e) => {
						toggleContactsList();
					}}
				>
					Chat
				</span>
			);
		}
	};

	const onContactSearchChange = (value) => {
		setUserSearchString(value);
	};

	const toggleContactsList = (e) => {
		setShowContactsList(!showContactsList);
		setUserSearchString("");
	};

	const getContacts = () => {
		let contacts = [];
		const userRole = user.role;

		// Always add default "All" for All Chat Option
		contacts.push("All", ...UserConfiguration.DEFINED_ROLES);

		if (userSearchString !== "") {
			return contacts
				.filter(
					(contact) =>
						contact.toUpperCase().includes(userSearchString.toUpperCase()) &&
						contact.toUpperCase() !== userRole.toUpperCase()
				)
				.map((contact) => {
					return (
						<li
							key={contact}
							className="contact-item"
							onClick={(e) => {
								startNewChat(contact);
							}}
						>
							{contact}
						</li>
					);
				});
		}

		return contacts
			.filter((contact) => contact.toUpperCase() !== userRole.toUpperCase())
			.map((contact) => {
				return (
					<li
						key={contact}
						className="contact-item"
						onClick={(e) => {
							startNewChat(contact);
						}}
					>
						{contact}
					</li>
				);
			});
	};

	const startNewChat = (targetRole) => {
		// check if state already includes an open chat for this contact
		if (chats.find((currentChat) => targetRole.toUpperCase() === currentChat.role.toUpperCase())) {
			return;
		}

		// probably needs some work for later
		dispatch(addChat({ sender: user, target: targetRole }));
	};

	const toggleSpilloverDropdown = () => {
		setDisplayExtraChats(!displayExtraChats);
	};

	const renderChatSpillOver = () => {
		const hasExtraChats = chats.length > maxChats;

		//get the last few chats, add that to the dropdown
		const extraChats = chats.slice(maxChats, chats.length);
		return (
			hasExtraChats && (
				<div className="open-chats-spill-over">
					<i
						className="material-icons open-chats-spill-over-button"
						onClick={() => {
							toggleSpilloverDropdown();
						}}
					>
						{MaterialIconNames.CHAT_FORUM}
					</i>
					{displayExtraChats && (
						<ul className="open-chats-spill-over-dropdown">{renderExtraChatsDropdown(extraChats)}</ul>
					)}
				</div>
			)
		);
	};

	const renderExtraChatsDropdown = (extraChats) => {
		let extraChatsHTML = extraChats.map((chat, index) => {
			return (
				<li
					className="open-chats-spill-over-dropdown-item"
					value={chat.role}
					key={chat.role + index}
					onClick={() => {
						handleSpillOverItemClick(chat, index);
					}}
				>
					{chat.role}
				</li>
			);
		});

		return extraChatsHTML;
	};

	const handleSpillOverItemClick = (chat, index) => {
		// first we want to remove the chat at the 0 index, and replace it with this guy that was clicked
		setDisplayExtraChats(!displayExtraChats);

		dispatch(swapChats(index + maxChats, maxChats));
		dispatch(toggleChatDisplay(chat, true));
	};

	const renderActiveChats = () => {
		return (
			<div className="open-chats-view">
				{chats.slice(0, maxChats).map((chat) => {
					return (
						<ChatItemView
							key={chat.role}
							chat={chat}
							user={user}
							updateChat={(message) => {
								dispatch(updateChat(message));
							}}
							toggleChatDisplay={(chat) => {
								dispatch(toggleChatDisplay(chat));
							}}
							removeChat={(chat) => {
								dispatch(removeChat(chat));
							}}
						/>
					);
				})}
				{renderChatSpillOver()}
			</div>
		);
	};

	return (
		<div className="chat-container">
			{renderContactsList()}
			{renderActiveChats()}
		</div>
	);
};

export default ChatContainer;
