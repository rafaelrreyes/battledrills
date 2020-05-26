import React, { Component } from "react";
import { Switch, Route } from "react-router-dom";
import {
	DiagramContainer,
	OverviewContainer,
	OwnReportsContainer,
	AllStatusContainer,
	TemplateEditorContainer,
	ReportsContainer,
	MyAccountContainer,
	NotificationContainer
} from "../index";
import { Routes } from "UTILITIES/index";

const Main = () => {
	return (
		<>
			<Switch>
				<Route exact path={Routes.OVERVIEW} component={OverviewContainer} />
				<Route path={[Routes.ACTIVE_DIAGRAM, Routes.COMPLETED_DIAGRAM]} component={DiagramContainer} />
				<Route path={Routes.MY_DRILLS} component={OwnReportsContainer} />
				<Route path={Routes.STATUS} component={AllStatusContainer} />
				<Route path={Routes.TEMPLATE_EDITOR} component={TemplateEditorContainer} />
				<Route path={Routes.REPORTS} component={ReportsContainer} />
				<Route path={Routes.MY_ACCOUNT} component={MyAccountContainer} />
			</Switch>
			<NotificationContainer />
		</>
	);
};

export default Main;
