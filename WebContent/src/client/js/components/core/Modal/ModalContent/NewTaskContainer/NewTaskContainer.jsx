import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { Input, INPUT_SIZES, INPUT_TYPES, Dropdown, DROPDOWN_SIZES, DROPDOWN_TYPES } from "CORE/";
import { getSelectedDrill } from "REDUX/";
import "./NewTaskContainer.scss";

const MAX_TASK_DESCRIPTION_LENGTH = 150;

const NewTaskContainer = ({ fromPalette = false, updateData, updateDisableSubmit, submit }) => {
	const [description, setDescription] = useState("");
	const [error, setError] = useState({ isError: false });
	const [role, setRole] = useState("");

	const { participants } = useSelector(getSelectedDrill);

	useEffect(() => {
		if (fromPalette) {
			if (role === "" || typeof participants === "undefined") {
				updateDisableSubmit(true);
			} else {
				updateDisableSubmit(false);
				updateData({ description, role });
			}
		} else {
			updateData(description);
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
				<label className="new-task-label">Assign to role:</label>
				<Dropdown
					dropdownType={DROPDOWN_TYPES.REGULAR}
					dropdownSize={DROPDOWN_SIZES.FILL}
					options={configureRoleOptions()}
					onChange={onRoleChange}
					defaultOption="Select an existing role*"
					defaultValid={false}
				/>
			</div>
		);
	};

	return (
		<div className="new-task-container">
			<span className="new-task-header">New Task</span>
			<div className="new-task-form">
				{fromPalette && renderRoleDropdown()}
				<Input
					inputType={INPUT_TYPES.REGULAR}
					inputSize={INPUT_SIZES.FILL}
					onChange={onDescriptionChange}
					focus={true}
					placeholder="Description"
					submit={submit}
					showError={error}
					maxlength={MAX_TASK_DESCRIPTION_LENGTH}
				/>
			</div>
		</div>
	);
};

export default NewTaskContainer;
