import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { NotificationView } from "COMPONENTS";
import { MenuDropdown, Icon } from "CORE";
import { MaterialIconNames, UserConfiguration } from "UTILITIES";
import {
	showModal,
	setUser,
	getUser,
	getRole,
	markAllRead,
	getUnreadNotificationsCount,
	getToasts,
	removeToast
} from "REDUX";
import { useLocalStorage } from "HOOKS";
import "./HeaderMenuContainer.scss";

const HeaderMenuContainer = ({}) => {
	const [showUserMenu, setShowUserMenu] = useState(false);
	const [showNotificationsView, setShowNotificationsViewMenu] = useState(false);
	const [loggedInUser, setLoggedInUser] = useLocalStorage("user", useSelector(getUser));

	const dispatch = useDispatch();

	// redux selectors
	const role = useSelector(getRole);
	const unreadNotifications = useSelector(getUnreadNotificationsCount);
	const toasts = useSelector(getToasts);

	const rolesOptions = (function () {
		let roles = [];
		let definedRoles = UserConfiguration.DEFINED_ROLES;
		definedRoles.forEach((role) => {
			roles.push({
				name: role,
				menuAction: () => {
					onSetUser(role);
				}
			});
		});
		return roles;
	})();

	const onToggleNotificationsDisplay = () => {
		if (!showNotificationsView) {
			dispatch(markAllRead());
		}
		setShowNotificationsViewMenu(!showNotificationsView);
	};

	const onUserIconClicked = () => {
		setShowUserMenu(!showUserMenu);
	};

	const renderNotificationsCounter = () => {
		if (!showNotificationsView && unreadNotifications !== 0) {
			// for now we are only putting 20 notifications in a window total
			return <span className="menu-notification-counter">{unreadNotifications}</span>;
		}
		return null;
	};

	const onDeleteNotification = (toastId) => {
		dispatch(removeToast(toastId));
	};

	const onSetUser = (role) => {
		// change later when we have a username
		setLoggedInUser({ username: role, role });
		dispatch(setUser({ username: role, role }));
	};

	return (
		<div className="menu">
			<span className="menu-notification-container">
				<Icon
					className={`menu-icon ${showNotificationsView ? "toggled" : ""}`}
					onClick={onToggleNotificationsDisplay}
				>
					{MaterialIconNames.NOTIFICATION}
				</Icon>
				{renderNotificationsCounter()}
				{showNotificationsView && (
					<NotificationView
						toasts={toasts}
						setVisible={onToggleNotificationsDisplay}
						deleteNotification={onDeleteNotification}
					/>
				)}
			</span>
			<span>
				<span className="menu-user-button" onClick={onUserIconClicked}>
					<Icon className="menu-icon">{MaterialIconNames.PERSON}</Icon>
					<span className="user-label">{role}</span>
				</span>
				{showUserMenu && <MenuDropdown menuOptions={rolesOptions} closeMenu={onUserIconClicked} />}
			</span>
		</div>
	);
};

export default HeaderMenuContainer;
