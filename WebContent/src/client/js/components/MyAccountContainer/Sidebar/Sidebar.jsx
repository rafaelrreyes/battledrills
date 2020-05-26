import React from "react";
import { Icon } from "CORE";
import { MaterialIconNames } from "UTILITIES";
import { SideOption } from "./SideOption/SideOption";
import { AccountViews } from "../MyAccountContainer";
import "./Sidebar.scss";

export const Sidebar = ({ onOptionClick }) => {
	return (
		<div className="sidebar">
			<Icon className="md-96">{MaterialIconNames.ACCOUNT_CIRCLE}</Icon>
			<div className="options">
				<SideOption
					icon={MaterialIconNames.PERSON}
					onClick={() => {
						onOptionClick(AccountViews.ACCOUNT);
					}}
				>
					Account
				</SideOption>
				<SideOption
					icon={MaterialIconNames.SECURITY}
					onClick={() => {
						onOptionClick(AccountViews.CHANGE_PASSWORD);
					}}
				>
					Change Password
				</SideOption>
				<SideOption
					icon={MaterialIconNames.SETTINGS}
					onClick={() => {
						onOptionClick(AccountViews.SETTINGS);
					}}
				>
					Settings
				</SideOption>
			</div>
		</div>
	);
};
