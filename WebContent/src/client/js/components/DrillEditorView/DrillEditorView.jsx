import React, { useEffect, useState, useRef } from "react";
import ReactDOM from "react-dom";
import { useDispatch, useSelector } from "react-redux";
import joint from "jointjs/index";
import { createPaletteOptions } from "../../joint/DrillEditorUtils";
import { API, MaterialIconNames, LinkStyles, LinkSmoothness } from "UTILITIES";
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
	getLinkSmoothness,
	getLinkStyle
} from "REDUX";

import "./DrillEditorView.scss";

const DrillEditorView = ({ battleDrillDiagram, diagramGraph, diagramPaper }) => {
	const editorViewRef = useRef(null);
	const paletteGraph = new joint.dia.Graph();
	let palettePaper;

	const [showLinkStyles, setShowLinkStyles] = useState(false);
	const [showLinkSmoothness, setShowLinkSmoothness] = useState(false);

	const linkStylesRef = useClickOutside(() => {
		setShowLinkStyles(false);
	});
	const linkSmoothnessRef = useClickOutside(() => {
		setShowLinkSmoothness(false);
	});

	const dispatch = useDispatch();

	const user = useSelector(getUser);
	const selectedDrill = useSelector(getSelectedDrill);
	const selectedTask = useSelector(getSelectedTask);
	const drillName = selectedDrill.name;
	const linkStyle = useSelector(getLinkStyle);
	const linkSmoothness = useSelector(getLinkSmoothness);

	useEffect(() => {
		palettePaper = new joint.dia.Paper({
			el: ReactDOM.findDOMNode(editorViewRef.current),
			model: paletteGraph,
			height: 100, // TODO make this as big as it needs to be
			interactive: false
		});

		createPaletteOptions(battleDrillDiagram, diagramGraph, diagramPaper, paletteGraph, palettePaper);
	}, [diagramPaper, battleDrillDiagram]);

	const addRole = () => {
		dispatch(
			showModal(ModalContentTypes.NEW_OWNER, {
				title: `Add New Role`,
				icon: MaterialIconNames.ACCOUNT,
				fromTemplate: false,
				fromPalette: true,
				action: ({ role, parent }) => {
					const requestBody = {
						owner: role, // retrieved from drop down selection
						drillName,
						parent: parent !== DROPDOWN_DEFAULT && parent ? parent : null,
						user
					};

					API.addSubordinateToOwner(requestBody, () => {
						// successfully added a subordinate
						API.getDrillByName(
							drillName,
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

	const addTask = () => {
		if (typeof selectedDrill.data === "undefined" || typeof selectedDrill.participants === "undefined") {
			return;
		}

		dispatch(
			showModal(ModalContentTypes.NEW_TASK, {
				title: `Add New Task`,
				icon: MaterialIconNames.TASK,
				fromTemplate: false,
				fromPalette: true,
				action: ({ description, role }) => {
					const requestBody = {
						drillName,
						description,
						owner: role,
						user
					};

					API.addTaskToOwner(
						requestBody,
						() => {
							API.getDrillByName(drillName, {}, (drill) => {
								dispatch(setSelectedDrill(drill));
							});
						},
						(error) => {
							console.error(error);
						}
					);
					dispatch(closeModal());
				}
			})
		);
	};

	const deleteAll = () => {
		if (typeof selectedDrill.data === "undefined" || typeof selectedDrill.participants === "undefined") {
			return;
		}

		// get the root owner, then delete it and all of its tasks/subordinates
		const owner = selectedDrill.data.title;

		dispatch(
			showModal(ModalContentTypes.CONFIRMATION, {
				title: `Delete Role`,
				description: `Deleting this role will delete all of its subordinates and associated tasks. Are you sure you want to delete ${owner}?`,
				icon: MaterialIconNames.DELETE_FOREVER,
				action: (role) => {
					const requestBody = {
						owner,
						drillName,
						user
					};
					API.deleteOwner(requestBody, () => {
						// successfully deleted root owner
						API.getDrillByName(
							drillName,
							{},
							(drill) => {
								// successfully updated selected drill
								dispatch(setSelectedDrill(drill));
							},
							(err) => {
								console.error(`Error when updating selected drill when deleting role ${owner}.`);
							}
						);
					});
					dispatch(closeModal());
				}
			})
		);
	};

	const onChangeLinkStyle = (style) => {
		dispatch(setLinkStyle(style));
		battleDrillDiagram.createBattleDrill(selectedDrill, selectedTask);
	};

	const onChangeLinkSmoothness = (smoothness) => {
		dispatch(setLinkSmoothness(smoothness));
		battleDrillDiagram.createBattleDrill(selectedDrill, selectedTask);
	};

	const toggleLinkStyles = () => {
		setShowLinkStyles(!showLinkStyles);
	};

	const toggleLinkSmoothness = () => {
		setShowLinkSmoothness(!showLinkSmoothness);
	};

	const renderLinkStyles = () => {
		if (showLinkStyles) {
			const options = [LinkStyles.NORMAL, LinkStyles.MANHATTAN, LinkStyles.ORTHOGONAL, LinkStyles.METRO];
			return (
				<span className="link-style-options-container">
					<ul className="link-style-options">
						{options.map((option, index) => {
							return (
								<li
									key={option + index}
									className="link-style-item"
									onClick={() => {
										onChangeLinkStyle(option);
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
			);
		}
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
										onChangeLinkSmoothness(option);
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

	return (
		<div className="drill-editor-view">
			<div className="drill-editor-commands">
				<div
					className={`editor-button ${typeof selectedDrill.name === "undefined" ? "disabled" : ""}`}
					onClick={addRole}
				>
					<Icon>{MaterialIconNames.ADD}</Icon>
					<Icon>{MaterialIconNames.ACCOUNT}</Icon>
					<label className="editor-button-label">Role</label>
				</div>
				<div
					className={`editor-button ${
						typeof selectedDrill.name === "undefined" || typeof selectedDrill.participants === "undefined"
							? "disabled"
							: ""
					}`}
					onClick={addTask}
				>
					<Icon>{MaterialIconNames.ADD}</Icon>
					<Icon>{MaterialIconNames.TASK}</Icon>
					<label className="editor-button-label">Task</label>
				</div>
				<div
					className={`editor-button ${
						typeof selectedDrill.name === "undefined" || typeof selectedDrill.participants === "undefined"
							? "disabled"
							: ""
					}`}
					onClick={deleteAll}
				>
					<Icon tooltip="Delete All" tooltipPlacement={TooltipPlacement.BOTTOM}>
						{MaterialIconNames.DELETE_FOREVER}
					</Icon>
				</div>
				{/* TODO: Add this later when we persist these on a user basis */}
				{/* <span className="link-style-container">
					<label className="link-style-label">
						<Icon>{MaterialIconNames.STYLE}</Icon>Links
					</label>
					<span className="link-style-dropdown-container">
						<div ref={linkStylesRef} className="link-style-button" onClick={toggleLinkStyles}>
							<span>Style: {linkStyle}</span>
						</div>
						{renderLinkStyles()}
					</span>
					<span className="link-style-dropdown-container">
						<div ref={linkSmoothnessRef} className="link-style-button" onClick={toggleLinkSmoothness}>
							<span>Smoothness: {linkSmoothness}</span>
						</div>
						{renderLinkSmoothness()}
					</span>
				</span> */}
				{/* <div
					className={`editor-button ${typeof selectedDrill.name === "undefined" ? "disabled" : ""}`}
					onClick={saveDrillTemplate}
				>
					<Icon>{MaterialIconNames.SAVE}</Icon>
				</div>
				<div className="editor-button" onClick={openTemplateManager}>
					<Icon>{MaterialIconNames.SETTINGS}</Icon>
					<label className="editor-button-label">Templates</label>
				</div> */}
			</div>
			{/* <div className="palette" id="palette" ref={editorViewRef}></div> */}
		</div>
	);
};

export default DrillEditorView;
