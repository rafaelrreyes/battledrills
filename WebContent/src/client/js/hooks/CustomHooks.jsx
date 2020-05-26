import { useState, useEffect } from "react";

export const useLocalStorage = (storageKey, defaultValue) => {
	// lazy initialize by using function as param to useState
	const [value, setValue] = useState(() => {
		const val = window.localStorage.getItem(storageKey);

		return val ? JSON.parse(val) : defaultValue;
	});

	useEffect(() => {
		// set local storage here
		window.localStorage.setItem(storageKey, JSON.stringify(value));
	}, [value]);

	return [value, setValue];
};
