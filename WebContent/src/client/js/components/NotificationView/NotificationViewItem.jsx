import React, { useState } from "react";
import { useHistory } from "react-router";
import { getNotificationLink, getToastMessageHtml, Icon } from "CORE";
import { MaterialIconNames, iso8061ToReadable } from "UTILITIES";

import "./NotificationViewItem.scss";

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
				{/* {getNotificationLink({
					operationType,
					objectType,
					user,
					taskData,
					drillName,
					note,
					setVisible,
					edittedKey,
					history
				})} */}
				<Icon
					className="notification-view-item-delete"
					onClick={() => {
						deleteNotification(toastId);
					}}
				>
					{MaterialIconNames.DELETE}
				</Icon>
			</span>
		</li>
	);
};

export default NotificationViewItem;
