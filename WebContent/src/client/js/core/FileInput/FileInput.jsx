import React, { useState, useRef, useEffect } from "react";
import { MaterialIconNames } from "UTILITIES";
import { Button, ButtonSizes, ButtonTypes, Icon } from "CORE";
import PropTypes from "prop-types";

// scss
import "./FileInput.scss";

const FileInput = ({
	onFileAdded,
	isDisabled,
	isUploading,
	resetDependency,
	onFileUploaded,
	onCancelUpload,
	maxCharacterLength
}) => {
	const fileInputRef = useRef();

	const [hasFile, setHasFile] = useState(false);
	const [filename, setFilename] = useState("");

	useEffect(() => {
		clearAttachmentHandler();
	}, [resetDependency]);

	const onDisplayDialog = () => {
		fileInputRef.current.click();
	};

	const renderAttachFile = () => {
		return <div className="attach-file">{renderFileName()}</div>;
	};

	const renderFileName = () => {
		let filenameDisplay = filename;
		if (filename.length > maxCharacterLength) {
			const type = fileInputRef.current.files[0].type.split("/")[1];

			filenameDisplay = filename.substring(0, maxCharacterLength) + "...." + type;
		}

		return filename === "" ? null : (
			<div className="file-attached">
				<Icon>{MaterialIconNames.ATTACH_FILE}</Icon>
				<label className="filename">{filenameDisplay}</label>
			</div>
		);
	};

	const onFileChangeHandler = (e) => {
		const targetFile = e.target.files[0];
		const filename = targetFile.name;

		setHasFile(true);
		setFilename(filename);
		onFileAdded(targetFile, filename);
	};

	const upload = () => {
		// only upload when file input is populated
		if (fileInputRef.current.files.length === 0) {
			return;
		}

		// perform upload callback
		onFileUploaded();

		// clear the file input
		clearAttachmentHandler();
	};

	const clearAttachmentHandler = () => {
		fileInputRef.current.value = null;
		setHasFile(false);
		setFilename("");
	};

	const renderClearButton = () => {
		return (
			<Button onClick={clearAttachmentHandler} buttonSize={ButtonSizes.XXSMALL} buttonType={ButtonTypes.GREY}>
				<Icon>{MaterialIconNames.CLOSE}</Icon>
			</Button>
		);
	};

	const renderCancelButton = () => {
		return (
			<Button onClick={onCancelUpload} buttonSize={ButtonSizes.XXSMALL} buttonType={ButtonTypes.GREY}>
				<Icon>{MaterialIconNames.CANCEL}</Icon>
			</Button>
		);
	};

	return (
		<div className="file-input">
			<input className="file-input-element" type="file" ref={fileInputRef} onChange={onFileChangeHandler} />
			<div className="file-commands">
				<Button onClick={onDisplayDialog} buttonSize={ButtonSizes.SMALL} isDisabled={isDisabled || isUploading}>
					Browse Files
				</Button>
				<div className="file-upload-commands">
					<Button onClick={upload} isDisabled={!hasFile} buttonSize={ButtonSizes.XXSMALL}>
						<Icon>{MaterialIconNames.UPLOAD}</Icon>
					</Button>
					{isUploading ? renderCancelButton() : renderClearButton()}
				</div>
			</div>
			{renderAttachFile()}
		</div>
	);
};

export default FileInput;

FileInput.defaultProps = {
	isDisabled: false,
	isUploading: false,
	maxCharacterLength: 40
};

FileInput.propTypes = {
	onFileAdded: PropTypes.func.isRequired,
	isDisabled: PropTypes.bool,
	isUploading: PropTypes.bool,
	resetDependency: PropTypes.object.isRequired,
	onFileUploaded: PropTypes.func.isRequired,
	onCancelUpload: PropTypes.func.isRequired,
	maxCharacterLength: PropTypes.number
};
