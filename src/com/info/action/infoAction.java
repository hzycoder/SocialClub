package com.info.action;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.xwork.ObjectUtils.Null;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.TUser;
import com.info.dao.infoDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

	private static final int BUFFER_SIZE = 40 * 40;
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

	private static void copy(File source, File target) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(source), BUFFER_SIZE);
			os = new BufferedOutputStream(new FileOutputStream(target), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (Exception e) {
			System.out.println("写失败了");
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (null != os) {
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

	public String execute() {
		ActionContext ac = ActionContext.getContext();
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		infoDao ifd = (infoDao) cxt.getBean("infoDao");

		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
			TUser friend = (TUser) ac.getSession().get("friend");
			userList = ifd.searchUser(friend);
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			userList = ifd.searchUser(user);
		}
		return SUCCESS;
	}

//	public void validateModify() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date = new java.util.Date();
//		String birthday = sdf.format(user.getBirthday());
//		this.clearErrorsAndMessages();
//
//		Pattern numPatt = Pattern.compile("[0-9]*");
//		Pattern birthdayPatt = Pattern.compile(
//				"^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))");
//
//		byte[] bytes = user.getPetname().getBytes();
//		if (bytes.length > 0 && bytes.length <= 20) {
//			this.addFieldError("usernameError", "昵称长度非法");
//		}
//		if (!user.getPhone().equals("") && user.getPhone().length() != 11) {
//			this.addFieldError("phoneError", "请填写正确的联系电话");
//		}
//
//
//	}

	public String modify() {
		ActionContext ac = ActionContext.getContext();
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		infoDao ifd = (infoDao) cxt.getBean("infoDao");

		
			TUser nowTUser = (TUser) ac.getSession().get("user");
			user.setUsername(nowTUser.getUsername());
			ifd.updateUser(user);
			
		
		return "update";
	}

	public String modifyPhoto() {
		ActionContext ac = ActionContext.getContext();
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		infoDao ifd = (infoDao) cxt.getBean("infoDao");

		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
			user = (TUser) ac.getSession().get("friend");
		} else {
			user = (TUser) ac.getSession().get("user");
		}

		String userPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + "\\"
				+ user.getUsername();
		String path = userPath + "\\" + this.getUploadFileName();
		// System.out.println("----------path-----");
		// System.out.println(path);
		// System.out.println(this.getUploadFileName());
		// System.out.println("----------path-----");
		File f = new File(userPath);
		if (!f.exists() && !f.isDirectory()) {
			System.out.println("文件夹不存在");
			boolean flag;
			flag = f.mkdirs();
			if (!flag) {
				System.out.println("无法创建");
			}

		} else {
			System.out.println("已创建");
		}
		File target = new File(path);
		// System.out.println(this.upload + this.uploadContentType +
		// this.uploadFileName);
		copy(this.upload, target);
		if (this.getUploadFileName() != null) {// 防止不上传文件就提交
			user.setUPicture(this.getUploadFileName());
		}
		ifd.updatePhoto(user);

		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
			ac.getSession().put("friend", user);
		} else {
			ac.getSession().put("user", user);
		}
		return "photo";
	}
}
