import React, { useCallback, useState } from "react";
import { MaterialIconNames, secondsToDate, parseType, AttachmentTypes } from "UTILITIES/";
import { conditionalTooltipRender } from "CORE/";
import { AttachmentsView } from "COMPONENTS/";
import "./DrillData.scss";

const DrillData = ({ drillInfo, activeDrills, elapsedTime, startDrill, stopDrill, deleteDrill }) => {
	const [drillNameRef, setDrillNameRef] = useState(null);
	const [drillTypeRef, setDrillTypeRef] = useState(null);

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

	const startTimeDate = secondsToDate(drillInfo.startTimeMillis);
	const endTimeDate = secondsToDate(drillInfo.endTimeMillis);
	const isDisabled = !Array.isArray(activeDrills) || !activeDrills.length || drillInfo.endTimeMillis !== -1;

	const renderDrillName = () => {
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
				{drillInfo.startTimeMillis === -1 && (
					<>
						<div className="data-key">Start</div>
						<button
							className="no-button drill-data-icon-hover data-icon"
							onClick={() => {
								startDrill(drillInfo.name);
							}}
						>
							<i className="material-icons md-20">{MaterialIconNames.PLAY_ARROW}</i>
						</button>
					</>
				)}
				{drillInfo.startTimeMillis !== -1 && (
					<>
						<div className="data-key">Stop</div>
						<button
							className={`no-button data-icon ${isDisabled ? `` : `drill-data-icon-hover`}`}
							disabled={isDisabled}
							onClick={() => {
								stopDrill(drillInfo.name);
							}}
						>
							<i className="material-icons md-20">{MaterialIconNames.STOP}</i>
						</button>
					</>
				)}
			</div>
			<div className="data-info">
				<div className="data-key">Start Time</div>
				{drillInfo.startTimeMillis === -1 ? (
					<div className="data-value">N/A</div>
				) : (
					<div className="data-value">{startTimeDate}</div>
				)}
			</div>
			<div className="data-info">
				<div className="data-key">End Time</div>
				{drillInfo.endTimeMillis === -1 ? (
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
					<i className="material-icons md-20">{MaterialIconNames.DELETE}</i>
				</button>
			</div>
			<div className="attachments-container">
				<AttachmentsView selectedObject={drillInfo} type={AttachmentTypes.DRILL}/>
			</div>
		</div>
	);
};

export default DrillData;
