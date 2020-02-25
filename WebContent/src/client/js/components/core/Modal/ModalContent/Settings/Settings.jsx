import React, { useState, useEffect } from "react";
import PropTypes from "prop-types";
import { Checkbox, ToggleSwitch } from "CORE/index";
import { MaterialIconNames } from "UTILITIES/index";
import { getNotificationPermission, getDisabledNotification } from "./SettingsHelper";
import "./Settings.scss";

export const Settings = ({ icon, title, description, updateData }) => {
	const [desktopNotificationToggle, setDesktopNotificationToggle] = useState(getNotificationPermission());

	const onDesktopToggle = () => {
		updateData({ desktopNotification: !desktopNotificationToggle });
		setDesktopNotificationToggle(!desktopNotificationToggle);
	};

	return (
		<>
			{icon && <i className="material-icons md-36">{icon}</i>}
			{title && <div className="modal-title">{title}</div>}
			<div className="settings-options-container">
				<div className="settings-options-row">
					<span>Desktop Notifications</span>
					<ToggleSwitch
						defaultToggle={getNotificationPermission()}
						disabled={getDisabledNotification()}
						onToggleProp={onDesktopToggle}
					></ToggleSwitch>
				</div>
			</div>
			{description && <div className="modal-description">{description}</div>}
		</>
	);
};

Settings.propTypes = {
	icon: PropTypes.string,
	title: PropTypes.string,
	description: PropTypes.string
};
