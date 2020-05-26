import axios from "axios";

// create default API config, we could always add properties here later if we need
const BDaxios = axios.create({
	baseURL: "/battledrills/rest"
});

// we can use this when logins are successful to set some type of session token, and clients should only be able to then make requests successfully
// using this token. For now, this token does not need to be stored in any persisted data, but only be created during backend runtime.
export const setAuthToken = (token) => {
	BDaxios.defaults.headers.common["Authorization"] = token;
};

// for whatever reason auth token is needed globally
export const getAuthToken = () => {
	return BDaxios.defaults.headers.common["Authorization"];
};

const BATTLE_DRILLS = "battledrills";
const BATTLE_DRILL = "battledrill";
const ATTACHMENT = "attachment";
const REPORTS = "reports";
const TASK = "task";
const METRICS = "metrics";
const TEMPLATES = "templates";

// Battledrills endpoints

/**
 * Gets all available drill types.
 * @param {Object} params, literally an object of the url parameters, ie /type?completed&age=22&startDate=oct2019&endDate=nov2020
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const types = (params, onSuccess, onError) => {
	const endpoint = `/${TEMPLATES}`;
	return get(endpoint, params, onSuccess, onError);
};

const getTemplate = (params, onSuccess, onError) => {
	const endpoint = `/${TEMPLATES}/${params.type}`;
	return get(endpoint, params, onSuccess, onError);
};

/**
 * Gets all battle drills that exist, both active and completed (not deleted).
 * @param {Object} params, Filter params if specified
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const all = (params, onSuccess, onError) => {
	const endpoint = `/${BATTLE_DRILLS}`;
	return get(endpoint, params, onSuccess, onError);
};

/**
 * Gets all battle drills that are active only.
 * @param {Object} params, Filter params if specified
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const active = (params, onSuccess, onError) => {
	const endpoint = `/${BATTLE_DRILLS}`;

	// default param for /active is ?type=active, merged with passed-in params if necessary
	const mergedParams = { ...params, type: `active` };
	return get(endpoint, mergedParams, onSuccess, onError);
};

/**
 * Gets all battle drills that are completed only.
 * @param {Object} params, Filter params if specified
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const completed = (params, onSuccess, onError) => {
	const endpoint = `/${BATTLE_DRILLS}`;

	// default param for /completed is ?type=completed, merged with passed-in params if necessary
	const mergedParams = { ...params, type: `completed` };
	return get(endpoint, mergedParams, onSuccess, onError);
};

/**
 * Starts a battle drill.
 * @param {String} name, The name of the battle drill.
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const startDrill = (name, params, onSuccess, onError) => {
	const endpoint = `/${BATTLE_DRILLS}/start/${encodeURIComponent(name)}`;
	return put(endpoint, params, onSuccess, onError);
};

/**
 * Stops a battle drill.
 * @param {String} name, The name of the battle drill.
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const stopDrill = (name, params, onSuccess, onError) => {
	const endpoint = `/${BATTLE_DRILLS}/stop/${encodeURIComponent(name)}`;
	return put(endpoint, params, onSuccess, onError);
};

/**
 * Gets a battle drill's complete source of truth by its name (which should be its unique identifier... -___-).
 * @param {String} name, The name of the battle drill.
 * @param {Object} params, filter parameters if necessary
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const getDrillByName = (name, params, onSuccess, onError) => {
	const endpoint = `/${BATTLE_DRILLS}/${BATTLE_DRILL}/${encodeURIComponent(name)}`;
	return get(endpoint, params, onSuccess, onError);
};

/**
 * Gets a subtree (data associated with) by owner and battle drill name.
 * @param {Object} data, Should consist of drillName and owner
 * @param {Object} params, Filter params if specified
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const getSubtreeByOwner = (data, params, onSuccess, onError) => {
	const { drillName, owner } = data;
	const endpoint = `/${BATTLE_DRILLS}/${encodeURIComponent(drillName)}/subtree/${owner}`;
	return get(endpoint, params, onSuccess, onError);
};

/**
 * Re-orders battle drills, active or completed.
 * @param {Array} requestBody, Should consist of the newly ordered drills.
 * @param {Function} onComplete
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const reorder = (requestBody, onComplete, onError) => {
	const endpoint = `/${BATTLE_DRILLS}/reorder`;
	return post(endpoint, requestBody, onComplete, onError);
};

/**
 * Creates a new battle drill.
 * @param {Object} requestBody
 * @param {Function} onComplete
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const createDrill = (requestBody, onComplete, onError) => {
	const endpoint = `/${BATTLE_DRILLS}`;
	return post(endpoint, requestBody, onComplete, onError);
};

/**
 * Deletes a battle drill.
 * @param {String} drillName
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved if any
 */
const deleteDrill = (drillName, requestBody, onSuccess, onError) => {
	const endpoint = `/${BATTLE_DRILLS}/${BATTLE_DRILL}/${drillName}`;
	return del(endpoint, requestBody, onSuccess, onError);
};

/**
 * Gets a battle drill's task's complete persisted source of truth by its unique identifier.
 * @param {String} taskId, The id of the task
 * @param {Object} params, Filter params if necessary
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved, if any
 */
const getTaskById = (taskId, params, onSuccess, onError) => {
	const endpoint = `/${TASK}/${encodeURIComponent(taskId)}`;
	return get(endpoint, params, onSuccess, onError);
};

/**
 * Deletes a battle drill's task by its unique identifier (taskId).
 * @param {String} taskId, The id of the task
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved, if any
 */
const deleteTaskById = (requestBody, onSuccess, onError) => {
	const endpoint = `/${TASK}`;
	return del(endpoint, requestBody, onSuccess, onError);
};

/**
 * Starts a task by its unique identifier.
 * @param {String} taskId, The id of the task
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved, if any
 */
const startTask = (taskId, onSuccess, onError) => {
	const endpoint = `/${TASK}/start/${taskId}`;
	return put(endpoint, {}, onSuccess, onError);
};

/**
 * Stops a task by its unique identifier.
 * @param {String} taskId
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved, if any
 */
const stopTask = (taskId, onSuccess, onError) => {
	const endpoint = `/${TASK}/stop/${taskId}`;
	return put(endpoint, {}, onSuccess, onError);
};

/**
 * Adds a comment to a task with a task id specified in the request body.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved, if any
 */
const addTaskNote = (requestBody = {}, onSuccess, onError) => {
	const endpoint = `/${TASK}/note`;
	return put(endpoint, requestBody, onSuccess, onError);
};

/**
 * Gets a billet by owner (or role).
 * @param {String} owner
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved, if any
 */
const getOwnerBillet = (owner, params, onSuccess, onError) => {
	const endpoint = `/${TASK}/billet/${encodeURIComponent(owner)}`;
	return get(endpoint, params, onSuccess, onError);
};

/**
 * Gets a battle drills metric data.
 * @param {Object} params, Filter params if specified
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved, if any
 */
const getMetrics = (params, onSuccess, onError) => {
	const endpoint = `/${TASK}/${METRICS}`;
	return get(endpoint, params, onSuccess, onError);
};

/**
 * Updates a task's status.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 *
 * @returns Data retrieved, if any
 */
const updateTaskStatus = (requestBody = {}, onSuccess, onError) => {
	const endpoint = `/${TASK}/status`;
	return post(endpoint, requestBody, onSuccess, onError);
};

/**
 * Updates the coordinates of an element on a drill, can be a user/role or a task block.
 * This coordinate pair is used for positioning elements on the diagram view.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const updateDiagramCoordinates = (requestBody = {}, onSuccess, onError) => {
	const endpoint = `/${BATTLE_DRILLS}/diagram/position`;
	return post(endpoint, requestBody, onSuccess, onError);
};

/**
 * Checks to see if attachment already exists.
 * @param {Object} params
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const checkAttachmentExists = (params, onSuccess, onError) => {
	const endpoint = `/${ATTACHMENT}/check`;
	return get(endpoint, params, onSuccess, onError);
};

/**
 * Uploads the attachment to a drill or task.
 * @param {Object} formdata
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const uploadAttachment = (formdata, config, onSuccess, onError) => {
	const endpoint = `/${ATTACHMENT}`;
	return post(endpoint, formdata, onSuccess, onError, config);
};

/**
 * Deletes the attachment of a drill or task.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const deleteAttachment = (requestBody, onSuccess, onError) => {
	const endpoint = `/${ATTACHMENT}`;
	return del(endpoint, requestBody, onSuccess, onError);
};

/**
 * Downloads the attachment of a drill or task.
 * @param {Object} params
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const downloadAttachment = (params, onSuccess, onError) => {
	const endpoint = `/${ATTACHMENT}`;
	return get(endpoint, params, onSuccess, onError);
};

/**
 * Adds a new task to an owner.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const addTaskToOwner = (requestBody, onSuccess, onError) => {
	const endpoint = `/${TASK}`;
	return post(endpoint, requestBody, onSuccess, onError);
};

/**
 * Adds a new subordinate to an owner.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const addSubordinateToOwner = (requestBody, onSuccess, onError) => {
	const endpoint = `/${BATTLE_DRILLS}/owner`;
	return post(endpoint, requestBody, onSuccess, onError);
};

/**
 * Deletes an owner and all of its associated tasks and subordinates.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const deleteOwner = (requestBody, onSuccess, onError) => {
	const endpoint = `/${BATTLE_DRILLS}/owner`;
	return del(endpoint, requestBody, onSuccess, onError);
};

/**
 * Edits a tasks description.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const editTask = (requestBody, onSuccess, onError) => {
	const endpoint = `/${TASK}`;
	return put(endpoint, requestBody, onSuccess, onError);
};

/**
 * Saves drill template by type.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const saveTemplateByDrillName = (requestBody, onSuccess, onError) => {
	const endpoint = `/${TEMPLATES}/save`;
	return post(endpoint, requestBody, onSuccess, onError);
};

/**
 * Saves drill template by object.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const saveTemplate = (requestBody, onSuccess, onError) => {
	const endpoint = `/${TEMPLATES}/save_template`;
	return post(endpoint, requestBody, onSuccess, onError);
};

/**
 * Creates a new drill template.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const createDrillTemplate = (requestBody, onSuccess, onError) => {
	const endpoint = `/${TEMPLATES}/create`;
	return post(endpoint, requestBody, onSuccess, onError);
};

/**
 * Deletes a single drill template.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const deleteDrillTemplate = (requestBody, onSuccess, onError) => {
	const endpoint = `/${TEMPLATES}`;
	return del(endpoint, requestBody, onSuccess, onError);
};

/**
 * Deletes multiple drill templates.
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const deleteDrillTemplates = (requestBody, onSuccess, onError) => {
	const endpoint = `${TEMPLATES}/multiple`;
	return post(endpoint, requestBody, onSuccess, onError);
};

/**
 * Reverts a drill template
 * @param {Object} requestBody
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const revertDrillTemplate = (requestBody, onSuccess, onError) => {
	const endpoint = `${TEMPLATES}/revert`;
	return post(endpoint, requestBody, onSuccess, onError);
};

/*
 * Returns necessary information for generating a report of charts
 * @param {Object} params
 * @param {Function} onSuccess
 * @param {Function} onError
 */
const getReport = (requestBody, onSuccess, onError) => {
	const endpoint = `/${REPORTS}`;
	return post(endpoint, requestBody, onSuccess, onError);
};

/**
 * Wrapper method for AXIOS GET requests.
 * @param {String} endpoint
 * @param {Object} params
 * @param {Function} success
 * @param {Function} error
 *
 * @returns {*} response data
 */
const get = async (endpoint = "", params = {}, success = () => {}, error = () => {}) => {
	try {
		const { data } = await BDaxios.get(endpoint, params);
		// can perform success call back if it is passed, otherwise return data if developer wants to perform their own async/await in component
		success(data);
		return data;
	} catch (err) {
		if (axios.isCancel(err)) {
			return;
		}
		error(err);
		throw new Error(
			`${err} Occurred when performing GET request from: ${endpoint}. Double check if endpoint is valid (or params if added).`
		);
	}
};

/**
 * Wrapper method for AXIOS POST requests.
 * @param {String} endpoint
 * @param {Object} data
 * @param {Function} success
 * @param {Function} error
 * @param {Object} config only really needed for file upload
 *
 * @returns {*} response data
 */
const post = async (endpoint = "", requestBody = {}, success = () => {}, error = () => {}, config = {}) => {
	try {
		const { data } = await BDaxios.post(endpoint, requestBody, config);

		// can perform success callback if it is passed, otherwise return data if developer wants to perform their own async/await in component
		success(data);
		return data;
	} catch (err) {
		if (axios.isCancel(err)) {
			return;
		}
		error(err.response);
		throw new Error(
			`${err} Occurred when performing POST request from: ${endpoint}. Double check if requestBody or endpoint is valid.`
		);
	}
};

/**
 * Wrapper method for AXIOS PUT requests.
 * @param {String} endpoint
 * @param {Object} data
 * @param {Function} success
 * @param {Function} error
 *
 * @returns {*} response data
 */
const put = async (endpoint = "", requestBody = {}, success = () => {}, error = () => {}) => {
	try {
		const { data } = await BDaxios.put(endpoint, requestBody);

		// can perform success callback if it is passed, otherwise return data if developer wants to perform their own async/await in component
		success(data);
		return data;
	} catch (err) {
		if (axios.isCancel(err)) {
			return;
		}
		error(err);
		throw new Error(
			`${err} Occurred when performing PUT request from: ${endpoint}. Double check request body or endpoint is valid.`
		);
	}
};

/**
 * Wrapper method for AXIOS DEL requests.
 * @param {String} endpoint
 * @param {Object} data
 * @param {Function} success
 * @param {Function} error
 *
 * @returns {*} response data
 */
const del = async (endpoint, requestBody = {}, success = () => {}, error = () => {}) => {
	try {
		const { data } = await BDaxios.delete(endpoint, { data: requestBody });

		// can perform success callback if it is passed, otherwise return data if developer wants to perform their own async/await in component
		success(data);
		return data;
	} catch (err) {
		if (axios.isCancel(err)) {
			return;
		}
		error(err);
		throw new Error(
			`${err} Occurred when performing DELETE request from: ${endpoint}. Double check request body or endpoint is valid.`
		);
	}
};

export const API = {
	types,
	getTemplate,
	active,
	completed,
	startDrill,
	stopDrill,
	startTask,
	stopTask,
	getTaskById,
	deleteDrill,
	deleteTaskById,
	stop,
	getDrillByName,
	all,
	getSubtreeByOwner,
	reorder,
	createDrill,
	addTaskNote,
	getOwnerBillet,
	getMetrics,
	updateTaskStatus,
	updateDiagramCoordinates,
	checkAttachmentExists,
	uploadAttachment,
	deleteAttachment,
	downloadAttachment,
	addTaskToOwner,
	addSubordinateToOwner,
	deleteOwner,
	editTask,
	createDrillTemplate,
	saveTemplateByDrillName,
	saveTemplate,
	deleteDrillTemplate,
	deleteDrillTemplates,
	revertDrillTemplate,
	getReport
};
