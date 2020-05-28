import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { NotificationView } from "COMPONENTS";
import { MenuDropdown, Icon, TooltipPlacement } from "CORE";
import { MaterialIconNames, UserConfiguration } from "UTILITIES";
import { setUser, getUser, getRole, markAllRead, getUnreadNotificationsCount, getToasts, removeToast } from "REDUX";
import { useLocalStorage } from "HOOKS";
import "./HeaderMenuContainer.scss";

const HeaderMenuContainer = () => {
	const [showUserMenu, setShowUserMenu] = useState(false);
	const [showNotificationsView, setShowNotificationsView] = useState(false);
	const [loggedInUser, setLoggedInUser] = useLocalStorage("user", useSelector(getUser));

	const dispatch = useDispatch();

	// redux selectors
	const role = useSelector(getRole);
	const unreadNotifications = useSelector(getUnreadNotificationsCount);
	const toasts = useSelector(getToasts);

	// need to set roles statically using IIFE
	const getRolesOptions = (function () {
		let roles = [];
		let definedRoles = UserConfiguration.DEFINED_ROLES;
		definedRoles.forEach((role) => {
			roles.push({
				name: role,
				menuAction: () => {
					setUserHandler(role);
				}
			});
		});
		return roles;
	})();

	const toggleNotificationDisplayHandler = () => {
		if (!showNotificationsView) {
			dispatch(markAllRead());
		}
		setShowNotificationsView(!showNotificationsView);
	};

	const userIconClickHandler = () => {
		setShowUserMenu(!showUserMenu);
	};

	const deleteNotificationHandler = (toastId) => {
		dispatch(removeToast(toastId));
	};

	const setUserHandler = (role) => {
		// change later when we have a username
		setLoggedInUser({ username: role, role });
		dispatch(setUser({ username: role, role }));
	};

	const renderNotificationsCounter = () => {
		if (!showNotificationsView && unreadNotifications !== 0) {
			// for now we are only putting 20 notifications in a window total
			return <span className="menu-notification-counter">{unreadNotifications}</span>;
		}
		return null;
	};

	const renderNotificationsButton = () => {
		return (
			<Icon
				className={`menu-icon ${showNotificationsView ? "toggled" : ""}`}
				onClick={toggleNotificationDisplayHandler}
				tooltip="Notifications"
				tooltipPlacement={TooltipPlacement.BOTTOM}
			>
				{MaterialIconNames.NOTIFICATION}
			</Icon>
		);
	};

	const renderNotificationView = () => {
		return (
			showNotificationsView && (
				<NotificationView
					toasts={toasts}
					setVisible={toggleNotificationDisplayHandler}
					deleteNotification={deleteNotificationHandler}
				/>
			)
		);
	};

	const renderUserAccountMenu = () => {
		return (
			<span>
				<span className="menu-user-button" onClick={userIconClickHandler}>
					<Icon className="menu-icon">{MaterialIconNames.PERSON}</Icon>
					<span className="user-label">{role}</span>
				</span>
				{showUserMenu && <MenuDropdown menuOptions={getRolesOptions} closeMenu={userIconClickHandler} />}
			</span>
		);
	};

	return (
		<div className="menu">
			<span className="menu-notification-container">
				{renderNotificationsButton()}
				{renderNotificationsCounter()}
				{renderNotificationView()}
			</span>
			{renderUserAccountMenu()}
		</div>
	);
};

export default HeaderMenuContainer;
