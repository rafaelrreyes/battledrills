import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { NotificationView } from "COMPONENTS/index";
import { MenuDropdown, ModalContentTypes, openCreateDrillModal, openSettingsModal } from "CORE/index";
import { MaterialIconNames, UserConfiguration } from "UTILITIES/index";
import {
	showModal,
	setUser,
	getRole,
	markAllRead,
	getUnreadNotificationsCount,
	getToasts,
	removeToast
} from "REDUX/index";
import "./HeaderMenuContainer.scss";

const HeaderMenuContainer = ({}) => {
	const [showMenu, setShowMenu] = useState(false);
	const [showUserMenu, setShowUserMenu] = useState(false);
	const [showNotificationsView, setShowNotificationsViewMenu] = useState(false);

	const dispatch = useDispatch();

	// redux selectors
	const role = useSelector(getRole);
	const unreadNotifications = useSelector(getUnreadNotificationsCount);
	const toasts = useSelector(getToasts);

	const rolesOptions = (function() {
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

	const menuOptions = [
		{
			name: "Create Drill",
			menuAction: openCreateDrillModal
		},
		{
			name: "Version",
			menuAction: () => {
				dispatch(
					showModal(ModalContentTypes.VERSION, {
						title: "Version",
						singleButton: true
					})
				);
			}
		},
		{
			name: "Settings",
			menuAction: openSettingsModal
		}
	];

	const onToggleNotificationsDisplay = () => {
		if (!showNotificationsView) {
			dispatch(markAllRead());
		}
		setShowNotificationsViewMenu(!showNotificationsView);
	};

	const onMenuIconClicked = () => {
		setShowMenu(!showMenu);
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
		dispatch(setUser({ username: role, role }));
	};

	return (
		<div className="menu">
			<span className="menu-notification-container">
				<i
					className={`material-icons menu-icon ${showNotificationsView ? "toggled" : ""}`}
					onClick={onToggleNotificationsDisplay}
				>
					{MaterialIconNames.NOTIFICATION}
				</i>
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
				<i className="material-icons menu-icon" onClick={onMenuIconClicked}>
					{MaterialIconNames.MENU}
				</i>
				{showMenu && <MenuDropdown menuOptions={menuOptions} closeMenu={onMenuIconClicked} />}
			</span>
			<span>
				<span className="menu-user-button" onClick={onUserIconClicked}>
					<i className="material-icons menu-icon">{MaterialIconNames.PERSON}</i>
					<span className="user-label">{role}</span>
				</span>
				{showUserMenu && <MenuDropdown menuOptions={rolesOptions} closeMenu={onUserIconClicked} />}
			</span>
		</div>
	);
};

export default HeaderMenuContainer;
