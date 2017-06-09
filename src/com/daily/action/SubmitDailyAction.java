package com.daily.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.daily.service.DailyService;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SubmitDailyAction extends ActionSupport {

	private String mesg;
	@Resource
	private DailyService dailySrc;
    // 上传文件标题  
    private String fileTitle;  
    // 上传文件域  
    private File upload;  
    // 上传文件类型  
    private String uploadFileType;  
    // 上传文件名  
    private String uploadFileName;  
    // 直接在sturts.xml文件中配置值的属性  
    //private String savePath_images = "/imageFile";    

	public String execute() {
		//if(upload!=null)
			upload_images();
		System.out.println(uploadFileName);
		Integer id = dailySrc.addmessage(mesg,uploadFileName);
		ActionContext ac = ActionContext.getContext();
		if (id > 0) {
			ac.getSession().put("SUBSUCCESS", "提交博文成功");
			return SUCCESS;
		} else {
			this.addFieldError(ERROR, "系统繁忙");
			return INPUT;
		}
	}
	
	public void upload_images(){
        try {  
            String realpath = ServletActionContext.getServletContext().getRealPath("/upload");  
            System.out.println("图片路径"+realpath+"3");   
            System.out.println(uploadFileName);
            if(uploadFileName==null||(uploadFileName.trim()).equals("")){
            	this.addFieldError("file", "文件不能为空");
            }else{
                File savefile = new File(realpath,uploadFileName);  
               if (!savefile.getParentFile().exists()){  
                   savefile.getParentFile().mkdirs();  
                } 
                FileUtils.copyFile(upload, savefile);  
            }
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	
	public String getFileTitle() {
		return fileTitle;
	}

	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileType() {
		return uploadFileType;
	}

	public void setUploadFileType(String uploadFileType) {
		this.uploadFileType = uploadFileType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

//	public String getSavePath_images() {
//		return savePath_images;
//	}
//
//	public void setSavePath_images(String savePath_images) {
//		this.savePath_images = savePath_images;
//	}
}
