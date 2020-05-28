import React from "react";
import { MaterialIconNames } from "UTILITIES";
import { Icon } from "CORE";

import "./AllStatusFooterView.scss";

const AllStatusFooterView = ({
	numDrills,
	maxPerPage,
	drillWindowSize,
	displayIndex,
	activePageIndex,
	onDrillsPage
}) => {
	return (
		<div className="all-status-footer-view">
			{renderPagerButtons(numDrills, maxPerPage, displayIndex, activePageIndex, onDrillsPage)}
			{renderPagerLabels(displayIndex, drillWindowSize, numDrills)}
		</div>
	);
};

const renderPagerLabels = (displayIndex, drillWindowSize, numDrills) => {
	// i.e. 1 - 5 of 6 Drills
	return (
		numDrills !== 0 && (
			<span className="all-status-page-label">{`${displayIndex + 1} - ${
				displayIndex + drillWindowSize
			} of ${numDrills} Drills`}</span>
		)
	);
};

const renderPagerButtons = (numDrills, maxPerPage, displayIndex, activePageIndex, onDrillsPage) => {
	// only need to render pager buttons on footer if there are more drills than max per page
	if (numDrills > maxPerPage) {
		return (
			<div className="all-status-pager-buttons">
				{renderLeftArrowButton(displayIndex, onDrillsPage)}
				{renderPageNumbers(numDrills, maxPerPage, activePageIndex, onDrillsPage)}
				{renderRightArrowButton(displayIndex, maxPerPage, numDrills, onDrillsPage)}
			</div>
		);
	}
};

const renderLeftArrowButton = (displayIndex, onDrillsPage) => {
	return (
		<Icon
			className={`all-status-pager-left ${displayIndex === 0 ? "disabled" : "enabled"}`}
			onClick={() => {
				onDrillsPage("LEFT");
			}}
			disabled
		>
			{MaterialIconNames.ARROW_LEFT}
		</Icon>
	);
};

const renderRightArrowButton = (displayIndex, maxPerPage, numDrills, onDrillsPage) => {
	return (
		<Icon
			className={`all-status-pager-right ${displayIndex + maxPerPage > numDrills ? "disabled" : "enabled"}`}
			onClick={() => {
				onDrillsPage("RIGHT");
			}}
		>
			{MaterialIconNames.ARROW_RIGHT}
		</Icon>
	);
};

const renderPageNumbers = (numDrills, maxPerPage, activePageIndex, onDrillsPage) => {
	const numPages = Math.ceil(numDrills / maxPerPage);

	const pagesJSX = [];

	// must start at page 1
	for (let pageIndex = 1; pageIndex <= numPages; pageIndex++) {
		const cssClasses = ["all-status-pager-number"];

		// add active class to active page index
		if (activePageIndex === pageIndex) {
			cssClasses.push("all-status-pager-number-active");
		}

		// create a number button for each page necessary
		pagesJSX.push(
			<span
				onClick={() => {
					onDrillsPage(pageIndex);
				}}
				key={`pageIndex-${pageIndex}`}
				className={`${cssClasses.join(" ")}`}
			>
				{pageIndex}
			</span>
		);
	}

	return pagesJSX;
};

export default AllStatusFooterView;
