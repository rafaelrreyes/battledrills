import React, { useState, useEffect } from "react";
import PropTypes from "prop-types";
import { ArrowTooltip, TooltipTypes, TooltipPlacement } from "CORE";
import { Checkbox, CheckboxPlacement } from "CORE";
import { Dropdown, DropdownSizes, DropdownTypes, DROPDOWN_DEFAULT } from "CORE";
import { Input, InputSizes, InputTypes } from "CORE";
import { Icon } from "CORE";
import {
	API,
	parseAllTypes,
	undoParsedType,
	isDropdownValid,
	isStringValid,
	isLatLonAltValid,
	DrillTypes
} from "UTILITIES";
import { getTypeError, getNameError, getLatLonAltError } from "./CreateDrillHelper";
import "./CreateDrillContainer.scss";

export const CreateDrillContainer = (props) => {
	const [types, setTypes] = useState([]);
	const [name, setName] = useState(null);
	const [type, setType] = useState(null);
	const [lat, setLat] = useState("");
	const [lon, setLon] = useState("");
	const [alt, setAlt] = useState("");
	const [tilt, setTilt] = useState("");
	const [startDrill, setStartDrill] = useState(false);
	/**
	 * Error Object
	 * {
	 * 	isError: true/false,
	 * 	message: message for when isError is true
	 *  placement: where to put the tooltip
	 * }
	 */
	const [errors, setErrors] = useState({
		name: {},
		type: { isError: false },
		lat: { isError: false },
		lon: { isError: false },
		alt: { isError: false },
		tilt: { isError: false }
	});
	const { drillType, icon, title, submit, updateDisableSubmit, updateData, validity } = props;

	// this is run when "name", "type", "lat", "lon", "alt", "tilt", or "startDrill" receive changes
	useEffect(() => {
		const nameReasonCode = isStringValid(name, 51);
		const typeReasonCode = isDropdownValid(type);
		const latReasonCode = isLatLonAltValid(lat, "lat");
		const lonReasonCode = isLatLonAltValid(lon, "lon");
		const altReasonCode = isLatLonAltValid(alt, "alt");
		setErrors({
			name: getNameError(nameReasonCode, name),
			type: getTypeError(typeReasonCode),
			lat: getLatLonAltError(latReasonCode, "lat"),
			lon: getLatLonAltError(lonReasonCode, "lon"),
			alt: getLatLonAltError(altReasonCode, "alt")
		});

		updateData({ name, type: undoParsedType(type), lat, lon, alt, tilt, startDrill });
	}, [name, type, lat, lon, alt, tilt, startDrill]);

	// this is run when "errors" receives changes
	useEffect(() => {
		// name and type will only be null when it is initialized and "" at minimum when touched
		// these ternary operators are used to keep the form blue/good when the form first opens
		const nameError = errors.name.isError === null ? true : errors.name.isError;
		const typeError = errors.type.isError === null ? true : errors.type.isError;

		if (type === DROPDOWN_DEFAULT) {
			updateDisableSubmit(true);
		} else {
			updateDisableSubmit(
				nameError || typeError || errors.lat.isError || errors.lon.isError || errors.alt.isError
			);
		}
	}, [errors]);

	// this is run when the component mounts
	useEffect(() => {
		API.types({}, (response) => {
			if (drillType === DrillTypes.CUSTOM) {
				setTypes(parseAllTypes(response.custom));
			} else if (drillType === DrillTypes.DEFAULT) {
				setTypes(parseAllTypes(response.default));
			}
		});
	}, [drillType]);

	const onDropdownChange = (type) => {
		setType(type);
	};

	const onNameChange = (name) => {
		setName(name);
	};

	const onLatChange = (lat) => {
		setLat(lat);
	};

	const onLonChange = (lon) => {
		setLon(lon);
	};

	const onAltChange = (alt) => {
		setAlt(alt);
	};

	const onTiltChange = (tilt) => {
		setTilt(tilt);
	};

	return (
		<div className="create-list-container">
			{icon && <Icon className="md-36">{icon}</Icon>}
			{title && <div className="modal-title">{title}</div>}
			<div className="drill-type-dropdown">
				<ArrowTooltip
					title={errors.type.isError ? errors.type.message : ""}
					placement={TooltipPlacement.TOP}
					type={TooltipTypes.ERROR}
					open={true}
				>
					<Dropdown
						dropdownType={DropdownTypes.REGULAR}
						dropdownSize={DropdownSizes.FILL}
						options={types}
						onChange={onDropdownChange}
						firstOption="Select a drill type*"
						firstValid={false}
						showError={errors.type.isError}
					/>
				</ArrowTooltip>
			</div>
			<div className="drill-name-container">
				<Input
					inputType={InputTypes.REGULAR}
					inputSize={InputSizes.FILL}
					onChange={onNameChange}
					submit={submit}
					focus={true}
					placeholder="Drill Name*"
					error={errors.name}
				/>
			</div>
			<div className="drill-location-container">
				<div className="latitude-input">
					<ArrowTooltip
						title={errors.lat.isError ? errors.lat.message : ""}
						placement={TooltipPlacement.LEFT}
						type={TooltipTypes.ERROR}
						open={true}
					>
						<Input
							inputType={InputTypes.REGULAR}
							inputSize={InputSizes.MEDIUM}
							onChange={onLatChange}
							submit={submit}
							placeholder="Latitude"
							error={errors.lat}
						/>
					</ArrowTooltip>
				</div>
				<Input
					inputType={InputTypes.REGULAR}
					inputSize={InputSizes.MEDIUM}
					onChange={onLonChange}
					submit={submit}
					placeholder="Longitude"
					error={errors.lon}
				/>
			</div>
			<div className="drill-location-container">
				<div className="latitude-input">
					<ArrowTooltip
						title={errors.alt.isError ? errors.alt.message : ""}
						placement={TooltipPlacement.LEFT}
						type={TooltipTypes.ERROR}
						open={true}
					>
						<Input
							inputType={InputTypes.REGULAR}
							inputSize={InputSizes.MEDIUM}
							onChange={onAltChange}
							submit={submit}
							placeholder="Altitude"
							error={errors.alt}
						/>
					</ArrowTooltip>
				</div>
				<Input
					inputType={InputTypes.REGULAR}
					inputSize={InputSizes.MEDIUM}
					onChange={onTiltChange}
					submit={submit}
					placeholder="Tilt"
				/>
			</div>
			<div className="start-drill-container">
				<Checkbox
					boxPosition={CheckboxPlacement.LEFT}
					label="Start drill on creation?"
					onChangeHandler={(checked) => {
						setStartDrill(checked);
					}}
					initChecked={false}
				/>
			</div>
		</div>
	);
};

CreateDrillContainer.propTypes = {
	updateData: PropTypes.func.isRequired,
	updateDisableSubmit: PropTypes.func.isRequired,
	icon: PropTypes.string,
	title: PropTypes.string,
	submit: PropTypes.func
};

export default CreateDrillContainer;
