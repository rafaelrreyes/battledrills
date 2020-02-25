/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.data;

import com.ngc.battledrills.data.TaskRepo;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ngc.battledrills.exception.DuplicateItemException;
import com.ngc.battledrills.template.BattleDrillTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Node {
    private String owner = "";
    private final Map<String, Integer> selfCoordinates = new HashMap<String, Integer>();
    private final Map<String, Integer> tasksCoordinates = new HashMap<String, Integer>();

    public class NodeConstants {
        public static final String SELF = "self";
        public static final String TASKS = "tasks";
    }

    @JsonManagedReference
    public List<Task> tasks = new ArrayList<>();

    @JsonBackReference(value="node")
    public Node parent;

    @JsonManagedReference(value="node")
    private List<Node> children = new ArrayList<>();

    @JsonBackReference
    private BattleDrillTemplate bdroot;

    public Node(){}

    @JsonProperty("title")
    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getOwner()
    {
        return this.owner;
    }

    /**
     * Sets the self coordinates when new drill is created using json template.
     * @param coordinates 
     */
    @JsonProperty("self_coordinates")
    private void setSelfCoordinates(Map<String, Integer> coordinates)
    {
        if (coordinates.containsKey("x") && coordinates.containsKey("y")) {
            this.selfCoordinates.put("x", coordinates.get("x"));
            this.selfCoordinates.put("y", coordinates.get("y"));
        }
    }

    public Map<String, Integer> getSelfCoordinates() {
        return this.selfCoordinates;
    }

    /**
     * Sets the tasks coordinates when new drill is created using json template.
     * @param coordinates 
     */
    @JsonProperty("tasks_coordinates")
    private void setTasksCoordinates(Map<String, Integer> coordinates)
    {
        if (coordinates.containsKey("x") && coordinates.containsKey("y")) {
            this.tasksCoordinates.put("x", coordinates.get("x"));
            this.tasksCoordinates.put("y", coordinates.get("y"));
        }
    }

    public Map<String, Integer> getTasksCoordinates() {
        return this.tasksCoordinates;
    }
    
    /**
     * Updates the self coordinates of the current node.
     * @param x
     * @param y 
     */
    public void updateSelfCoordinates(int x, int y) {
        this.selfCoordinates.put("x", x);
        this.selfCoordinates.put("y", y);
    }

     /**
     * Updates the self coordinates of the current node.
     * @param x
     * @param y 
     */
    public void updateTasksCoordinates(int x, int y) {
        this.tasksCoordinates.put("x", x);
        this.tasksCoordinates.put("y", y);
    }
    
    @JsonIgnore
    public String getBattleDrillName()
    {
        if(null != bdroot)
        {
            return bdroot.getName();
        }
        else if(null != parent)
        {
            return parent.getBattleDrillName();
        }
        else
        {
            return "";
        }
    }

    @JsonProperty("tasks")
    public void setTasks(List<Task> tasks)
    {
        try
        {
            TaskRepo.addTasks(tasks);
            this.tasks = tasks;
        }
        catch(DuplicateItemException d)
        {
            System.err.println("Unable to set tasks for owner " + getOwner() + " - duplicate task being added: " + d);
        }
    }

    public List<Task> getTasks()
    {
        return this.tasks;
    }

    @JsonProperty("children")
    public void setChildNodes(List<Node> children)
    {
        this.children = children;
    }

    public List<Node> getChildNodes()
    {
        return this.children;
    }

    // Traverse the tree to get the tasks for all owners/billets
    @JsonIgnore
    public void getTasksForAllOwners(Map<String, List<Task>> ownerXtasks)
    {
        String owner = this.getOwner();
        if(ownerXtasks.containsKey(owner))
        {
            List<Task> mytasks = ownerXtasks.get(owner);
            mytasks.addAll(tasks);
        }
        else
        {
            ownerXtasks.put(owner, tasks);
        }

        for(Node child : children)
        {
            child.getTasksForAllOwners(ownerXtasks);
        }
    }

    // Traverse the tree to get the tasks owned by the requested owner/billet
    public List<Task> getTasksByOwner(String owner)
    {
        Node match = null;
        for(Node child : children)
        {
            if(child.getOwner().equalsIgnoreCase(owner))
            {
                match = child;
                break;
            }
        }

        if(null != match)
        {
            return match.getTasks();
        }
        else // If the node matching the owner was not found, pass the find request to child nodes
        {
            for(Node child : children)
            {
                match = child.getSubtreeByOwner(owner);
                if(null != match)
                {
                    break;
                }
            }
        }

        return (match == null)?null:match.getTasks();
    }

    // Traverse the tree to get the subtree owned by the requested owner
    public Node getSubtreeByOwner(String owner)
    {
        Node match = null;
        for(Node child : children)
        {
            if(child.getOwner().equalsIgnoreCase(owner))
            {
                match = child;
                break;
            }
        }

        if(null != match)
        {
            return match;
        }
        else // If the node matching the owner was not found, pass the find request to child nodes
        {
            for(Node child : children)
            {
                match = child.getSubtreeByOwner(owner);
                if(null != match)
                {
                    break;
                }
            }
        }

        return match;
    }

    // Traverse the tree to delete the requested task
    public boolean deleteTask(String taskId)
    {
        boolean success = false;
        Task toDelete = null;

        // First check if the task is in this node's task list.  If so, delete it and return successful
        for(Task task : tasks)
        {
            if(task.getId().equals(taskId))
            {
                toDelete = task;
                break;
            }
        }

        // If the task was found in this node's task list, delete it and record success
        if(null != toDelete)
        {
            tasks.remove(toDelete);
            success = true;
        }
        else // If the task was not found, pass the delete request to child nodes, and return immediately if the task is successfully deleted in a descendant of this node
        {
            for(Node child : children)
            {
                success = child.deleteTask(taskId);
                if(success == true)
                {
                    break;
                }
            }
        }

        return success;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Owner: ").append(this.owner).append(System.lineSeparator());

        if (selfCoordinates.containsKey("x") && selfCoordinates.containsKey("y")) {
            sb.append("Self coordinates: { x: " + selfCoordinates.get("x") + ", y: " + selfCoordinates.get("y") + " }").append(System.lineSeparator());
        }

        if (tasksCoordinates.containsKey("x") && tasksCoordinates.containsKey("y")) {
            sb.append("Tasks coordinates: { x: " + tasksCoordinates.get("x") + ", y: " + tasksCoordinates.get("y") + " }").append(System.lineSeparator());
        }

        if(tasks != null && tasks.size() > 0)
        {
            sb.append("Tasks: ").append(System.lineSeparator());
            for(Task task : tasks)
            {
                sb.append(task).append(System.lineSeparator());
            }
        }

        if(children != null && children.size() > 0)
        {
            sb.append("Children: ").append(System.lineSeparator());
            for(Node node : children)
            {
                sb.append(node).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
