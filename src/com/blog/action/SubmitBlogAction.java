package com.blog.action;

import javax.annotation.Resource;

import org.apache.struts2.components.Else;

import com.blog.domain.BlogList;
import com.blog.service.BlogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitBlogAction extends ActionSupport {
	String title;
	String content;
	@Resource
	BlogList blogList;
	@Resource
	BlogService blogSrv;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String execute() {
		ActionContext ac = ActionContext.getContext();
		
		blogList.setContent(title+"\n"+content);
		
		Integer id = blogSrv.insertBlog(blogList);
		if (id > 0) {
			ac.getSession().put("SUBSUCCESS", "提交博文成功");
			return SUCCESS;
		} else 
			this.addFieldError(ERROR, "系统繁忙");
			return INPUT;

	}
}
