import React from "react";
import PropTypes from "prop-types";
import { NavLink } from "react-router-dom";
import { MaterialIconNames } from "UTILITIES";
import { Icon } from "CORE";
import "./Hyperlink.scss";

export const HyperlinkTypes = {
	ICON: "ICON",
	TEXT: "TEXT"
};

export const Hyperlink = ({ to, addClass, children, type = HyperlinkTypes.ICON, hyperlinkRef }) => {
	return (
		<NavLink activeClassName="active-hyperlink" className={`${addClass}`} exact to={to} ref={hyperlinkRef}>
			{type === HyperlinkTypes.ICON ? <Icon>{MaterialIconNames.LINK}</Icon> : <>{children}</>}
		</NavLink>
	);
};

Hyperlink.propTypes = {
	to: PropTypes.string.isRequired,
	hyperlinkRef: PropTypes.func.isRequired,
	type: PropTypes.string,
	children: PropTypes.oneOfType([PropTypes.string, PropTypes.node]),
	addClass: PropTypes.string
};
