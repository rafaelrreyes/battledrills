import React, { useState, useEffect } from "react";
import { getAvailableActions } from "./TaskActionsMenuHelper";
import { MenuDropdown } from "CORE/index";
import { API } from "UTILITIES/index";
import "./TaskActionsMenu.scss";

const TaskActionsMenu = ({ closeMenu, taskId }) => {
	const [menuOptions, setMenuOptions] = useState([]);

	// this is run when the component mounts
	useEffect(() => {
		API.getTaskById(taskId, {}, (res) => {
			// get the available actions for each task based on their status
			setMenuOptions(getAvailableActions(res.currentStatus.status, res));
		});
	}, []);

	return (
		<span className="task-actions-container">
			<MenuDropdown menuOptions={menuOptions} closeMenu={closeMenu} />
		</span>
	);
};

export default TaskActionsMenu;
