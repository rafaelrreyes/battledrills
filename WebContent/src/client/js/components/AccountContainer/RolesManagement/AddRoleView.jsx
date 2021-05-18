import React, { useState, useEffect } from "react";

import { Button, ButtonSizes, Input, InputSizes, Dropdown, DropdownSizes, Spinner, Icon, TooltipPlacement } from "CORE";
import { DragDropContext, Droppable, Draggable } from "react-beautiful-dnd";
import { API, MaterialIconNames } from "UTILITIES";

import "./AddRoleView.scss";

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
	stagedGroups: "stagedGroups",
	availableGroups: "availableGroups"
};

const AddRoleView = ({ onSave, onCancel }) => {
	const [name, setName] = useState("");
	const [permission, setPermission] = useState("*");

	const [permissionTypes, setPermissionTypes] = useState([]);
	const [stagedGroups, setStagedGroups] = useState([]);
	const [availableGroups, setAvailableGroups] = useState([]);
	const [isLoadingAvailable, setIsLoadingAvailable] = useState(false);

	useEffect(() => {
		API.getPermissionTypes((types) => {
			setPermissionTypes(types);
		});

		setIsLoadingAvailable(true);
		API.getGroups((groups) => {
			setAvailableGroups(groups);
			setIsLoadingAvailable(false);
		});
	}, []);

	/**
	 * Gets the state based on which list id is passed in.
	 * @param {String} id
	 * @returns
	 */
	const getGroupById = (id) => {
		return id === droppableListIds.stagedGroups ? stagedGroups : availableGroups;
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
				<div className="field">
					<span className="field-label">Permission</span>
					<Dropdown
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
			name,
			permission,
			groups: stagedGroups.map((group) => {
				return group.id;
			})
		};

		API.addRole(requestBody, (role) => {
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
			const reordered = reorderList(getGroupById(source.droppableId), source.index, destination.index);

			if (source.droppableId === droppableListIds.stagedGroups) {
				setStagedGroups(reordered);
			} else if (source.droppableId === droppableListIds.availableGroups) {
				setAvailableGroups(reordered);
			}
		} else {
			// moving group from available one list to another
			const manipulatedLists = moveItem(
				getGroupById(source.droppableId),
				getGroupById(destination.droppableId),
				source,
				destination
			);

			// set state of each lists
			setStagedGroups(manipulatedLists[droppableListIds.stagedGroups]);
			setAvailableGroups(manipulatedLists[droppableListIds.availableGroups]);
		}
	};

	const onRemoveStagedGroupHandler = (groupId, index) => {
		const staged = Array.from(stagedGroups);
		const available = Array.from(availableGroups);
		const [removed] = staged.splice(index, 1);
		available.splice(0, 0, removed);

		// set new state based on manipulated array copies
		setStagedGroups(staged);
		setAvailableGroups(available);
	};

	const onAddAvailableGroupHandler = (groupId, index) => {
		const staged = Array.from(stagedGroups);
		const available = Array.from(availableGroups);
		const [added] = available.splice(index, 1);
		staged.splice(0, 0, added);

		setStagedGroups(staged);
		setAvailableGroups(available);
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
		if (isLoadingAvailable) {
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
						<Droppable droppableId={droppableListIds.stagedGroups}>
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
						<Droppable droppableId={droppableListIds.availableGroups}>
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
		<div className="add-role-view">
			<div className="role-view-header">Add Role</div>
			{renderInputs()}
			{renderDraggableLists()}
			{renderButtons()}
		</div>
	);
};

export default AddRoleView;
