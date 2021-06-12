/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.rest;

import com.ngc.battledrills.restparams.AttachmentRestParams;
import com.ngc.battledrills.manage.AttachmentManager;
import static com.ngc.battledrills.manage.AttachmentManager.AttachmentTypes;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import com.ngc.battledrills.data.Task;
import com.ngc.battledrills.data.TaskRepo;
import com.ngc.battledrills.data.User;
import com.ngc.battledrills.exception.ItemNotFoundException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

/**
 *
 * @author rafael
 */

@Path("/attachment")
public class AttachmentService {
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/check")
    public Response checkAttachment(
        @QueryParam("filename") String fileName,
        @QueryParam("id") String id,
        @QueryParam("type") String type
        ) throws ItemNotFoundException {
        
        if (StringUtils.isBlank(fileName) || StringUtils.isBlank(id) || StringUtils.isBlank(type)) {
            throw new WebApplicationException(
                Response.status(Response.Status.BAD_REQUEST)
                    .entity("Some parameters are missing. Filename, ID, and type must all be defined.")
                    .build()
            );
        }
        
        Response response = null;
        
        if (!type.equals(AttachmentTypes.BATTLE_DRILL) && !type.equals(AttachmentTypes.TASK)) {
            response = Response.status(Response.Status.BAD_REQUEST)
                    .entity("Attachments can only be uploaded to drills or tasks.")
                    .build();
        } else {
            AttachmentManager mgr = AttachmentManager.getInstance();
            boolean attachmentExists = mgr.checkAttachmentExists(id, type, fileName);
            response = Response.status(Response.Status.OK).entity(attachmentExists).build();
        }
        
        return response;
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("text/plain")
    public Response uploadAttachment(
        @FormDataParam("id") String id,
        @FormDataParam("type") String type,
        @FormDataParam("uploader") FormDataBodyPart uploader,
        @FormDataParam("file") InputStream inputStream, 
        @FormDataParam("file") FormDataContentDisposition fileDetails,
        @FormDataParam("file") FormDataBodyPart body
    ) throws ItemNotFoundException {
        
        // TODO check if user is authorized otherwise return UNAUTHORIZED
        
        AttachmentManager mgr = AttachmentManager.getInstance();
        
        // check if file type is supported
        String mediaType = body.getMediaType().toString();
        if (mgr.isSupportedAttachmentType(mediaType) == false) {
            throw new WebApplicationException(
                Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE)
                    .entity("Unsupported media type.")
                    .type("text/plain")
                    .build()
            );
        }
        
        // check if all form parameters are provided
        if (StringUtils.isBlank(id) || StringUtils.isBlank(type) || null == inputStream || null == fileDetails || null == uploader || null == body) {
            throw new WebApplicationException(
                Response.status(Response.Status.BAD_REQUEST)
                    .entity("Some parameters are missing. ID, type, and file must all be defined.")
                    .type("text/plain")
                    .build()
            );
        }
        
        // http response
        Response response = null;
        
        // upload file
        if (!type.equals(AttachmentTypes.BATTLE_DRILL) && !type.equals(AttachmentTypes.TASK)) {
            response = Response.status(Response.Status.BAD_REQUEST)
                    .entity("Attachments can only be uploaded to drills or tasks.")
                    .type("text/plain")
                    .build();
        } else {
            uploader.setMediaType(MediaType.APPLICATION_JSON_TYPE);
            User jsonifiedUploader = uploader.getValueAs(User.class);
            String responseMessage = type.equals(AttachmentManager.AttachmentTypes.BATTLE_DRILL)
                    ? mgr.uploadDrillAttachment(id, jsonifiedUploader, inputStream, fileDetails)
                    : mgr.uploadTaskAttachment(id, jsonifiedUploader, inputStream, fileDetails);
            response = Response.status(Response.Status.OK).entity(responseMessage).build();
        }
        
        return response;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadAttachmentByQuery(
            @QueryParam("filename") String fileName,
            @QueryParam("id") String id,
            @QueryParam("type") String type
    ) throws ItemNotFoundException {   
        // TODO check if user is authorized otherwise return UNAUTHORIZED
        
        // check if all parameters are provided
        if (StringUtils.isBlank(fileName) || StringUtils.isBlank(id) || StringUtils.isBlank(type)) {
            throw new WebApplicationException(
                Response.status(Response.Status.BAD_REQUEST)
                    .entity("Some parameters are missing. Filename, ID, and type must all be defined.")
                    .type("text/plain")
                    .build()
            );
        }
        
        // http response
        Response response = null;
        
        // download file
        if (!type.equals(AttachmentTypes.BATTLE_DRILL) && !type.equals(AttachmentTypes.TASK)) {
            throw new WebApplicationException(
                Response.status(Response.Status.BAD_REQUEST)
                    .entity("Attachments can only be downloaded from drill or tasks directories.")
                    .type("text/plain")
                    .build()
            );
        } else {
            
            String directoryPath = "";
            
            if (type.equals(AttachmentTypes.BATTLE_DRILL)) {
                // the path should just be to the drills directory
                directoryPath = id + "/";
            } else {
                // the path should be the taskId as the directory name, stored inside of the roles drills directory
                // ex. /troops_in_contact_5a/1234_5678/
                Task task = TaskRepo.getTask(id);
                String drill = task.getBattleDrillId();
                directoryPath = drill + "/" + id + "/";
            }
            
            AttachmentManager mgr = AttachmentManager.getInstance();
            StreamingOutput fileStream = mgr.downloadAttachment(directoryPath, fileName);
            
            ResponseBuilder responseBuilder = Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM);
            responseBuilder.header("Content-Disposition", "attachment; filename=" + fileName);
            response = responseBuilder.build();
            return response;
        }
        
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAttachment(AttachmentRestParams params) throws ItemNotFoundException {
        
        String filename = params.getFilename();
        String id = params.getId();
        User user = params.getUser();
        String type = params.getType();
        
        // TODO check if user is authorized otherwise return UNAUTHORIZED
        
        if (StringUtils.isBlank(filename) || StringUtils.isBlank(id) || StringUtils.isBlank(type) || null == user || user.isEmpty()) {
            throw new WebApplicationException(
                Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error when deleting attachment. Filename, id, user object, and type must all be specified.")
                    .type("text/plain")
                    .build()
            );
        }
        
        // http response
        Response response = null;
        
        // download file
        if (!type.equals(AttachmentTypes.BATTLE_DRILL) && !type.equals(AttachmentTypes.TASK)) {
            throw new WebApplicationException(
                Response.status(Response.Status.BAD_REQUEST)
                    .entity("Attachments can only be downloaded from drill or tasks directories.")
                    .type("text/plain")
                    .build()
            );
        } else {

            AttachmentManager mgr = AttachmentManager.getInstance();
            boolean isAttachmentDeleted = mgr.deleteAttachment(id, type, user, filename);
            
            if (isAttachmentDeleted) {
                response = Response.status(Response.Status.OK)
                    .entity("Successfully deleted attachment.")
                    .type("text/plain")
                    .build();
            } else {
                response = Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error when attempting to delete attachment.")
                    .type("text/plain")
                    .build();
            }
            
            return response;
        }   
    }
}
