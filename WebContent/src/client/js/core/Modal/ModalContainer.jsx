import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Modal } from "./Modal";
import {
	CreateDrillContainer,
	Version,
	Confirmation,
	NewRoleContainer,
	NewTaskContainer,
	CreateTemplateContainer,
	SaveTemplateContainer,
	ManageTemplatesContainer,
	ConfigureTasksContainer
} from "./ModalContent/";
import { getModalContentType, getModalContentData, closeModal } from "REDUX";

export const ModalContentTypes = {
	NEW_DRILL: "NEW_DRILL",
	VERSION: "VERSION",
	CONFIRMATION: "CONFIRMATION",
	NEW_ROLE: "NEW_ROLE",
	NEW_TASK: "NEW_TASK",
	CREATE_TEMPLATE: "CREATE_TEMPLATE",
	SAVE_TEMPLATE: "SAVE_TEMPLATE",
	MANAGE_TEMPLATES: "MANAGE_TEMPLATES",
	CONFIGURE_TASKS: "CONFIGURE_TASKS"
};

export const ModalContainer = () => {
	const [data, setData] = useState(null);
	const [disableSubmit, setDisableSubmit] = useState(false); // true means it is disabled
	const [validity, setValidity] = useState(null);
	const dispatch = useDispatch();
	const contentData = useSelector(getModalContentData);
	const contentType = useSelector(getModalContentType);

	const close = () => {
		// if cancel action is specified, do that instead, can be whatever developer specifies
		if (contentData.hasOwnProperty("cancelAction") && contentData.cancelAction) {
			contentData.cancelAction();
		} else {
			dispatch(closeModal());
			setDisableSubmit(false);
		}
	};

	const submitModal = () => {
		if (!disableSubmit && contentData.hasOwnProperty("action") && contentData.action) {
			// action returns an error if the server refuses the data sent
			setValidity(contentData.action(data));
		} else {
			console.log("No action was given to the submit button of the Modal or Submit is disabled.");
		}
	};

	const updateData = (data) => {
		setData(data);
	};

	const updateDisableSubmit = (disableSubmit) => {
		setDisableSubmit(disableSubmit);
	};

	const modalToRender = (contentType, contentData) => {
		switch (contentType) {
			case ModalContentTypes.NEW_DRILL:
				return (
					<CreateDrillContainer
						updateData={updateData}
						updateDisableSubmit={updateDisableSubmit}
						title={contentData.title}
						icon={contentData.icon}
						validity={validity}
						drillType={contentData.drillType}
						submit={submitModal} //this is for submitting on "enter" key press
					/>
				);
			case ModalContentTypes.VERSION:
				return <Version title={contentData.title} icon={contentData.icon} />;
			case ModalContentTypes.CONFIRMATION:
				return (
					<Confirmation
						title={contentData.title}
						icon={contentData.icon}
						description={contentData.description}
					/>
				);
			case ModalContentTypes.NEW_ROLE:
				return (
					<NewRoleContainer
						{...contentData}
						updateData={updateData}
						updateDisableSubmit={updateDisableSubmit}
						submit={submitModal}
					/>
				);
			case ModalContentTypes.NEW_TASK:
				return (
					<NewTaskContainer
						{...contentData}
						updateData={updateData}
						updateDisableSubmit={updateDisableSubmit}
						submit={submitModal}
					/>
				);
			case ModalContentTypes.CREATE_TEMPLATE:
				return (
					<CreateTemplateContainer
						title={contentData.title}
						updateData={updateData}
						templates={contentData.templates}
						updateDisableSubmit={updateDisableSubmit}
						icon={contentData.icon}
						submit={submitModal}
					/>
				);
			case ModalContentTypes.SAVE_TEMPLATE:
				return (
					<SaveTemplateContainer
						defaultValue={contentData.defaultValue}
						updateData={updateData}
						updateDisableSubmit={updateDisableSubmit}
						icon={contentData.icon}
						submit={submitModal}
					/>
				);
			case ModalContentTypes.MANAGE_TEMPLATES:
				return <ManageTemplatesContainer title={contentData.title} icon={contentData.icon} />;
			case ModalContentTypes.CONFIGURE_TASKS:
				return (
					<ConfigureTasksContainer
						{...contentData}
						updateData={updateData}
						title={contentData.title}
						icon={contentData.icon}
					/>
				);
			default:
				return (
					<Confirmation
						title={contentData.title}
						icon={contentData.icon}
						description={contentData.description}
					/>
				);
		}
	};

	let singleButton = false;
	let acceptText = "Submit";
	if (contentData) {
		singleButton = contentData.singleButton ? contentData.singleButton : false;
		acceptText = contentData.acceptText ? contentData.acceptText : "Submit";
	}

	return (
		<>
			{contentType !== null && (
				<Modal
					disable={disableSubmit}
					close={close}
					submit={submitModal}
					singleButton={singleButton}
					acceptText={acceptText}
				>
					{modalToRender(contentType, contentData)}
				</Modal>
			)}
		</>
	);
};
