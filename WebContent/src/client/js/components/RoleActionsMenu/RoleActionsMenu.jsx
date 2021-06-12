import React from "react";
import { MenuDropdown } from "CORE";
import { getRoleMenuOptions } from "./RoleActionsMenuHelper";

// scss
import "./RoleActionsMenu.scss";

const RoleActionsMenu = ({ isTemplate = false, roleId = 0, roleName = "", closeMenu = () => {} }) => {
	return (
		<span className="role-actions-container">
			<MenuDropdown menuOptions={getRoleMenuOptions(isTemplate, roleId, roleName)} closeMenu={closeMenu} />
		</span>
	);
};

export default RoleActionsMenu;
