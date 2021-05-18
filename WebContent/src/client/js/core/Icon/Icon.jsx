import React from "react";
import { ArrowTooltip, TooltipPlacement } from "CORE";

import "./Icon.scss";

export const Icon = ({
	tooltip = "",
	tooltipPlacement = TooltipPlacement.TOP,
	children,
	className = "",
	onClick,
	hasCircledBackground = false,
	isDisabled = false
}) => {
	return (
		<ArrowTooltip title={tooltip} placement={tooltipPlacement}>
			<i
				className={`material-icons icon ${className} ${hasCircledBackground ? "circled-background" : ""} ${
					isDisabled ? "disabled" : ""
				}`}
				onClick={(e) => {
					if (typeof onClick === "undefined") {
						return;
					}

					e.stopPropagation();
					onClick();
				}}
			>
				{children}
			</i>
		</ArrowTooltip>
	);
};
