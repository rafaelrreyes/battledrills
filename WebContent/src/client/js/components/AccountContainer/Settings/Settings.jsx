import React, { useState } from "react";
import { Button, ButtonSizes, ButtonTypes } from "CORE";
import { ToggleSwitch } from "CORE";

import { getNotificationPermission, getDisabledNotification } from "./SettingsHelper";
import "./Settings.scss";

const Settings = () => {
	const [desktopNotificationToggle, setDesktopNotificationToggle] = useState(getNotificationPermission());

	const desktopToggleHandler = () => {
		setDesktopNotificationToggle(!desktopNotificationToggle);
	};

	const saveHandler = () => {
		if (desktopNotificationToggle) {
			Notification.requestPermission();
		}
	};

	return (
		<div className="main">
			<div className="title">Manage Your Settings</div>
			<div className="title-break"></div>
			<div className="user-info">
				<div className="title">Notifications</div>
				<div className="info">
					<div className="notifications">
						<span>Desktop Notifications</span>
						<ToggleSwitch
							defaultToggle={getNotificationPermission()}
							disabled={getDisabledNotification()}
							onToggleProp={desktopToggleHandler}
						></ToggleSwitch>
					</div>
				</div>
				<Button buttonSize={ButtonSizes.SMALL} buttonType={ButtonTypes.REGULAR} onClick={saveHandler}>
					Save
				</Button>
			</div>
		</div>
	);
};

export default Settings;
