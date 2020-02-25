import React, { useState, useCallback } from "react";
import PropTypes from "prop-types";
import { makeStyles } from "@material-ui/core/styles";
import blueGrey from "@material-ui/core/colors/blueGrey";
import cyan from "@material-ui/core/colors/cyan";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import { ArrowTooltip } from "CORE/index";
import { isContentOverflowed } from "UTILITIES/index";

const tabStyles = makeStyles({
	wrapper: {
		overflow: "hidden",
		display: "block",
		color: "white",
		fontFamily: "Roboto",
		fontSize: "1.125em",
		textTransform: "none"
	},
	selected: {
		"&:hover": {
			color: cyan[300]
		}
	},
	tabText: {
		overflow: "hidden",
		display: "block",
		textAlign: "center",
		textOverflow: "ellipsis",
		whiteSpace: "nowrap"
	}
});

const tabsStyles = makeStyles({
	root: {
		flexGrow: 1,
		width: "100%",
		backgroundColor: blueGrey[900],
		color: "white"
	},
	indicator: {
		backgroundColor: cyan[300]
	}
});

export const ScrollableTabs = ({ tabValues, tooltipPlacement = "top", onActiveTabSelected, selectedItem }) => {
	const tabClasses = tabStyles();
	const tabsClasses = tabsStyles();
	const [value, setValue] = useState();
	const [tabRef, setTabRef] = useState({});

	// not using useRef here because the object ref doesn't notify about changes to the current ref value
	// in this case, you could use useRef, but I use the callback for an example (:
	const tabRefCallback = useCallback((node) => {
		// accessing element that gets overflowed, complicated when using material-ui's stuff
		if (node !== null && node.firstChild !== null) {
			// state is previous state of the ref
			// https://reactjs.org/docs/hooks-faq.html#should-i-use-one-or-many-state-variables
			setTabRef((state) => ({ ...state, [node.firstChild.textContent]: node.firstChild.firstChild }));
		}
	}, []);

	const handleChange = (event, newValue) => {
		if (value !== newValue) {
			setValue(newValue);
			onActiveTabSelected({ selectedName: event.target.textContent });
		}
	};

	const renderTabs = () => {
		return tabValues.map((tabText, index) => {
			let tooltip = isContentOverflowed(tabRef[tabText]) ? tabText : "";
			return (
				<Tab
					classes={{ wrapper: tabClasses.wrapper, selected: tabClasses.selected }}
					key={tabText}
					value={tabText}
					label={
						<ArrowTooltip title={tooltip} key={tabText} placement={tooltipPlacement}>
							<div className={tabClasses.tabText}>{tabText}</div>
						</ArrowTooltip>
					}
					ref={tabRefCallback}
				/>
			);
		});
	};

	return (
		<Tabs
			classes={{ root: tabsClasses.root, indicator: tabsClasses.indicator }}
			value={selectedItem && tabValues.includes(selectedItem) ? selectedItem : tabValues[0]}
			onChange={handleChange}
			textColor="primary"
			variant="scrollable"
			scrollButtons="auto"
		>
			{renderTabs()}
		</Tabs>
	);
};

ScrollableTabs.propTypes = {
	tabValues: PropTypes.array.isRequired,
	onActiveTabSelected: PropTypes.func.isRequired
};
