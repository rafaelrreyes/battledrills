const axios = require("axios");

const DRILLS_ENDPOINT = "http://localhost:3000/battledrills/rest/battledrills";
const DELETE_DRILL_ENDPOINT = "http://localhost:3000/battledrills/rest/battledrills/battledrill";
let delay = 500;

// 1. Get all existing drills
const getExistingDrills = async () => {
	try {
		const { data } = await axios.get(DRILLS_ENDPOINT);
		return [...data.active, ...data.completed];
	} catch (e) {
		console.error(e);
	}
};

// 2. Delete all Drills
(async () => {
	const existingDrills = await getExistingDrills();

	existingDrills.forEach((drill) => {
		setTimeout(() => {
			const requestBody = {
				username: "WO",
				role: "WO",
				sessionId: "11111111"
			};
			axios
				.delete(DELETE_DRILL_ENDPOINT + "/" + drill, { data: requestBody })
				.then(() => {
					console.log(`Deleted drill: ${drill}`);
				})
				.catch((error) => {
					console.error(error);
				});
		}, (delay += 500));
	});
})();
