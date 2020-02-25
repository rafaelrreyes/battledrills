import { BilletConstants } from "./BilletConstants";

const initialState = {
	billet: []
};

export default function(state = initialState, action) {
	const { type, payload } = action;

	switch (type) {
		case BilletConstants.SET_ACTIVE_BILLET:
			return {
				...state,
				billet: payload
			};
		case BilletConstants.EDIT_BILLET:
			return {
				...state,
				billet: editBillet(state.billet, payload)
			};
		default:
			return state;
	}
}

const editBillet = (currentBillet, updatedBillet) => {
	// check for corresponding drill that needs an update,
	// then query which task needs
	// an update
	const { drillName, updatedTask } = updatedBillet;

	let newBillet = currentBillet.map((billet) => {
		// get the name of the current drill
		let targetDrill = Object.keys(billet)[0];

		// set the default return tasks to be all the unchanged values
		let targetTask = {
			[Object.keys(billet)[0]]: Object.values(billet)[0]
		};

		// if there is a drill that matches, change its tasks that are being changed
		if (targetDrill === drillName) {
			let tasks = Object.values(billet)[0].map((task) => {
				if (task.taskId === updatedTask.taskId) {
					return { ...updatedTask };
				}
				return task;
			});

			// set the target tasks to be equal to the new tasks
			targetTask = {
				[Object.keys(billet)[0]]: tasks
			};
		}
		return targetTask;
	});
	return newBillet;
};
