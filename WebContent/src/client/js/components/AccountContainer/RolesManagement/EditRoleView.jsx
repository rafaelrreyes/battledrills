import React, { useState, useEffect } from "react";
import { Button, ButtonSizes, Input, InputSizes, Dropdown, DropdownSizes, Spinner, Icon, TooltipPlacement } from "CORE";
import { DragDropContext, Droppable, Draggable } from "react-beautiful-dnd";
import { API, MaterialIconNames } from "UTILITIES";

import "./EditRoleView.scss";

const reorderList = (list, startIndex, endIndex) => {
	const result = Array.from(list);
	const [removed] = result.splice(startIndex, 1);

	// insert removed item at endIndex
	result.splice(endIndex, 0, removed);
	return result;
};

const moveItem = (source, destination, droppableSource, droppableDestination) => {
	// clone source and destination arrays
	const sourceCloneArray = Array.from(source);
	const destinationCloneArray = Array.from(destination);

	// remove from source array
	const [removed] = sourceCloneArray.splice(droppableSource.index, 1);

	// add to destination array
	destinationCloneArray.splice(droppableDestination.index, 0, removed);

	// create new object with new updated clones and assign key of table ids
	const result = {};
	result[droppableSource.droppableId] = sourceCloneArray;
	result[droppableDestination.droppableId] = destinationCloneArray;

	return result;
};

const droppableListsIds = {
	stagedGroups: "stagedGroups",
	availableGroups: "availableGroups"
};

const EditRoleView = ({ role, onSave, onCancel }) => {
	const [name, setName] = useState(role.name);
	const [permission, setPermission] = useState(role.permission);

	const [permissionTypes, setPermissionTypes] = useState([]);
	const [stagedGroups, setStagedGroups] = useState([]);
	const [availableGroups, setAvailableGroups] = useState([]);
	const [isMovingGroup, setIsMovingGroup] = useState(false);
	const [isLoadingAvailableGroups, setIsLoadingAvailableGroups] = useState(false);

	useEffect(() => {
		API.getPermissionTypes((types) => {
			setPermissionTypes(types);
		});

		setIsLoadingAvailableGroups(true);
		API.getGroups(
			(groups) => {
				const staged = [];
				const available = [];
				groups.forEach((group) => {
					// if the current role is included in this group, stage
					if (role.groups.includes(group.id)) {
						staged.push(group);
					} else {
						available.push(group);
					}
				});

				setIsLoadingAvailableGroups(false);
				setStagedGroups(staged);
				setAvailableGroups(available);
			},
			() => {}
		);
	}, []);

	/**
	 * Gets the state based on which list id is passed in.
	 * @param {String} id
	 * @returns
	 */
	const getGroupById = (id) => {
		return id === droppableListsIds.stagedGroups ? stagedGroups : availableGroups;
	};

	const renderInputs = () => {
		return (
			<div className="input-fields">
				<div className="field">
					<span className="field-label">Name</span>
					<Input
						placeholder="Name"
						initValue={name}
						inputSize={InputSizes.LARGE}
						onChange={(value) => {
							setName(value);
						}}
					/>
				</div>
				<div className="field">
					<span className="field-label">Permission</span>
					<Dropdown
						dropdownSize={DropdownSizes.LARGE}
						options={permissionTypes}
						firstOption={"Select Permission"}
						defaultSelect={permission}
						onChange={(permission) => {
							setPermission(permission);
						}}
					/>
				</div>
			</div>
		);
	};

	const renderButtons = () => {
		return (
			<div className="footer-buttons">
				<Button
					isDisabled={name === "" || permission === "*"}
					buttonSizes={ButtonSizes.SMALL}
					onClick={onSaveClickHandler}
				>
					Save
				</Button>
				<Button buttonSizes={ButtonSizes.SMALL} onClick={onBackClickHandler}>
					Back
				</Button>
			</div>
		);
	};

	const onSaveClickHandler = () => {
		if (name.trim() === "" || permission === "*") {
			// TODO name cannot be empty and permission must be set validator
			return;
		}

		const requestBody = {
			id: role.id,
			properties: {
				name,
				permission
			}
		};

		API.editRoleProperties(requestBody, (updatedRole) => {
			onSave();
		});
	};

	const onBackClickHandler = () => {
		onCancel();
	};

	const onDragEnd = (result) => {
		const { source, destination, draggableId } = result;
		const groupId = parseInt(draggableId);
		const roleId = role.id;

		if (!destination) {
			return;
		}

		// drop in same list
		if (source.droppableId === destination.droppableId) {
			// gets reordered version of source list
			const reordered = reorderList(getGroupById(source.droppableId), source.index, destination.index);

			// if reordering in staged list
			if (source.droppableId === droppableListsIds.stagedGroups) {
				setStagedGroups(reordered);

				// otherwise, reordering in available list
			} else if (source.droppableId === droppableListsIds.availableGroups) {
				setAvailableGroups(reordered);
			}

			// moving from one list to the other
		} else {
			// moving group from available to staged
			const manipulatedLists = moveItem(
				getGroupById(source.droppableId),
				getGroupById(destination.droppableId),
				source,
				destination
			);

			const requestBody = {
				groupId,
				roleId
			};

			setIsMovingGroup(true);
			if (destination.droppableId === droppableListsIds.stagedGroups) {
				API.addRoleToGroupById(
					requestBody,
					() => {
						setIsMovingGroup(false);
					},
					() => {}
				);
			} else {
				API.deleteRoleFromGroupById(
					requestBody,
					() => {
						setIsMovingGroup(false);
					},
					() => {}
				);
			}
			// set the state of each list based on manipulations
			setStagedGroups(manipulatedLists[droppableListsIds.stagedGroups]);
			setAvailableGroups(manipulatedLists[droppableListsIds.availableGroups]);
		}
	};

	const onRemoveStagedGroupHandler = (groupId, index) => {
		const requestBody = {
			groupId,
			roleId: role.id
		};

		setIsMovingGroup(true);
		API.deleteRoleFromGroupById(requestBody, () => {
			setIsMovingGroup(false);
			// remove included group and place into available groups
			const staged = Array.from(stagedGroups);
			const available = Array.from(availableGroups);
			const [removed] = staged.splice(index, 1);

			// places removed staged group at the first index of available groups
			available.splice(0, 0, removed);
			setIsMovingGroup(false);
			setStagedGroups(staged);
			setAvailableGroups(available);
		});
	};

	const onAddAvailableGroupHandler = (groupId, index) => {
		const requestBody = {
			groupId,
			roleId: role.id
		};

		setIsMovingGroup(true);
		API.addRoleToGroupById(requestBody, () => {
			const staged = Array.from(stagedGroups);
			const available = Array.from(availableGroups);
			const [added] = available.splice(index, 1);
			staged.splice(0, 0, added);
			setIsMovingGroup(false);
			setStagedGroups(staged);
			setAvailableGroups(available);
		});
	};

	const Group = ({ index, group }) => {
		return (
			<Draggable draggableId={group.id.toString()} index={index}>
				{(provided) => {
					return (
						<div
							ref={provided.innerRef}
							{...provided.draggableProps}
							{...provided.dragHandleProps}
							className="group-list-item"
						>
							<span className="group-list-item-name">{group.name}</span>
							<Icon
								tooltip="Remove"
								tooltipPlacement={TooltipPlacement.TOP}
								onClick={() => {
									onRemoveStagedGroupHandler(group.id, index);
								}}
								hasCircledBackground={true}
							>
								{MaterialIconNames.REMOVE}
							</Icon>
						</div>
					);
				}}
			</Draggable>
		);
	};

	const AvailableGroup = ({ index, group }) => {
		return (
			<Draggable draggableId={group.id.toString()} index={index}>
				{(provided) => {
					return (
						<div
							ref={provided.innerRef}
							{...provided.draggableProps}
							{...provided.dragHandleProps}
							className="available-group-list-item"
						>
							<span className="group-list-item-name">{group.name}</span>
							<Icon
								tooltip="Add"
								tooltipPlacement={TooltipPlacement.TOP}
								onClick={() => {
									onAddAvailableGroupHandler(group.id, index);
								}}
								hasCircledBackground={true}
							>
								{MaterialIconNames.ADD}
							</Icon>
						</div>
					);
				}}
			</Draggable>
		);
	};

	const GroupList = ({ groups, type }) => {
		if (isMovingGroup || isLoadingAvailableGroups) {
			return (
				<div className="loading-wheel">
					<Spinner size="md" />
				</div>
			);
		}

		return groups.map((group, index) => {
			return type === "staged" ? (
				<Group index={index} group={group} key={group.id} />
			) : (
				<AvailableGroup index={index} group={group} key={group.id} />
			);
		});
	};

	const renderDraggableLists = () => {
		return (
			<div className="drag-drop-container">
				<DragDropContext onDragEnd={onDragEnd}>
					<div className="group-list-container">
						<div className="group-list-header">Groups ({stagedGroups.length})</div>
						<Droppable droppableId={droppableListsIds.stagedGroups}>
							{(provided) => {
								return (
									<div {...provided.droppableProps} ref={provided.innerRef} className="group-list">
										<GroupList groups={stagedGroups} type={"staged"} />
										{provided.placeholder}
									</div>
								);
							}}
						</Droppable>
					</div>
					<div className="group-list-container">
						<div className="group-list-header">Available Groups ({availableGroups.length})</div>
						<Droppable droppableId={droppableListsIds.availableGroups}>
							{(provided) => {
								return (
									<div {...provided.droppableProps} ref={provided.innerRef} className="group-list">
										<GroupList groups={availableGroups} type={"available"} />
										{provided.placeholder}
									</div>
								);
							}}
						</Droppable>
					</div>
				</DragDropContext>
			</div>
		);
	};

	return (
		<div className="edit-role-view">
			<div className="role-view-header">Edit Role</div>
			{renderInputs()}
			{renderDraggableLists()}
			{renderButtons()}
		</div>
	);
};

export default EditRoleView;
