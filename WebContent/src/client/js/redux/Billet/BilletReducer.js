import { BilletConstants } from "./BilletConstants";

const initialState = {
	billet: []
};

export default function (state = initialState, action) {
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
	const { drillId, updatedTask } = updatedBillet;

	let newBillet = currentBillet.map((billet) => {
		// get the name of the current drill
		let { id, name, tasks } = billet;

		// if there is a drill that matches, change its tasks that are being changed
		if (id === drillId) {
			return {
				id,
				name,
				tasks: billet.tasks.map((task) => {
					if (task.taskId === updatedTask.taskId) {
						return { ...updatedTask };
					}
					return task;
				})
			};
		} else {
			return {
				id,
				name,
				tasks
			};
		}
	});

	return newBillet;
};
