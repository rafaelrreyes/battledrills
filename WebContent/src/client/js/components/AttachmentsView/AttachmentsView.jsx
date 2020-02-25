import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { AttachmentsListView } from "COMPONENTS/";
import { FileInput, ModalContentTypes } from "CORE/";
import { getUser, addDrillAttachment, addTaskAttachment, editSelectedTaskNotes, showModal, closeModal } from "REDUX/";
import moment from "moment-timezone";
import { API, AutogenTypes, NoteTypes, AttachmentTypes, MaterialIconNames } from "UTILITIES/";
import { CancelToken } from "axios";

// scss
import "./AttachmentsView.scss";

const AttachmentsView = ({ selectedObject, type, collapsible = false }) => {

    const dispatch = useDispatch();

    const user = useSelector(getUser);

    const [file, setFile] = useState(null);
    const [filename, setFilename] = useState("");
    const [isUploading, setIsUploading] = useState(false);
    const [uploadProgress, setUploadProgress] = useState(0);
    const [source, setSource] = useState(CancelToken.source());

    const [collapsed, setCollapsed] = useState(() => { return collapsible ? true : false });

    useEffect(() => {
        setFile(null);
        setFilename("");
    }, [selectedObject]);

    const onFileAdded = (file, filename) => {
        setFile(file);
        setFilename(filename);
    };

    const attemptUpload = () => {

        // check if file exists, overwrite

        const requestBody = {
            params: {
                filename,
                type,
                id: type === AttachmentTypes.DRILL ? selectedObject.name : selectedObject.taskId
            }
        };

        API.checkAttachmentExists(requestBody, (data) => {
            const exists = data;
            if (exists) {
                dispatch(
                    showModal(ModalContentTypes.CONFIRMATION, {
                        title: `Attachment "${filename} exists. Do you want to overwrite it?`,
                        icon: MaterialIconNames.ATTACHMENT,
                        action: () => {
                            uploadAttachment(exists);
                            dispatch(closeModal());
                        }
                    })
                )
            } else {
                uploadAttachment(exists);
            }
        }, () => {
            // TODO error
        });
    };

    const uploadAttachment = (isOverwrite) => {
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

        API.uploadAttachment(formdata, config, () => {
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
                dispatch(editSelectedTaskNotes({
                    noteText: filename,
                    user,
                    type: NoteTypes.AUTO,
                    autoType: AutogenTypes.ATTACHMENT_UPLOAD,
                    timestampMillis: moment().unix()
                }));
            }
        }, () => {
            setIsUploading(false);
            setUploadProgress(0);
            console.error("Error when attempting to upload attachment: " + filename);
        });
    };

    const cancelUpload = () => {
        source.cancel("Cancelled upload");
        setIsUploading(false);
        setUploadProgress(0);
        setFile(null);
        setFilename("");
        setSource(CancelToken.source());
    };

    const renderUploadProgress = (uploadProgress) => {
        if (!collapsed) {
            return uploadProgress !== 0
                ? (
                    <div className="upload-progress">
                        <span className="upload-bar" style={{ width: `${uploadProgress}%`, height: `1.5em`}}>
                            <span className="upload-percentage">{`${uploadProgress}%`}</span>
                        </span>
                    </div>
                ) : null;
        }
    };

    const renderHeader = () => {
        if (collapsible) {
            return (
                <h1 className="attachments-header" style={{ cursor: `${collapsible ? 'pointer' : 'default'}`}} onClick={() => { setCollapsed(!collapsed); }}>
                    <span>Attachments</span>
                    <i className="material-icons">
                        {collapsed ? MaterialIconNames.ARROW_DROP_DOWN : MaterialIconNames.ARROW_UP}
                    </i>
                </h1>
            )
        }

        return (
            <h1 className="attachments-header">
                <span>Attachments</span>
            </h1>
        );
    };

    const renderAttachmentView = () => {
        if (!collapsed) {
            return (
                <>
                    <AttachmentsListView
                        attachmentType={type}
                        selectedObject={selectedObject}
                        user={user}
                    />
                    <FileInput
                        onFileAdded={onFileAdded}
                        resetDependency={selectedObject}
                        isDisabled={isUploading}
                        isUploading={isUploading}
                        onFileUploaded={attemptUpload}
                        cancelUpload={cancelUpload}
                    />
                </>
            );
        }
    }

    return (
        <div className="attachments-view">
            {renderHeader()}
            {renderAttachmentView()}
            {renderUploadProgress(uploadProgress)}
        </div>
    )
};

export default AttachmentsView;