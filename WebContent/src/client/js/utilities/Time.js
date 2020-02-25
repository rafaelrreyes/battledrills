import moment from "moment-timezone";

export const secondsToDate = (seconds) => {
	let temp = moment.unix(parseInt(seconds)).local();
	let date = temp.tz(moment.tz.guess(true)).format("MM/DD/YYYY HH:mm:ss z");

	return date;
};

export const secondsToDateMinimal = (seconds) => {
	let temp = moment.unix(parseInt(seconds)).local();
	return temp.tz(moment.tz.guess(true)).format("MM/DD/YY HH:mm");
};

export const getElapsedTime = (start, end) => {
	let startUnix = moment.unix(parseInt(start)).format("HH:mm:ss");
	let endUnix = moment.unix(parseInt(end)).format("HH:mm:ss");

	if (end === -1) {
		endUnix = moment.unix(parseInt(moment().valueOf() / 1000)).format("HH:mm:ss");
	}

	let elapsedTime = moment.utc(moment(endUnix, "HH:mm:ss").diff(moment(startUnix, "HH:mm:ss"))).format("HH:mm:ss");
	return elapsedTime;
};

export const getStartTime = (startTime) => {
	let start = moment.unix(parseInt(startTime)).format("HH:mm:ss");
	let now = moment.unix(parseInt(moment().valueOf() / 1000)).format("HH:mm:ss");
	let diff = moment.utc(moment(now, "HH:mm:ss").diff(moment(start, "HH:mm:ss")));
	return diff;
};
