import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { getSelectedDrill, getSelectedTemplate } from "REDUX";
import { UserConfiguration } from "UTILITIES";
import { Dropdown, DropdownSizes, DropdownTypes, DROPDOWN_DEFAULT, Icon } from "CORE";
import "./NewOwnerContainer.scss";

const NewOwnerContainer = ({
	fromTemplate = false,
	fromPalette = false,
	updateData,
	updateDisableSubmit,
	parentRole = "",
	icon,
	title
}) => {
	const [role, setRole] = useState(DROPDOWN_DEFAULT);
	const [parent, setParent] = useState(DROPDOWN_DEFAULT);

	const { participants } = fromTemplate ? useSelector(getSelectedTemplate) : useSelector(getSelectedDrill);

	useEffect(() => {
		if (fromPalette) {
			if (role === DROPDOWN_DEFAULT) {
				updateDisableSubmit(true);
			} else if (
				role !== DROPDOWN_DEFAULT &&
				typeof participants !== "undefined" &&
				participants.length !== 0 &&
				parent === DROPDOWN_DEFAULT
			) {
				updateDisableSubmit(true);
			} else {
				updateDisableSubmit(false);
				if (parent === DROPDOWN_DEFAULT) {
					updateData({ role, parent: null });
					return;
				}
				updateData({ role, parent });
			}
		} else {
			if (role === DROPDOWN_DEFAULT) {
				updateDisableSubmit(true);
			} else {
				updateDisableSubmit(false);
				updateData({ role, parent: parentRole });
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
			return renderDefaultRoleDropdown();
		}

		// otherwise, render as if there is already ATLEAST a root owner to add to, and so on
		return (
			<>
				<div className="new-owner-form">
					<span className="new-owner-form-item">{renderDefaultRoleDropdown()}</span>
					{role !== DROPDOWN_DEFAULT && (
						<span className="new-owner-form-item">
							<Dropdown
								dropdownType={DropdownTypes.REGULAR}
								dropdownSize={DropdownSizes.LARGE}
								options={configureExistingParticipants()}
								onChange={onParentChange}
								firstOption={`Select a role to add ${role} to*`}
								firstValid={false}
							/>
						</span>
					)}
				</div>
			</>
		);
	};

	const renderFromDiagram = () => {
		return (
			<>
				<div className="new-owner-form">{renderDefaultRoleDropdown()}</div>
			</>
		);
	};

	const renderDefaultRoleDropdown = () => {
		return (
			<Dropdown
				dropdownType={DropdownTypes.REGULAR}
				dropdownSize={DropdownSizes.LARGE}
				options={configureOptions()}
				onChange={onRoleChange}
				firstOption="Select a new role to add*"
				firstValid={false}
			/>
		);
	};

	const renderConfirmationMessage = () => {
		if (parentRole !== "" && role !== DROPDOWN_DEFAULT) {
			return (
				<span className="confirmation-message">{`Are you sure you want to add ${role} to ${parentRole}?`}</span>
			);
		} else if (role !== DROPDOWN_DEFAULT && parent !== DROPDOWN_DEFAULT) {
			return <span className="confirmation-message">{`Are you sure you want to add ${role} to ${parent}?`}</span>;
		}

		return null;
	};

	return (
		<div className="new-owner-container">
			{icon && <Icon className="md-36">{icon}</Icon>}
			{title && <div className="modal-title">{title}</div>}
			{fromPalette ? renderFromPalette() : renderFromDiagram()}
			{renderConfirmationMessage()}
		</div>
	);
};

export default NewOwnerContainer;
