import React, { useState, useEffect } from "react";
import { useDispatch } from "react-redux";
import { API, MaterialIconNames } from "UTILITIES";
import { setGroups, deleteGroup } from "REDUX";
import { Button, ButtonSizes, Input, InputSizes, Spinner, Icon } from "CORE";
import AddGroupView from "./AddGroupView";
import EditGroupView from "./EditGroupView";

import "./GroupManagement.scss";

const SortTypes = {
	NAME: "name",
	NUM_ROLES: "roles"
};

const SortOrder = {
	ASC: "asc",
	DESC: "desc"
};

const GroupManagement = () => {
	const [isAddingGroup, setIsAddingGroup] = useState(false);
	const [isEditingGroup, setIsEditingGroup] = useState(false);
	const [selectedGroup, setSelectedGroup] = useState(null);
	const [sortBy, setSortBy] = useState(SortTypes.NAME);
	const [sortOrder, setSortOrder] = useState(SortOrder.ASC);
	const [searchBy, setSearchBy] = useState("");
	const [isLoading, setIsLoading] = useState(false);
	const [viewGroups, setViewGroups] = useState([]);

	const dispatch = useDispatch();

	const fetchGroups = () => {
		setIsLoading(true);
		API.getGroups((groups) => {
			let filteredGroups;
			if (searchBy.trim() !== "") {
				filteredGroups = groups.filter((group) => {
					const { name, roleNames } = group;
					const lowercasedSearch = searchBy.toLowerCase();
					if (
						name.toLowerCase().includes(lowercasedSearch) ||
						roleNames.join("").toLowerCase().includes(lowercasedSearch)
					) {
						return group;
					}
				});
			} else {
				filteredGroups = groups;
			}

			let sortFunction;
			if (sortBy === SortTypes.NAME) {
				sortFunction =
					sortOrder === SortOrder.ASC
						? (a, b) => {
								return a[sortBy] > b[sortBy] ? 1 : -1;
						  }
						: (a, b) => {
								return a[sortBy] > b[sortBy] ? -1 : 1;
						  };
			} else if (sortBy === SortTypes.NUM_ROLES) {
				sortFunction =
					sortOrder === SortOrder.ASC
						? (a, b) => {
								return a[sortBy].length > b[sortBy].length ? 1 : -1;
						  }
						: (a, b) => {
								return a[sortBy].length > b[sortBy].length ? -1 : 1;
						  };
			}

			filteredGroups = filteredGroups.sort(sortFunction);

			dispatch(setGroups(groups));
			setViewGroups(filteredGroups);
			setIsLoading(false);
		});
	};

	useEffect(() => {
		fetchGroups();
	}, [isAddingGroup, isEditingGroup, sortBy, sortOrder]);

	const onSearchChangeHandler = (value) => {
		setSearchBy(value);
	};

	const onSearchHandler = () => {
		fetchGroups();
	};

	const onSortOrderClickHandler = () => {
		sortOrder === SortOrder.ASC ? setSortOrder(SortOrder.DESC) : setSortOrder(SortOrder.ASC);
	};

	const renderMain = () => {
		if (isAddingGroup) {
			return (
				<AddGroupView
					onSave={() => {
						setIsAddingGroup(false);
					}}
					onCancel={() => {
						setIsAddingGroup(false);
					}}
				/>
			);
		} else if (isEditingGroup) {
			return (
				<EditGroupView
					group={selectedGroup}
					onSave={() => {
						setIsEditingGroup(false);
					}}
					onCancel={() => {
						setSelectedGroup(null);
						setIsEditingGroup(false);
					}}
				/>
			);
		} else {
			return (
				<>
					{renderMainBar()}
					{renderHeaders()}
					<div className="group-list">{renderGroupsList()}</div>
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
						setIsAddingGroup(true);
					}}
					isDisabled={isLoading}
				>
					<Icon>{MaterialIconNames.ADD_GROUP}</Icon>
					<span className="add-group-label">Add Group</span>
				</Button>
				{/* <div className="group-metrics">{groups.length} groups</div> */}
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
				<div className="header-item group-name-header">
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
				<div className="header-item roles-count-header">
					<div
						className="roles-count-header-label"
						onClick={() => {
							onHeaderClickHandler(SortTypes.NUM_ROLES);
						}}
					>
						# Roles
					</div>
					{sortBy === SortTypes.NUM_ROLES && (
						<Icon onClick={onSortOrderClickHandler}>
							{sortOrder === SortOrder.ASC
								? MaterialIconNames.ARROW_UP
								: MaterialIconNames.ARROW_DROP_DOWN}
						</Icon>
					)}
				</div>
				<div className="header-item commands-header"></div>
			</div>
		);
	};

	const renderGroupsList = () => {
		if (isLoading) {
			return (
				<div className="loading-wheel">
					<Spinner size="md" />
				</div>
			);
		}

		if (viewGroups.length === 0) {
			return <div className="no-groups-available-label">No groups available.</div>;
		}

		return viewGroups.map((group, index) => {
			return (
				<div
					className="group-row-item"
					key={index}
					onClick={() => {
						setIsEditingGroup(true);
						setSelectedGroup(group);
					}}
				>
					<div className="group-column-item group-name">
						<Icon>{MaterialIconNames.ACCOUNTS}</Icon>
						<span className="group-name-label">{group.name}</span>
					</div>
					<div className="group-column-item group-permission">{group.permission}</div>
					<div className="group-column-item group-role-count">
						<Icon>{MaterialIconNames.ROLES}</Icon>
						<span className="group-role-count-label">{group.roles.length}</span>
					</div>
					<div className="group-column-item group-commands">
						<Icon
							tooltip="Edit"
							onClick={() => {
								setIsEditingGroup(true);
								setSelectedGroup(group);
							}}
							hasCircledBackground={true}
						>
							{MaterialIconNames.EDIT}
						</Icon>
						<Icon
							tooltip="Delete"
							className="material-icons"
							onClick={() => {
								onDeleteGroupHandler(group.id);
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

	const onHeaderClickHandler = (headerType) => {
		setSortBy(headerType);
	};

	const onDeleteGroupHandler = (id) => {
		const requestBody = { id };

		API.deleteGroupById(requestBody, () => {
			dispatch(deleteGroup(id));
			const updatedGroups = viewGroups.filter((group) => {
				return group.id !== id;
			});
			setViewGroups(updatedGroups);
		});
	};

	return (
		<div className="main">
			<div className="title">Groups</div>
			<div className="title-break"></div>
			{renderMain()}
		</div>
	);
};

export default GroupManagement;
