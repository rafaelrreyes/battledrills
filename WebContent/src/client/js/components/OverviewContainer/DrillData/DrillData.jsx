import React, { useCallback, useState, useEffect } from "react";
import {
	MaterialIconNames,
	iso8061ToReadable,
	parseType,
	AttachmentTypes,
	saveTemplateByDrillId,
	API
} from "UTILITIES";
import { conditionalTooltipRender, Icon, Input, InputSizes } from "CORE";
import { AttachmentsView } from "COMPONENTS";
import "./DrillData.scss";

const DrillData = ({
	isEditingDrill = false,
	onDrillNameChange = () => {},
	drillInfo,
	activeDrills,
	elapsedTime,
	startDrill,
	stopDrill,
	deleteDrill
}) => {
	const [drillName, setDrillName] = useState(drillInfo.name);
	const [drillNameRef, setDrillNameRef] = useState(null);
	const [drillTypeRef, setDrillTypeRef] = useState(null);

	useEffect(() => {
		onDrillNameChange(drillName);
	}, [drillName]);

	// not using useRef here because the object ref doesn't notify about changes to the current ref value
	// in this case, you could use useRef, but I use the callback for an example (:
	const drillNameRefCallback = useCallback((node) => {
		if (node !== null) {
			setDrillNameRef(node);
		}
	}, []);
	const drillTypeRefCallback = useCallback((node) => {
		if (node !== null) {
			setDrillTypeRef(node);
		}
	}, []);

	const startTimeDate = iso8061ToReadable(drillInfo.startTime, "MM/DD/YYYY HH:mm:ss z");
	const endTimeDate = iso8061ToReadable(drillInfo.endTime, "MM/DD/YYYY HH:mm:ss z");
	const isDisabled = !Array.isArray(activeDrills) || !activeDrills.length || drillInfo.endTime;

	const renderDrillName = () => {
		if (isEditingDrill) {
			return (
				<Input
					initValue={drillInfo.name}
					inputSize={InputSizes.LARGE}
					onChange={(value) => {
						setDrillName(value);
					}}
				/>
			);
		}
		let drillNameElement = (
			<div className="data-value overflow-data" ref={drillNameRefCallback}>
				{drillInfo.name}
			</div>
		);
		return conditionalTooltipRender(drillNameElement, drillNameRef, drillInfo.name);
	};

	const renderDrillType = () => {
		let drillTypeElement = (
			<div className="data-value overflow-data" ref={drillTypeRefCallback}>
				{parseType(drillInfo.type)}
			</div>
		);
		return conditionalTooltipRender(drillTypeElement, drillTypeRef, parseType(drillInfo.type));
	};

	const renderSaveTemplateButton = () => {
		// if the drill is completed, render save button
		if (typeof drillInfo.endTime !== "undefined") {
			return (
				<div className="data-info-final">
					<div className="data-key">Save As Template</div>
					<button className="no-button drill-data-icon-hover data-icon" onClick={saveTemplateByDrillId}>
						<Icon className="md-20">{MaterialIconNames.SAVE}</Icon>
					</button>
				</div>
			);
		}
	};

	return (
		<div className="data-flex-container">
			<div className="data-info">
				<div className="data-key">Name</div>
				{drillInfo.name !== "" && renderDrillName()}
			</div>
			<div className="data-info">
				<div className="data-key">Type</div>
				{drillInfo.name !== "" && renderDrillType()}
			</div>
			<div className="data-info">
				<div className="data-key">Created By</div>
				<div className="data-value">{drillInfo.name !== "" && drillInfo.creatorName}</div>
			</div>
			<div className="data-info">
				{!drillInfo.startTime && (
					<>
						<div className="data-key">Start</div>
						<button
							className="no-button drill-data-icon-hover data-icon"
							onClick={() => {
								startDrill(drillInfo.id);
							}}
						>
							<Icon className="md-20">{MaterialIconNames.START}</Icon>
						</button>
					</>
				)}
				{drillInfo.startTime && (
					<>
						<div className="data-key">Stop</div>
						<button
							className={`no-button data-icon ${isDisabled ? `` : `drill-data-icon-hover`}`}
							disabled={isDisabled}
							onClick={() => {
								stopDrill(drillInfo.id);
							}}
						>
							<Icon className="md-20">{MaterialIconNames.STOP}</Icon>
						</button>
					</>
				)}
			</div>
			<div className="data-info">
				<div className="data-key">Start Time</div>
				{!drillInfo.startTime ? (
					<div className="data-value">N/A</div>
				) : (
					<div className="data-value">{startTimeDate}</div>
				)}
			</div>
			<div className="data-info">
				<div className="data-key">End Time</div>
				{!drillInfo.endTime ? (
					<div className="data-value">N/A</div>
				) : (
					<div className="data-value">{endTimeDate}</div>
				)}
			</div>
			<div className="data-info">
				<div className="data-key">Elapsed Time</div>
				<div className="data-value">{elapsedTime}</div>
			</div>
			<div className="data-info-final">
				<div className="data-key">Delete</div>
				<button
					className="no-button drill-data-icon-hover data-icon"
					onClick={() => {
						deleteDrill();
					}}
				>
					<Icon className="md-20">{MaterialIconNames.DELETE}</Icon>
				</button>
			</div>
			{renderSaveTemplateButton()}
			<div className="attachments-container">
				<AttachmentsView selectedObject={drillInfo} type={AttachmentTypes.DRILL} />
			</div>
		</div>
	);
};

export default DrillData;
