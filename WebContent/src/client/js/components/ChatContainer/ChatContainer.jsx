import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { API, MaterialIconNames } from "UTILITIES";
import ChatItemView from "./ChatItemView/ChatItemView";
import { Icon, Input, InputSizes, InputTypes } from "CORE";
import { addChat, getRoles, toggleChatDisplay, swapChats, updateChat, removeChat, getUser, getAllChats } from "REDUX";

import "./ChatContainer.scss";

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
	const [allRoles, setAllRoles] = useState([]);
	const [showContactsList, setShowContactsList] = useState(false);
	const [userSearchString, setUserSearchString] = useState("");
	const [displayExtraChats, setDisplayExtraChats] = useState(false);
	const [maxChats, setMaxChats] = useState(Math.floor(getWidth() / SCREEN_WIDTH_CONSTANT));
	const chats = useSelector(getAllChats);
	const user = useSelector(getUser);
	const reduxRoles = useSelector(getRoles);

	const dispatch = useDispatch();

	useEffect(() => {
		window.addEventListener("resize", handleResize);
		return () => {
			window.removeEventListener("resize", handleResize);
		};
	}, []);

	useEffect(() => {
		// anytime the roles is changed in app state, fetch most updated roles
		API.getRoles((roles) => {
			setAllRoles(roles);
		});
	}, [reduxRoles]);

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
						<span className="contacts-list-header">
							<Icon>{MaterialIconNames.CONTACTS}</Icon>
							<label className="contacts-list-header-label">Contacts</label>
						</span>
						<Icon
							className="contacts-view-minimize-button"
							onClick={() => {
								toggleContactsListHandler();
							}}
						>
							{MaterialIconNames.REMOVE}
						</Icon>
					</div>
					<ul className="contacts-list">{getContacts()}</ul>
					<div className="contacts-list-search-input">
						<Input
							inputType={InputTypes.REGULAR}
							inputSize={InputSizes.FILL}
							onChange={contactSearchHandler}
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
						toggleContactsListHandler();
					}}
				>
					Chat
				</span>
			);
		}
	};

	const contactSearchHandler = (value) => {
		setUserSearchString(value);
	};

	const toggleContactsListHandler = (e) => {
		setShowContactsList(!showContactsList);
		setUserSearchString("");
	};

	const getContacts = () => {
		let contacts = [];
		const { id, name } = user;
		// Always add default "All" for All Chat Option
		contacts.push({ id: "*", name: "All" }, ...allRoles);

		if (userSearchString !== "") {
			return contacts
				.filter(
					(contact) =>
						contact.name.toUpperCase().includes(userSearchString.toUpperCase()) &&
						contact.name.toUpperCase() !== user.name.toUpperCase()
				)
				.map((contact) => {
					return (
						<li
							key={`chat-contact-${contact.id}`}
							className="contact-item"
							onClick={(e) => {
								openNewChatHandler(contact);
							}}
						>
							{contact.name}
						</li>
					);
				});
		}

		return contacts
			.filter((contact) => contact.name.toUpperCase() !== user.name.toUpperCase())
			.map((contact) => {
				return (
					<li
						key={`chat-contact-${contact.id}`}
						className="contact-item"
						onClick={(e) => {
							openNewChatHandler(contact);
						}}
					>
						{contact.name}
					</li>
				);
			});
	};

	const openNewChatHandler = (targetRole) => {
		// check if state already includes an open chat for this contact
		if (chats.find((currentChat) => targetRole.id === currentChat.id)) {
			return;
		}

		// TODO probably needs some work for later
		dispatch(addChat({ senderId: user.id, receiverId: targetRole.id, receiverName: targetRole.name }));
	};

	const toggleSpilloverMenuHandler = () => {
		setDisplayExtraChats(!displayExtraChats);
	};

	const spilloverItemClickHandler = (chat, index) => {
		// first we want to remove the chat at the 0 index, and replace it with this guy that was clicked
		setDisplayExtraChats(!displayExtraChats);

		dispatch(swapChats(index + maxChats, maxChats));
		dispatch(toggleChatDisplay(chat, true));
	};

	const renderChatSpillOver = () => {
		const hasExtraChats = chats.length > maxChats;

		//get the last few chats, add that to the dropdown
		const extraChats = chats.slice(maxChats, chats.length);
		return (
			hasExtraChats && (
				<div className="open-chats-spill-over">
					<Icon
						className="open-chats-spill-over-button"
						onClick={() => {
							toggleSpilloverMenuHandler();
						}}
					>
						{MaterialIconNames.CHAT_FORUM}
					</Icon>
					{displayExtraChats && (
						<ul className="open-chats-spill-over-dropdown">{renderExtraChatsDropdown(extraChats)}</ul>
					)}
				</div>
			)
		);
	};

	const renderExtraChatsDropdown = (extraChats) => {
		let extraChatsHTML = extraChats.map((chat, index) => {
			console.log(chat);
			return (
				<li
					className="open-chats-spill-over-dropdown-item"
					value={chat.role}
					key={chat.role + index}
					onClick={() => {
						spilloverItemClickHandler(chat, index);
					}}
				>
					{chat.role}
				</li>
			);
		});

		return extraChatsHTML;
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
							onUpdateChat={(message) => {
								dispatch(updateChat(message));
							}}
							onToggleChat={(chat) => {
								dispatch(toggleChatDisplay(chat));
							}}
							onRemoveChat={(chat) => {
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
