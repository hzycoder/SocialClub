package com.blog.action;

import java.util.List;

import javax.annotation.Resource;

import com.blog.domain.BlogList;
import com.blog.service.BlogService;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowBlogAction extends ActionSupport{
	@Resource
	List<BlogList> blogLists;
	@Resource
	BlogService blogSrv;
	@Override
	public String execute(){
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		Integer userID = user.getUserId();
		blogLists = blogSrv.researchBlog(userID,3,0);
		
		ac.getSession().put("blogLists", blogLists);
		System.out.println("blogsshowActionoOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		System.out.println(blogLists.get(0).getContent());
		return SUCCESS;
		
	}

}
