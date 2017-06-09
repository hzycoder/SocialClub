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
    // �ϴ��ļ�����  
    private String fileTitle;  
    // �ϴ��ļ���  
    private File upload;  
    // �ϴ��ļ�����  
    private String uploadFileType;  
    // �ϴ��ļ���  
    private String uploadFileName;  
    // ֱ����sturts.xml�ļ�������ֵ������  
    //private String savePath_images = "/imageFile";    

	public String execute() {
		//if(upload!=null)
			upload_images();
		System.out.println(uploadFileName);
		Integer id = dailySrc.addmessage(mesg,uploadFileName);
		ActionContext ac = ActionContext.getContext();
		if (id > 0) {
			ac.getSession().put("SUBSUCCESS", "�ύ���ĳɹ�");
			return SUCCESS;
		} else {
			this.addFieldError(ERROR, "ϵͳ��æ");
			return INPUT;
		}
	}
	
	public void upload_images(){
        try {  
            String realpath = ServletActionContext.getServletContext().getRealPath("/upload");  
            System.out.println("ͼƬ·��"+realpath+"3");   
            System.out.println(uploadFileName);
            if(uploadFileName==null||(uploadFileName.trim()).equals("")){
            	this.addFieldError("file", "�ļ�����Ϊ��");
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
