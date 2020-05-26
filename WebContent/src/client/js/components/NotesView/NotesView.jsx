import React, { useEffect, useRef } from "react";
import { STATUS_TYPES, isObjectEmpty, NoteTypes, AutogenTypes, iso8061ToReadable } from "UTILITIES/";
import NotesTextbox from "./NotesTextbox/NotesTextbox";
import moment from "moment";
import "./NotesView.scss";

const scrollToBottom = (listRef) => {
	listRef.current.scrollTop = listRef.current.scrollHeight;
};

const renderNotes = (notes) => {
	if (typeof notes === "undefined") {
		return <div>No notes available</div>;
	}

	return notes.map((note, index) => {
		const { user } = note;
		return (
			<li key={index} className="notes-view-item">
				<div className="notes-view-header">
					<span className="notes-view-sender">{user.username ? user.username : "Unknown User"}</span>
					<span className="notes-view-timestamp">
						{note.timestamp
							? iso8061ToReadable(note.timestamp, "MMMM Do, YYYY hh:mm a")
							: "No Date Available"}
					</span>
				</div>
				<div className="notes-view-text">{renderDerivedNoteText(note)}</div>
			</li>
		);
	});
};

const renderDerivedNoteText = (note) => {
	if (isObjectEmpty(note)) {
		return null;
	}
	const { type, noteText, user } = note;
	if (type === NoteTypes.AUTO) {
		switch (note.autoType) {
			case AutogenTypes.STATUS_CHANGE:
				const noteTextLower = noteText.toLowerCase();
				if ([STATUS_TYPES.IN_PROGRESS, STATUS_TYPES.BLOCKED, STATUS_TYPES.COMPLETED].includes(noteTextLower)) {
					return (
						<>
							{`${user.username} changed status to: `}
							<span className={`notes-view-automated-label-${noteTextLower}`}>
								{noteText.replace("-", " ")}
							</span>
						</>
					);
				}
			case AutogenTypes.ATTACHMENT_UPLOAD:
				return <>{`${user.username} uploaded attachment: ${noteText}`}</>;
			case AutogenTypes.ATTACHMENT_DELETE:
				return <>{`${user.username} deleted attachment: ${noteText}`}</>;
			default:
				break;
		}
	}
	return note.noteText;
};

const NotesView = ({ taskId, user, notes, showTextbox }) => {
	const listRef = useRef(null);

	useEffect(() => {
		scrollToBottom(listRef);
	});

	return (
		<div className="notes-view">
			<ul className="notes-view-list" ref={listRef}>
				{renderNotes(notes)}
			</ul>
			{showTextbox && (
				<NotesTextbox
					taskId={taskId}
					user={user}
					scrollToBottom={() => {
						scrollToBottom(listRef);
					}}
				/>
			)}
		</div>
	);
};

export default NotesView;
