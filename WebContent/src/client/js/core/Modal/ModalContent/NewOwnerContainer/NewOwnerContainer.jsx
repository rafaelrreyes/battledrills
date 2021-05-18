import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { getSelectedDrill, getSelectedTemplate } from "REDUX";
import { Dropdown, DropdownSizes, DropdownTypes, DROPDOWN_DEFAULT, Icon } from "CORE";
import { API } from "UTILITIES";
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
	const [allRoles, setAllRoles] = useState([]);

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

	useEffect(() => {
		API.getRoles((roles) => {
			let configuredRoles;
			if (typeof participants === "undefined") {
				configuredRoles = roles.map((role) => {
					return role.name;
				});
			} else {
				configuredRoles = roles
					.filter((role) => {
						return !participants.includes(role.name);
					})
					.map((mappedRole) => {
						return mappedRole.name;
					});
			}

			setAllRoles(configuredRoles);
		});
	}, []);

	const onRoleChange = (role) => {
		setRole(role);
	};

	const onParentChange = (parent) => {
		setParent(parent);
	};

	const configureExistingParticipants = () => {
		if (typeof participants === "undefined") {
			return allRoles;
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
				options={allRoles}
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
