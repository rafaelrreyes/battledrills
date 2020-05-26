import React, { useState, useEffect } from "react";
import { Input, InputSizes, InputTypes, ArrowTooltip, TooltipTypes, Icon } from "CORE";
import { ValidatorReasonCodes, isStringValid, undoParsedType } from "UTILITIES";
import "./CreateTemplateContainer.scss";

const MAX_TEMPLATE_STRING_SIZE = 50;

const CreateTemplateContainer = ({ title, submit, icon, templates, updateData, updateDisableSubmit }) => {
	const [templateType, setTemplateType] = useState("");
	const [error, setError] = useState({ isError: false });

	useEffect(() => {
		updateData(templateType);
	}, [templateType]);

	useEffect(() => {
		if (checkAlreadyExists(undoParsedType(templateType))) {
			setError({ isError: true, placement: "right", message: "Template already exists." });
		} else {
			const typeReasonCode = isStringValid(templateType, MAX_TEMPLATE_STRING_SIZE);
			setError(getTypeError(typeReasonCode));
		}
	}, [templateType]);

	useEffect(() => {
		const typeError = error.isError ? true : false;
		updateDisableSubmit(typeError);
	}, [error]);

	const onTypeChange = (value) => {
		setTemplateType(value);
	};

	const checkAlreadyExists = (type) => {
		if (templates.custom.indexOf(type) !== -1 || templates.default.indexOf(type) !== -1) {
			return true;
		}
		return false;
	};

	const getTypeError = (reasonCode) => {
		const errorObj = {
			isError: true,
			placement: "right"
		};

		switch (reasonCode) {
			case ValidatorReasonCodes.NULL:
				return {
					isError: null
				};
			case ValidatorReasonCodes.EMPTY:
				return {
					...errorObj,
					message: "Type cannot be blank"
				};
			case ValidatorReasonCodes.VALID:
				return {
					isError: false
				};
			case ValidatorReasonCodes.MAX_CHARACTERS:
				return {
					...errorObj,
					message: `Type has a max of ${MAX_TEMPLATE_STRING_SIZE} characters`
				};
			default:
				return {
					isError: false
				};
		}
	};

	return (
		<div className="create-template-container">
			{icon && <Icon className="s md-36">{icon}</Icon>}
			<span className="create-template-header">{title}</span>
			<div className="create-template-form">
				<ArrowTooltip
					title={error.isError ? error.message : ""}
					placement={error.placement}
					type={TooltipTypes.ERROR}
					open={true}
				>
					<Input
						inputType={InputTypes.REGULAR}
						inputSize={InputSizes.FILL}
						onChange={onTypeChange}
						focus={true}
						placeholder="Enter a template name"
						submit={submit}
						showError={error}
					/>
				</ArrowTooltip>
			</div>
		</div>
	);
};

export default CreateTemplateContainer;
