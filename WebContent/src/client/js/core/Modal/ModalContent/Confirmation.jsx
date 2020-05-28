import React, { Component } from "react";
import { Icon } from "CORE";
import PropTypes from "prop-types";

const Confirmation = ({ icon, title, description }) => {
	return (
		<>
			{icon && <Icon className="md-36">{icon}</Icon>}
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
