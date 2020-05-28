import React, { useState, useEffect } from "react";
import { useHistory, useLocation } from "react-router";

import { LinkButton, Icon, TooltipPlacement } from "CORE";
import { Routes, MaterialIconNames, MobileViewMaxWidth } from "UTILITIES";
import { useWindowDimensions } from "HOOKS";
import { default as HeaderMenuContainer } from "./HeaderMenuContainer/HeaderMenuContainer";
import { default as HeaderDropdown } from "./HeaderDropdown/HeaderDropdown";
import HeaderOptions from "./HeaderOptions/HeaderOptions";

import "./Header.scss";

const getHeaderTab = (name, icon, isMobile) => {
	return (
		<>
			{isMobile ? (
				<Icon tooltip={name} tooltipPlacement={TooltipPlacement.BOTTOM}>
					{icon}
				</Icon>
			) : (
				name
			)}
		</>
	);
};

const Header = () => {
	const [isMobile, setIsMobile] = useState(false);
	const [activeDiagram, setActiveDiagram] = useState(false);
	const [diagramName, setDiagramName] = useState("Drills");
	const { width } = useWindowDimensions();
	const history = useHistory();
	const location = useLocation();

	const diagramOptions = [
		{
			name: "Active",
			menuAction: () => {
				history.push(Routes.ACTIVE_DIAGRAM);
				setDiagramName("Active");
			}
		},
		{
			name: "Completed",
			menuAction: () => {
				history.push(Routes.COMPLETED_DIAGRAM);
				setDiagramName("Completed");
			}
		}
	];

	useEffect(() => {
		if (location.pathname === Routes.ACTIVE_DIAGRAM || location.pathname === Routes.COMPLETED_DIAGRAM) {
			setActiveDiagram(true);
			setDiagramName(location.pathname === Routes.ACTIVE_DIAGRAM ? "Active" : "Completed");
		} else {
			setActiveDiagram(false);
			setDiagramName("Drills");
		}
	}, [location]);

	useEffect(() => {
		if (width <= MobileViewMaxWidth) {
			setIsMobile(true);
		} else {
			setIsMobile(false);
		}
	}, [width]);

	return (
		<div className="header">
			<div className="header-flex-container">
				<div className="nav-title">Battle Drills</div>
				<LinkButton to={Routes.OVERVIEW}>
					{getHeaderTab("Overview", MaterialIconNames.DASHBOARD, isMobile)}
				</LinkButton>
				<LinkButton to={Routes.MY_DRILLS}>
					{getHeaderTab("My Drills", MaterialIconNames.DESCRIPTION, isMobile)}
				</LinkButton>
				<LinkButton to={Routes.STATUS}>
					{getHeaderTab("Status", MaterialIconNames.LINE_STYLE, isMobile)}
				</LinkButton>
				<LinkButton to={Routes.REPORTS}>
					{getHeaderTab("Reports", MaterialIconNames.INSERT_CHART_OUTLINED, isMobile)}
				</LinkButton>
				{/* TODO should only be available to admin roles */}
				<LinkButton to={Routes.TEMPLATE_EDITOR}>
					{getHeaderTab("Templates", MaterialIconNames.EDIT, isMobile)}
				</LinkButton>
				<LinkButton to={Routes.MY_ACCOUNT}>
					{getHeaderTab("Account", MaterialIconNames.PERSON, isMobile)}
				</LinkButton>
				<HeaderDropdown options={diagramOptions} active={activeDiagram}>
					{getHeaderTab(diagramName, MaterialIconNames.ACCOUNT_TREE, isMobile)}
				</HeaderDropdown>
				<HeaderOptions />
				<HeaderMenuContainer />
			</div>
		</div>
	);
};

export default Header;
