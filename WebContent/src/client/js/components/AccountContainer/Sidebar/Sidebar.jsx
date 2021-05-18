import React from "react";
import { Icon } from "CORE";
import { MaterialIconNames } from "UTILITIES";
import SideOption from "./SideOption/SideOption";
import { AccountViews } from "../AccountContainer";
import "./Sidebar.scss";

const Sidebar = ({ onOptionClick, activeView }) => {
	return (
		<div className="sidebar">
			<Icon className="md-96">{MaterialIconNames.ACCOUNT_CIRCLE}</Icon>
			<div className="options">
				<SideOption
					icon={MaterialIconNames.ACCOUNT}
					isActive={activeView === AccountViews.ACCOUNT}
					onClick={() => {
						onOptionClick(AccountViews.ACCOUNT);
					}}
				>
					My Account
				</SideOption>
				{/* <SideOption
					icon={MaterialIconNames.SECURITY}
					isActive={activeView === AccountViews.CHANGE_PASSWORD}
					onClick={() => {
						onOptionClick(AccountViews.CHANGE_PASSWORD);
					}}
				>
					Change Password
				</SideOption> */}
				<SideOption
					icon={MaterialIconNames.SETTINGS}
					isActive={activeView === AccountViews.SETTINGS}
					onClick={() => {
						onOptionClick(AccountViews.SETTINGS);
					}}
				>
					Settings
				</SideOption>

				{/* <SideOption
					icon={MaterialIconNames.ACCOUNTS}
					isActive={activeView === AccountViews.ACCOUNT_MANAGEMENT}
					onClick={() => {
						onOptionClick(AccountViews.ACCOUNT_MANAGEMENT);
					}}
				>
					Manage Accounts
				</SideOption> */}
				<SideOption
					icon={MaterialIconNames.ROLES}
					isActive={activeView === AccountViews.ROLES}
					onClick={() => {
						onOptionClick(AccountViews.ROLES);
					}}
				>
					Roles
				</SideOption>
				<SideOption
					icon={MaterialIconNames.ACCOUNTS}
					isActive={activeView === AccountViews.GROUPS}
					onClick={() => {
						onOptionClick(AccountViews.GROUPS);
					}}
				>
					Groups
				</SideOption>
			</div>
		</div>
	);
};

export default Sidebar;
