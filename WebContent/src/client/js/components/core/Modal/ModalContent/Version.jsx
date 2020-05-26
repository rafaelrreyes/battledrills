import React, { Component } from "react";
import { Icon } from "CORE";
import PropTypes from "prop-types";

const Version = ({ icon, title }) => {
	// TODO make this reflect integration build
	const version = 1.2;
	return (
		<>
			{icon && <Icon className="md-36">{icon}</Icon>}
			{title && <div className="modal-title">{title}</div>}
			<div className="version-text">{version}</div>
		</>
	);
};

Version.propTypes = {
	icon: PropTypes.string,
	title: PropTypes.string
};

export default Version;
