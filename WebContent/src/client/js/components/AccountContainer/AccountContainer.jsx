import React, { useState } from "react";
import Sidebar from "./Sidebar/Sidebar";
import Account from "./Account/Account";
import ChangePassword from "./ChangePassword/ChangePassword";
import Settings from "./Settings/Settings";
import AccountManagement from "./AccountManagement/AccountManagement";
import RolesManagement from "./RolesManagement/RolesManagement";
import GroupManagement from "./GroupManagement/GroupManagement";
import { useLocalStorage } from "HOOKS";
import "./AccountContainer.scss";

export const AccountViews = {
	ACCOUNT: "account",
	CHANGE_PASSWORD: "change_password",
	SETTINGS: "settings",
	ACCOUNT_MANAGEMENT: "account_management",
	ROLES: "roles",
	GROUPS: "groups"
};

const AccountContainer = () => {
	const [view, setView] = useLocalStorage("account_management_view", AccountViews.ACCOUNT);

	const optionClickHandler = (newView) => {
		setView(newView);
	};

	return (
		<div className="account-view">
			<Sidebar activeView={view} onOptionClick={optionClickHandler}></Sidebar>
			{view === AccountViews.ACCOUNT && <Account></Account>}
			{view === AccountViews.CHANGE_PASSWORD && <ChangePassword></ChangePassword>}
			{view === AccountViews.SETTINGS && <Settings></Settings>}
			{view === AccountViews.ACCOUNT_MANAGEMENT && <AccountManagement></AccountManagement>}
			{view === AccountViews.ROLES && <RolesManagement />}
			{view === AccountViews.GROUPS && <GroupManagement />}
		</div>
	);
};

export default AccountContainer;
