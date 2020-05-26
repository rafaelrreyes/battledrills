import { default as ChartJS } from "chart.js";
import {
	API,
	GREY,
	GREEN,
	CYAN,
	RED,
	YELLOW,
	PURPLE,
	PINK,
	BLUE,
	ORANGE,
	BROWN,
	WHITE,
	secondsToHHmmss
} from "UTILITIES/";
ChartJS.defaults.global.defaultFontFamily = "Roboto";

const getDataPoint = (tooltipItem, datasets) => {
	const data = datasets[tooltipItem.datasetIndex].data;

	return data.find((element, index, arr) => {
		return element.x === tooltipItem.xLabel && parseFloat(element.y) === tooltipItem.yLabel;
	});
};

const getDataPointBar = (tooltipItem, datasets) => {
	const data = datasets[tooltipItem.datasetIndex].data;

	return data.find((element, index, arr) => {
		return element.y === tooltipItem.yLabel;
	});
};

const lineColors = [
	CYAN[300],
	GREEN[300],
	PURPLE[300],
	PINK[300],
	BLUE[300],
	ORANGE[300],
	YELLOW[300],
	BROWN[300],
	RED[300],
	WHITE
];
const getDataSets = (dataList) => {
	let dataSets = [];
	let i = 0;
	dataList.forEach((data, index) => {
		const set = {
			label: data.drillName,
			fill: false,
			borderColor: lineColors[i % lineColors.length], // line color
			pointBackgroundColor: GREY[900],
			pointBorderColor: lineColors[i % lineColors.length],
			pointBorderWidth: 2,
			pointRadius: 4,
			pointHoverBorderWidth: 3,
			pointHoverRadius: 5,
			data: data.dataPoints
		};
		i++;
		dataSets.push(set);
	});
	return dataSets;
};

const getMaxTicks = (dataList) => {
	let max = 0;
	dataList.forEach((data, index) => {
		if (max < data.dataPoints.length) {
			max = data.dataPoints.length;
		}
	});
	return max;
};

export const createTimeToCompletion = async (canvas, reportParams) => {
	let response = await API.getReport(
		reportParams,
		(res) => {},
		(err) => {
			console.error(err);
		}
	);

	let chart = new ChartJS(canvas, {
		type: "line",
		data: {
			datasets: getDataSets(response)
			// datasets: [
			// 	{
			// 		label: reportParams.drillName,
			// 		fill: false,
			// 		borderColor: CYAN[300], // line color
			// 		pointBackgroundColor: GREY[900],
			// 		pointBorderColor: CYAN[300],
			// 		pointBorderWidth: 2,
			// 		pointRadius: 4,
			// 		pointHoverBorderWidth: 3,
			// 		pointHoverRadius: 5,
			// 		data: response[reportParams.drillName].dataPoints
			// 	}
			// ]
		},
		options: {
			responsive: true,
			tooltips: {
				callbacks: {
					afterTitle: (tooltipItem, data) => {
						return getDataPoint(tooltipItem[0], data.datasets).owner;
					},
					beforeBody: (tooltipItem, data) => {
						return getDataPoint(tooltipItem[0], data.datasets).description;
					},
					label: (tooltipItem, data) => {
						return tooltipItem.yLabel + "%";
					}
				}
			},
			maintainAspectRatio: false,
			title: {
				display: true,
				text: "Time to Drill Completion",
				fontColor: GREY[300],
				fontSize: 14
			},
			legend: {
				labels: {
					fontColor: GREY[300]
				}
			},
			scales: {
				xAxes: [
					{
						type: "time",
						distribution: "linear",
						bounds: "ticks",
						time: {
							parser: "HH:mm:ss",
							unit: "hour",
							stepSize: 0.25,
							displayFormats: {
								hour: "HH:mm:ss"
							}
						},
						gridLines: {
							color: GREY[700]
						},
						display: true,
						ticks: {
							beginAtZero: false,
							autoSkip: true,
							maxTicksLimit: getMaxTicks(response),
							fontColor: GREY[300]
						},
						scaleLabel: {
							display: true,
							fontColor: GREY[300],
							labelString: "Time (HH:mm:ss)"
						}
					}
				],
				yAxes: [
					{
						gridLines: {
							color: GREY[700]
						},
						ticks: {
							beginAtZero: true,
							suggestedMin: 0,
							suggestedMax: 100,
							fontColor: GREY[300]
						},
						scaleLabel: {
							display: true,
							fontColor: GREY[300],
							labelString: "Percent Complete (%)"
						}
					}
				]
			}
		}
	});
	return chart;
};

export const createTaskStatusSummary = async (canvas, reportParams) => {
	let response = await API.getReport(
		reportParams,
		(res) => {},
		(err) => {
			console.error(err);
		}
	);

	const xLabels = response.data.map((data) => data.x);
	const pendingData = response.data.map((data) => {
		return {
			y: data.y[0],
			description: data.description
		};
	});
	const inProgressData = response.data.map((data) => {
		return {
			y: data.y[1],
			description: data.description
		};
	});
	const blockedData = response.data.map((data) => {
		return {
			y: data.y[2],
			description: data.description
		};
	});

	let chart = new ChartJS(canvas, {
		type: "bar",
		data: {
			labels: xLabels,
			datasets: [
				{
					label: "Pending",
					backgroundColor: GREY[300],
					hoverBackgroundColor: GREY[300],
					data: pendingData
				},
				{
					label: "In-Progress",
					backgroundColor: YELLOW[300],
					hoverBackgroundColor: YELLOW[300],
					data: inProgressData
				},
				{
					label: "Blocked",
					backgroundColor: RED[300],
					hoverBackgroundColor: RED[300],
					data: blockedData
				}
			]
		},
		options: {
			responsive: true,
			maintainAspectRatio: false,
			title: {
				display: true,
				text: "Task Status Summary",
				fontColor: GREY[300],
				fontSize: 14
			},
			legend: {
				labels: {
					fontColor: GREY[300]
				}
			},
			tooltips: {
				callbacks: {
					beforeBody: (tooltipItem, data) => {
						return getDataPointBar(tooltipItem[0], data.datasets).description;
					},
					label: (tooltipItem, data) => {
						return secondsToHHmmss(tooltipItem.yLabel);
					}
				}
			},
			scales: {
				xAxes: [
					{
						stacked: true,
						bounds: "ticks",
						gridLines: {
							color: GREY[700]
						},
						display: true,
						ticks: {
							fontColor: GREY[300]
						},
						scaleLabel: {
							display: true,
							fontColor: GREY[300],
							labelString: "Role"
						}
					}
				],
				yAxes: [
					{
						stacked: true,
						gridLines: {
							color: GREY[700]
						},
						ticks: {
							callback: (label, index, labels) => {
								return secondsToHHmmss(label);
							},
							beginAtZero: true,
							fontColor: GREY[300]
						},
						scaleLabel: {
							display: true,
							fontColor: GREY[300],
							labelString: "Time (HH:mm:ss)"
						}
					}
				]
			}
		}
	});
	return chart;
};
