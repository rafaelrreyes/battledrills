import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import AttachmentsListView from "./AttachmentsListView/AttachmentsListView";
import { FileInput, ModalContentTypes, Icon } from "CORE";
import { getUser, addDrillAttachment, addTaskAttachment, editSelectedTaskNotes, showModal, closeModal } from "REDUX";
import moment from "moment-timezone";
import { API, AutogenTypes, NoteTypes, AttachmentTypes, MaterialIconNames } from "UTILITIES";
import { CancelToken } from "axios";

// scss
import "./AttachmentsView.scss";

const AttachmentsView = ({ selectedObject, type, isCollapsible = false }) => {
	const dispatch = useDispatch();

	const user = useSelector(getUser);

	const [file, setFile] = useState(null);
	const [filename, setFilename] = useState("");
	const [isUploading, setIsUploading] = useState(false);
	const [uploadProgress, setUploadProgress] = useState(0);
	const [source, setSource] = useState(CancelToken.source());

	const [isCollapsed, setIsCollapsed] = useState(() => {
		return isCollapsible ? true : false;
	});

	useEffect(() => {
		setFile(null);
		setFilename("");
	}, [selectedObject]);

	const setFileHandler = (file, filename) => {
		setFile(file);
		setFilename(filename);
	};

	const attemptUploadHandler = () => {
		// check if file exists, overwrite

		const requestBody = {
			params: {
				filename,
				type,
				id: type === AttachmentTypes.DRILL ? selectedObject.name : selectedObject.taskId
			}
		};

		API.checkAttachmentExists(requestBody, (data) => {
			// if data exists, overwrite
			const isOverwrite = data ? true : false;
			if (isOverwrite) {
				dispatch(
					showModal(ModalContentTypes.CONFIRMATION, {
						title: `Attachment "${filename} exists. Do you want to overwrite it?`,
						icon: MaterialIconNames.ATTACHMENT,
						action: () => {
							uploadHandler(true);
							dispatch(closeModal());
						}
					})
				);
			} else {
				uploadHandler(false);
			}
		});
	};

	const uploadHandler = (isOverwrite) => {
		setIsUploading(true);
		const formdata = new FormData();
		formdata.append("file", file);

		// drill or task
		formdata.append("id", type === AttachmentTypes.DRILL ? selectedObject.name : selectedObject.taskId);
		formdata.append("type", type);

		// use blob for form data must be passed with its own content
		const userJson = JSON.stringify(user);
		const blob = new Blob([userJson], {
			type: "application/json"
		});
		formdata.append("uploader", blob);

		const config = {
			headers: {
				"content-type": "multipart/form-data"
			},
			onUploadProgress: (progress) => {
				let percentComplete = Math.round((progress.loaded * 100) / progress.total);
				setUploadProgress(percentComplete);
				if (percentComplete === 100) {
					setIsUploading(false);
					setUploadProgress(0);
					setFile(null);
					setFilename("");
				}
			},
			cancelToken: source.token
		};

		API.uploadAttachment(
			formdata,
			config,
			() => {
				const dispatchObject = {
					type,
					uploader: user.role,
					filename,
					lastModifiedEpoch: moment().unix()
				};

				// Only update reducer if it isn't an overwrite
				// but we do want to atleast show the note for overwrite uploads
				if (type === AttachmentTypes.DRILL) {
					!isOverwrite && dispatch(addDrillAttachment(dispatchObject));
				} else {
					!isOverwrite && dispatch(addTaskAttachment(dispatchObject));
					dispatch(
						editSelectedTaskNotes({
							noteText: filename,
							user,
							type: NoteTypes.AUTO,
							autoType: AutogenTypes.ATTACHMENT_UPLOAD,
							timestampMillis: moment().unix()
						})
					);
				}
			},
			() => {
				setIsUploading(false);
				setUploadProgress(0);
				console.error("Error when attempting to upload attachment: " + filename);
			}
		);
	};

	const cancelUploadHandler = () => {
		source.cancel("Cancelled upload");
		setIsUploading(false);
		setUploadProgress(0);
		setFile(null);
		setFilename("");
		setSource(CancelToken.source());
	};

	const renderUploadProgress = (uploadProgress) => {
		return (
			!isCollapsed &&
			uploadProgress !== 0 && (
				<div className="upload-progress">
					<span className="upload-bar" style={{ width: `${uploadProgress}%`, height: `1.5em` }}>
						<span className="upload-percentage">{`${uploadProgress}%`}</span>
					</span>
				</div>
			)
		);
	};

	const renderHeader = () => {
		let header = isCollapsible ? (
			<h1
				className="attachments-header"
				style={{ cursor: `${isCollapsible ? "pointer" : "default"}` }}
				onClick={() => {
					setIsCollapsed(!isCollapsed);
				}}
			>
				<span>Attachments</span>
				<Icon>{isCollapsed ? MaterialIconNames.ARROW_DROP_DOWN : MaterialIconNames.ARROW_UP}</Icon>
			</h1>
		) : (
			<h1 className="attachments-header">
				<span>Attachments</span>
			</h1>
		);

		return header;
	};

	const renderAttachmentView = () => {
		return (
			!isCollapsed && (
				<>
					<AttachmentsListView attachmentType={type} selectedObject={selectedObject} user={user} />
					<FileInput
						onFileAdded={setFileHandler}
						resetDependency={selectedObject}
						isDisabled={isUploading}
						isUploading={isUploading}
						onFileUploaded={attemptUploadHandler}
						onCancelUpload={cancelUploadHandler}
					/>
				</>
			)
		);
	};

	return (
		<div className="attachments-view">
			{renderHeader()}
			{renderAttachmentView()}
			{renderUploadProgress(uploadProgress)}
		</div>
	);
};

export default AttachmentsView;
