import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { Input, InputSizes, InputTypes, Dropdown, DropdownSizes, DropdownTypes, Icon } from "CORE";
import { getSelectedDrill, getSelectedTemplate } from "REDUX";
import "./NewTaskContainer.scss";

const MAX_TASK_DESCRIPTION_LENGTH = 150;

const NewTaskContainer = ({
	fromTemplate = false,
	fromPalette = false,
	updateData,
	updateDisableSubmit,
	submit,
	parentRole = "",
	title,
	icon
}) => {
	const [description, setDescription] = useState("");
	const [error, setError] = useState({ isError: false });
	const [role, setRole] = useState("");

	const { participants } = fromTemplate ? useSelector(getSelectedTemplate) : useSelector(getSelectedDrill);

	useEffect(() => {
		if (fromPalette) {
			if (role === "" || typeof participants === "undefined") {
				updateDisableSubmit(true);
			} else {
				updateDisableSubmit(false);
				updateData({ description, role });
			}
		} else {
			updateData({ description });
		}
	}, [description, role]);

	const onDescriptionChange = (value) => {
		if (value.length > MAX_TASK_DESCRIPTION_LENGTH) {
			setError({
				isError: true,
				placement: "right",
				tooltipAttached: true,
				message: `Max Character Length Exceeded (${MAX_TASK_DESCRIPTION_LENGTH})`
			});
			updateDisableSubmit(true);
		} else {
			setError({
				isError: false
			});
			updateDisableSubmit(false);
			setDescription(value);
		}
	};

	const onRoleChange = (role) => {
		setRole(role);
	};

	const configureRoleOptions = () => {
		if (typeof participants === "undefined") {
			return [];
		}

		return participants;
	};

	const renderRoleDropdown = () => {
		return (
			<div className="new-task-role">
				<Dropdown
					dropdownType={DropdownTypes.REGULAR}
					dropdownSize={DropdownSizes.FILL}
					options={configureRoleOptions()}
					onChange={onRoleChange}
					firstOption="Add new task to existing role*"
					firstValid={false}
				/>
			</div>
		);
	};

	return (
		<div className="new-task-container">
			{icon && <Icon className="md-36">{icon}</Icon>}
			{title && <div className="modal-title">{title}</div>}
			<div className="new-task-form">
				{fromPalette && renderRoleDropdown()}
				<Input
					inputType={InputTypes.REGULAR}
					inputSize={InputSizes.FILL}
					onChange={onDescriptionChange}
					focus={true}
					placeholder="Description"
					submit={submit}
					showError={error}
					maxlength={MAX_TASK_DESCRIPTION_LENGTH}
				/>
			</div>
			<span className="confirmation-message">
				{(role !== "" || parentRole !== "") &&
					`Are you sure you want to add this task to ${role || parentRole}?`}
			</span>
		</div>
	);
};

export default NewTaskContainer;
