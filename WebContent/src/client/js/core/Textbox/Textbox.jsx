import React, { Component, createRef } from "react";
import PropTypes from "prop-types";
import "./Textbox.scss";

const DEFAULT_MAX_LENGTH = 200;

export class Textbox extends Component {
	constructor(props) {
		super(props);
		this.state = {
			value: ""
		};
		this.textareaRef = createRef();
	}

	componentWillReceiveProps(nextProps) {
		if (nextProps.clearText) {
			this.setState({ value: "" });
			// prop passed to set clearText back to false
			this.props.resetClearTextState();
			// reset the style on submit
			this.textareaRef.current.setAttribute("style", "");
			this.textareaRef.current.parentElement.setAttribute("style", "");
			this.textareaRef.current.value = "";
		}
	}

	onInputResize = (e) => {
		const { current } = this.textareaRef;
		current.setAttribute("style", "height: auto;overflow-y:hidden;");
		current.parentElement.setAttribute("style", "height: auto;");
		current.setAttribute("style", "height:" + (current.scrollHeight + 3) + "px;overflow-y:hidden;");
		current.parentElement.setAttribute("style", "height:" + current.scrollHeight + "px;");

		// 91 is equivalent of 5 rows, can change this later to pass in a prop to do any # of rows
		if (current.scrollHeight + 3 > 91) {
			current.setAttribute("style", "height: 91px;overflow-y:auto;");
			current.parentElement.setAttribute("style", "height: 91px;");
			current.scrollTop = current.scrollHeight;
		}
	};

	onTextareaChange = (e) => {
		this.setState(
			{
				value: e.target.value
			},
			() => {
				// use passed in prop method to update the parent's state
				this.props.onChange(this.state.value);
			}
		);
	};

	// require onKeyUp and onKeyDown for instance of someone keeping "enter" pressed
	// don't want to submit multiple times
	onKeyUp = (e) => {
		if (e.key === "Enter") {
			e.preventDefault();
			this.props.enterSubmit();

			return false;
		}
	};

	// do nothing while "enter" is pressed
	onKeyDown = (e) => {
		if (e.key === "Enter") {
			e.preventDefault();
			return false;
		}
	};

	render = () => {
		const placeholder = this.props.placeholder ? this.props.placeholder : "Enter text";
		const maxLength = this.props.maxLength ? this.props.maxLength : DEFAULT_MAX_LENGTH;
		const { focusOnMount } = this.props;
		const { value } = this.state;
		return (
			<div className="text-area-container">
				<textarea
					maxLength={maxLength}
					rows="1"
					autoFocus={focusOnMount}
					className="auto-size-textarea"
					onInput={this.onInputResize}
					placeholder={placeholder}
					onChange={this.onTextareaChange}
					onKeyUp={this.onKeyUp}
					onKeyDown={this.onKeyDown}
					value={value}
					ref={this.textareaRef}
				/>
			</div>
		);
	};
}

Textbox.propTypes = {
	focusOnMount: PropTypes.bool,
	maxLength: PropTypes.number,
	resetClearTextState: PropTypes.func.isRequired,
	onChange: PropTypes.func.isRequired,
	enterSubmit: PropTypes.func.isRequired,
	placeholder: PropTypes.string
};
