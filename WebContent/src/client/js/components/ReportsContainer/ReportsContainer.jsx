import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { Chart, ExportPDF, DROPDOWN_DEFAULT } from "CORE";
import { API, Routes, parseType } from "UTILITIES";
import { getAllDrills, getSelectedDrill } from "REDUX";
import { updateAllDrills, setCurrentView, setSelectedDrill, resetSelectedDrill } from "REDUX";
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
	const [drillToGenerate, setDrillToGenerate] = useState(selectedDrill.name);
	const [compareDrills, setCompareDrills] = useState([]);
	const [render, setRender] = useState(false);

	useEffect(() => {
		dispatch(setCurrentView(Routes.REPORTS));
		API.all(
			{},
			(res) => {
				dispatch(updateAllDrills(res));
			},
			(err) => {
				console.error(err);
			}
		);
	}, []);

	const saveCharts = (chart) => {
		if (chart !== null) {
			// there is likely a better way to do this
			// sometimes the chart can be saved in the wrong order so exporting will have charts out of order
			// this is only used to keep track of charts to export to PDF
			setCharts((prevCharts) => {
				return [...prevCharts, chart];
			});
		}
	};

	const onGenerateReport = (drillName, drills) => {
		setDrillToGenerate(drillName);
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
					selectedDrillName={drillToGenerate}
					allDrills={allDrills}
					onGenerateReport={onGenerateReport}
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
						saveChart={saveCharts}
						drillName={drillToGenerate}
						reportType={ReportTypes.TimeToCompletion}
						compareDrillNames={compareDrills}
					></Chart>
					<Chart
						render={render}
						createChart={createTaskStatusSummary}
						saveChart={saveCharts}
						drillName={drillToGenerate}
						reportType={ReportTypes.TaskStatusSummary}
					></Chart>
				</div>
			) : null}
		</div>
	);
};

export default ReportsContainer;
