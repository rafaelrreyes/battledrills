import moment from "moment-timezone";

export const iso8061ToReadable = (dateISO, format) => {
	if (dateISO) {
		let temp = moment(dateISO);
		let date = temp.tz(moment.tz.guess(true)).format(format);
		return date;
	}
	return null;
};

export const getElapsedTime = (start, end) => {
	if (!end) {
		end = moment();
	}

	let elapsedTime = moment.utc(moment(end).diff(moment(start))).format("HH:mm:ss");
	return elapsedTime;
};

export const getStartTime = (startTime) => {
	let start = moment.unix(parseInt(startTime)).format("HH:mm:ss");
	let now = moment.unix(parseInt(moment().valueOf() / 1000)).format("HH:mm:ss");
	let diff = moment.utc(moment(now, "HH:mm:ss").diff(moment(start, "HH:mm:ss")));
	return diff;
};

export const secondsToHHmmss = (seconds) => {
	// need *1000 because .utc() takes in milliseconds
	return moment.utc(seconds * 1000).format("HH:mm:ss");
};
