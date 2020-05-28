import React, { Component } from "react";
import { MaterialIconNames } from "UTILITIES";
import { ArrowTooltip, TooltipTypes, Icon } from "CORE";
import "./InputErrorIcon.scss";

const ErrorIcon = () => {
	return <Icon className="md-20 input-error-icon">{MaterialIconNames.ERROR_OUTLINE}</Icon>;
};

export const InputErrorIcon = ({ errorMessage = "", placement, tooltipAttached }) => {
	if (errorMessage !== "" && tooltipAttached) {
		return (
			<ArrowTooltip title={errorMessage} placement={placement} type={TooltipTypes.ERROR} open={true}>
				<ErrorIcon />
			</ArrowTooltip>
		);
	}
	return <ErrorIcon />;
};
