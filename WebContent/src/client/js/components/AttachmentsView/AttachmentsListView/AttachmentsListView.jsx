import React from "react";
import { useDispatch } from "react-redux";
import { API, MaterialIconNames, AutogenTypes, NoteTypes, AttachmentTypes } from "UTILITIES/";
import { ModalContentTypes } from "CORE/";
import moment from "moment-timezone";

// scss
import "./AttachmentsListView.scss";
import { deleteDrillAttachment, deleteTaskAttachment, showModal, closeModal, editSelectedTaskNotes } from "REDUX/";

const FILENAME_MAX_LENGTH = 30;

const AttachmentsListView = ({ selectedObject, user }) => {

    const dispatch = useDispatch(); 
    const renderAttachments = () => {

        const { attachments } = selectedObject;
        if (typeof attachments === "undefined" || attachments.length === 0) {
            return <div className="no-attachments">
                No attachments.
            </div>
        }

        return attachments.map((attachment, index) => {
            return <li key={attachment.filename + index}>{renderAttachment(attachment)}</li>;
        });
    };
    
    const renderAttachment = (attachment) => {
        const { filename } = attachment;
        let displayFilename = filename;
        const mediaType = filename.substring(filename.lastIndexOf(".") + 1, filename.length);
        if (filename.length > FILENAME_MAX_LENGTH) {
            displayFilename = `${filename.substring(0, FILENAME_MAX_LENGTH)}...${mediaType}`;
        }

        return (
            <div className="attachment">
                <div className="attachment-flex">
                    <i className="material-icons attachment-icon">
                        {MaterialIconNames.ATTACHMENT}
                    </i>
                    <label className="attachment-label">
                        {displayFilename}
                    </label>
                </div>
                <div className="attachment-buttons">
                    <i className="material-icons" onClick={() => onDownloadClick(attachment)}>
                        {MaterialIconNames.DOWNLOAD}
                    </i>
                    <i className="material-icons" onClick={() => onDeleteClick(attachment)}>
                        {MaterialIconNames.DELETE}
                    </i>
                </div>
                
            </div>
        );
    };

    const onDownloadClick = (attachment) => {
        const { type, filename } = attachment;
        const id = type === AttachmentTypes.DRILL ? selectedObject.name : selectedObject.taskId;

        const requestBody = {
            params: {
                filename,
                id,
                type
            },
            responseType: "blob"
        };

        API.downloadAttachment(requestBody, (data) => {
            const url = window.URL.createObjectURL(new Blob([data], {
                type: "application/octet-stream"
            }));
            const a = document.createElement("a");
            a.href = url;
            a.download = filename;
            a.click();
            a.remove();
            window.URL.revokeObjectURL(url);
        });
    };

    const onDeleteClick = (attachment) => {
        dispatch(
            showModal(ModalContentTypes.CONFIRMATION, {
                title: `Delete attachment "${attachment.filename}"?`,
                icon: MaterialIconNames.DELETE,
                action: () => {
                    const { type, filename } = attachment;
                    const id = type === AttachmentTypes.DRILL ? selectedObject.name : selectedObject.taskId;
                    const requestBody = {
                        filename,
                        id,
                        type,
                        user
                    };

                    API.deleteAttachment(requestBody, () => {
                        if (type === AttachmentTypes.DRILL) {
                            dispatch(deleteDrillAttachment(filename));
                        } else if (type === AttachmentTypes.TASK) {
                            dispatch(deleteTaskAttachment(filename));
                            dispatch(editSelectedTaskNotes({
                                noteText: filename,
                                user,
                                type: NoteTypes.AUTO,
                                autoType: AutogenTypes.ATTACHMENT_DELETE,
                                timestampMillis: moment().unix()
                            }));
                        }
                    }, () => {
                        // TODO
                        console.error("Error when attempting to delete attachment: " + filename);
                    });
                    dispatch(closeModal());
                }
            })
        )
    };

    return (
        <div className="attachments-list-view">
            <ul className="attachments">
                {renderAttachments()}
            </ul>
        </div>
    )
};

export default AttachmentsListView;