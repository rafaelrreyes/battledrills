import React, { useState, useRef, useEffect } from "react";
import "./Chart.scss";

export const Chart = ({ render, createChart, saveChart, drillId, reportType, compareDrillIds = [] }) => {
	const chartCanvas = useRef(null);
	const [chart, setChart] = useState(null);

	// use render as a flag to generate new reports
	// usecase for remaking a report for active drills without switching selected drill
	// also used for adding different drills to compare
	useEffect(() => {
		// we reuse the chart canvas when generating report to report so we need to save the chart instance
		// to destroy it before generating a new report
		// e.g. report 1 generated -> click to generate report 2 -> destroy report 1 -> report 2 generated
		const getChart = async () => {
			const reportParams = {
				drillId,
				reportType,
				compareDrillIds
			};
			setChart(await createChart(chartCanvas.current, reportParams));
		};

		if (chart !== null) {
			chart.destroy();
		}
		getChart();
	}, [render]);

	useEffect(() => {
		if (chart !== null) {
			// have to set oncomplete option of the chart here to save the chart after animation
			// this makes the image conversion for ExportPDF a complete chart instead of halfway loaded
			chart.options.animation.onComplete = () => {
				saveChart(chart);
			};
		}
	}, [chart]);

	return (
		<div className="chart">
			<canvas ref={chartCanvas}></canvas>
		</div>
	);
};
