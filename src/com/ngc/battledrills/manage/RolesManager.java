/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngc.battledrills.BattleDrillsConfig;
import com.ngc.battledrills.data.Role;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.ngc.battledrills.constants.RolesConstants.RolesProperties;
import com.ngc.battledrills.util.JsonUtils;
import java.nio.charset.StandardCharsets;
import static org.apache.commons.io.FileUtils.getFile;

/**
 *
 * @author rafae
 */
public class RolesManager {
    
    private static final List<Role> roles = new ArrayList<Role>();
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
     * Returns the list of role objects.
     * @return 
     */
    public List<Role> getRoles() {
        return roles;
    }
    
    /**
     * Returns an array list of role names.
     * @return 
     */
    public ArrayList<String> getRolenames() {
        ArrayList<String> roleNames = new ArrayList<String>();
        roles.forEach((role) -> {
           roleNames.add(role.getName());
        });
        return roleNames;
    }
    
    private void loadAllRoles() {
        // load all roles from json file
        try {
            File rolesFile = new File(BattleDrillsConfig.getRolesFile());
            String fileContents = FileUtils.readFileToString(rolesFile);
            List<Role> mappedRoles = loadFromJson(fileContents);
            roles.addAll(mappedRoles);
            roles.forEach((role) -> {
                roleIds.add(role.getId());
            });
        } catch (IOException e) {
            System.err.println("Unable to load  roles into runtime");
        }
    }
    
    /**
     * De-serializes role string into role object.
     * @param json
     * @return Role
     * @throws IOException 
     */
    private List<Role> loadFromJson(String json) throws IOException {
        List<Role> roles = Arrays.asList(new ObjectMapper().readValue(json, Role[].class));
        return roles;
    }
    
    /**
     * 
     * @param name
     * @param permission 
     */
    public void addRole(String name, String permission) throws JsonProcessingException, IOException {
        
        if (null == name || null == permission) {
            return;
        }
        
        // self assign ID
        int newRoleId = getAvailableID();
        Role newRole = new Role(newRoleId, name, permission);
        
        // add role to runtime and role ID container
        roles.add(newRole);
        roleIds.add(newRoleId);
        
        updateJsonFile();
    }
    
    /**
     * Edits a role's value by property.
     * @param id
     * @param property
     * @param value 
     */
    public void editRoleByProperty(int id, RolesProperties property, String value) throws JsonProcessingException, IOException {
        
        if (null == property || null == value) {
            return;
        }
        
        Role targetRole = null;
        // find corresponding role by id
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getId() == id) {
                targetRole = roles.get(i);
                break;
            }
        }
        
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
    }
    
    /**
     * Deletes a role by its ID.
     * @param id
     * @return 
     */
    public boolean deleteRoleById(int id) {
        boolean isDeleted = false;
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getId() == id) {
                roles.remove(i);
                isDeleted = true;
                updateJsonFile();
                break;
            }
        }
        
        // remove id in the rolesId container
        for (int j = 0; j < roleIds.size(); j++) {
            if (roleIds.get(j) == id) {
                roleIds.remove(j);
                break;
            }
        }
        
        return isDeleted;
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
    private void updateJsonFile() {
        try {
            File file = FileUtils.getFile(BattleDrillsConfig.getRolesFile());
            FileUtils.writeStringToFile(file, JsonUtils.writeValue(roles), StandardCharsets.UTF_8);
        } catch (IOException e) {
            
        }
    }
}
