package com.info.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.TUser;
import com.info.dao.infoDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
public class infoAction extends ActionSupport {
	private TUser user;
	private List<TUser> userList;
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public List<TUser> getUserList() {
		return userList;
	}
	public void setUserList(List<TUser> userList) {
		this.userList = userList;
	}
	private static final int BUFFER_SIZE=40*40;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}

	
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	private static void copy(File source,File target){
		InputStream is = null;
		OutputStream os =null;
		try{
			is = new BufferedInputStream(new FileInputStream(source),BUFFER_SIZE);
			os = new BufferedOutputStream(new FileOutputStream(target),BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int length = 0;
			while((length=is.read(buffer))>0){
				os.write(buffer,0,length);
			}
		}
		catch(Exception e){
			System.out.println("写失败了");
		}
		finally{
			if(null!=is){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(null!=os){
					try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	public String execute(){
		ActionContext ac = ActionContext.getContext();
		user=(TUser)ac.getSession().get("user");
		System.out.println("user:"+user.getUserId());
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		infoDao ifd = (infoDao) cxt.getBean("infoDao");
		userList= ifd.searchUser(user);
		return SUCCESS;
	}
	public String modify(){
		ActionContext ac = ActionContext.getContext();
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		infoDao ifd = (infoDao) cxt.getBean("infoDao");
		TUser flag = (TUser)ac.getSession().get("user");
		user.setUsername(flag.getUsername());
		System.out.println("petname"+user.getPetname()+user.getBirthday());
		ifd.updateUser(user);
		return "update";
	}
	public String modifyPhoto(){
		ActionContext ac=ActionContext.getContext();
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		infoDao ifd = (infoDao) cxt.getBean("infoDao");
		user = (TUser)ac.getSession().get("user");
			
		String userPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath())+"\\"+user.getUsername();
		String path = userPath+"\\"+this.getUploadFileName();
		System.out.println(path);
		File f = new File(userPath);
		if(!f.exists()&&!f.isDirectory()){
			System.out.println("文件夹不存在");
			boolean flag;
			flag=f.mkdirs();
			if(!flag){
				System.out.println("无法创建");
			}
			
		
		}
		else{
			System.out.println("已创建");
		}	
			File target = new File(path);
			
			System.out.println(this.upload+this.uploadContentType+this.uploadFileName);
			copy(this.upload,target);
			user.setUPicture(this.getUploadFileName());
			ifd.updatePhoto(user);
		ac.getSession().put("user", user);
		return "photo";
	}
}
