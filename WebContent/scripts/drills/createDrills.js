const axios = require("axios");

const CREATE_DRILL_ENDPOINT = "http://localhost:3000/battledrills/rest/battledrills";
let delay = 1000;

const TEST_DRILLS = [
	{ name: "Test Troops In Contact 1x1", type: "attack_on_convoy" },
	{ name: "Test Attack on Firm Base 2x2", type: "attack_on_firm_base" },
	{ name: "Test Intelligence Alert of Impending Attack", type: "intelligence_alert_of_impending_attack" },
	{ name: "Test Assassination of Iraqi Gov Official 555", type: "assassination_of_iraqi_government_official" },
	{ name: "Test IED Discovered 1000", type: "ied_discovered" },
	{ name: "Test Missing Marine Captain America", type: "missing_marine" },
	{ name: "Test Weapons Stash Found 5", type: "weapon_cache_discovery" },
	{ name: "Test MEDEVAC 15a2", type: "medevac" },
	{ name: "Test Lost Comms with Unit MAYDAY", type: "lost_communication_with_unit" },
	{ name: "Test IED VBIED SVBIED Attack 0", type: "ied_vbied_svbied_attack" },
	{ name: "Test Attack on Critical Infrastructure 6", type: "attack_on_critical_infrastructure" },
	{ name: "Test Attack on Allied Convoy 1", type: "attack_on_convoy" },
	{ name: "Test Tactical Maneuver 000", type: "tactical_maneuver" }
];

// 1. Query for existing drills
const getExistingDrills = async () => {
	try {
		const { data } = await axios.get(CREATE_DRILL_ENDPOINT);
		return [...data.active, ...data.completed];
	} catch (e) {
		console.error(e);
	}
};

// 2. Create drills
(async () => {
	const existingDrills = await getExistingDrills();

	// check if test drills already exists, if so, don't recreate them
	for (let i = 0; i < TEST_DRILLS.length; i++) {
		let createDrill = true;
		setTimeout(() => {
			existingDrills.forEach((drill) => {
				if (TEST_DRILLS[i].name.toUpperCase() === drill.toUpperCase()) {
					createDrill = false;
				}
			});

			if (createDrill) {
				const requestBody = {
					user: {
						username: "WO",
						role: "WO",
						sessionId: "TestSessionID"
					},
					location: {
						altitude: 1000,
						latitude: 30,
						longitude: 110,
						tilt: 50
					},
					name: TEST_DRILLS[i].name,
					type: TEST_DRILLS[i].type
				};
				axios
					.post(CREATE_DRILL_ENDPOINT, requestBody)
					.then(() => {
						console.log(`Created drill: ${TEST_DRILLS[i].name}`);
					})
					.catch((error) => {
						console.error(error);
					});
			} else {
				console.log(`Drill: ${TEST_DRILLS[i].name} already exists.`);
			}
		}, (delay += 1000));
	}
})();
