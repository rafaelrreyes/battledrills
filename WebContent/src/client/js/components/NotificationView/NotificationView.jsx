import React from "react";
import NotificationViewItem from "./NotificationViewItem";
import { useClickOutside } from "HOOKS/index";

import "./NotificationView.scss";

const NotificationView = ({ toasts, setVisible, deleteNotification }) => {
	const notificationViewRef = useClickOutside(setVisible);

	const renderNotifications = () => {
		if (toasts.length === 0) {
			return <span className="notifications-view-none">No notifications</span>;
		}

		const notifications = toasts.map((toast, index) => {
			return (
				<NotificationViewItem
					key={toast + index}
					{...toast}
					setVisible={setVisible}
					deleteNotification={deleteNotification}
				/>
			);
		});

		return <ul className="notification-view-list">{notifications}</ul>;
	};

	return (
		<div ref={notificationViewRef} className="notification-view">
			{renderNotifications(toasts)}
		</div>
	);
};

export default NotificationView;
