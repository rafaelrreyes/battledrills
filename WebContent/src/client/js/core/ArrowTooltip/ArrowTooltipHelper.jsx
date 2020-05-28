import React from "react";
import { isContentOverflowed } from "UTILITIES/index";
import { ArrowTooltip } from "./ArrowTooltip";

/**
 * Helper method to save space and reusable across any elements.
 * Used to determine if the element's content is overflowing and if a tooltip is needed.
 *
 * @param {ReactElement} elementToRender The core element to render with or without a tooltip.
 * @param {HTMLElementReference} ref The reference to the element itself to check if its content overflows.
 * @param {String} tooltip The text to display in the Tooltip
 * @param {String} key If used in a loop, React requires each instance to have a unique key (can use toolTip)
 */
export const conditionalTooltipRender = (elementToRender, ref, tooltip, key = null) => {
	let element = elementToRender;
	if (isContentOverflowed(ref)) {
		element = (
			<ArrowTooltip title={tooltip} key={key}>
				{elementToRender}
			</ArrowTooltip>
		);
	}
	return element;
};
