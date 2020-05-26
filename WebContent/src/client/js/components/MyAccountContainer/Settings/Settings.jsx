import React, { useState } from "react";
import { Button, ButtonSizes, ButtonTypes } from "CORE";
import { ToggleSwitch } from "CORE/index";

import { getNotificationPermission, getDisabledNotification } from "./SettingsHelper";
import "./Settings.scss";

export const Settings = () => {
	const [desktopNotificationToggle, setDesktopNotificationToggle] = useState(getNotificationPermission());

	const onDesktopToggle = () => {
		setDesktopNotificationToggle(!desktopNotificationToggle);
	};

	const saveSettings = () => {
		if (desktopNotificationToggle) {
			Notification.requestPermission();
		}
	};

	return (
		<div className="main">
			<div className="title">Manage Your Settings</div>
			<hr className="title-break"></hr>
			<div className="user-info">
				<div className="title">Notifications</div>
				<div className="info">
					<div className="notifications">
						<span>Desktop Notifications</span>
						<ToggleSwitch
							defaultToggle={getNotificationPermission()}
							disabled={getDisabledNotification()}
							onToggleProp={onDesktopToggle}
						></ToggleSwitch>
					</div>
				</div>
				<Button buttonSize={ButtonSizes.SMALL} buttonType={ButtonTypes.REGULAR} onClick={saveSettings}>
					Save
				</Button>
			</div>
		</div>
	);
};
