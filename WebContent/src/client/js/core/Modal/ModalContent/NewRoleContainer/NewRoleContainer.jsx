import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { getSelectedDrill, getSelectedTemplate } from "REDUX";
import { Dropdown, DropdownSizes, DropdownTypes, DROPDOWN_DEFAULT, Icon } from "CORE";
import { API } from "UTILITIES";
import "./NewRoleContainer.scss";

const NewRoleContainer = ({
	fromTemplate = false,
	fromPalette = false,
	updateData,
	updateDisableSubmit,
	parentRole = "",
	parentId = 0,
	icon,
	title
}) => {
	const [roleId, setRoleId] = useState(DROPDOWN_DEFAULT);
	const [dropdownParentId, setDropdownParentId] = useState(DROPDOWN_DEFAULT);
	const [participantOptions, setParticipantOptions] = useState([]);
	const [allRoles, setAllRoles] = useState([]);

	const { participants } = fromTemplate ? useSelector(getSelectedTemplate) : useSelector(getSelectedDrill);

	useEffect(() => {
		const targetRole = allRoles.find((role) => {
			return role.id === parseInt(roleId);
		});

		if (fromPalette) {
			if (roleId === DROPDOWN_DEFAULT) {
				updateDisableSubmit(true);
			} else if (
				roleId !== DROPDOWN_DEFAULT &&
				typeof participants !== "undefined" &&
				participants.length !== 0 &&
				dropdownParentId === DROPDOWN_DEFAULT
			) {
				updateDisableSubmit(true);
			} else {
				updateDisableSubmit(false);
				if (dropdownParentId === DROPDOWN_DEFAULT) {
					updateData({ roleId, roleName: targetRole.name, parentId: dropdownParentId });
					return;
				}
				updateData({ roleId, roleName: targetRole.name, parentId: dropdownParentId });
			}
		} else {
			if (roleId === DROPDOWN_DEFAULT) {
				updateDisableSubmit(true);
			} else {
				updateDisableSubmit(false);
				updateData({
					roleId,
					roleName: targetRole.name,
					parentId: fromTemplate ? parentId : dropdownParentId,
					parentRole
				});
			}
		}
	}, [roleId, dropdownParentId]);

	useEffect(() => {
		API.getRoles((roles) => {
			let configuredRoles;
			if (typeof participants === "undefined") {
				configuredRoles = roles.map((role) => {
					return role;
				});
			} else {
				configuredRoles = roles.filter((role) => {
					return !participants.includes(role.id);
				});

				const participantDropdownOptions = [];
				roles.forEach((role) => {
					if (participants.includes(role.id)) {
						participantDropdownOptions.push({ id: role.id, name: role.name });
					}
				});
				setParticipantOptions(participantDropdownOptions);
			}

			setAllRoles(configuredRoles);
		});
	}, []);

	const onRoleChange = (roleId) => {
		setRoleId(parseInt(roleId));
	};

	const onParentChange = (parentId) => {
		setDropdownParentId(parseInt(parentId));
	};

	const renderFromPalette = () => {
		// if there are no participants, render the modal as if user wants to add a new root role
		if (typeof participants === "undefined" || participants.length === 0) {
			return renderDefaultRoleDropdown();
		}

		// find target role to fetch name
		const targetRole = allRoles.find((role) => role.id === parseInt(roleId));

		// otherwise, render as if there is already ATLEAST a root role to add to, and so on
		return (
			<>
				<div className="new-role-form">
					<span className="new-role-form-item">{renderDefaultRoleDropdown()}</span>
					{roleId !== DROPDOWN_DEFAULT && (
						<span className="new-role-form-item">
							<Dropdown
								dropdownType={DropdownTypes.REGULAR}
								dropdownSize={DropdownSizes.LARGE}
								options={participantOptions}
								onChange={onParentChange}
								firstOption={`Select a role to add ${targetRole.name} to*`}
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
				<div className="new-role-form">{renderDefaultRoleDropdown()}</div>
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
		let foundRole;

		if (roleId !== 0) {
			foundRole = allRoles.find((role) => {
				return role.id === parseInt(roleId);
			});
		}

		if (fromPalette && dropdownParentId !== DROPDOWN_DEFAULT) {
			const targetParent = participantOptions.find((participant) => {
				return participant.id === parseInt(dropdownParentId);
			});
			parentRole = targetParent.name;
		}

		if (parentRole !== "" && roleId !== DROPDOWN_DEFAULT) {
			return (
				<span className="confirmation-message">{`Are you sure you want to add ${foundRole.name} to ${parentRole}?`}</span>
			);
		} else if (roleId !== DROPDOWN_DEFAULT && dropdownParentId !== DROPDOWN_DEFAULT) {
			return (
				<span className="confirmation-message">{`Are you sure you want to add ${foundRole.name} to ${parentRole}?`}</span>
			);
		}

		return null;
	};

	return (
		<div className="new-role-container">
			{icon && <Icon className="md-36">{icon}</Icon>}
			{title && <div className="modal-title">{title}</div>}
			{fromPalette ? renderFromPalette() : renderFromDiagram()}
			{renderConfirmationMessage()}
		</div>
	);
};

export default NewRoleContainer;
