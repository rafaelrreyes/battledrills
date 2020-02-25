import React from "react";
import PropTypes from "prop-types";
import { NavLink } from "react-router-dom";
import { MaterialIconNames } from "UTILITIES/index";
import "./Hyperlink.scss";

export const HyperlinkTypes = {
	ICON: "ICON",
	TEXT: "TEXT"
};

export const Hyperlink = ({ to, addClass, children, type = HyperlinkTypes.ICON, hyperlinkRef }) => {
	return (
		<NavLink activeClassName="active-hyperlink" className={`${addClass}`} exact to={to} ref={hyperlinkRef}>
			{type === HyperlinkTypes.ICON ? (
				<i className="material-icons">{MaterialIconNames.LINK}</i>
			) : (
				<>{children}</>
			)}
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
