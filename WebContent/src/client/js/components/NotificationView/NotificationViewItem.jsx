import React, { useState } from "react";
import "./NotificationViewItem.scss";
import { getNotificationLink, getToastMessageHtml } from "CORE/index";
import { MaterialIconNames, secondsToDateMinimal } from "UTILITIES/index";

const NotificationViewItem = ({
	toastId,
	user,
	taskData,
	drillName,
	note,
	operationType,
	objectType,
	timestamp,
	setVisible,
	deleteNotification,
	attachmentName,
	attachmentType
}) => {
	const [expanded, setExpanded] = useState(false);

	const onNotificationClick = () => {
		setExpanded(!expanded);
	};

	return (
		<li className="notification-view-item" onClick={onNotificationClick}>
			<span
				className={`${expanded ? "notification-view-item-message-expanded" : "notification-view-item-message"}`}
			>
				<span className="notification-view-item-timestamp">{secondsToDateMinimal(timestamp)} - </span>
				{getToastMessageHtml({
					operationType,
					objectType,
					user,
					taskData,
					drillName,
					note,
					attachmentName,
					attachmentType
				})}
			</span>

			<span className="notification-view-item-commands">
				{getNotificationLink({
					operationType,
					objectType,
					user,
					taskData,
					drillName,
					note,
					setVisible
				})}
				<i
					className="material-icons notification-view-item-delete"
					onClick={() => {
						deleteNotification(toastId);
					}}
				>
					{MaterialIconNames.DELETE}
				</i>
			</span>
		</li>
	);
};

export default NotificationViewItem;
