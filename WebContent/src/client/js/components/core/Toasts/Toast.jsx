import React, { useState, useEffect } from "react";
import { useHistory } from "react-router";
import PropTypes from "prop-types";
import { CSSTransition } from "react-transition-group";
import { MaterialIconNames, createDesktopNotification } from "UTILITIES/index";
import notification_important from "IMAGES/notification_important.png";
import { getToastMessageHtml, getToastMessageString, getNotificationLink, onNotificationClick } from "./ToastHelper";
import "./Toast.scss";

export const Toast = ({
	toastType,
	enterDelay,
	exitDelay,
	user,
	taskData,
	drillName,
	note,
	operationType,
	objectType,
	attachmentName,
	attachmentType,
	edittedKey
}) => {
	const [visible, setVisible] = useState(true);
	const history = useHistory();
	const notiProps = {
		operationType,
		objectType,
		user,
		taskData,
		drillName,
		note,
		setVisible,
		history,
		attachmentName,
		attachmentType,
		edittedKey
	};

	useEffect(() => {
		setDisappearingTimer(enterDelay, setVisible);
		const options = {
			body: getToastMessageString({ operationType, objectType, user, taskData, drillName, note, edittedKey }),
			icon: notification_important,
			badge: notification_important
		};

		let notification = createDesktopNotification("Battle Drills", options);
		if (notification) {
			notification.addEventListener("click", (event) => {
				onNotificationClick(notiProps);
			});
		}
	}, []);

	return (
		// CSSTransition needs to be used here instead of wrapping <Toast> in Toasts.jsx
		// caused 3 rerenders when used in Toasts.jsx
		<CSSTransition in={visible} unmountOnExit classNames="example" timeout={{ enter: enterDelay, exit: exitDelay }}>
			<div className={`toast ${toastType}`}>
				<span className="toast-message-container">
					<i className="material-icons toast-icon">{MaterialIconNames.ERROR_OUTLINE}</i>
					{getToastMessageHtml(notiProps)}
				</span>
				<span className="toast-actions">
					<div className="toast-link-view">{getNotificationLink(notiProps)}</div>
					<i
						className="material-icons toast-close-button"
						onClick={() => {
							setVisible(false);
						}}
					>
						{MaterialIconNames.CLOSE}
					</i>
				</span>
			</div>
		</CSSTransition>
	);
};

const setDisappearingTimer = (delay, setVisible) => {
	setTimeout(() => {
		setVisible(false);
	}, delay);
};

Toast.propTypes = {
	enterDelay: PropTypes.number,
	exitDelay: PropTypes.number,
	toastType: PropTypes.string,
	user: PropTypes.shape({
		username: PropTypes.string,
		sessionId: PropTypes.string,
		role: PropTypes.string
	}),
	taskData: PropTypes.shape({
		currentStatus: PropTypes.string,
		taskId: PropTypes.string,
		taskDescription: PropTypes.string
	}),
	drillName: PropTypes.string,
	operationType: PropTypes.string,
	objectType: PropTypes.string,
	note: PropTypes.shape({
		noteText: PropTypes.string,
		user: PropTypes.shape({
			username: PropTypes.string,
			sessionId: PropTypes.string,
			role: PropTypes.string
		}),
		id: PropTypes.string,
		type: PropTypes.string,
		timestampMillis: PropTypes.number
	})
};
