import React, { useState, useRef } from "react";
import { MaterialIconNames } from "UTILITIES";
import { Icon } from "CORE";
import PropTypes from "prop-types";

// scss
import "./FileDropzone.scss";

// I am just adding this for now, but we can always update it later.
// This was a very early prototype and I thought it was fun to make
const FileDropzone = ({ onFileAdded }) => {
	const [highlight, setHighlight] = useState(false);
	const [filename, setFilename] = useState("No attachment selected");
	const fileInputRef = useRef();

	const openDirectoryDialog = (e) => {
		fileInputRef.current.click();
	};

	const onFileAddedHandler = (e) => {
		const file = e.target.files[0];
		const filename = file.name;

		// propagate to parent component caller
		onFileAdded(file, filename);
		setFilename(filename);
	};

	const onDragOverHandler = (e) => {
		e.preventDefault();
		setHighlight(true);
	};

	const onDropHandler = (e) => {
		e.preventDefault();
		const file = e.dataTransfer.files[0];
		const filename = file.name;
		onFileAdded(file, filename);
		setFilename(filename);

		// set state of file string here
	};

	const onDragLeave = (e) => {
		setHighlight(false);
	};

	return (
		<div
			className={`file-dropzone ${highlight ? "highlight" : ""}`}
			onClick={openDirectoryDialog}
			onDragOver={onDragOverHandler}
			onDrop={onDropHandler}
			onDragLeave={onDragLeave}
		>
			<Icon className="icon">{MaterialIconNames.ATTACHMENT_ADD}</Icon>
			<input
				onClick={preventBubble}
				ref={fileInputRef}
				className="file-input"
				type="file"
				onChange={onFileAddedHandler}
			/>
			<div className="file-dropzone-label">{filename}</div>
		</div>
	);
};

const preventBubble = (e) => {
	e.stopPropagation();
};

export default FileDropzone;

FileDropzone.propTypes = {
	onFileAdded: PropTypes.func.isRequired
};
