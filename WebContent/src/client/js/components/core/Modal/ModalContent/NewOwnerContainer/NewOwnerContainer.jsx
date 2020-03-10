import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { getSelectedDrill } from "REDUX/";
import { UserConfiguration } from "UTILITIES/";
import { Dropdown, DROPDOWN_SIZES, DROPDOWN_TYPES } from "CORE/";
import "./NewOwnerContainer.scss";

const NewOwnerContainer = ({ fromPalette, updateData, updateDisableSubmit, submit }) => {
	const [role, setRole] = useState("");
	const [parent, setParent] = useState("");

	const { participants } = useSelector(getSelectedDrill);

	useEffect(() => {
		if (fromPalette) {
			if (role === "" || (parent === "" && typeof participants !== "undefined")) {
				updateDisableSubmit(true);
			} else {
				updateDisableSubmit(false);
				updateData({ role, parent });
			}
		} else {
			if (role === "") {
				updateDisableSubmit(true);
			} else {
				updateDisableSubmit(false);
				updateData(role);
			}
		}
	}, [role, parent]);

	const onRoleChange = (role) => {
		setRole(role);
	};

	const onParentChange = (parent) => {
		setParent(parent);
	};

	const configureOptions = () => {
		// all roles are available, eventually we will make defined roles something that admins can add or delete from
		if (typeof participants === "undefined") {
			return UserConfiguration.DEFINED_ROLES;
		}

		// we only want to allow roles that aren't in the drill yet
		return UserConfiguration.DEFINED_ROLES.filter((role) => {
			return !participants.includes(role);
		});
	};

	const configureExistingParticipants = () => {
		if (typeof participants === "undefined") {
			return UserConfiguration.DEFINED_ROLES;
		}

		return participants;
	};

	const renderFromPalette = () => {
		// if there are no participants, render the modal as if user wants to add a new root owner
		if (typeof participants === "undefined" || participants.length === 0) {
			return (
				<>
					<span className="new-owner-header">New Root Role</span>
					{renderDefaultRoleDropdown()}
				</>
			);
		}

		// otherwise, render as if there is already ATLEAST a root owner to add to, and so on
		return (
			<>
				<span className="new-owner-header">New Role</span>
				<div className="new-owner-form">
					<span className="new-owner-form-item">
						<label className="new-owner-label">Add Subordinate:</label>
						{renderDefaultRoleDropdown()}
					</span>
					<span className="new-owner-form-item">
						<label className="new-owner-label">To Role:</label>
						<Dropdown
							dropdownType={DROPDOWN_TYPES.REGULAR}
							dropdownSize={DROPDOWN_SIZES.FILL}
							options={configureExistingParticipants()}
							onChange={onParentChange}
							defaultOption="Select an existing role*"
							defaultValid={false}
						/>
					</span>
				</div>
			</>
		);
	};

	const renderFromDiagram = () => {
		return (
			<>
				<span className="new-owner-header">New Role</span>
				<div className="new-owner-form">{renderDefaultRoleDropdown()}</div>
			</>
		);
	};

	const renderDefaultRoleDropdown = () => {
		return (
			<Dropdown
				dropdownType={DROPDOWN_TYPES.REGULAR}
				dropdownSize={DROPDOWN_SIZES.FILL}
				options={configureOptions()}
				onChange={onRoleChange}
				defaultOption="Select a new role to add*"
				defaultValid={false}
			/>
		);
	};

	return <div className="new-owner-container">{fromPalette ? renderFromPalette() : renderFromDiagram()}</div>;
};

export default NewOwnerContainer;
