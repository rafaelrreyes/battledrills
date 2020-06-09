import React from "react";
import store from "REDUX/store";
import { MaterialIconNames, AttachmentTypes, API, NoteTypes } from "UTILITIES";
import { Icon, ModalContentTypes } from "CORE";
import { showModal, closeModal, editSelectedTaskNotes, deleteDrillAttachment, deleteTaskAttachment } from "REDUX";

import "./AttachmentsListViewItem.scss";

const FILENAME_MAX_LENGTH = 30;

const AttachmentsListViewItem = ({ attachment, selectedObject, user }) => {
	return (
		<div className="attachment">
			<div className="attachment-flex">
				<Icon className="attachment-icon">{MaterialIconNames.ATTACHMENT}</Icon>
				<label className="attachment-label">{getDisplayName(attachment.filename)}</label>
			</div>
			<div className="attachment-buttons">
				<Icon onClick={() => onDownloadClick(attachment, selectedObject)}>{MaterialIconNames.DOWNLOAD}</Icon>
				<Icon onClick={() => onDeleteClick(attachment, selectedObject, user)}>{MaterialIconNames.DELETE}</Icon>
			</div>
		</div>
	);
};

const getDisplayName = (filename) => {
	const mediaType = filename.substring(filename.lastIndexOf(".") + 1, filename.length);
	return filename.length > FILENAME_MAX_LENGTH
		? `${filename.substring(0, FILENAME_MAX_LENGTH)}...${mediaType}`
		: filename;
};

const getObjectId = (type, selectedObject) => {
	return type === AttachmentTypes.DRILL ? selectedObject.name : selectedObject.taskId;
};

const onDownloadClick = (attachment, selectedObject) => {
	const { filename, type } = attachment;
	const requestBody = {
		params: { filename, id: getObjectId(type, selectedObject), type },
		responseType: "blob"
	};

	API.downloadAttachment(requestBody, (data) => {
		const url = window.URL.createObjectURL(
			new Blob([data], {
				type: "application/octet-stream"
			})
		);
		const a = document.createElement("a");
		a.href = url;
		a.download = filename;
		a.click();
		a.remove();
		window.URL.revokeObjectURL(url);
	});
};

const onDeleteClick = (attachment, selectedObject, user) => {
	store.dispatch(
		showModal(ModalContentTypes.CONFIRMATION, {
			title: `Delete attachment "${attachment.filename}`,
			icon: MaterialIconNames.DELETE,
			action: () => {
				const { type, filename } = attachment;
				// id can either be the name of the drill, or the id of a task
				const requestBody = {
					filename,
					id: getObjectId(type, selectedObject),
					type,
					user
				};

				API.deleteAttachment(requestBody, () => {
					if (type === AttachmentTypes.DRILL) {
						store.dispatch(deleteDrillAttachment(filename));
					} else if (type === AttachmentTypes.TASK) {
						store.dispatch(deleteTaskAttachment(filename));

						// create an automated note
						store.dispatch(
							editSelectedTaskNotes({
								noteText: filename,
								user,
								type: NoteTypes.AUTO,
								autoType: AutogenTypes.ATTACHMENT_DELETE,
								timestampMillis: moment().unix()
							})
						);
					}
				});
				store.dispatch(closeModal());
			}
		})
	);
};

export default AttachmentsListViewItem;
