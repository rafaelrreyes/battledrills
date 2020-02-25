import React, { Component } from "react";
import PropTypes from "prop-types";

const Confirmation = (props) => {
	const { icon, title, description } = props;
	return (
		<>
			{icon && <i className="material-icons md-36">{icon}</i>}
			{title && <div className="modal-title">{title}</div>}
			{description && <div className="modal-description">{description}</div>}
		</>
	);
};

Confirmation.propTypes = {
	icon: PropTypes.string,
	title: PropTypes.string,
	description: PropTypes.string
};

export default Confirmation;
