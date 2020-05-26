export const UserConfiguration = {
	DEFINED_ROLES: [
		"AirO",
		"BAS",
		"CO",
		"FSCC",
		"IO",
		"LOC",
		"PAO",
		"SAS",
		"S-1",
		"S-2",
		"S-3",
		"S-4",
		"S-6",
		"WO",
		"XO"
	]
};

export const AttachmentTypes = {
	DRILL: "drill",
	TASK: "task"
};

export const Routes = {
	OVERVIEW: "/",
	ACTIVE_DIAGRAM: "/active_diagram",
	COMPLETED_DIAGRAM: "/completed_diagram",
	MY_DRILLS: "/my_drills",
	STATUS: "/status",
	REPORTS: "/reports",
	MY_ACCOUNT: "/my_account",
	TEMPLATE_EDITOR: "/template_editor"
};

export const DrillState = { ACTIVE: "Active", COMPLETED: "Completed" };

export const CoordinateTypes = {
	SELF: "self",
	TASKS: "tasks"
};

export const NoteTypes = {
	AUTO: "auto",
	USER: "user"
};

export const AutogenTypes = {
	ATTACHMENT_UPLOAD: "attachment_upload",
	ATTACHMENT_DELETE: "attachment_delete",
	STATUS_CHANGE: "status"
};

export const TASK_DESCRIPTION_PLACEHOLDER = "--";

export const LinkStyles = {
	NORMAL: "Normal",
	ORTHOGONAL: "Orthogonal",
	MANHATTAN: "Manhattan",
	METRO: "Metro"
};

export const LinkSmoothness = {
	NORMAL: "Normal",
	SMOOTH: "Smooth",
	ROUNDED: "Rounded"
};

export const DrillTypes = {
	CUSTOM: "custom",
	DEFAULT: "default"
};

export const MobileViewMaxWidth = 820;
export const DesktopViewMinWidth = 821;
