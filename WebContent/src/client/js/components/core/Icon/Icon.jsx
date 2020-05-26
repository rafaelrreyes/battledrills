import React from "react";
import { ArrowTooltip, TooltipPlacement } from "CORE";

export const Icon = ({ tooltip = "", tooltipPlacement = TooltipPlacement.TOP, children, className = "", onClick }) => {
	return (
		<ArrowTooltip title={tooltip} placement={tooltipPlacement}>
			<i className={`material-icons ${className}`} onClick={onClick}>
				{children}
			</i>
		</ArrowTooltip>
	);
};
