import React, { useState, useEffect } from "react";
import { useHistory, useLocation } from "react-router";
import { LinkButton } from "CORE/index";
import { Routes } from "UTILITIES/index";
import { default as HeaderMenuContainer } from "./HeaderMenuContainer/HeaderMenuContainer";
import { default as MenuItem } from "./MenuItem/MenuItem";
import "./Header.scss";

const Header = () => {
	const [activeDiagram, setActiveDiagram] = useState(false);
	const [diagramName, setDiagramName] = useState("Diagram");
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
			setDiagramName("Diagram");
		}
	}, [location]);

	return (
		<div className="header">
			<div className="header-flex-container">
				<div className="nav-title">Battle Drills</div>
				<LinkButton addClass="link-1" to={Routes.MAIN}>
					Overview
				</LinkButton>
				<LinkButton addClass="link-2" to={Routes.MY_REPORT}>
					My Drills
				</LinkButton>
				<LinkButton addClass="link-3" to={Routes.STATUS}>
					Status
				</LinkButton>
				<span className="link-4">
					<MenuItem options={diagramOptions} active={activeDiagram}>
						{diagramName}
					</MenuItem>
				</span>
				<HeaderMenuContainer />
			</div>
		</div>
	);
};

export default Header;
