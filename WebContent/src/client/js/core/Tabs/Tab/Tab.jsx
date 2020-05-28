import React from "react";

import PropTypes from "prop-types";

export const Tab = (props) => {
	const { isActive, label } = props;

	const handleTabClick = (event) => {
		const { onClick, tabIndex, label } = props;

		event.preventDefault();
		onClick({ selectedIndex: tabIndex, selectedName: label });
	};

	return (
		<li className={`tab ${isActive ? "active" : "not-active"}`} onClick={handleTabClick}>
			{label}
		</li>
	);
};

Tab.propTypes = {
	label: PropTypes.string.isRequired,
	tabIndex: PropTypes.number,
	isActive: PropTypes.bool,
	onClick: PropTypes.func
};
