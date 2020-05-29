export const getNotificationPermission = () => {
	// check if the browser supports notifications
	if (!("Notification" in window)) {
		console.log("This browser does not support desktop notification.");
		return false;
	}
	// check whether notification permissions have already been granted
	else if (Notification.permission === "granted") {
		return true;
	}
	// Otherwise, we need to ask the user for permission
	else {
		return false;
	}
};

export const getDisabledNotification = () => {
	// check if the browser supports notifications
	if (!("Notification" in window)) {
		console.log("This browser does not support desktop notification.");
		return true;
	}
	// check whether notification permissions have already been granted
	else if (Notification.permission === "granted" || Notification.permission === "denied") {
		return true;
	}
	// Otherwise, we need to ask the user for permission
	else {
		return false;
	}
};
