import React from "react";
import PropTypes from "prop-types";
import { NavLink } from "react-router-dom";
import "./LinkButton.scss";

export const LinkButton = ({ className = "", to, children }) => {
	return (
		<NavLink activeClassName="active-link" className={`link-button ${className}`} exact to={to}>
			{children}
		</NavLink>
	);
};

LinkButton.propTypes = {
	children: PropTypes.oneOfType([PropTypes.string, PropTypes.element]).isRequired,
	to: PropTypes.string.isRequired,
	className: PropTypes.string
};
