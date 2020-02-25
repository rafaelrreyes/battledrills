import React, { Component } from "react";
import { MaterialIconNames } from "UTILITIES/index";
import { ArrowTooltip, TooltipTypes } from "CORE/index";
import "./InputErrorIcon.scss";

export const InputErrorIcon = (props) => {
	const { errorMessage, placement, tooltipAttached } = props;
	if (errorMessage !== "") {
		return tooltipAttached ? (
			<ArrowTooltip title={errorMessage} placement={placement} type={TooltipTypes.ERROR} open={true}>
				<i className="material-icons md-20 input-error-icon">{MaterialIconNames.ERROR_OUTLINE}</i>
			</ArrowTooltip>
		) : (
			<i className="material-icons md-20 input-error-icon">{MaterialIconNames.ERROR_OUTLINE}</i>
		);
	}
	return <i className="material-icons md-20 input-error-icon">{MaterialIconNames.ERROR_OUTLINE}</i>;
};
