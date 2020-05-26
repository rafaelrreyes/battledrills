import React, { useState } from "react";
import { Sidebar } from "./Sidebar/Sidebar";
import { Account } from "./Account/Account";
import { ChangePassword } from "./ChangePassword/ChangePassword";
import { Settings } from "./Settings/Settings";
import "./MyAccountContainer.scss";

export const AccountViews = {
	ACCOUNT: "account",
	CHANGE_PASSWORD: "change_password",
	SETTINGS: "settings"
};

const MyAccountContainer = () => {
	const [view, setView] = useState(AccountViews.ACCOUNT);

	const onOptionClick = (newView) => {
		setView(newView);
	};

	return (
		<div className="my-account">
			<Sidebar onOptionClick={onOptionClick}></Sidebar>
			{view === AccountViews.ACCOUNT && <Account></Account>}
			{view === AccountViews.CHANGE_PASSWORD && <ChangePassword></ChangePassword>}
			{view === AccountViews.SETTINGS && <Settings></Settings>}
		</div>
	);
};

export default MyAccountContainer;
