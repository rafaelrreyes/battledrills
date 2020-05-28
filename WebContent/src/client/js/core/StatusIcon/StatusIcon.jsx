import React, { Component } from "react";
import PropTypes from "prop-types";
import { MaterialIconNames, StatusTypes } from "UTILITIES";
import { Icon } from "CORE";
import "./StatusIcon.scss";

const DEFAULT_ICON_SIZE = 20;

export const StatusIcon = ({ type, size = DEFAULT_ICON_SIZE }) => {
	return <Icon className={`material-icons ${type}-icon md-${size}`}>{getIconType(type)}</Icon>;
};

const getIconType = (status) => {
	switch (status.toLowerCase()) {
		case StatusTypes.PENDING:
			return MaterialIconNames.PANORAMA_FISH_EYE;
		case StatusTypes.IN_PROGRESS:
			return MaterialIconNames.SCHEDULE;
		case StatusTypes.BLOCKED:
			return MaterialIconNames.BLOCK;
		case StatusTypes.COMPLETED:
			return MaterialIconNames.CHECK_CIRCLE;
		default:
			return MaterialIconNames.PANORAMA_FISH_EYE;
	}
};

StatusIcon.propTypes = {
	type: PropTypes.string.isRequired,
	size: PropTypes.number
};
