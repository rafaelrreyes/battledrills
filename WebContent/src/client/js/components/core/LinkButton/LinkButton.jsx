import React, { Component } from "react";
import PropTypes from "prop-types";
import { NavLink } from "react-router-dom";
import "./LinkButton.scss";

export const LinkButton = ({ addClass, to, children }) => {
	return (
		<NavLink activeClassName="active-link" className={`link-button ${addClass}`} exact to={to}>
			{children}
		</NavLink>
	);
};

LinkButton.propTypes = {
	children: PropTypes.string.isRequired,
	to: PropTypes.string.isRequired,
	addClass: PropTypes.string
};
