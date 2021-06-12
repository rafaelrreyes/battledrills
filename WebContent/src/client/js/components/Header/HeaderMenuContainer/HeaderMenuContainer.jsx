import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { NotificationView } from "COMPONENTS";
import { MenuDropdown, Icon, TooltipPlacement } from "CORE";
import { MaterialIconNames, UserConfiguration } from "UTILITIES";
import {
	setUser,
	getUser,
	getRoles,
	setRoles,
	getRole,
	markAllRead,
	getUnreadNotificationsCount,
	getToasts,
	removeToast
} from "REDUX";
import { useLocalStorage } from "HOOKS";
import "./HeaderMenuContainer.scss";
import { API } from "UTILITIES/API";

const HeaderMenuContainer = () => {
	const [showUserMenu, setShowUserMenu] = useState(false);
	const [showNotificationsView, setShowNotificationsView] = useState(false);
	const [loggedInUser, setLoggedInUser] = useLocalStorage("user", useSelector(getUser));
	const [menuRoles, setMenuRoles] = useState([]);
	const dispatch = useDispatch();

	// redux selectors
	const unreadNotifications = useSelector(getUnreadNotificationsCount);
	const toasts = useSelector(getToasts);

	useEffect(() => {
		if (showUserMenu) {
			API.getRoles((roles) => {
				dispatch(setRoles(roles));
				const allRoles = roles.map((role) => {
					return {
						name: role.name,
						menuAction: () => {
							setRoleHandler(role);
						}
					};
				});
				setMenuRoles(allRoles);
			});
		}
	}, [showUserMenu]);

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

	const setRoleHandler = (role) => {
		// change later when we have a username
		const { id, name } = role;
		setLoggedInUser({ username: name, name, id });
		dispatch(setUser({ username: name, name, id }));
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
					<Icon className="menu-icon" onClick={userIconClickHandler}>
						{MaterialIconNames.ACCOUNT}
					</Icon>
					<span className="user-label">{loggedInUser.name}</span>
				</span>
				{showUserMenu && (
					<MenuDropdown
						className="override-menu-dropdown"
						menuOptions={menuRoles}
						closeMenu={userIconClickHandler}
					/>
				)}
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
