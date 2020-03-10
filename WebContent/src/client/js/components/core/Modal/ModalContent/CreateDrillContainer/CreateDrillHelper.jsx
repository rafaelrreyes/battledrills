import React from "react";
import store from "REDUX/store";
import { showModal, closeModal, updateActiveDrills, setActiveBillet, setAllStatuses } from "REDUX/index";
import { getCurrentView, getUser, getRole, getActiveDrills } from "REDUX/index";
import { ModalContentTypes } from "CORE/index";
import { MaterialIconNames, API, ValidatorReasonCodes, Routes } from "UTILITIES/index";

export const openCreateDrillModal = () => {
	store.dispatch(
		showModal(ModalContentTypes.NEW_DRILL, {
			title: `Create a Drill`,
			icon: MaterialIconNames.CREATE,
			action: (data) => {
				const requestBody = {
					type: data.type,
					name: data.name,
					user: getUser(store.getState()),
					// location has these defaults if not submitted
					location: {
						// san diego
						latitude: data.lat === "" ? "32.7157" : data.lat,
						longitude: data.lon === "" ? "117.1611" : data.lon,
						altitude: data.alt === "" ? "5000" : data.alt,
						tilt: data.tilt === "" ? "50" : data.tilt
					}
				};
				API.createDrill(
					requestBody,
					(response) => {
						createDrillUpdate(response.name);
						createDrillUpdateMyDrillsView();
						createDrillUpdateStatusView();

						// "startDrill" toggle checkmark was selected when drill was created
						if (data.startDrill) {
							API.startDrill(response.name, (res) => {});
						}

						store.dispatch(closeModal());
					},
					(err) => {
						console.log("An Error occured", err);
					}
				);
			},
			// this is a part of props.contentData in ModalContainer.jsx
			// if using 'false', can leave it empty
			// shows one or two buttons in the modal
			singleButton: false
		})
	);
};

// fires every time a new drill is created
export const createDrillUpdate = (drillName) => {
	let activeDrills = getActiveDrills(store.getState()).slice(); // don't modify actual redux store
	activeDrills.push(drillName);
	store.dispatch(updateActiveDrills(activeDrills));
};

// should only fire if the view is on "My Drills" and a new drill is created
export const createDrillUpdateMyDrillsView = () => {
	if (getCurrentView(store.getState()) === Routes.MY_REPORT) {
		const role = getRole(store.getState()).toUpperCase();
		API.getOwnerBillet(role, {}, (data) => {
			store.dispatch(setActiveBillet(data));
		});
	}
};

// should only fire if the view is on "Status" and a new drill is created
export const createDrillUpdateStatusView = () => {
	if (getCurrentView(store.getState()) === Routes.STATUS) {
		API.getMetrics({}, (response) => {
			store.dispatch(setAllStatuses(response));
		});
	}
};

/**
 * Helper object for displaying error texts in tooltips
 */
export const ErrorMessages = {
	NON_ALPHANUMERIC: (
		<>
			Must start and end with:
			<ul className="bullet-list">
				<li>A-Z</li>
				<li>a-z</li>
				<li>0-9</li>
			</ul>
			Allowed special characters:
			<ul className="bullet-list">
				<li>_ - . [Space]</li>
			</ul>
		</>
	),
	NON_NUMERIC: `Value must be numeric.`,
	MAX_DECIMALS: `Decimals limited to 4 places.`,
	OUT_OF_RANGE: {
		lat: `Latitude must be between -90 and 90.`,
		lon: `Longitude must be between -180 and 180.`,
		alt: `Altitude must be between -50000 and 50000.`
	},
	EMPTY: {
		name: `Drill name cannot be blank.`,
		type: `Select a drill type`
	}
};

/**
 *
 * @param {String} reasonCode one of ValidatorReasonCodes.
 * @returns {Object} object with keys "isError", "placement", and "message".
 * 			isError is true/false
 * 			placement is set to "right" for tooltip purposes
 * 			message is a string of what to display in the tooltip
 */
export const getTypeError = (reasonCode) => {
	const errorObj = {
		isError: true,
		placement: "right"
	};
	switch (reasonCode) {
		case ValidatorReasonCodes.NULL:
			return {
				isError: null
			};
		case ValidatorReasonCodes.EMPTY:
			return {
				...errorObj,
				message: ErrorMessages.EMPTY.type
			};
		case ValidatorReasonCodes.VALID:
			return {
				isError: false
			};
		default:
			return {
				isError: false
			};
	}
};

/**
 *
 * @param {String} reasonCode one of ValidatorReasonCodes.
 * @param {String} name string of the drill name used to display length on error
 * @returns {Object} object with keys "isError", "placement", and "message".
 * 			isError is true/false
 * 			placement is set to "right" for tooltip purposes
 * 			message is a string of what to display in the tooltip
 * 			tooltipAttached is true when the tooltip should be on the error icon, false when not
 */
export const getNameError = (reasonCode, name) => {
	const errorObj = {
		isError: true,
		placement: "right",
		tooltipAttached: true
	};
	switch (reasonCode) {
		case ValidatorReasonCodes.NULL:
			return {
				isError: null
			};
		case ValidatorReasonCodes.EMPTY:
			return {
				...errorObj,
				message: ErrorMessages.EMPTY.name
			};
		case ValidatorReasonCodes.NON_ALPHANUMERIC:
			return {
				...errorObj,
				message: ErrorMessages.NON_ALPHANUMERIC
			};
		case ValidatorReasonCodes.MAX_CHARACTERS:
			return {
				...errorObj,
				message: `Drill name has a max of 50 characters: (${name.length}/50)`
			};
		case ValidatorReasonCodes.VALID:
			return {
				isError: false
			};
		default:
			return {
				isError: false
			};
	}
};

/**
 *
 * @param {String} reasonCode string from isLatLonValid returning a ValidationReasonCode
 * @param {String} type string of if the error is for lat or lon
 * @returns {Object} object with keys "isError", "placement", and "message".
 * 			isError is true/false
 * 			placement is tooltip placement location
 * 			message is a string of what to display in the tooltip
 */
export const getLatLonAltError = (reasonCode, type) => {
	let errorObj = {
		isError: true,
		placement: type === "lat" || type === "alt" ? "left" : "right",
		tooltipAttached: type === "lat" || type === "alt" ? false : true
	};

	switch (reasonCode) {
		case ValidatorReasonCodes.NON_NUMERIC:
			return {
				...errorObj,
				message: ErrorMessages.NON_NUMERIC
			};
		case ValidatorReasonCodes.MAX_DECIMALS:
			return {
				...errorObj,
				message: ErrorMessages.MAX_DECIMALS
			};
		case ValidatorReasonCodes.OUT_OF_RANGE:
			return {
				...errorObj,
				message: ErrorMessages.OUT_OF_RANGE[type]
			};
		case ValidatorReasonCodes.VALID:
			return {
				isError: false
			};
		default:
			return {
				isError: false
			};
	}
};
