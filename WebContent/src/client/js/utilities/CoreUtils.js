export const isContentOverflowed = (element) => {
	if (element) {
		if (element.scrollWidth > element.clientWidth) {
			return true; // content of this element overflows
		}
	}
	return false; // content of this element does NOT overflow
};

export const areArraysEqual = (a, b) => {
	// if the one array is a falsy value, return
	if (!a || !b) return false;

	// compare lengths - can save a lot of time
	if (a.length !== b.length) return false;

	for (let i = 0; i < a.length; i++) {
		// Check if we have nested arrays
		if (a[i] instanceof Array && b[i] instanceof Array) {
			// recurse into the nested arrays
			if (!areArraysEqual(a[i], b[i])) return false;
		} else if (a[i] != b[i]) {
			// Warning - two different object instances will never be equal: {x:20} != {x:20}
			return false;
		}
	}
	return true;
};

export const isObjectEmpty = (obj) => {
	for (let key in obj) {
		if (obj.hasOwnProperty(key)) return false;
	}
	return true;
};

export const createDesktopNotification = (title, options) => {
	if (!("Notification" in window)) {
		console.log("This browser does not support desktop notification.");
	} else if (Notification.permission === "granted") {
		if (isWindowHidden()) {
			let notification = new Notification(title, options);
			return notification;
		}
	} else {
		console.log("Notifications are disabled or need to be enabled, check browser permissions.");
	}
	return null;
};

export const isWindowHidden = () => {
	if (document[getHiddenProp()]) {
		return true;
	} else {
		if (document.hasFocus()) {
			return false;
		} else {
			return true;
		}
	}
};

export const getHiddenProp = () => {
	let prefixes = ["webkit", "moz", "ms", "o"];
	// if 'hidden' is natively supported just return it
	if ("hidden" in document) return "hidden";

	// otherwise loop over all the known prefixes until we find one
	for (let i = 0; i < prefixes.length; i++) {
		if (prefixes[i] + "Hidden" in document) return prefixes[i] + "Hidden";
	}

	// otherwise it's not supported
	return null;
};
