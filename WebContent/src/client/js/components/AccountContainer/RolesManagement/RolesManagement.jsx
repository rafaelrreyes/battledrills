import { Button, ButtonSizes, Input, InputSizes, Spinner, Icon } from "CORE";
import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import { setRoles, deleteRole, getRoles } from "REDUX";
import { API, MaterialIconNames } from "UTILITIES";
import AddRoleView from "./AddRoleView";
import EditRoleView from "./EditRoleView";

import "./RolesManagement.scss";

const SortTypes = {
	NAME: "name",
	PERMISSION: "permission"
};

const SortOrder = {
	ASC: "asc",
	DESC: "desc"
};

const RolesManagement = () => {
	const [isAddingRole, setIsAddingRole] = useState(false);
	const [isEditingRole, setIsEditingRole] = useState(false);
	const [selectedRole, setSelectedRole] = useState(null);
	const [sortBy, setSortBy] = useState(SortTypes.NAME);
	const [sortOrder, setSortOrder] = useState(SortOrder.ASC);
	const [searchBy, setSearchBy] = useState("");
	const [viewRoles, setViewRoles] = useState([]);

	const [isLoading, setIsLoading] = useState(false);

	const dispatch = useDispatch();

	const fetchRoles = () => {
		setIsLoading(true);
		API.getRoles((roles) => {
			let filteredRoles;
			if (searchBy.trim() !== "") {
				filteredRoles = roles.filter((role) => {
					const { name, permission, groupNames } = role;
					const lowercasedSearch = searchBy.toLowerCase();
					if (
						name.toLowerCase().includes(lowercasedSearch) ||
						permission.toLowerCase().includes(lowercasedSearch) ||
						groupNames.join("").toLowerCase().includes(lowercasedSearch)
					) {
						return role;
					}
				});
			} else {
				filteredRoles = roles;
			}

			const sortFunction =
				sortOrder === SortOrder.ASC
					? (a, b) => {
							return a[sortBy] > b[sortBy] ? 1 : -1;
					  }
					: (a, b) => {
							return a[sortBy] > b[sortBy] ? -1 : 1;
					  };

			filteredRoles = filteredRoles.sort(sortFunction);

			dispatch(setRoles(roles));
			setViewRoles(filteredRoles);
			setIsLoading(false);
		});
	};

	useEffect(() => {
		fetchRoles();
	}, [isAddingRole, isEditingRole, sortBy, sortOrder]);

	const onSearchChangeHandler = (value) => {
		setSearchBy(value);
	};

	const onSearchHandler = () => {
		fetchRoles();
	};

	const onSortOrderClickHandler = () => {
		sortOrder === SortOrder.ASC ? setSortOrder(SortOrder.DESC) : setSortOrder(SortOrder.ASC);
	};

	const renderMain = () => {
		if (isAddingRole) {
			return (
				<AddRoleView
					onSave={() => {
						setIsAddingRole(false);
					}}
					onCancel={() => {
						setIsAddingRole(false);
					}}
				/>
			);
		} else if (isEditingRole) {
			return (
				<EditRoleView
					role={selectedRole}
					onSave={() => {
						setIsEditingRole(false);
					}}
					onCancel={() => {
						setSelectedRole(null);
						setIsEditingRole(false);
					}}
				/>
			);
		} else {
			return (
				<>
					{renderMainBar()}
					{renderHeaders()}
					<div className="roles-list">{renderRolesList()}</div>
				</>
			);
		}
	};

	const renderMainBar = () => {
		return (
			<div className="main-commands">
				<Button
					buttonSize={ButtonSizes.SMALL}
					onClick={() => {
						setIsAddingRole(true);
					}}
					isDisabled={isLoading}
				>
					<Icon>{MaterialIconNames.ADD_ROLE}</Icon>
					<span className="add-role-label">Add Role</span>
				</Button>
				{/* <div className="role-metrics">{roles.length} roles</div> */}
				<div className="search-input">
					<Input
						inputSize={InputSizes.LARGE}
						placeholder="Search"
						disabled={isLoading}
						onChange={(value) => {
							onSearchChangeHandler(value);
						}}
						submit={onSearchHandler}
					/>
					<Icon tooltip="Search" isDisabled={isLoading} hasCircledBackground={true} onClick={onSearchHandler}>
						{MaterialIconNames.SEARCH}
					</Icon>
				</div>
			</div>
		);
	};

	const renderHeaders = () => {
		return (
			<div className="headers">
				<div className="header-item role-name-header">
					<div
						className="name-header-label"
						onClick={() => {
							onHeaderClickHandler(SortTypes.NAME);
						}}
					>
						Name
					</div>
					{sortBy === SortTypes.NAME && (
						<Icon onClick={onSortOrderClickHandler}>
							{sortOrder === SortOrder.ASC
								? MaterialIconNames.ARROW_UP
								: MaterialIconNames.ARROW_DROP_DOWN}
						</Icon>
					)}
				</div>
				<div className="header-item permission-header">
					<div
						className="permission-header-label"
						onClick={() => {
							onHeaderClickHandler(SortTypes.PERMISSION);
						}}
					>
						Permission
					</div>
					{sortBy === SortTypes.PERMISSION && (
						<Icon onClick={onSortOrderClickHandler}>
							{sortOrder === SortOrder.ASC
								? MaterialIconNames.ARROW_UP
								: MaterialIconNames.ARROW_DROP_DOWN}
						</Icon>
					)}
				</div>
				<div className="header-item groups-header">Groups</div>
				<div className="header-item commands-header"></div>
			</div>
		);
	};

	const renderRolesList = () => {
		if (isLoading) {
			return (
				<div className="loading-wheel">
					<Spinner size="md" />
				</div>
			);
		}

		if (viewRoles.length === 0) {
			return <div className="no-roles-available-label">No roles available.</div>;
		}

		return viewRoles.map((role, index) => {
			return (
				<div
					className="role-row-item"
					key={index}
					onClick={() => {
						setIsEditingRole(true);
						setSelectedRole(role);
					}}
				>
					<div className="role-column-item role-name">
						<Icon>{MaterialIconNames.ROLES}</Icon>
						<span className="role-name-label">{role.name}</span>
					</div>
					<div className="role-column-item role-permission">{role.permission}</div>
					<div className="role-column-item role-groups">{renderGroups(role.groupNames)}</div>
					<div className="role-column-item role-commands">
						<Icon
							tooltip="Edit"
							onClick={() => {
								setIsEditingRole(true);
								setSelectedRole(role);
							}}
							hasCircledBackground={true}
						>
							{MaterialIconNames.EDIT}
						</Icon>
						<Icon
							tooltip="Delete"
							className="material-icons"
							onClick={() => {
								onDeleteRoleHandler(role.id);
							}}
							hasCircledBackground={true}
						>
							{MaterialIconNames.DELETE}
						</Icon>
					</div>
				</div>
			);
		});
	};

	const renderGroups = (groupNames) => {
		return groupNames.map((groupname, index) => {
			return <span className="role-item-groupname">{groupname}</span>;
		});
	};

	const onHeaderClickHandler = (headerType) => {
		setSortBy(headerType);
	};

	const onDeleteRoleHandler = (id) => {
		API.deleteRoleById({ id }, () => {
			dispatch(deleteRole(id));
			const updatedRoles = viewRoles.filter((role) => {
				return role.id !== id;
			});
			setViewRoles(updatedRoles);
		});
	};

	return (
		<div className="main">
			<div className="title">Roles</div>
			<div className="title-break"></div>
			{renderMain()}
		</div>
	);
};

export default RolesManagement;
