import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { Input, InputSizes, InputTypes, Dropdown, DropdownSizes, DropdownTypes, Icon } from "CORE";
import { API } from "UTILITIES";
import { getSelectedDrill, getSelectedTemplate } from "REDUX";
import "./NewTaskContainer.scss";

const MAX_TASK_DESCRIPTION_LENGTH = 150;

const NewTaskContainer = ({
	fromTemplate = false,
	fromPalette = false,
	updateData,
	updateDisableSubmit,
	submit,
	parentId = 0,
	title,
	icon
}) => {
	const [description, setDescription] = useState("");
	const [error, setError] = useState({ isError: false });
	const [roleId, setRoleId] = useState(0);
	const [dropdownRoles, setDropdownRoles] = useState([]);

	const { participants } = fromTemplate ? useSelector(getSelectedTemplate) : useSelector(getSelectedDrill);

	useEffect(() => {
		if (fromPalette) {
			if (roleId === 0 || typeof participants === "undefined") {
				updateDisableSubmit(true);
			} else {
				updateDisableSubmit(false);
				updateData({ description, roleId });
			}
		} else {
			updateData({ description, roleId: parentId });
		}
	}, [description, roleId]);

	useEffect(() => {
		if (typeof participants !== "undefined" && fromPalette) {
			API.getRoles((roles) => {
				const dropdownOptions = [];
				roles.forEach((role) => {
					if (participants.includes(role.id)) {
						dropdownOptions.push({ id: role.id, name: role.name });
					}
				});
				setDropdownRoles(dropdownOptions);
			});
		}
	}, []);

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

	const onRoleChange = (roleId) => {
		setRoleId(parseInt(roleId));
	};

	const renderRoleDropdown = () => {
		return (
			<div className="new-task-role">
				<Dropdown
					dropdownType={DropdownTypes.REGULAR}
					dropdownSize={DropdownSizes.FILL}
					options={dropdownRoles}
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
				{(roleId !== 0 || parentId !== 0) && `Are you sure you want to add this task?`}
			</span>
		</div>
	);
};

export default NewTaskContainer;
