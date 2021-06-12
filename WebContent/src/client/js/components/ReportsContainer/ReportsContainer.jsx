import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { Chart, ExportPDF } from "CORE";
import { API, Routes, parseType } from "UTILITIES";
import { getAllDrills, getSelectedDrill } from "REDUX";
import { updateAllDrills, setCurrentView } from "REDUX";
import { ReportsSelect } from "./ReportsSelect/ReportsSelect";
import { createTimeToCompletion, createTaskStatusSummary } from "./ReportsHelper";
import "./ReportsContainer.scss";

const ReportTypes = {
	TimeToCompletion: "Time_To_Completion",
	TaskStatusSummary: "Task_Status_Summary"
};

// default generates a report for the select drill
const ReportsContainer = () => {
	const selectedDrill = useSelector(getSelectedDrill);
	const allDrills = useSelector(getAllDrills);
	const dispatch = useDispatch();
	const [charts, setCharts] = useState([]);
	const [drillToGenerate, setDrillToGenerate] = useState(selectedDrill.id);
	const [compareDrills, setCompareDrills] = useState([]);
	const [render, setRender] = useState(false);

	useEffect(() => {
		dispatch(setCurrentView(Routes.REPORTS));
		API.all({}, (res) => {
			dispatch(updateAllDrills(res));
		});
	}, []);

	const saveChartsHandler = (chart) => {
		if (chart !== null) {
			// there is likely a better way to do this
			// sometimes the chart can be saved in the wrong order so exporting will have charts out of order
			// this is only used to keep track of charts to export to PDF
			setCharts((prevCharts) => {
				return [...prevCharts, chart];
			});
		}
	};

	const generateReportHandler = (drillId, drills) => {
		setDrillToGenerate(drillId);
		setCompareDrills(drills);
		setCharts([]); // clear array of charts on new generates
		setRender(!render);
	};

	const getBase64Images = () => {
		return charts.map((chart) => {
			return chart.toBase64Image();
		});
	};

	return (
		<div className="reports-view">
			<div className="reports-nav">
				<ReportsSelect
					selectedDrillId={drillToGenerate}
					allDrills={allDrills}
					onGenerateReport={generateReportHandler}
				></ReportsSelect>
				<ExportPDF
					images={getBase64Images()}
					title="Battle Drill Report"
					name={drillToGenerate}
					type={parseType(selectedDrill.type)}
				></ExportPDF>
			</div>
			{drillToGenerate !== undefined ? (
				<div className="charts">
					<Chart
						render={render}
						createChart={createTimeToCompletion}
						saveChart={saveChartsHandler}
						drillId={drillToGenerate}
						reportType={ReportTypes.TimeToCompletion}
						compareDrillIds={compareDrills}
					></Chart>
					<Chart
						render={render}
						createChart={createTaskStatusSummary}
						saveChart={saveChartsHandler}
						drillId={drillToGenerate}
						reportType={ReportTypes.TaskStatusSummary}
					></Chart>
				</div>
			) : null}
		</div>
	);
};

export default ReportsContainer;
