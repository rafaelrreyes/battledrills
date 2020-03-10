import { TasksConstants } from "./TasksConstants";

const initialState = {
	tasks: [],
	selectedTask: {}
};

export default function(state = initialState, action) {
	const { type, payload } = action;
	switch (type) {
		case TasksConstants.SET_SELECTED_TASK:
			return {
				...state,
				selectedTask: payload
			};
		case TasksConstants.EDIT_SELECTED_TASK_NOTES:
			let notes = [];

			if (typeof state.selectedTask.notes !== "undefined") {
				notes = state.selectedTask.notes;
			}

			return {
				...state,
				selectedTask: {
					...state.selectedTask,
					notes: [
						...notes,
						{
							...payload
						}
					]
				}
			};
		case TasksConstants.RESET_SELECTED_TASK:
			return {
				...state,
				selectedTask: {}
			};
		case TasksConstants.ADD_TASK_ATTACHMENT: {
			const attachment = payload;

			// attachments is empty on backend, create an empty array list here
			if (typeof state.selectedTask.attachments === "undefined") {
				return {
					...state,
					selectedTask: {
						...state.selectedTask,
						attachments: [
							{
								...attachment
							}
						]
					}
				};
			}

			// or add the new attachment to the end of array list
			return {
				...state,
				selectedTask: {
					...state.selectedTask,
					attachments: [
						...state.selectedTask.attachments,
						{
							...attachment
						}
					]
				}
			};
		}
		case TasksConstants.DELETE_TASK_ATTACHMENT: {
			const attachmentName = payload;

			// filter out the attachment being deleted
			return {
				...state,
				selectedTask: {
					...state.selectedTask,
					attachments: state.selectedTask.attachments.filter((attachment) => {
						return attachment.filename !== attachmentName;
					})
				}
			};
		}
		default:
			return state;
	}
}
