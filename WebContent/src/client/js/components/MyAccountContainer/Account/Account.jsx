import React, { useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { Icon, Input, InputSizes, InputTypes } from "CORE";
import { Button, ButtonTypes, ButtonSizes } from "CORE";
import { MaterialIconNames } from "UTILITIES";
import { getUser } from "REDUX";
import "./Account.scss";

export const Account = () => {
	const user = useSelector(getUser);
	const [username, setUsername] = useState(user.username);
	const onUsernameChange = (name) => {
		// if keeping username in redux, probably dispatch update here
		setUsername(name);
	};

	const updateInfo = () => {
		// do API req with new username
		console.log("update info", username);
	};

	return (
		<div className="main">
			<div className="title">Manage Your Account</div>
			<hr className="title-break"></hr>
			<div className="user-info">
				<div className="TODO">This feature is currently a work in progress.</div>
				<div className="title">User Information</div>
				<div className="info">
					<div className="label">Username:</div>
					<Input
						inputType={InputTypes.REGULAR}
						inputSize={InputSizes.LARGE}
						onChange={onUsernameChange}
						initValue={user.username}
						submit={updateInfo}
					/>
				</div>
				<div className="info">
					<div className="label">Role:</div>
					<Input
						inputType={InputTypes.REGULAR}
						inputSize={InputSizes.LARGE}
						onChange={onUsernameChange}
						initValue={user.role}
						disabled={true}
					/>
				</div>
				<div className="info">
					<Button buttonSize={ButtonSizes.SMALL} buttonType={ButtonTypes.REGULAR} onClick={updateInfo}>
						Save
					</Button>
				</div>
			</div>
		</div>
	);
};
