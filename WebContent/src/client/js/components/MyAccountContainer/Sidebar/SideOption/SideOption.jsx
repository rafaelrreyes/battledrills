import React from "react";
import { Icon } from "CORE";
import "./SideOption.scss";

export const SideOption = ({ children, icon, onClick }) => {
	return (
		<div className="side-option" onClick={onClick}>
			<Icon>{icon}</Icon>
			<div className="side-text">{children}</div>
		</div>
	);
};
