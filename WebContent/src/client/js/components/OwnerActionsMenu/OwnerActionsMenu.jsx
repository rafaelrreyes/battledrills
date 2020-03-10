import React from "react";

import { MenuDropdown } from "CORE/";
import { getOwnerMenuActions } from "./OwnerActionsMenuHelper";

// scss
import "./OwnerActionsMenu.scss";

const OwnerActionsMenu = ({ owner = "", closeMenu = () => {} }) => {
	return (
		<span className="owner-actions-container">
			<MenuDropdown menuOptions={getOwnerMenuActions(owner)} closeMenu={closeMenu} />
		</span>
	);
};

export default OwnerActionsMenu;
