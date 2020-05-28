import React, { useState } from "react";
import { MenuDropdown } from "CORE";
import "./HeaderDropdown.scss";

const HeaderDropdown = ({ children, options, active }) => {
	const [showOptions, setShowOptions] = useState(false);

	const menuClickHandler = () => {
		setShowOptions(!showOptions);
	};

	return (
		<div className={`link-container`} onClick={menuClickHandler}>
			<div className={`link-button ${showOptions ? `selected-link` : ``} ${active ? `active-link` : ``}`}>
				{children}
			</div>
			{showOptions && <MenuDropdown menuOptions={options} closeMenu={menuClickHandler}></MenuDropdown>}
		</div>
	);
};

export default HeaderDropdown;
