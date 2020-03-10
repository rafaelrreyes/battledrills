import React, { useEffect, useState, useRef } from "react";
import ReactDOM from "react-dom";

import { useDispatch, useSelector } from "react-redux";
import joint from "jointjs/index";
import { createPaletteOptions } from "../../joint/DrillEditorUtils";
import { API, MaterialIconNames } from "UTILITIES/";
import { ModalContentTypes } from "CORE/";
import { getUser, getSelectedDrill, setSelectedDrill, showModal, closeModal } from "REDUX/";

import "./DrillEditorView.scss";

const DrillEditorView = ({ battleDrillDiagram, diagramGraph, diagramPaper }) => {
	const editorViewRef = useRef(null);
	const paletteGraph = new joint.dia.Graph();
	let palettePaper;

	const dispatch = useDispatch();

	const user = useSelector(getUser);
	const selectedDrill = useSelector(getSelectedDrill);
	const drillName = selectedDrill.name;

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
				fromPalette: true,
				action: ({ role, parent }) => {
					const requestBody = {
						owner: role, // retrieved from drop down selection
						drillName,
						parent: parent ? parent : null,
						user
					};

					API.addSubordinateToOwner(
						requestBody,
						() => {
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
						},
						(err) => {
							// console.error(`Error when adding a subordinate role to ${owner}`);
						}
					);
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
				title: `Are you sure you want to delete ${owner} and all of their subordinates and associated tasks?`,
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

	return (
		<div className="drill-editor-view">
			<div className="drill-editor-commands">
				<div className="editor-button" onClick={addRole}>
					<i className="material-icons">{MaterialIconNames.ACCOUNT}</i>
					Add Role
				</div>
				<div className="editor-button" onClick={addTask}>
					<i className="material-icons">{MaterialIconNames.TASK}</i>
					Add Task
				</div>
				<div className="editor-button" onClick={deleteAll}>
					<i className="material-icons">{MaterialIconNames.DELETE_FOREVER}</i>
					Delete All
				</div>
			</div>
			{/* <div className="palette" id="palette" ref={editorViewRef}></div> */}
		</div>
	);
};

export default DrillEditorView;
