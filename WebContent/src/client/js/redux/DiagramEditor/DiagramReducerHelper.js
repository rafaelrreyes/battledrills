const DEFAULT_ROOT_COORDINATES = {
	x: 600,
	y: 25
};

export const addRole = (selectedTemplate, role, parent = null) => {
	if (parent === null) {
		return {
			title: role,
			self_coordinates: { x: DEFAULT_ROOT_COORDINATES.x, y: DEFAULT_ROOT_COORDINATES.y },
			children: [],
			tasks: []
		};
	}

	// traverse to find parent, then add this role as a child of that node
	if (selectedTemplate !== null) {
		const newData = Object.assign({}, selectedTemplate.data);
		addRoleRecursive(newData, role, parent);
		return newData;
	}
};

const addRoleRecursive = (node, newRole, parentRole) => {
	if (typeof node.title !== "undefined") {
		if (node.title === parentRole) {
			const offset_coordinates = { x: node.self_coordinates.x, y: node.self_coordinates.y + 30 };

			if (typeof node.children === "undefined") {
				node.children = [];
			}

			const newNode = {
				title: newRole,
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
			addRoleRecursive(child, newRole, parentRole);
		});
	}
};

export const addTask = (selectedTemplate, task, owner) => {
	const newData = Object.assign({}, selectedTemplate.data);
	addTaskRecursive(newData, task, owner);
	return newData;
};

const addTaskRecursive = (node, task, owner) => {
	if (typeof node.title !== "undefined" && node.title === owner) {
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
			addTaskRecursive(child, task, owner);
		});
	}
};

export const editTaskDescription = (selectedTemplate, id, description, owner) => {
	const newData = Object.assign({}, selectedTemplate.data);
	editTaskDescriptionRecursive(newData, id, description, owner);
	return newData;
};

const editTaskDescriptionRecursive = (node, id, description, owner) => {
	if (typeof node.title !== "undefined" && typeof node.tasks !== "undefined" && node.tasks.length !== 0) {
		// loop through tasks and find by id
		node.tasks.forEach((task) => {
			if (task.taskId === id) {
				task.description = description;
			}
		});
	}

	if (typeof node.children !== "undefined" && node.children.length > 0) {
		node.children.forEach((child) => {
			editTaskDescriptionRecursive(child, id, description, owner);
		});
	}
};

export const editTaskCoordinates = (selectedTemplate, role, coordinates) => {
	const newData = Object.assign({}, selectedTemplate.data);
	editCoordinatesRecursive(newData, role, "tasks_coordinates", coordinates);
	return newData;
};

export const editRoleCoordinates = (selectedTemplate, role, coordinates) => {
	const newData = Object.assign({}, selectedTemplate.data);
	editCoordinatesRecursive(newData, role, "self_coordinates", coordinates);
	return newData;
};

const editCoordinatesRecursive = (node, role, type, coordinates) => {
	if (typeof node.title !== "undefined" && node.title === role) {
		node[type] = coordinates;
		return;
	}

	if (typeof node.children !== "undefined" && node.children.length > 0) {
		node.children.forEach((child) => {
			editCoordinatesRecursive(child, role, type, coordinates);
		});
	}
};

export const deleteRoleFromTemplate = (selectedTemplate, role) => {
	// deleting root, delete everything
	if (selectedTemplate.data.title === role) {
		return {
			...selectedTemplate,
			participants: [],
			data: {}
		};
	}

	const newData = Object.assign({}, selectedTemplate.data);

	// create a new participant container to track, and add the top level role to it first
	const newParticipants = [newData.title];
	deleteRoleRecursive(newData, newParticipants, role);
	return {
		...selectedTemplate,
		data: newData,
		participants: newParticipants
	};
};

const deleteRoleRecursive = (node, participants, role) => {
	if (typeof node.children !== "undefined" && node.children.length > 0) {
		for (let i = 0; i < node.children.length; i++) {
			// found the target, delete it
			if (node.children[i].title === role) {
				// add the child after this one because the array is getting shrunk
				if (typeof node.children[i + 1] !== "undefined") {
					participants.push(node.children[i + 1].title);
				}
				node.children.splice(i, 1);
			} else {
				participants.push(node.children[i].title);
				deleteRoleRecursive(node.children[i], participants, role);
			}
		}
	}
};

export const getTask = (selectedTemplate, id) => {
	let target = {};
	getTaskRecursive(selectedTemplate.data, target, id);
	return target.task;
};

const getTaskRecursive = (node, target, id) => {
	if (typeof node.title !== "undefined" && typeof node.tasks !== "undefined" && node.tasks.length !== 0) {
		// loop through taks and find by id
		for (let i = 0; i < node.tasks.length; i++) {
			if (node.tasks[i].taskId === id) {
				target.task = Object.assign({}, node.tasks[i]);
				break;
			}
		}
	}

	if (typeof node.children !== "undefined" && node.children.length > 0) {
		node.children.forEach((child) => {
			getTaskRecursive(child, target, id);
		});
	}
};
