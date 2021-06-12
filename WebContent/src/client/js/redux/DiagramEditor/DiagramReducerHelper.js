const DEFAULT_ROOT_COORDINATES = {
	x: 600,
	y: 25
};

export const addRole = (selectedTemplate, roleId, roleName, parentId = 0) => {
	if (parentId === "*") {
		return {
			roleId,
			roleName,
			self_coordinates: { x: DEFAULT_ROOT_COORDINATES.x, y: DEFAULT_ROOT_COORDINATES.y },
			children: [],
			tasks: []
		};
	}

	// traverse to find parent, then add this role as a child of that node
	if (selectedTemplate !== null) {
		const newData = Object.assign({}, selectedTemplate.data);
		addRoleRecursive(newData, roleId, roleName, parentId);
		return newData;
	}
};

const addRoleRecursive = (node, roleId, roleName, parentId) => {
	if (typeof node.roleId !== "undefined") {
		if (node.roleId === parentId) {
			const offset_coordinates = { x: node.self_coordinates.x, y: node.self_coordinates.y + 30 };

			if (typeof node.children === "undefined") {
				node.children = [];
			}

			const newNode = {
				roleId,
				roleName,
				tasks: [],
				children: [],
				self_coordinates: offset_coordinates,
				tasks_coordinates: offset_coordinates
			};

			node.children.push(newNode);
			return;
		}
	}

	// iterate through children of current node if necessary
	if (typeof node.children !== "undefined" && node.children.length > 0) {
		node.children.forEach((child) => {
			addRoleRecursive(child, roleId, roleName, parentId);
		});
	}
};

export const addTask = (selectedTemplate, task, roleId) => {
	const newData = Object.assign({}, selectedTemplate.data);
	addTaskRecursive(newData, task, roleId);
	return newData;
};

const addTaskRecursive = (node, task, roleId) => {
	if (typeof node.roleId !== "undefined" && node.roleId === roleId) {
		const offset_coordinates = { x: node.self_coordinates.x + 100, y: node.self_coordinates.y };
		if (typeof node.tasks === "undefined") {
			node.tasks = [];
			node.tasks_coordinates = offset_coordinates;
		}

		node.tasks.push(task);
		return;
	}

	// iterate through children of current node if necessary
	if (typeof node.children !== "undefined" && node.children.length > 0) {
		node.children.forEach((child) => {
			addTaskRecursive(child, task, roleId);
		});
	}
};

export const editTaskDescription = (selectedTemplate, taskId, description, roleId) => {
	const newData = Object.assign({}, selectedTemplate.data);
	editTaskDescriptionRecursive(newData, taskId, description, roleId);
	return newData;
};

const editTaskDescriptionRecursive = (node, taskId, description) => {
	if (typeof node.taskId !== "undefined" && typeof node.tasks !== "undefined" && node.tasks.length !== 0) {
		// loop through tasks and find by id
		node.tasks.forEach((task) => {
			if (task.taskId === taskId) {
				task.description = description;
			}
		});
	}

	if (typeof node.children !== "undefined" && node.children.length > 0) {
		node.children.forEach((child) => {
			editTaskDescriptionRecursive(child, taskId, description);
		});
	}
};

export const editTaskCoordinates = (selectedTemplate, roleId, coordinates) => {
	const newData = Object.assign({}, selectedTemplate.data);
	editCoordinatesRecursive(newData, roleId, "tasks_coordinates", coordinates);
	return newData;
};

export const editRoleCoordinates = (selectedTemplate, roleId, coordinates) => {
	const newData = Object.assign({}, selectedTemplate.data);
	editCoordinatesRecursive(newData, roleId, "self_coordinates", coordinates);
	return newData;
};

const editCoordinatesRecursive = (node, roleId, type, coordinates) => {
	if (typeof node.roleId !== "undefined" && node.roleId === roleId) {
		node[type] = coordinates;
		return;
	}

	if (typeof node.children !== "undefined" && node.children.length > 0) {
		node.children.forEach((child) => {
			editCoordinatesRecursive(child, roleId, type, coordinates);
		});
	}
};

export const deleteRoleFromTemplate = (selectedTemplate, roleId) => {
	// deleting root, delete everything
	if (selectedTemplate.data.roleId === roleId) {
		return {
			...selectedTemplate,
			participants: [],
			data: {}
		};
	}

	const newData = Object.assign({}, selectedTemplate.data);

	// create a new participant container to track, and add the top level role to it first
	const newParticipants = [newData.roleId];
	deleteRoleRecursive(newData, newParticipants, roleId);
	return {
		...selectedTemplate,
		data: newData,
		participants: newParticipants
	};
};

const deleteRoleRecursive = (node, participants, roleId) => {
	if (typeof node.children !== "undefined" && node.children.length > 0) {
		for (let i = 0; i < node.children.length; i++) {
			// found the target, delete it
			if (node.children[i].roleId === roleId) {
				// add the child after this one because the array is getting shrunk
				if (typeof node.children[i + 1] !== "undefined") {
					participants.push(node.children[i + 1].roleId);
				}
				node.children.splice(i, 1);
			} else {
				participants.push(node.children[i].roleId);
				deleteRoleRecursive(node.children[i], participants, roleId);
			}
		}
	}
};

export const getTask = (selectedTemplate, taskId) => {
	let target = {};
	getTaskRecursive(selectedTemplate.data, target, taskId);
	return target.task;
};

const getTaskRecursive = (node, target, taskId) => {
	if (typeof node.roleId !== "undefined" && typeof node.tasks !== "undefined" && node.tasks.length !== 0) {
		// loop through taks and find by id
		for (let i = 0; i < node.tasks.length; i++) {
			if (node.tasks[i].taskId === taskId) {
				target.task = Object.assign({}, node.tasks[i]);
				break;
			}
		}
	}

	if (typeof node.children !== "undefined" && node.children.length > 0) {
		node.children.forEach((child) => {
			getTaskRecursive(child, target, taskId);
		});
	}
};
