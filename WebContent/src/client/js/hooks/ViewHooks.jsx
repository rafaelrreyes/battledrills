import React, { useRef, useEffect } from "react";

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
