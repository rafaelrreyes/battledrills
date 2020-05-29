import React, { useState } from "react";
import { useSelector } from "react-redux";
import { Input, InputSizes, InputTypes } from "CORE";
import { Button, ButtonTypes, ButtonSizes } from "CORE";
import { getUser } from "REDUX";

const ChangePassword = () => {
	const user = useSelector(getUser);
	// add a password tag to inputs to hide characters typed
	const [oldPass, setOldPass] = useState("");
	const [newPass, setNewPass] = useState("");
	const [confirmPass, setConfirmPass] = useState("");

	const oldPassChangeHandler = (pass) => {
		setOldPass(pass);
	};

	const newPassChangeHandler = (pass) => {
		setNewPass(pass);
	};

	const confirmPassHandler = (pass) => {
		setConfirmPass(pass);
	};

	const updatePassHandler = () => {
		// do API req with new password
		console.log("pass info", oldPass, newPass, confirmPass);
	};

	return (
		<div className="main">
			<div className="title">Change Your Password</div>
			<hr className="title-break"></hr>
			<div className="user-info">
				<div className="TODO">This feature is currently a work in progress.</div>
				<div className="info">
					<div className="label">Current Password</div>
					<Input
						inputType={InputTypes.REGULAR}
						inputSize={InputSizes.LARGE}
						onChange={oldPassChangeHandler}
					/>
				</div>
				<div className="info">
					<div className="label">New Password</div>
					<Input
						inputType={InputTypes.REGULAR}
						inputSize={InputSizes.LARGE}
						onChange={newPassChangeHandler}
					/>
				</div>
				<div className="info">
					<div className="label">Confirm Password</div>
					<Input inputType={InputTypes.REGULAR} inputSize={InputSizes.LARGE} onChange={confirmPassHandler} />
				</div>
				<div className="info">
					<Button buttonSize={ButtonSizes.SMALL} buttonType={ButtonTypes.REGULAR} onClick={updatePassHandler}>
						Save
					</Button>
				</div>
			</div>
		</div>
	);
};

export default ChangePassword;
