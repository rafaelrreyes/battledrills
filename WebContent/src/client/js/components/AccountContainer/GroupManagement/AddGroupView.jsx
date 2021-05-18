import React, { useState, useEffect } from "react";

import { Button, ButtonSizes, Input, Spinner, Icon, TooltipPlacement } from "CORE";
import { DragDropContext, Droppable, Draggable } from "react-beautiful-dnd";
import { API, MaterialIconNames } from "UTILITIES";

import "./AddGroupView.scss";

const reorderList = (list, startIndex, endIndex) => {
	const result = Array.from(list);
	const [removed] = result.splice(startIndex, 1);
	result.splice(endIndex, 0, removed);
	return result;
};

/**
 * Moves one object from one draggable list to another and returns a object containing keys named after the draggable list ids with the updated arrays.
 * @param {Array} source
 * @param {Array} destination
 * @param {Object} droppableSource
 * @param {Object} droppableDestination
 * @returns {Object} result
 */
const moveItem = (source, destination, droppableSource, droppableDestination) => {
	const sourceCloneArray = Array.from(source);
	const destinationCloneArray = Array.from(destination);

	// remove from source array
	const [removed] = sourceCloneArray.splice(droppableSource.index, 1);
	destinationCloneArray.splice(droppableDestination.index, 0, removed);

	const result = {};
	result[droppableSource.droppableId] = sourceCloneArray;
	result[droppableDestination.droppableId] = destinationCloneArray;

	return result;
};

const droppableListIds = {
	stagedRoles: "stagedRoles",
	availableRoles: "availableRoles"
};

const AddGroupView = ({ onSave, onCancel }) => {
	const [name, setName] = useState("");
	const [stagedRoles, setStagedRoles] = useState([]);
	const [availableRoles, setAvailableRoles] = useState([]);
	const [isLoadingAvailable, setIsLoadingAvailable] = useState(false);

	useEffect(() => {
		setIsLoadingAvailable(true);
		API.getRoles((roles) => {
			setAvailableRoles(roles);
			setIsLoadingAvailable(false);
		});
	}, []);

	/**
	 * Gets the state based on which list id is passed in.
	 * @param {String} id
	 * @returns
	 */
	const getRolesById = (id) => {
		return id === droppableListIds.stagedRoles ? stagedRoles : availableRoles;
	};

	const renderInputs = () => {
		return (
			<div className="input-fields">
				<div className="field">
					<span className="field-label">Name</span>
					<Input
						placeholder="Name"
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
			name,
			roles: stagedRoles.map((role) => {
				return role.id;
			})
		};

		API.addGroup(requestBody, (group) => {
			onSave();
		});
	};

	const onBackClickHandler = () => {
		onCancel();
	};

	const onDragEnd = (result) => {
		const { source, destination } = result;

		if (!destination) {
			return;
		}

		// drop in same list
		if (source.droppableId === destination.droppableId) {
			const reordered = reorderList(getRolesById(source.droppableId), source.index, destination.index);

			if (source.droppableId === droppableListIds.stagedRoles) {
				setStagedRoles(reordered);
			} else if (source.droppableId === droppableListIds.availableRoles) {
				setAvailableRoles(reordered);
			}
		} else {
			// moving role from available one list to another
			const manipulatedLists = moveItem(
				getRolesById(source.droppableId),
				getRolesById(destination.droppableId),
				source,
				destination
			);

			// set state of each lists
			setStagedRoles(manipulatedLists[droppableListIds.stagedRoles]);
			setAvailableRoles(manipulatedLists[droppableListIds.availableRoles]);
		}
	};

	const onRemoveStagedRoleHandler = (roleId, index) => {
		const staged = Array.from(stagedRoles);
		const available = Array.from(availableRoles);
		const [removed] = staged.splice(index, 1);
		available.splice(0, 0, removed);

		// set new state based on manipulated array copies
		setStagedRoles(staged);
		setAvailableRoles(available);
	};

	const onAddAvailableRoleHandler = (roleId, index) => {
		const staged = Array.from(stagedRoles);
		const available = Array.from(availableRoles);
		const [added] = available.splice(index, 1);
		staged.splice(0, 0, added);

		setStagedRoles(staged);
		setAvailableRoles(available);
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
							className="role-list-item"
						>
							<span className="role-list-item-name">{role.name}</span>
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
							className="available-role-list-item"
						>
							<span className="role-list-item-name">{role.name}</span>
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
		if (isLoadingAvailable) {
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
					<div className="role-list-container">
						<div className="role-list-header">Roles ({stagedRoles.length})</div>
						<Droppable droppableId={droppableListIds.stagedRoles}>
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
					<div className="role-list-container">
						<div className="role-list-header">Available Roles ({availableRoles.length})</div>
						<Droppable droppableId={droppableListIds.availableRoles}>
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
		<div className="add-group-view">
			<div className="group-view-header">Add Group</div>
			{renderInputs()}
			{renderDraggableLists()}
			{renderButtons()}
		</div>
	);
};

export default AddGroupView;
