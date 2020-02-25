import React from "react";
import { MaterialIconNames } from "UTILITIES/index";

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
	if (numDrills === 0) {
		return null;
	}

	return (
		<span className="all-status-page-label">
			{`${displayIndex + 1} - ${displayIndex + drillWindowSize} of ${numDrills} Drills`}
		</span>
	);
};

const renderPagerButtons = (numDrills, maxPerPage, displayIndex, activePageIndex, onDrillsPage) => {
	if (numDrills > maxPerPage) {
		return (
			<div className="all-status-pager-buttons">
				<i
					className={`material-icons all-status-pager-left ${displayIndex === 0 ? "disabled" : "enabled"}`}
					onClick={() => {
						onDrillsPage("LEFT");
					}}
					disabled
				>
					{MaterialIconNames.ARROW_LEFT}
				</i>
				{renderPageNumbers(numDrills, maxPerPage, displayIndex, activePageIndex, onDrillsPage)}
				<i
					className={`material-icons all-status-pager-right ${
						displayIndex + maxPerPage > numDrills ? "disabled" : "enabled"
					}`}
					onClick={() => {
						onDrillsPage("RIGHT");
					}}
				>
					{MaterialIconNames.ARROW_RIGHT}
				</i>
			</div>
		);
	}
};

const renderPageNumbers = (numDrills, maxPerPage, displayIndex, activePageIndex, onDrillsPage) => {
	const numPages = Math.ceil(numDrills / maxPerPage);

	const pagesJSX = [];
	for (let pageIndex = 1; pageIndex <= numPages; pageIndex++) {
		let cssClasses = ["all-status-pager-number"];
		if (activePageIndex === pageIndex) {
			cssClasses.push("all-status-pager-number-active");
		}
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
