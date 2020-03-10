import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Modal } from "./Modal";
import {
	CreateDrillContainer,
	Version,
	Confirmation,
	Settings,
	NewOwnerContainer,
	NewTaskContainer
} from "./ModalContent/index";
import { getModalContentType, getModalContentData, closeModal } from "REDUX/index";

export const ModalContentTypes = {
	NEW_DRILL: "NEW_DRILL",
	VERSION: "VERSION",
	CONFIRMATION: "CONFIRMATION",
	SETTINGS: "SETTINGS",
	NEW_OWNER: "NEW_OWNER",
	NEW_TASK: "NEW_TASK"
};

export const ModalContainer = () => {
	const [data, setData] = useState(null);
	const [disableSubmit, setDisableSubmit] = useState(false); // true means it is disabled
	const [validity, setValidity] = useState(null);
	const dispatch = useDispatch();
	const contentData = useSelector(getModalContentData);
	const contentType = useSelector(getModalContentType);

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
			case ModalContentTypes.SETTINGS:
				return (
					<Settings
						title={contentData.title}
						icon={contentData.icon}
						description={contentData.description}
						updateData={updateData}
					/>
				);
			case ModalContentTypes.NEW_OWNER:
				return (
					<NewOwnerContainer
						updateData={updateData}
						fromPalette={contentData.fromPalette}
						updateDisableSubmit={updateDisableSubmit}
						submit={submitModal}
					/>
				);
			case ModalContentTypes.NEW_TASK:
				return (
					<NewTaskContainer
						updateData={updateData}
						fromPalette={contentData.fromPalette}
						updateDisableSubmit={updateDisableSubmit}
						submit={submitModal}
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
					close={() => {
						dispatch(closeModal());
						setDisableSubmit(false);
					}}
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
