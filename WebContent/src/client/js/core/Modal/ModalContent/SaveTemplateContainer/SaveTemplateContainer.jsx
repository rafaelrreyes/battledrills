import React, { useState, useEffect } from "react";
import { Input, InputSizes, InputTypes, Icon } from "CORE";
import "./SaveTemplateContainer.scss";

const SaveTemplateContainer = ({ submit, icon, updateData, defaultValue, updateDisableSubmit }) => {
	const [templateType, setTemplateType] = useState(defaultValue ? defaultValue : "");
	const [error, setError] = useState({ isError: false });

	// TODO validation
	useEffect(() => {
		if (templateType === "") {
			updateDisableSubmit(true);
		} else {
			updateDisableSubmit(false);
		}
		updateData(templateType);
	}, [templateType]);

	const onTypeChange = (value) => {
		setTemplateType(value);
	};

	return (
		<div className="save-template-container">
			{icon && <Icon className="md-36">{icon}</Icon>}
			<span className="save-template-header">Save Template</span>
			<div className="save-template-form">
				<Input
					initValue={defaultValue}
					inputType={InputTypes.REGULAR}
					inputSize={InputSizes.LARGE}
					onChange={onTypeChange}
					focus={true}
					placeholder="Enter a template name"
					submit={submit}
					showError={error}
				/>
			</div>
		</div>
	);
};

export default SaveTemplateContainer;
