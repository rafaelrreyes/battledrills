import React, { useState } from "react";
import PropTypes from "prop-types";
import Tooltip from "@material-ui/core/Tooltip";
import { makeStyles } from "@material-ui/core/styles";
import red from "@material-ui/core/colors/red";

export const TooltipTypes = {
	INFO: "info",
	ERROR: "error"
};

export const TooltipPlacement = {
	TOP_START: "top-start",
	TOP: "top",
	TOP_END: "top-end",
	LEFT_START: "left-start",
	LEFT: "left",
	LEFT_END: "left-end",
	RIGHT_START: "right-start",
	RIGHT: "right",
	RIGHT_END: "right-end",
	BOTTOM_START: "bottom-start",
	BOTTOM: "bottom",
	BOTTOM_END: "bottom_end"
};

// from the material-ui tutorial https://material-ui.com/components/tooltips/#customized-tooltips
function arrowGenerator(color) {
	return {
		'&[x-placement*="bottom"] $arrow': {
			top: 0,
			left: 0,
			marginTop: "-0.95em",
			width: "3em",
			height: "1em",
			"&::before": {
				borderWidth: "0 1em 1em 1em",
				borderColor: `transparent transparent ${color} transparent`
			}
		},
		'&[x-placement*="top"] $arrow': {
			bottom: 0,
			left: 0,
			marginBottom: "-0.95em",
			width: "3em",
			height: "1em",
			"&::before": {
				borderWidth: "1em 1em 0 1em",
				borderColor: `${color} transparent transparent transparent`
			}
		},
		'&[x-placement*="right"] $arrow': {
			left: 0,
			marginLeft: "-0.95em",
			height: "3em",
			width: "1em",
			"&::before": {
				borderWidth: "1em 1em 1em 0",
				borderColor: `transparent ${color} transparent transparent`
			}
		},
		'&[x-placement*="left"] $arrow': {
			right: 0,
			marginRight: "-0.95em",
			height: "3em",
			width: "1em",
			"&::before": {
				borderWidth: "1em 0 1em 1em",
				borderColor: `transparent transparent transparent ${color}`
			}
		}
	};
}

const useStylesArrow = makeStyles((theme) => ({
	arrow: {
		position: "absolute",
		fontSize: 6,
		width: "3em",
		height: "3em",
		"&::before": {
			content: '""',
			margin: "auto",
			display: "block",
			width: 0,
			height: 0,
			borderStyle: "solid"
		}
	},
	longWordWrap: {
		wordWrap: "break-word"
	},
	tooltipDefault: {
		backgroundColor: theme.palette.grey[900],
		margin: 0, // this is for keeping the tooltip attached to the arrow
		fontSize: 12
	},
	tooltipError: {
		backgroundColor: red[800],
		margin: 0, // this is for keeping the tooltip attached to the arrow
		fontSize: 12
	},
	popperDefault: arrowGenerator(theme.palette.grey[900]),
	popperError: arrowGenerator(red[800])
}));

const getTooltipClasses = (classes, type) => {
	switch (type) {
		case TooltipTypes.ERROR:
			return {
				tooltip: classes.tooltipError,
				popper: classes.popperError
			};
		case TooltipTypes.INFO:
			return {
				tooltip: classes.tooltipDefault,
				popper: classes.popperDefault
			};
		default:
			return {
				tooltip: classes.tooltipDefault,
				popper: classes.popperDefault
			};
	}
};

export const ArrowTooltip = (props) => {
	// longWordWrap will wrap strings that are extremely long with no spaces
	const { arrow, longWordWrap, ...classes } = useStylesArrow();
	// tooltipClasses is just an object of various classes defined by useStylesArrow()
	const tooltipClasses = getTooltipClasses(classes, props.type);
	const [arrowRef, setArrowRef] = useState(null);
	return (
		<Tooltip
			classes={tooltipClasses}
			PopperProps={{
				popperOptions: {
					modifiers: {
						arrow: {
							enabled: Boolean(arrowRef),
							element: arrowRef
						}
					}
				}
			}}
			{...props}
			title={
				props.title.length !== 0 ? (
					<>
						<span className={longWordWrap}>{props.title}</span>
						<span className={arrow} ref={setArrowRef} />
					</>
				) : (
					""
				)
			}
		/>
	);
};

ArrowTooltip.propTypes = {
	title: PropTypes.node.isRequired,
	type: PropTypes.oneOf([TooltipTypes.INFO, TooltipTypes.ERROR])
};

ArrowTooltip.defaultProps = {
	enterDelay: 500,
	placement: "top",
	type: TooltipTypes.INFO
};
