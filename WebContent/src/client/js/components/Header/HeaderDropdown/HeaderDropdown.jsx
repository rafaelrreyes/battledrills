import React, { useState } from "react";
import { MenuDropdown } from "COMPONENTS";
import "./HeaderDropdown.scss";

const HeaderDropdown = ({ children, options, active }) => {
	const [showOptions, setShowOptions] = useState(false);

	const onMenuClick = () => {
		setShowOptions(!showOptions);
	};

	return (
		<div className={`link-container`} onClick={onMenuClick}>
			<div className={`link-button ${showOptions ? `selected-link` : ``} ${active ? `active-link` : ``}`}>
				{children}
			</div>
			{showOptions && <MenuDropdown menuOptions={options} closeMenu={onMenuClick}></MenuDropdown>}
		</div>
	);
};

export default HeaderDropdown;
