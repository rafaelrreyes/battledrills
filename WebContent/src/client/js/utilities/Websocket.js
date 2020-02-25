import ReconnectingWebsocket from "reconnecting-websocket";

let rws = null;

export const SUPPORTED_WS_EVENT_TYPES = {
	OPEN: "open",
	CLOSE: "close",
	MESSAGE: "message",
	ERROR: "error"
};

export function WS() {
	const options = {
		connectionTimeout: 1000,
		maxRetries: 10,
		port: 8443,
		hostname: window.location.hostname
	};

	return {
		getInstance: () => {
			if (rws === null) {
				rws = new ReconnectingWebsocket(`wss://${options.hostname}:${options.port}/battledrills/ws`);
			}

			return rws;
		},
		send: (messageObj, successCallback, errorCallback) => {
			if (rws) {
				let successMsg = rws.send(JSON.stringify(messageObj));
				// need to get an ack from server
				successCallback();
			}
		},
		addListener: (type, callback) => {
			if (typeof callback !== "function" || typeof callback === "undefined") {
				callback = function() {};
			}

			if (!Object.values(SUPPORTED_WS_EVENT_TYPES).includes(type)) {
				console.error(
					`Type: ${type} is not supported by websocket. Use one of the following: ${Object.values(
						SUPPORTED_WS_EVENT_TYPES
					)
						.join()
						.replace(/,/g, ", ")}`
				);
				return;
			}

			rws.addEventListener(type, callback);
		}
	};
}
