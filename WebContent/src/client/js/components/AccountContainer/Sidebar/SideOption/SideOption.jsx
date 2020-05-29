import React from "react";
import { Icon } from "CORE";
import "./SideOption.scss";

const SideOption = ({ children, icon, onClick, isActive }) => {
	return (
		<div className={`side-option ${isActive ? "active" : ""}`} onClick={onClick}>
			<Icon>{icon}</Icon>
			<div className="side-text">{children}</div>
		</div>
	);
};

export default SideOption;
