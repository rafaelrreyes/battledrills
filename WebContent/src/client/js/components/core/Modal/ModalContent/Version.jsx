import React, { Component } from "react";
import PropTypes from "prop-types";

const Version = (props) => {
	const { icon, title } = props;
	const version = 1.1;
	return (
		<>
			{icon && <i className="material-icons md-36">{icon}</i>}
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
