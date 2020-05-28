import React, { useState, useEffect } from "react";
import { getStartTime } from "UTILITIES";

const OPTIONS = {
	TIMER_INTERVAL: 1000 //1 second
};

const DetailedTimer = ({ start }) => {
	const [currentTime, setCurrentTime] = useState(getStartTime(start));
	const [seconds, setSeconds] = useState(0);

	useEffect(() => {
		function tick() {
			setSeconds(seconds + 1);
			setCurrentTime(currentTime.add(1, "second"));
		}
		const interval = setInterval(tick, OPTIONS.TIMER_INTERVAL);

		return () => {
			clearInterval(interval);
		};
	}, [seconds]);

	return (
		<>
			<span>{currentTime.format("HH:mm:ss")}</span>
		</>
	);
};

export default DetailedTimer;
