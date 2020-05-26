import React, { useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { Icon, Input, InputSizes, InputTypes } from "CORE";
import { Button, ButtonTypes, ButtonSizes } from "CORE";
import { MaterialIconNames } from "UTILITIES";
import { getUser } from "REDUX";

export const ChangePassword = () => {
	const user = useSelector(getUser);
	// add a password tag to inputs to hide characters typed
	const [oldPass, setOldPass] = useState("");
	const [newPass, setNewPass] = useState("");
	const [confirmPass, setConfirmPass] = useState("");

	const onOldPassChange = (pass) => {
		setOldPass(pass);
	};

	const onNewPassChange = (pass) => {
		setNewPass(pass);
	};

	const onConfirmPassChange = (pass) => {
		setConfirmPass(pass);
	};

	const updatePassword = () => {
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
					<div className="label">Current Password:</div>
					<Input inputType={InputTypes.REGULAR} inputSize={InputSizes.LARGE} onChange={onOldPassChange} />
				</div>
				<div className="info">
					<div className="label">New Password:</div>
					<Input inputType={InputTypes.REGULAR} inputSize={InputSizes.LARGE} onChange={onNewPassChange} />
				</div>
				<div className="info">
					<div className="label">Confirm Password:</div>
					<Input inputType={InputTypes.REGULAR} inputSize={InputSizes.LARGE} onChange={onConfirmPassChange} />
				</div>
				<div className="info">
					<Button buttonSize={ButtonSizes.SMALL} buttonType={ButtonTypes.REGULAR} onClick={updatePassword}>
						Save
					</Button>
				</div>
			</div>
		</div>
	);
};
