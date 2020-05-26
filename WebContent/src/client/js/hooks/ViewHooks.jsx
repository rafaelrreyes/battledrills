import React, { useState, useRef, useEffect } from "react";

/**
 * Custom hook used to perform behavior when clicking outside of view of reference.
 * @param {Function} callback
 */
export const useClickOutside = (callback) => {
	const domReference = useRef(null);

	const handleClickCallback = (event) => {
		if (domReference.current && !domReference.current.contains(event.target)) {
			callback();
		}
	};

	useEffect(() => {
		document.addEventListener("click", handleClickCallback);
		return () => {
			document.removeEventListener("click", handleClickCallback);
		};
	}, []);

	return domReference;
};

const getWindowDimensions = () => {
	const width = window.innerWidth;
	const height = window.innerHeight;
	return {
		width,
		height
	};
};

/**
 * Custom hook to get the width/height of the window
 * Used for changing components based on form-factor
 */
export const useWindowDimensions = () => {
	const [windowDimensions, setWindowDimensions] = useState(getWindowDimensions());

	useEffect(() => {
		const handleResize = () => {
			setWindowDimensions(getWindowDimensions());
		};

		window.addEventListener("resize", handleResize);
		return () => {
			window.removeEventListener("resize", handleResize);
		};
	}, []);

	return windowDimensions;
};
