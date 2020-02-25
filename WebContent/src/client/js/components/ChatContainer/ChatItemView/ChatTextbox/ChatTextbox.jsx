import React, { useState } from "react";
import { Textbox } from "CORE/index";

//scss

const ChatTextbox = ({ clearMessage, onSubmitMessage, onClearMessage }) => {
	const [message, setMessage] = useState("");

	return (
		<div className="open-chats-view-item-input">
			<Textbox
				focusOnMount={true}
				placeholder="Enter message..."
				maxLength={100}
				onChange={(newMessage) => {
					setMessage(newMessage);
				}}
				clearText={clearMessage}
				enterSubmit={() => {
					onSubmitMessage(message);
					setMessage("");
				}}
				resetClearTextState={onClearMessage}
			/>
		</div>
	);
};

export default ChatTextbox;
