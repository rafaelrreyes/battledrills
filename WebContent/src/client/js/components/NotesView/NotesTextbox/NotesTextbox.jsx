import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { Textbox, Icon } from "CORE";
import { API, MaterialIconNames, isMaxCharacters, isTextEmpty } from "UTILITIES";

import { editSelectedTaskNotes } from "REDUX";

const MAX_CHARACTERS_ALLOWED = 100;

const NotesTextbox = ({ taskId, user, scrollToBottom }) => {
	const [note, setNote] = useState("");
	const [clearText, setClearText] = useState(false);

	const dispatch = useDispatch();

	const taskNoteChangeHandler = (value) => {
		setNote(value);
	};

	const resetTextHandler = () => {
		setClearText(false);
	};

	const checkCharacterLimit = () => {
		if (isMaxCharacters(note, MAX_CHARACTERS_ALLOWED)) {
			return "error-character-limit";
		}
	};

	const submitHandler = () => {
		if (isMaxCharacters(note, MAX_CHARACTERS_ALLOWED + 1) || isTextEmpty(note)) {
			return;
		}
		const requestPayload = {
			taskId,
			user,
			noteText: note
		};

		API.addTaskNote(requestPayload, (response) => {
			//create a notification here
			//clear out the input field
			dispatch(editSelectedTaskNotes(response));
			scrollToBottom();
			setNote("");
			setClearText(true);
		});
	};

	return (
		<div className="message-container">
			<div className="notes-message">
				<Textbox
					focusOnMount={false}
					placeholder="Enter message"
					onChange={taskNoteChangeHandler}
					clearText={clearText}
					enterSubmit={submitHandler}
					resetClearTextState={resetTextHandler}
				/>
				<button
					className="no-button"
					onClick={submitHandler}
					disabled={isMaxCharacters(note, MAX_CHARACTERS_ALLOWED + 1) || isTextEmpty(note)}
				>
					<Icon className="md-24 notes-send-icon">{MaterialIconNames.SEND}</Icon>
				</button>
			</div>
			<div className={`character-limit ${checkCharacterLimit()}`}>
				{note.length}/{`${MAX_CHARACTERS_ALLOWED}`}
			</div>
		</div>
	);
};

export default NotesTextbox;
