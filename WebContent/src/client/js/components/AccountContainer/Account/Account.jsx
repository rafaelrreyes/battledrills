import React, { useState } from "react";
import { useSelector } from "react-redux";
import { Input, InputSizes, InputTypes } from "CORE";
import { Button, ButtonTypes, ButtonSizes } from "CORE";
import { getUser } from "REDUX";
import "./Account.scss";

const Account = () => {
	const user = useSelector(getUser);
	const [username, setUsername] = useState(user.username);

	const usernameChangeHandler = (name) => {
		// if keeping username in redux, probably dispatch update here
		setUsername(name);
	};

	const updateInfoHandler = () => {
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
					<div className="label">Username</div>
					<Input
						inputType={InputTypes.REGULAR}
						inputSize={InputSizes.LARGE}
						onChange={usernameChangeHandler}
						initValue={user.username}
						submit={updateInfoHandler}
					/>
				</div>
				<div className="info">
					<div className="label">Role</div>
					<Input
						inputType={InputTypes.REGULAR}
						inputSize={InputSizes.LARGE}
						onChange={usernameChangeHandler}
						initValue={user.role}
						disabled={true}
					/>
				</div>
				<div className="info">
					<Button buttonSize={ButtonSizes.SMALL} buttonType={ButtonTypes.REGULAR} onClick={updateInfoHandler}>
						Save
					</Button>
				</div>
			</div>
		</div>
	);
};

export default Account;
