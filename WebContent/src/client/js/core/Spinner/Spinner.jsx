import React, { Component } from "react";
import PropTypes from "prop-types";
import "./Spinner.scss";

export const Spinner = ({ size }) => {
	if (size === undefined) {
		size = `default`;
	}
	return (
		<div className={`spinner-${size}`}>
			<div id="spin-div1" className={`spin-div1-${size}`} />
			<div id="spin-div2" className={`spin-div2-${size}`} />
			<div id="spin-div3" className={`spin-div3-${size}`} />
			<div id="spin-div4" className={`spin-div4-${size}`} />
			<div id="spin-div5" className={`spin-div5-${size}`} />
			<div id="spin-div6" className={`spin-div6-${size}`} />
			<div id="spin-div7" className={`spin-div7-${size}`} />
			<div id="spin-div8" className={`spin-div8-${size}`} />
		</div>
	);
};

Spinner.propTypes = {
	size: PropTypes.string
};
