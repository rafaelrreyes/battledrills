import { AllDrillsConstants } from "./AllDrillsConstants";

// These are ordered drills, previous is used to record the state prior to updating and roll back if needed
const initialState = {
	previousActive: [],
	previousCompleted: [],
	active: [],
	completed: []
};

export default function(state = initialState, action) {
	const { type, payload } = action;
	switch (type) {
		case AllDrillsConstants.UPDATE_DRILLS: {
			const { active, completed } = payload;
			return {
				...state,
				previousActive: state.active,
				previousCompleted: state.completed,
				active: [...active],
				completed: [...completed]
			};
		}
		case AllDrillsConstants.PENDING_UPDATE_ACTIVE_DRILLS: {
			return {
				...state,
				active: [...payload]
			};
		}
		case AllDrillsConstants.UPDATE_ACTIVE_DRILLS: {
			return {
				...state,
				previousActive: state.active,
				active: [...payload]
			};
		}
		case AllDrillsConstants.REVERT_ACTIVE_DRILL_ORDER: {
			return {
				...state,
				active: state.previousActive
			};
		}
		case AllDrillsConstants.PENDING_UPDATE_COMPLETED_DRILLS: {
			return {
				...state,
				completed: [...payload]
			};
		}
		case AllDrillsConstants.UPDATE_COMPLETED_DRILLS: {
			return {
				...state,
				previousCompleted: state.completed,
				completed: [...payload]
			};
		}
		case AllDrillsConstants.REVERT_COMPLETED_DRILL_ORDER: {
			return {
				...state,
				completed: state.previousCompleted
			};
		}
		default:
			return state;
	}
}
