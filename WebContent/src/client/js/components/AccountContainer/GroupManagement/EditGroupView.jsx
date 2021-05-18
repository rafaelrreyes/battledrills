import React, { useState, useEffect } from "react";
import { Button, ButtonSizes, Input, InputSizes, Dropdown, DropdownSizes, Spinner, Icon, TooltipPlacement } from "CORE";
import { DragDropContext, Droppable, Draggable } from "react-beautiful-dnd";
import { API, MaterialIconNames } from "UTILITIES";

import "./EditGroupView.scss";

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
	stagedRoles: "stagedRoles",
	availableRoles: "availableRoles"
};

const EditGroupView = ({ group, onSave, onCancel }) => {
	const [name, setName] = useState(group.name);

	const [stagedRoles, setStagedRoles] = useState([]);
	const [availableRoles, setAvailableRoles] = useState([]);
	const [isMovingRole, setIsMovingRole] = useState(false);
	const [isLoadingAvailableRole, setIsLoadingAvailableRole] = useState(false);

	useEffect(() => {
		setIsLoadingAvailableRole(true);
		API.getRoles(
			(roles) => {
				const staged = [];
				const available = [];
				roles.forEach((role) => {
					// if the current group includes this role, stage
					if (group.roles.includes(role.id)) {
						staged.push(role);
					} else {
						available.push(role);
					}
				});

				setIsLoadingAvailableRole(false);
				setStagedRoles(staged);
				setAvailableRoles(available);
			},
			() => {}
		);
	}, []);

	/**
	 * Gets the state based on which list id is passed in.
	 * @param {String} id
	 * @returns
	 */
	const getRolesById = (id) => {
		return id === droppableListsIds.stagedRoles ? stagedRoles : availableRoles;
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
			</div>
		);
	};

	const renderButtons = () => {
		return (
			<div className="footer-buttons">
				<Button isDisabled={name === ""} buttonSizes={ButtonSizes.SMALL} onClick={onSaveClickHandler}>
					Save
				</Button>
				<Button buttonSizes={ButtonSizes.SMALL} onClick={onBackClickHandler}>
					Back
				</Button>
			</div>
		);
	};

	const onSaveClickHandler = () => {
		if (name.trim() === "") {
			// TODO name cannot be empty validator
			return;
		}

		const requestBody = {
			id: role.id,
			properties: {
				name
			}
		};

		API.editGroupProperties(requestBody, (updatedGroup) => {
			onSave();
		});
	};

	const onBackClickHandler = () => {
		onCancel();
	};

	const onDragEnd = (result) => {
		const { source, destination, draggableId } = result;
		const groupId = group.id;
		const roleId = parseInt(draggableId);

		if (!destination) {
			return;
		}

		// drop in same list
		if (source.droppableId === destination.droppableId) {
			// gets reordered version of source list
			const reordered = reorderList(getRolesById(source.droppableId), source.index, destination.index);

			// if reordering in staged list
			if (source.droppableId === droppableListsIds.stagedRoles) {
				setStagedRoles(reordered);

				// otherwise, reordering in available list
			} else if (source.droppableId === droppableListsIds.availableRoles) {
				setAvailableRoles(reordered);
			}

			// moving from one list to the other
		} else {
			// moving role from available to staged
			const manipulatedLists = moveItem(
				getRolesById(source.droppableId),
				getRolesById(destination.droppableId),
				source,
				destination
			);

			const requestBody = {
				groupId,
				roleId
			};

			setIsMovingRole(true);
			if (destination.droppableId === droppableListsIds.stagedRoles) {
				API.addRoleToGroupById(
					requestBody,
					() => {
						setIsMovingRole(false);
					},
					() => {}
				);
			} else {
				API.deleteRoleFromGroupById(
					requestBody,
					() => {
						setIsMovingRole(false);
					},
					() => {}
				);
			}
			// set the state of each list based on manipulations
			setStagedRoles(manipulatedLists[droppableListsIds.stagedRoles]);
			setAvailableRoles(manipulatedLists[droppableListsIds.availableRoles]);
		}
	};

	const onRemoveStagedRoleHandler = (roleId, index) => {
		const requestBody = {
			groupId: group.id,
			roleId
		};

		setIsMovingRole(true);
		API.deleteRoleFromGroupById(requestBody, () => {
			setIsMovingGroup(false);
			// remove included role and place into available roles
			const staged = Array.from(stagedRoles);
			const available = Array.from(availableRoles);
			const [removed] = staged.splice(index, 1);

			// places removed staged role at the first index of available roles
			available.splice(0, 0, removed);
			setIsMovingRole(false);
			setStagedRoles(staged);
			setAvailableRoles(available);
		});
	};

	const onAddAvailableRoleHandler = (roleId, index) => {
		const requestBody = {
			groupId: group.id,
			roleId
		};

		setIsMovingRole(true);
		API.addRoleToGroupById(requestBody, () => {
			const staged = Array.from(stagedRoles);
			const available = Array.from(availableRoles);
			const [added] = available.splice(index, 1);
			staged.splice(0, 0, added);
			setIsMovingRole(false);
			setStagedRoles(staged);
			setAvailableRoles(available);
		});
	};

	const Role = ({ index, role }) => {
		return (
			<Draggable draggableId={role.id.toString()} index={index}>
				{(provided) => {
					return (
						<div
							ref={provided.innerRef}
							{...provided.draggableProps}
							{...provided.dragHandleProps}
							className="roles-list-item"
						>
							<span className="roles-list-item-name">{role.name}</span>
							<Icon
								tooltip="Remove"
								tooltipPlacement={TooltipPlacement.TOP}
								onClick={() => {
									onRemoveStagedRoleHandler(role.id, index);
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

	const AvailableRole = ({ index, role }) => {
		return (
			<Draggable draggableId={role.id.toString()} index={index}>
				{(provided) => {
					return (
						<div
							ref={provided.innerRef}
							{...provided.draggableProps}
							{...provided.dragHandleProps}
							className="available-roles-list-item"
						>
							<span className="roles-list-item-name">{role.name}</span>
							<Icon
								tooltip="Add"
								tooltipPlacement={TooltipPlacement.TOP}
								onClick={() => {
									onAddAvailableRoleHandler(role.id, index);
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

	const RolesList = ({ roles, type }) => {
		if (isMovingRole || isLoadingAvailableRole) {
			return (
				<div className="loading-wheel">
					<Spinner size="md" />
				</div>
			);
		}

		return roles.map((role, index) => {
			return type === "staged" ? (
				<Role index={index} role={role} key={role.id} />
			) : (
				<AvailableRole index={index} role={role} key={role.id} />
			);
		});
	};

	const renderDraggableLists = () => {
		return (
			<div className="drag-drop-container">
				<DragDropContext onDragEnd={onDragEnd}>
					<div className="roles-list-container">
						<div className="roles-list-header">Roles ({stagedRoles.length})</div>
						<Droppable droppableId={droppableListsIds.stagedRoles}>
							{(provided) => {
								return (
									<div {...provided.droppableProps} ref={provided.innerRef} className="roles-list">
										<RolesList roles={stagedRoles} type={"staged"} />
										{provided.placeholder}
									</div>
								);
							}}
						</Droppable>
					</div>
					<div className="roles-list-container">
						<div className="roles-list-header">Available Roles ({availableRoles.length})</div>
						<Droppable droppableId={droppableListsIds.availableRoles}>
							{(provided) => {
								return (
									<div {...provided.droppableProps} ref={provided.innerRef} className="roles-list">
										<RolesList roles={availableRoles} type={"available"} />
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
		<div className="edit-group-view">
			<div className="group-view-header">Edit Group</div>
			{renderInputs()}
			{renderDraggableLists()}
			{renderButtons()}
		</div>
	);
};

export default EditGroupView;
