import React, { Component } from "react";
import PropTypes from "prop-types";
import { MaterialIconNames, STATUS_TYPES } from "UTILITIES";
import "./StatusIcon.scss";

const DEFAULT_ICON_SIZE = 20;

export const StatusIcon = ({ type, size = DEFAULT_ICON_SIZE }) => {
	return <i className={`material-icons ${type}-icon md-${size}`}>{getIconType(type)}</i>;
};

const getIconType = (status) => {
	switch (status.toLowerCase()) {
		case STATUS_TYPES.PENDING:
			return MaterialIconNames.PANORAMA_FISH_EYE;
		case STATUS_TYPES.IN_PROGRESS:
			return MaterialIconNames.SCHEDULE;
		case STATUS_TYPES.BLOCKED:
			return MaterialIconNames.BLOCK;
		case STATUS_TYPES.COMPLETED:
			return MaterialIconNames.CHECK_CIRCLE;
		default:
			return MaterialIconNames.PANORAMA_FISH_EYE;
	}
};

StatusIcon.propTypes = {
	type: PropTypes.string.isRequired,
	size: PropTypes.number
};
