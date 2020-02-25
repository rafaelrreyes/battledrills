import { MaterialIconNames, STATUS_TYPES } from "UTILITIES/index";

export const ShapesConstants = {
	// Diagram Shape Configuration Data
	CONTRIBUTOR_COLOR: "white",
	CONTRIBUTOR_HEIGHT: 25,
	CONTRIBUTOR_WIDTH_MULTIPLIER: 15,

	ACTION_BLOCK_WIDTH: 160,
	ACTION_BLOCK_HEIGHT: 1,

	ACTION_COLOR: "lightblue",
	FONT_COLOR_1: "black"
};

export const getIcon = (status) => {
	switch (status) {
		case STATUS_TYPES.PENDING:
			return `<i class="material-icons pending-icon task-icon md-18">${MaterialIconNames.PANORAMA_FISH_EYE}</i>`;

		case STATUS_TYPES.IN_PROGRESS:
			return `<i class="material-icons in-progress-icon task-icon md-18">${MaterialIconNames.SCHEDULE}</i>`;

		case STATUS_TYPES.BLOCKED:
			return `<i class="material-icons blocked-icon task-icon md-18">${MaterialIconNames.BLOCK}</i>`;

		case STATUS_TYPES.COMPLETED:
			return `<i class="material-icons completed-icon task-icon md-18">${MaterialIconNames.CHECK_CIRCLE}</i>`;

		default:
			return `<i class="material-icons pending-icon task-icon md-18">${MaterialIconNames.PANORAMA_FISH_EYE}</i>`;
	}
};
