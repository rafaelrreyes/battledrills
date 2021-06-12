/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.manage;

import com.ngc.battledrills.BattleDrillsConfig;
import com.ngc.battledrills.data.Attachment;
import com.ngc.battledrills.data.BattleDrill;
import com.ngc.battledrills.data.Task;
import com.ngc.battledrills.data.TaskRepo;
import com.ngc.battledrills.data.User;
import com.ngc.battledrills.exception.ItemNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

/**
 *
 * @author rafae
 */
public class AttachmentManager {
    
    private static final String ATTACHMENT_DIRECTORY_PATH = BattleDrillsConfig.getFileDir();
    private static AttachmentManager instance;
    
    private static final Map<String, String> SUPPORTED_TYPES;
    
    public static final long MAX_ATTACHMENT_SIZE = 25000000;    // 25 megabytes
        
    public static class AttachmentTypes {
        public static final String BATTLE_DRILL = "drill";
        public static final String TASK = "task";
    }
    
    // We can add to this map as time goes on and meetings are had
    static {
        Map<String, String> types = new HashMap<>();
        types.put("pdf", "pdf");
        types.put("docx", "vnd.openxmlformats-officedocument.wordprocessingml.document");
        types.put("xlsx", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        types.put("png", "png");
        types.put("jpeg", "jpeg");
        types.put("csv", "csv");
        types.put("text", "plain");
        types.put("json", "json");
        types.put("zip", "zip");
        types.put("compressed", "x-zip-compressed");
        SUPPORTED_TYPES = Collections.unmodifiableMap(types);
    }
    
    private AttachmentManager() {}
    
    public static AttachmentManager getInstance() {
        if (instance == null) {
            instance = new AttachmentManager();
        }
        return instance;
    }
    
    /**
     * Creates a file directory for a drill by its id 
     * @param drillId
     */
    public void createDrillDirectory(String drillId) {
        // create the files directory in secure/data if it doesn't exist
        // although it should, unless deleted by a user manually
        
        try { 
            if (!checkDirectoryExists(ATTACHMENT_DIRECTORY_PATH)) {
                File fileDirectory = new File(ATTACHMENT_DIRECTORY_PATH);
                fileDirectory.mkdirs();
            }

            // create drill directory in secure/data/files/ directory if it doesn't exist
            String drillDirectoryPath = ATTACHMENT_DIRECTORY_PATH + drillId;

            if (!checkDirectoryExists(drillDirectoryPath)) {
                File drillDirectory = new File(drillDirectoryPath);
                drillDirectory.mkdir();
            }
        } catch (SecurityException ex) {
            System.err.println("Error when attempting to create directory. " + ex);
            throw new WebApplicationException("Error when attempting to create directory.");
        }
    }
    
    /**
     * Creates a task directory for a task by its id.
     * @param taskId
     * @throws com.ngc.battledrills.exception.ItemNotFoundException
     */
    public void createTaskDirectory(String taskId) throws ItemNotFoundException {
        // get the task
        Task targetTask = TaskRepo.getTask(taskId);
        String associatedBattleDrill = targetTask.getBattleDrillId();
        
        // create drill directory if it doesn't exist, this would only be when a drill has no attachments
        createDrillDirectory(associatedBattleDrill);
        
        try {
            String taskDirectoryPath = ATTACHMENT_DIRECTORY_PATH + associatedBattleDrill + "/" + taskId;
            
            if (!checkDirectoryExists(taskDirectoryPath)) {
                File taskDirectory = new File(taskDirectoryPath);
                taskDirectory.mkdir();
            }
        } catch (SecurityException ex) {
            System.err.println("Error when attempting to create directory. " + ex);
            throw new WebApplicationException("Error when attempting to create directory");
        }
    }
   
    /**
     * Uploads an attachment to a drill by the drills id, the role uploading (WO, CO, S-1, etc), and the file itself.
     * @param id
     * @param uploader
     * @param inputStream
     * @param fileDetails
     * @return 
     */
    public String uploadDrillAttachment(String id, User uploader, InputStream inputStream, FormDataContentDisposition fileDetails) {
        createDrillDirectory(id);
        String response = "";
        boolean success;
        
        // check for duplicate file name
        BattleDrillManager mgr = BattleDrillManager.getInstance();
        BattleDrill battleDrill = mgr.getById(id);
        
        String fileName = fileDetails.getFileName();
        
        try {
            String filePath = ATTACHMENT_DIRECTORY_PATH + id + "/" + fileName;
            success = uploadFileAttachment(inputStream, filePath);
        } catch (IOException ex) {
            System.err.println("Error when uploading drill attachment: " + ex);
            throw new WebApplicationException("Error when uploading drill attachment.");
        }
       
        if (success) {
            try {
                // uploading a file with a name that already exists of the same extension will just overwrite
                if (fileNameExists(battleDrill, fileName)) {
                    // only update existing attachment "lastModified" property
                    // TODO, update running log of new uploader making an edit, will need another new object and array for this
                    battleDrill.getAttachmentByName(fileName).setLastModified(LocalDateTime.now());
                } else {
                    // create attachment object
                    Attachment attachment = new Attachment();
                    attachment.setUploaderId(uploader.getId());
                    attachment.setFilename(fileName);
                    attachment.setType(AttachmentTypes.BATTLE_DRILL);
                    battleDrill.addAttachment(attachment, uploader);
                }
                mgr.saveBattleDrill(battleDrill.getId(), false);
            } catch (ItemNotFoundException ex) {
                System.err.println("Error when updating attachment POJO");
                throw new WebApplicationException("Error when updating attachment POJO");
            }
            response = "Successfully uploaded drill attachment";
        } else {
            response = "Error when uploading drill attachment";
        }
        
        return response;
    }
    
    /**
     * Uploads an attachment to task by its task id.
     * @param id
     * @param uploader
     * @param inputStream
     * @param fileDetails
     * @return
     * @throws ItemNotFoundException 
     */
    public String uploadTaskAttachment(String id, User uploader, InputStream inputStream, FormDataContentDisposition fileDetails) throws ItemNotFoundException {
        
        // create the directory if need be
        createTaskDirectory(id);
        String response = "";
        boolean success;
        
        // get the task and associated battle drill
        Task targetTask = TaskRepo.getTask(id);
        String drillId = targetTask.getBattleDrillId();
        
        String fileName = fileDetails.getFileName();
        
        try {
            String filePath = ATTACHMENT_DIRECTORY_PATH + drillId + "/" + id + "/" + fileName;
            System.out.println(filePath);
            success = uploadFileAttachment(inputStream, filePath);
        } catch (IOException ex) {
            System.err.println("Error when uploading drill attachment: " + ex);
            throw new WebApplicationException("Error when uploading drill attachment.");
        }
        
        if (success) {
            // uploading a file with a name that already exists of the same extension will just overwrite
            if (fileNameExists(targetTask, fileName)) {
                // only update existing attachment "lastModified" property
                // TODO, update running log of new uploader making an edit, will need another new object and array for this
                targetTask.getAttachmentByName(fileName).setLastModified(LocalDateTime.now());
            } else {
                // create attachment object
                Attachment attachment = new Attachment();
                attachment.setUploaderId(uploader.getId());
                attachment.setFilename(fileName);
                attachment.setType(AttachmentTypes.TASK);
                targetTask.addAttachment(attachment, uploader);
            }   
            response = "Successfully uploaded task attachment";
        } else {
            response = "Error when uploading task attachment";
        }
        
        return response;
    }
    
    /**
     * Uploads an attachment. Ensures that the attachment does not exceed the allowed maximum size in bytes.
     * @param inputStream
     * @param fileTarget
     * @return Response message
     * @throws IOException 
     */
    private boolean uploadFileAttachment(InputStream inputStream, String fileTarget) throws IOException {
        
        boolean successfulUpload = true;
        OutputStream out = null;
        int read = 0;
        byte[] bytes = new byte[1024];
        
        File file = new File(fileTarget);
        out = new FileOutputStream(file);
        while ((read = inputStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
            
            // exceeds maximum allowed size, this can be configured at anytime
            if (file.length() > MAX_ATTACHMENT_SIZE) {
                successfulUpload = false;
                break;
            }
        }
        
        out.flush();
        out.close();
        
        // delete file if it exceeds the size limit
        if (successfulUpload == false) {
            file.delete();
            throw new WebApplicationException("Uploading attachment: " + fileTarget + " failed. File size must be under " + (MAX_ATTACHMENT_SIZE / 1000000) + " megabytes.");
        }
        
        return successfulUpload;
    }
    
    /**
     * Downloads the attachment by using directory path to locate the directory (drill or task), then the filename.
     * @param directoryPath
     * @param fileName
     * @return 
     */
    public StreamingOutput downloadAttachment(String directoryPath, String fileName) {
        
        // Examples for directoryPath param
        // Drill - /secure/data/files/troops_in_contact_5a/report_for_drill_1.pdf
        // Task - /secure/data/files/troops_in_contact_5a/<taskId>/report_for_task_1.pdf
        String fileLocation = ATTACHMENT_DIRECTORY_PATH + directoryPath + fileName;
        // get the file
        StreamingOutput fileStream = new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                try {
                    Path path = Paths.get(fileLocation);
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                } catch (IOException e) {
                    throw new WebApplicationException(
                            Response.status(Response.Status.NOT_FOUND)
                                    .entity("File not found: " + fileName)
                                    .type("text/plain")
                                    .build()
                    );
                }
            }
        };
            
        return fileStream;
    }
    
    /**
     * Deletes an attachment by its id, type, and filename. Type is either drill or task.
     * @param id
     * @param type
     * @param user
     * @param fileName
     * @return 
     * @throws com.ngc.battledrills.exception.ItemNotFoundException 
     */
    public boolean deleteAttachment(String id, String type, User user, String fileName) throws ItemNotFoundException {
        String fileLocation = null;
        boolean isDeletedFromDB = false;
        boolean isDeletedFromFS = false;
        boolean isDeleted = false;
        
        if (type.equals(AttachmentTypes.BATTLE_DRILL)) {
            BattleDrillManager mgr = BattleDrillManager.getInstance();
            BattleDrill bd = mgr.getById(id);
            fileLocation =  ATTACHMENT_DIRECTORY_PATH + id + "/" + fileName;
            isDeletedFromDB = bd.deleteAttachment(fileName, user);
        } else if (type.equals(AttachmentTypes.TASK)) {
            // handle deletion for task attachment
            Task task = TaskRepo.getTask(id);
            String drill = task.getBattleDrillId();
            fileLocation = ATTACHMENT_DIRECTORY_PATH + drill + "/" + id + "/" + fileName;
            isDeletedFromDB = task.deleteAttachment(fileName, user);
        }
        
        System.out.println(fileLocation);
        
        try { 
            
            // locate the file
            File targetFile = new File(fileLocation);
            if (targetFile.exists()) {
                isDeletedFromFS = targetFile.delete();
            }
        } catch (SecurityException ex) {
            throw new WebApplicationException("Error when deleting attachment: " + fileLocation);
        }

        if (isDeletedFromDB && isDeletedFromFS) {
            isDeleted = true;
        } else {
            throw new WebApplicationException("Error when deleting attachment: " + fileLocation + ". File doesn't exist in either database or filesystem");
        }
        return isDeleted;
    }
    
    /**
     * Checks if a drill contains an attachment that already contains a given name.
     * @param drill
     * @param filename
     * @return 
     */
    public boolean fileNameExists(BattleDrill drill, String filename) {
        boolean exists = false;
        
        for (Attachment attachment : drill.getAttachments()) {
            if (attachment.getFilename().equals(filename)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    
    /**
     * Checks if a task contains an attachment that already contains a given name.
     * @param task
     * @param filename
     * @return
     */
    public boolean fileNameExists(Task task, String filename) {
        boolean exists = false;
        for (Attachment attachment : task.getAttachments()) {
            if (attachment.getFilename().equals(filename)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    
    /**
     * Checks to see if attachment exists.
     * @param id
     * @param type
     * @param fileName
     * @return boolean
     * @throws com.ngc.battledrills.exception.ItemNotFoundException
     */
    
    public boolean checkAttachmentExists(String id, String type, String fileName) throws ItemNotFoundException {
        boolean exists = false;    
        if (type.equals(AttachmentTypes.BATTLE_DRILL)) {
            BattleDrillManager mgr = BattleDrillManager.getInstance();
            BattleDrill bd = mgr.getById(id);
            exists = fileNameExists(bd, fileName);
        } else if (type.equals(AttachmentTypes.TASK)) {
            Task task =  TaskRepo.getTask(id);
            exists = fileNameExists(task, fileName);
        }
        return exists;
    }
    
    /**
     * Checks if the path parameter currently exists as a file directory.
     * @param path
     * @return 
     */
    public boolean checkDirectoryExists(String path) {
        File file = new File(path);
        return file.exists() && file.isDirectory();
    }
    
            
    /**
     * Checks if the media type is supported by Battle Drills.
     * @param mediaType
     * @return boolean
     */
    public boolean isSupportedAttachmentType(String mediaType) {
        // split media type by "/", only extract the second part
        // example: application/json -> json
        String[] parts = mediaType.split("/");
        return SUPPORTED_TYPES.containsValue(parts[1]);
    }
}
