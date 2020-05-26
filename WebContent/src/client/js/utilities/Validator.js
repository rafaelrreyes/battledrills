import { DROPDOWN_DEFAULT } from "CORE";

export const ValidatorReasonCodes = {
	NON_ALPHANUMERIC: "non_alphanumeric",
	NON_NUMERIC: "non-numeric",
	MAX_CHARACTERS: "max_characters",
	MAX_DECIMALS: "max_decimals",
	OUT_OF_RANGE: "out_of_range",
	EMPTY: "empty",
	NULL: "null",
	VALID: "valid",
	DROPDOWN_DEFAULT: "*"
};

export const isMaxCharacters = (text, max) => {
	return text.length >= max;
};

export const isTextEmpty = (text) => {
	return text.length <= 0;
};

export const isNumeric = (num) => {
	return !isNaN(parseFloat(num)) && isFinite(num);
};

/**
 * Returns true/false if the string passes the regex
 * e.g. "A_A", "A A", "A-A", etc.
 * @param {String} text string to validate
 * @returns {Boolean} true/false based the regex
 */
export const isAlphaNumeric = (text) => {
	// must start and end with a-z, A-Z, or 0-9
	// only one of " ", "-", and "_" inbetween
	const regex = /^[a-zA-Z0-9]+([_ -.]{1}[a-zA-Z0-9]+)*$/;
	return regex.test(text);
};

/**
 * Returns a ValidatorReasonCode based on the string given
 * @param {String} text string to validate
 * @param {Number} max max number of characters allowed (if any)
 * @returns {String} one of ValidatorReasonCodes
 */
export const isDropdownValid = (dropdown) => {
	if (dropdown === "") {
		return ValidatorReasonCodes.EMPTY;
	} else if (dropdown === DROPDOWN_DEFAULT) {
		return ValidatorReasonCodes.DROPDOWN_DEFAULT;
	} else if (!dropdown) {
		return ValidatorReasonCodes.NULL;
	} else {
		return ValidatorReasonCodes.VALID;
	}
};

/**
 * Returns a ValidatorReasonCode based on the string given
 * @param {String} text string to validate
 * @param {Number} max max number of characters allowed (if any)
 * @returns {String} one of ValidatorReasonCodes
 */
export const isStringValid = (text, max) => {
	if (text === "") {
		return ValidatorReasonCodes.EMPTY;
	} else if (!text) {
		return ValidatorReasonCodes.NULL;
	} else if (!isAlphaNumeric(text)) {
		return ValidatorReasonCodes.NON_ALPHANUMERIC;
	} else if (max !== undefined && isMaxCharacters(text, max)) {
		return ValidatorReasonCodes.MAX_CHARACTERS;
	} else {
		return ValidatorReasonCodes.VALID;
	}
};

/**
 * Returns the number of digits after the decimal in the value passed if it is a number itself
 * @param {Number or String} num number to count the digits after a decimal
 * @returns {Number} number of digits after the decimal
 */
export const countDecimals = (num) => {
	if (Math.floor(num) === num) {
		return 0;
	}
	const split = num.toString().split(".");
	return split.length > 1 ? split[1].length : 0;
};

/**
 * Returns a ValidatorReasonCode based on the string given
 * @param {String} num string to validate
 * @param {String} type either "lat", "lon", "alt" to determine max value
 * @returns {String} one of ValidatorReasonCodes
 */
export const isLatLonAltValid = (num, type) => {
	if (num === "") {
		return ValidatorReasonCodes.VALID;
	}
	if (!isNumeric(num) || num.slice(num.length - 1) === ".") {
		return ValidatorReasonCodes.NON_NUMERIC;
	}
	if (countDecimals(num) > 4) {
		return ValidatorReasonCodes.MAX_DECIMALS;
	}
	if (type === "lat" && Math.abs(num) > 90) {
		return ValidatorReasonCodes.OUT_OF_RANGE;
	} else if (type === "lon" && Math.abs(num) > 180) {
		return ValidatorReasonCodes.OUT_OF_RANGE;
	} else if (type === "alt" && Math.abs(num) > 50000) {
		return ValidatorReasonCodes.OUT_OF_RANGE;
	}
	return ValidatorReasonCodes.VALID;
};
