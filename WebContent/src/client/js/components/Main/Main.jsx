import React, { Component } from "react";
import { Switch, Route } from "react-router-dom";
import {
	DiagramContainer,
	OverviewContainer,
	OwnReportsContainer,
	AllStatusContainer,
	NotificationContainer
} from "../index";
import { Routes } from "UTILITIES/index";

const Main = () => {
	return (
		<>
			<Switch>
				<Route exact path={Routes.MAIN} component={OverviewContainer} />
				<Route path={[Routes.ACTIVE_DIAGRAM, Routes.COMPLETED_DIAGRAM]} component={DiagramContainer} />
				<Route path={Routes.MY_REPORT} component={OwnReportsContainer} />
				<Route path={Routes.STATUS} component={AllStatusContainer} />
			</Switch>
			<NotificationContainer />
		</>
	);
};

export default Main;
