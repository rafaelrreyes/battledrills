import React, { useState, useRef } from "react";
import { useHistory } from "react-router";
import { useDispatch, useSelector } from "react-redux";
import { API, MaterialIconNames, Routes, LinkStyles, LinkSmoothness } from "UTILITIES";
import { ModalContentTypes, Icon, DROPDOWN_DEFAULT, TooltipPlacement } from "CORE";
import { useClickOutside } from "HOOKS";
import {
	getUser,
	getSelectedDrill,
	setSelectedDrill,
	showModal,
	closeModal,
	setLinkStyle,
	getSelectedTask,
	setLinkSmoothness,
	updateAllDrills,
	getLinkStyle,
	getLinkSmoothness
} from "REDUX";

// scss
import "./DiagramPaletteView.scss";

const DiagramPaletteView = ({ diagram }) => {
	const editorViewRef = useRef(null);

	const [showLinkStyles, setShowLinkStyles] = useState(false);
	const [showLinkSmoothness, setShowLinkSmoothness] = useState(false);

	const linkStylesRef = useClickOutside(() => {
		setShowLinkStyles(false);
	});
	const linkSmoothnessRef = useClickOutside(() => {
		setShowLinkSmoothness(false);
	});

	const dispatch = useDispatch();
	const history = useHistory();

	const user = useSelector(getUser);
	const selectedDrill = useSelector(getSelectedDrill);
	const selectedTask = useSelector(getSelectedTask);
	const drillId = selectedDrill.id;
	const linkStyle = useSelector(getLinkStyle);
	const linkSmoothness = useSelector(getLinkSmoothness);

	const addRoleHandler = () => {
		dispatch(
			showModal(ModalContentTypes.NEW_ROLE, {
				title: `Add New Role`,
				icon: MaterialIconNames.ACCOUNT,
				fromTemplate: false,
				fromPalette: true,
				action: ({ roleId, parentId }) => {
					const requestBody = {
						roleId,
						drillId,
						parentId: parentId !== DROPDOWN_DEFAULT && parentId > 0 ? parentId : 0,
						user
					};

					API.addRoleToDrill(requestBody, () => {
						// successfully added a subordinate
						API.getDrillById(
							drillId,
							{},
							(drill) => {
								// successfully updated selected drill
								dispatch(setSelectedDrill(drill));
							},
							(err) => {
								console.error(`Error when updating selected drill while adding new subordinate.`);
							}
						);
					});
					dispatch(closeModal());
				}
			})
		);
	};

	const addTaskHandler = () => {
		if (typeof selectedDrill.data === "undefined" || typeof selectedDrill.participants === "undefined") {
			return;
		}

		dispatch(
			showModal(ModalContentTypes.NEW_TASK, {
				title: `Add New Task`,
				icon: MaterialIconNames.TASK,
				fromTemplate: false,
				fromPalette: true,
				action: ({ description, roleId }) => {
					const requestBody = {
						drillId,
						description,
						roleId,
						user
					};

					API.addTaskToRole(requestBody, () => {
						API.getDrillById(drillId, {}, (drill) => {
							dispatch(setSelectedDrill(drill));
						});
					});
					dispatch(closeModal());
				}
			})
		);
	};

	const deleteAllHandler = () => {
		if (typeof selectedDrill.data === "undefined" || typeof selectedDrill.participants === "undefined") {
			return;
		}

		// get the root role, then delete it and all of its tasks/subordinates
		const { roleId, roleName } = selectedDrill.data;

		dispatch(
			showModal(ModalContentTypes.CONFIRMATION, {
				title: `Delete Role`,
				description: `Deleting this role will delete all of its subordinates and associated tasks. Are you sure you want to delete ${roleName}?`,
				icon: MaterialIconNames.DELETE_FOREVER,
				action: (role) => {
					const requestBody = {
						roleId,
						drillId,
						user
					};
					API.deleteRoleFromDrill(requestBody, () => {
						// successfully deleted root role
						API.getDrillById(drillId, {}, (drill) => {
							// successfully updated selected drill
							dispatch(setSelectedDrill(drill));
						});
					});
					dispatch(closeModal());
				}
			})
		);
	};

	const linkStyleHandler = (style) => {
		dispatch(setLinkStyle(style));
		diagram.createBattleDrill(selectedDrill, selectedTask);
	};

	const linkSmoothnessHandler = (smoothness) => {
		dispatch(setLinkSmoothness(smoothness));
		diagram.createBattleDrill(selectedDrill, selectedTask);
	};

	const onStartHandler = () => {
		dispatch(
			showModal(ModalContentTypes.CONFIRMATION, {
				icon: MaterialIconNames.START,
				title: `Drill: ${selectedDrill.name}`,
				description: "Are you sure you want to start this drill?",
				acceptText: "Start",
				action: () => {
					API.startDrill(drillId, user, (response) => {
						API.getDrillById(drillId, {}, (response) => {
							dispatch(setSelectedDrill(response));
						});
					});
					dispatch(closeModal());
				}
			})
		);
	};

	const onStopHandler = () => {
		dispatch(
			showModal(ModalContentTypes.CONFIRMATION, {
				icon: MaterialIconNames.STOP,
				title: `Stop drill "${selectedDrill.name}"?`,
				acceptText: "Stop",
				action: () => {
					API.stopDrill(drillId, user, (response) => {
						dispatch(setSelectedDrill(response));
						// remove this later and just transfer active drill to completed in Redux
						API.all({}, (res) => {
							dispatch(updateAllDrills(res));
							history.push(Routes.COMPLETED_DIAGRAM);
						});
					});
					dispatch(closeModal());
				}
			})
		);
	};

	const toggleLinkStylesHandler = () => {
		setShowLinkStyles(!showLinkStyles);
	};

	const toggleLinkSmoothnessHandler = () => {
		setShowLinkSmoothness(!showLinkSmoothness);
	};

	const renderLinkStyles = () => {
		const options = [LinkStyles.NORMAL, LinkStyles.MANHATTAN, LinkStyles.ORTHOGONAL, LinkStyles.METRO];
		return (
			showLinkStyles && (
				<span className="link-style-options-container">
					<ul className="link-style-options">
						{options.map((option, index) => {
							return (
								<li
									key={option + index}
									className="link-style-item"
									onClick={() => {
										linkStyleHandler(option);
									}}
								>
									<Icon>
										{option === linkStyle
											? MaterialIconNames.RADIO_BUTTON_CHECKED
											: MaterialIconNames.RADIO_BUTTON_UNCHECKED}
									</Icon>
									<span className="link-style-item-label">{option}</span>
								</li>
							);
						})}
					</ul>
				</span>
			)
		);
	};

	const renderLinkSmoothness = () => {
		if (showLinkSmoothness) {
			const options = [LinkSmoothness.NORMAL, LinkSmoothness.SMOOTH, LinkSmoothness.ROUNDED];
			return (
				<span className="link-style-options-container">
					<ul className="link-style-options">
						{options.map((option, index) => {
							return (
								<li
									key={option + index}
									className="link-style-item"
									onClick={() => {
										linkSmoothnessHandler(option);
									}}
								>
									<Icon>
										{option === linkSmoothness
											? MaterialIconNames.RADIO_BUTTON_CHECKED
											: MaterialIconNames.RADIO_BUTTON_UNCHECKED}
									</Icon>
									<span className="link-style-item-label">{option}</span>
								</li>
							);
						})}
					</ul>
				</span>
			);
		}
	};

	const renderStartStopButton = () => {
		if (typeof selectedDrill.startTime === "undefined") {
			return (
				<div className="editor-button" onClick={onStartHandler}>
					<Icon className={`green`} tooltip="Start Drill" tooltipPlacement={TooltipPlacement.BOTTOM}>
						{MaterialIconNames.START}
					</Icon>
				</div>
			);
		} else {
			return (
				<div className="editor-button" onClick={onStopHandler}>
					<Icon className={`red`} tooltip="Stop Drill" tooltipPlacement={TooltipPlacement.BOTTOM}>
						{MaterialIconNames.STOP}
					</Icon>
				</div>
			);
		}
	};

	const renderAddRoleButton = () => {
		return (
			<div
				className={`editor-button ${typeof selectedDrill.name === "undefined" ? "disabled" : ""}`}
				onClick={addRoleHandler}
			>
				<Icon>{MaterialIconNames.ADD}</Icon>
				<Icon>{MaterialIconNames.ACCOUNT}</Icon>
				<label className="editor-button-label">Role</label>
			</div>
		);
	};

	const renderAddTaskButton = () => {
		return (
			<div
				className={`editor-button ${
					typeof selectedDrill.name === "undefined" || typeof selectedDrill.participants === "undefined"
						? "disabled"
						: ""
				}`}
				onClick={addTaskHandler}
			>
				<Icon>{MaterialIconNames.ADD}</Icon>
				<Icon>{MaterialIconNames.TASK}</Icon>
				<label className="editor-button-label">Task</label>
			</div>
		);
	};

	const renderDeleteAllButton = () => {
		return (
			<div
				className={`editor-button ${
					typeof selectedDrill.name === "undefined" || typeof selectedDrill.participants === "undefined"
						? "disabled"
						: ""
				}`}
				onClick={deleteAllHandler}
			>
				<Icon tooltip="Delete All" tooltipPlacement={TooltipPlacement.BOTTOM}>
					{MaterialIconNames.DELETE_FOREVER}
				</Icon>
			</div>
		);
	};

	const renderLinkButtons = () => {
		return (
			<span className="link-style-container">
				<label className="link-style-label">Links</label>
				<span className="link-style-dropdown-container">
					<div ref={linkStylesRef} className="link-style-button" onClick={toggleLinkStylesHandler}>
						<span>Style: {linkStyle}</span>
					</div>
					{renderLinkStyles()}
				</span>
				<span className="link-style-dropdown-container">
					<div ref={linkSmoothnessRef} className="link-style-button" onClick={toggleLinkSmoothnessHandler}>
						<span>Smoothness: {linkSmoothness}</span>
					</div>
					{renderLinkSmoothness()}
				</span>
			</span>
		);
		{
			/* TODO: Add this later when we persist these on a user basis */
		}
		{
			// <span className="link-style-container">
			// 	<label className="link-style-label">
			// 		<Icon>{MaterialIconNames.STYLE}</Icon>Links
			// 	</label>
			// 	<span className="link-style-dropdown-container">
			// 		<div ref={linkStylesRef} className="link-style-button" onClick={toggleLinkStylesHandler}>
			// 			<span>Style: {linkStyle}</span>
			// 		</div>
			// 		{renderLinkStyles()}
			// 	</span>
			// 	<span className="link-style-dropdown-container">
			// 		<div ref={linkSmoothnessRef} className="link-style-button" onClick={toggleLinkSmoothnessHandler}>
			// 			<span>Smoothness: {linkSmoothness}</span>
			// 		</div>
			// 		{renderLinkSmoothness()}
			// 	</span>
			// </span>;
		}
		{
			/* <div
					className={`editor-button ${typeof selectedDrill.name === "undefined" ? "disabled" : ""}`}
					onClick={saveDrillTemplate}
				>
					<Icon>{MaterialIconNames.SAVE}</Icon>
				</div>
				<div className="editor-button" onClick={openTemplateManager}>
					<Icon>{MaterialIconNames.SETTINGS}</Icon>
					<label className="editor-button-label">Templates</label>
				</div> */
		}
	};

	const renderPaletteCommands = () => {
		return (
			typeof selectedDrill.name !== "undefined" && (
				<div className="diagram-palette-commands">
					{renderStartStopButton()}
					{renderAddRoleButton()}
					{renderAddTaskButton()}
					{renderLinkButtons()}
					{renderDeleteAllButton()}
				</div>
			)
		);
	};

	return <div className="diagram-palette-view">{renderPaletteCommands()}</div>;
};

export default DiagramPaletteView;
