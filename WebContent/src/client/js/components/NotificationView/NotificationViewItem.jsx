import React, { useState } from "react";
import { useHistory } from "react-router";
import "./NotificationViewItem.scss";
import { getNotificationLink, getToastMessageHtml } from "CORE";
import { MaterialIconNames, iso8061ToReadable } from "UTILITIES";

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
	attachmentType,
	edittedKey
}) => {
	const [expanded, setExpanded] = useState(false);
	const history = useHistory();
	const onNotificationClick = () => {
		setExpanded(!expanded);
	};

	return (
		<li className="notification-view-item" onClick={onNotificationClick}>
			<span
				className={`${expanded ? "notification-view-item-message-expanded" : "notification-view-item-message"}`}
			>
				<span className="notification-view-item-timestamp">
					{iso8061ToReadable(timestamp, "MM/DD/YY HH:mm")} -{" "}
				</span>
				{getToastMessageHtml({
					operationType,
					objectType,
					user,
					taskData,
					drillName,
					note,
					attachmentName,
					attachmentType,
					edittedKey
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
					setVisible,
					edittedKey,
					history
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
