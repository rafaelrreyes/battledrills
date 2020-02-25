export const getTasks = (store) => {
    return store.Tasks.tasks;
}

export const getActiveTasks = (store) => {
    return store.Tasks.activeTasks;
}

export const getSelectedTask = (store) => {
    return store.Tasks.selectedTask;
}