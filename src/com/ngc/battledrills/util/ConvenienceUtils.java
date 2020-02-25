/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ConvenienceUtils {
    public static String JTCW_REG_LOCATION = "HKEY_LOCAL_MACHINE\\SOFTWARE\\Wow6432Node\\JTCW\\JTCWCGW";
    
    public enum VmfType
    {
        MEDEVAC
    }
    
    public static String readWindowsRegistry(String location, String key) {
        return ConvenienceUtils.readWindowsRegistry(location, key, "REG_SZ");
    }
    
    // Valid dataType: REG_SZ, REG_MULTI_SZ, REG_EXPAND_SZ, REG_DWORD, REG_QWORD,
  // REG_BINARY, REG_NONE. 
  // Note: It's the caller responsibility to convert the returned value to the desired data type.
    public static String readWindowsRegistry(String location, String key, String dataType) {
        String value = null;
        String query = "REG QUERY " + "\"" + location + "\" /v " + "\"" + key + "\"" + " /t " + dataType;
        List<String> result = new ArrayList<>();
        if (ConvenienceUtils.execute(query, result) == false) 
        {
            return value;
        }
        
        // result has the following format:
        // Windows 7: \n<Version information>\n\n<key>\t<registry type>\t<value>
        // Windows Server 2003: \n<Version information>\n\n<key> <registry type> <value>
        for (String line : result) {
            final String regsz = dataType;
            if ((line.trim().contains(key))) {
                if (line.contains("\t")) {
                    String[] parsed = line.split("\t");
                    value = parsed[parsed.length - 1];
                    break;
                } else {
                    int index = line.indexOf(regsz);
                    if (index == -1) {
                        continue;
                    }
                    index += regsz.length();
                    // Skip spaces between <registry type> and <value>
                    for (; index < line.length(); index++) {
                        if (line.charAt(index) != ' ') {
                            break;
                        }
                    }
                    value = line.substring(index);
                }
            }
        }
        return value;
    }
    
    public static boolean execute(String sysCommand, List<String> result) {
        String line = null;
        boolean successful = false;
        try {
            java.lang.Process p = Runtime.getRuntime().exec(sysCommand);
            BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = bri.readLine()) != null) {
                result.add(line);
            }
            bri.close();
            successful = true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return successful;
    }
}
