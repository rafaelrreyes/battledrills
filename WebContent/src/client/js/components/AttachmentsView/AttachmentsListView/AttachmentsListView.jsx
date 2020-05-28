import React from "react";

import AttachmentsListViewItem from "./AttachmentsListViewItem";

// scss
import "./AttachmentsListView.scss";

const AttachmentsListView = ({ selectedObject, user }) => {
	const renderAttachments = () => {
		const { attachments } = selectedObject;
		if (typeof attachments === "undefined" || attachments.length === 0) {
			return <div className="no-attachments">No attachments.</div>;
		}

		return attachments.map((attachment, index) => {
			return (
				<li key={attachment.filename + index}>
					<AttachmentsListViewItem attachment={attachment} selectedObject={selectedObject} user={user} />
				</li>
			);
		});
	};

	return (
		<div className="attachments-list-view">
			<ul className="attachments">{renderAttachments()}</ul>
		</div>
	);
};

export default AttachmentsListView;
