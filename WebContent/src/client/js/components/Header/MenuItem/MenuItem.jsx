import React, { useState } from "react";
import { MenuDropdown } from "CORE/index";
import { MaterialIconNames } from "UTILITIES/index";
import "./MenuItem.scss";

const MenuItem = ({ children, options, active }) => {
	const [showOptions, setShowOptions] = useState(false);

	const onMenuClick = () => {
		setShowOptions(!showOptions);
	};

	return (
		<>
			<span
				className={`header-menu-item ${active ? `active-link` : ``} ${showOptions ? `selected-link` : ``}`}
				onClick={onMenuClick}
			>
				{children}
				<i className={`material-icons md-18 ${active ? `active-link-icon` : ``}`}>
					{MaterialIconNames.EXPAND_MORE}
				</i>
			</span>
			{showOptions && <MenuDropdown menuOptions={options} closeMenu={onMenuClick}></MenuDropdown>}
		</>
	);
};

export default MenuItem;
