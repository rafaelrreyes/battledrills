import React from "react";
import { MenuDropdown } from "CORE";
import { getOwnerMenuActions } from "./OwnerActionsMenuHelper";

// scss
import "./OwnerActionsMenu.scss";

const OwnerActionsMenu = ({ isTemplate = false, owner = "", closeMenu = () => {} }) => {
	return (
		<span className="owner-actions-container">
			<MenuDropdown menuOptions={getOwnerMenuActions(isTemplate, owner)} closeMenu={closeMenu} />
		</span>
	);
};

export default OwnerActionsMenu;
