import React, { useState } from "react";
import { MenuDropdown, Icon } from "CORE";
import { MaterialIconNames } from "UTILITIES";
import "./MenuItem.scss";

const MenuItem = ({ children, options, active }) => {
	const [showOptions, setShowOptions] = useState(false);

	const menuClickHandler = () => {
		setShowOptions(!showOptions);
	};

	return (
		<>
			<span
				className={`header-menu-item ${active ? `active-link` : ``} ${showOptions ? `selected-link` : ``}`}
				onClick={menuClickHandler}
			>
				{children}
				<Icon className={`md-18 ${active ? `active-link-icon` : ``}`}>{MaterialIconNames.EXPAND_MORE}</Icon>
			</span>
			{showOptions && <MenuDropdown menuOptions={options} closeMenu={menuClickHandler}></MenuDropdown>}
		</>
	);
};

export default MenuItem;
