/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngc.battledrills.BattleDrillsConfig;
import com.ngc.battledrills.data.Role;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.ngc.battledrills.constants.RolesConstants.RolesProperties;
import com.ngc.battledrills.data.Group;
import com.ngc.battledrills.util.JsonUtils;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rafae
 */
public class RolesManager {
    
    private static final Map<Integer, Role> roles = new HashMap<Integer, Role>();
    private static final ArrayList<Integer> roleIds = new ArrayList<Integer>();
    private static RolesManager instance;
    
    private RolesManager() {
        loadAllRoles();
    }
    
    public static RolesManager getInstance() {
        if (instance == null) {
            instance = new RolesManager();
        }
        
        return instance;
    }
    
    /**
     * Returns the map of role objects.
     * @return 
     */
    public Map<Integer, Role> getRolesMap() {
        return roles;
    }
    
    /**
     * Returns the list of role objects.
     * @return 
     */
    public List<Role> getRolesList() {
        return new ArrayList<>(roles.values());
    }
    
    /**
     * Returns an array list of role names.
     * @return 
     */
    public ArrayList<String> getRolenames() {
        ArrayList<String> roleNames = new ArrayList<>();
        getRolesList().forEach((role) -> {
           roleNames.add(role.getName());
        });
        return roleNames;
    }
    
    private void loadAllRoles() {
        // load all roles from json file
        try {
            File rolesFile = new File(BattleDrillsConfig.getRolesFile());
            String fileContents = FileUtils.readFileToString(rolesFile);
            Map<Integer, Role> mappedRoles = loadFromJson(fileContents);
            roles.putAll(mappedRoles);
            getRolesList().forEach((role) -> {
                roleIds.add(role.getId());
            });
        } catch (IOException e) {
            System.err.println("Unable to load roles into runtime");
        }
    }
    
    /**
     * De-serializes role string into role object.
     * @param json
     * @return Role
     * @throws IOException 
     */
    private Map<Integer, Role> loadFromJson(String json) throws IOException {
        Map<Integer, Role> mappedRoles = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Role>>() {});
        return mappedRoles;
    }
    
    /**
     * 
     * @param name
     * @param permission 
     * @param groups 
     * @return  
     * @throws com.fasterxml.jackson.core.JsonProcessingException 
     */
    public Role addRole(String name, String permission, ArrayList<Integer> groups) throws JsonProcessingException, IOException {
        
        if (null == name || null == permission) {
            return null;
        }
        
        if (null == groups) {
            groups = new ArrayList<>();
        }
        
        // self assign ID
        int newRoleId = getAvailableID();
        Role newRole = new Role(newRoleId, name, permission, groups);
        
        // add role to runtime and role ID container
        roles.put(newRoleId, newRole);
        roleIds.add(newRoleId);
        
        GroupManager groupMgr = GroupManager.getInstance();
        groups.forEach((groupId) -> {
            Group currentGroup = groupMgr.getGroupsMap().get(groupId);
            currentGroup.getRoles().add(newRoleId);
        });
        
        groupMgr.updateJsonFile();
        
        updateJsonFile();
        
        return newRole;
    }
    
    /**
     * Edits multiple properties of a role by its id.
     * Properties can contain "name" or "permission".
     * @param id
     * @param properties
     * @return Role
     */
    public Role editRoleProperties(int id, Map<String, String> properties) {
        
        Role targetRole = roles.get(id);
        
        if (null != targetRole) {
            if (properties.containsKey("name")) {
                targetRole.setName(properties.get("name"));
            }

            if (properties.containsKey("permission")) {
                targetRole.setPermission(properties.get("permission"));
            }
        }
        
        updateJsonFile();
        
        return targetRole;
    }
    
    /**
     * Edits a role's value by property.
     * @param id
     * @param property
     * @param value 
     * @return Role
     * @throws com.fasterxml.jackson.core.JsonProcessingException 
     */
    public Role editRoleByProperty(int id, RolesProperties property, String value) throws JsonProcessingException, IOException {
        
        if (null == property || null == value) {
            return null;
        }
        
        Role targetRole = roles.get(id);
        
        // set property
        if (null != targetRole) {
            switch (property) {
                case NAME:
                    targetRole.setName(value);
                    break;
                case PERMISSION:
                    targetRole.setPermission(value);
                    break;
                default:
                    break;      
            }
        }
        
        updateJsonFile();
        
        return targetRole;
    }
    
    /**
     * Deletes a role by its ID.
     * @param id
     * @return 
     */
    public boolean deleteRoleById(int id) {
        boolean isDeleted = false;
        Role removedRole = roles.remove(id);
          
        if (null == removedRole) {
            return false;
        }
        
        updateJsonFile();

        // remove id in the rolesId container
        for (int j = 0; j < roleIds.size(); j++) {
            if (roleIds.get(j) == id) {
                roleIds.remove(j);
                break;
            }
        }
        
        GroupManager groupMgr = GroupManager.getInstance();
        List<Group> groups = groupMgr.getGroupsList();
        
        groups.forEach((group) -> {
            ArrayList<Integer> rolesInCurrentGroup = group.getRoles();
            if (rolesInCurrentGroup.indexOf(id) != -1) {
                rolesInCurrentGroup.remove(rolesInCurrentGroup.indexOf(id));
            }
        });
        
        groupMgr.updateJsonFile();
        
        return true;
    }
    
    /**
     * Gets an available role id by selecting the highest ID number
     * in the Roles ID array then taking the next available ID number.
     * @return int
     */
    public int getAvailableID() {
        if (roleIds.isEmpty()) {
            return 1;
        }
        
        int highestID = getRoleIDs().get(roleIds.size() - 1);
        return highestID + 1;
    }
    
    /**
     * Gets an array of IDs that are used by other roles.
     * @return 
     */
    public ArrayList<Integer> getRoleIDs() {
        // sort the array first
        Collections.sort(roleIds);
        return roleIds;
    }
    
    /**
     * Writes the contents of Roles container to json file.
     */
    public void updateJsonFile() {
        try {
            File file = FileUtils.getFile(BattleDrillsConfig.getRolesFile());
            FileUtils.writeStringToFile(file, JsonUtils.writeValue(roles), StandardCharsets.UTF_8);
        } catch (IOException e) {
            
        }
    }
}
