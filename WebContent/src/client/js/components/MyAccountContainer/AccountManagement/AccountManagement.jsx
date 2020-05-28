import React, { useEffect, useState } from "react";
import { Button, ButtonSizes, ButtonTypes, Icon } from "CORE";
import { API, UserConfiguration, MaterialIconNames } from "UTILITIES";

import "./AccountManagement.scss";

const AccountManagement = () => {
	const [roles, setRoles] = useState([]);
	useEffect(() => {
		setRoles(UserConfiguration.DEFINED_ROLES);
	}, []);

	const addAccountHandler = () => {
		console.log("adding account");
	};

	const renderAccountsList = () => {
		return roles.map((role, index) => {
			return (
				<li key={index} className="role-item">
					{role}
				</li>
			);
		});
	};
	return (
		<div className="main">
			<div className="title">Account Management</div>
			<hr className="title-break"></hr>
			<div className="user-info">
				<div className="TODO">This feature is currently a work in progress.</div>
				<div className="title">Accounts</div>
				<div className="info">
					<ul className="roles">{renderAccountsList()}</ul>
					<div className="account-commands">
						<Button
							buttonSize={ButtonSizes.SMALL}
							buttonType={ButtonTypes.REGULAR}
							onClick={addAccountHandler}
						>
							<Icon>{MaterialIconNames.ADD}</Icon>
							<label className="account-command-label">New</label>
						</Button>
					</div>
				</div>
			</div>
		</div>
	);
};

export default AccountManagement;
