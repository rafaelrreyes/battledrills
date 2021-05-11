/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngc.battledrills.BattleDrillsConfig;
import com.ngc.battledrills.data.Group;
import com.ngc.battledrills.data.Role;
import com.ngc.battledrills.util.JsonUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author rafae
 */
public class GroupManager {
    
    private static final Map<Integer, Group> groups = new HashMap<Integer, Group>();
    private static final ArrayList<Integer> groupIds = new ArrayList<Integer>();
    private static GroupManager instance;
    
    private GroupManager() {
        loadAllGroups();
    }
    
    public static GroupManager getInstance() {
        if (instance == null) {
            instance = new GroupManager();
        }
        
        return instance;
    }
    
    public Map<Integer, Group> getGroupsMap() {
        return groups;
    }
    
    public List<Group> getGroupsList() {
        return new ArrayList<>(groups.values());
    }
    
    public List<String> getGroupnames() {
        ArrayList<String> groupNames = new ArrayList<>();
        groups.values().forEach((group) -> {
            groupNames.add(group.getName());
        });
        
        return groupNames;
    }
    
    private void loadAllGroups() {
        // load all groups from json file
        try {
            File groupsFile = new File(BattleDrillsConfig.getGroupsFile());
            String contents = FileUtils.readFileToString(groupsFile);
            Map<Integer, Group> mappedGroups = loadFromJson(contents);
            groups.putAll(mappedGroups);
            groups.values().forEach((group) -> {
                groupIds.add(group.getId());
            });
        } catch (IOException e) {
            System.err.println("Unable to load groups into runtime");
        }
    }
    
    private Map<Integer, Group> loadFromJson(String json) throws IOException {
        Map<Integer, Group> mappedGroups = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Group>>() {});
        return mappedGroups;
    }
    
    public Group addGroup(String name, ArrayList<Integer> roles) {
        
        // cannot add empty group name
        if (null == name) {
            return null;
        }
        
        if (null == roles) {
            roles = new ArrayList<>();
        }
        
        // self assign group id
        int newGroupId = getAvailableID();
        Group newGroup = new Group(newGroupId, name, roles);
        
        // For each role id in 'roles' parameter, add this group to that role object
        // then update json file of roles manager
        RolesManager rolesMgr = RolesManager.getInstance();
        roles.forEach((roleId) -> {
            Role currentRole = rolesMgr.getRolesMap().get(roleId);
            currentRole.getGroups().add(newGroupId);
        });
        
        rolesMgr.updateJsonFile();
        
        // add role to runtime and id container
        groups.put(newGroupId, newGroup);
        groupIds.add(newGroupId);
        
        updateJsonFile();
        
        return newGroup;
    }
    
    public Group editGroupnameById(int id, String name) {
        
        if (StringUtils.isBlank(name)) {
            System.err.println("Cannot set group name to empty value.");
            return null;
        }
        
        Group targetGroup = groups.get(id);
        
        if (null != targetGroup) {
            targetGroup.setName(name);
        }
        
        return targetGroup;
    }
    
    public boolean deleteGroupById(int id) {
        Group removedGroup = groups.remove(id);
        
        if (null == removedGroup) {
            return false;
        }
        
        updateJsonFile();
        
        for (int i = 0; i < groupIds.size(); i++) {
            if (groupIds.get(i) == id) {
                groupIds.remove(i);
                break;
            }
        }
        
        RolesManager rolesMgr = RolesManager.getInstance();
        List<Role> roles = rolesMgr.getRolesList();
        
        roles.forEach((role) -> {
            ArrayList<Integer> groupsInCurrentRole = role.getGroups();
            if (groupsInCurrentRole.indexOf(id) != -1) {
                groupsInCurrentRole.remove(groupsInCurrentRole.indexOf(id));
            }
        });
        
        rolesMgr.updateJsonFile();
        
        return true;
    }
    
    /**
     * Adds a role to a group by their respective ids.
     * @param groupId
     * @param roleId
     * @return Role
     */
    public Map<String, Object> addRoleToGroupById(int groupId, int roleId) {
        Map<String, Object> returnObj = new HashMap<String, Object>();
        
        if (groupId < 1 || roleId < 1) {
            System.err.println("Error when adding role to group. Both group and role id must be defined.");
            return null;
        }
        
        Group targetGroup = groups.get(groupId);
        targetGroup.getRoles().add(roleId);
        
        updateJsonFile();
        
        // add to role in roles repo
        RolesManager rolesMgr = RolesManager.getInstance();
        Role targetRole = rolesMgr.getRolesMap().get(roleId);
        targetRole.getGroups().add(groupId);
        
        rolesMgr.updateJsonFile();
        
        returnObj.put("role", targetRole);
        returnObj.put("group", targetGroup);
        return returnObj;
    }
    
    public boolean deleteRoleFromGroupById(int groupId, int roleId) {
        if (groupId < 1 || roleId < 1) {
            System.err.println("Error when deleting role from group. Both group and role id must be defined.");
            return false;
        }
        
        Group targetGroup = groups.get(groupId);
        ArrayList<Integer> roleIdsInGroup = targetGroup.getRoles();
        int indexOfRole = roleIdsInGroup.indexOf(roleId);
        
        if (indexOfRole != -1) {
            int remove = roleIdsInGroup.remove(indexOfRole);
        }
        
        updateJsonFile();
        
        // remove from role in roles repo
        RolesManager rolesMgr = RolesManager.getInstance();
        Role targetRole = rolesMgr.getRolesMap().get(roleId);
        
        for (int i = 0; i < targetRole.getGroups().size(); i++) {
            if (targetRole.getGroups().get(i) == groupId) {
                int foundAtIndex = targetRole.getGroups().remove(i);
                break;
            }
        }
        
        rolesMgr.updateJsonFile();
        
        return true;
    }
    
    public int getAvailableID() {
        if (groupIds.isEmpty()) {
            return 1;
        }
        
        int highestID = getGroupIDs().get(groupIds.size() - 1);
        return highestID + 1;
    }
    
    public ArrayList<Integer> getGroupIDs() {
        Collections.sort(groupIds);
        return groupIds;
    }
    
    public void updateJsonFile() {
        try {
            File file = FileUtils.getFile(BattleDrillsConfig.getGroupsFile());
            FileUtils.writeStringToFile(file, JsonUtils.writeValue(groups), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error when updating persisted groups json");
        }
    }
}
