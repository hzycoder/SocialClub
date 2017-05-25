package com.blog.action;

import java.util.List;

import javax.annotation.Resource;

import com.blog.domain.BlogList;
import com.blog.service.BlogService;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowBlogAction extends ActionSupport {
	@Resource
	List<BlogList> blogLists;
	@Resource
	BlogService blogSrv;
	private int pageIndex = 1;// 页码
	private int pageCount;
	private int maxResult = 5;// 一页最大显示行数

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public String execute() {
		int rows;
		// -----分页显示----
		ActionContext ac = ActionContext.getContext();
		// 获取最大记录数

		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
			TUser friend = (TUser) ac.getSession().get("friend");
			rows = blogSrv.blogRows(friend.getUserId());
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			rows = blogSrv.blogRows(user.getUserId());
		}
		
//		ac.getSession().put("pageIndex", pageIndex);
		System.out.println("rows===" + rows);
		if (rows % maxResult == 0) {// 算出总页数
			pageCount = rows / maxResult;
		} else {
			pageCount = rows / maxResult + 1;
		}
		if (pageIndex < 1) {
			pageIndex = 1;
		} else if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}

		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
			TUser friend = (TUser) ac.getSession().get("friend");
			blogLists = blogSrv.researchBlog(friend.getUserId(), maxResult, (pageIndex - 1) * maxResult);
			ac.getSession().put("blogLists", blogLists);
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			blogLists = blogSrv.researchBlog(user.getUserId(), maxResult, (pageIndex - 1) * maxResult);
			ac.getSession().put("blogLists", blogLists);
		}
		return SUCCESS;

	}

}
