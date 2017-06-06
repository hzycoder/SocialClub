package com.blog.action;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.blog.domain.BlogList;
import com.blog.domain.BlogShow;
import com.blog.service.BlogService;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowBlogAction extends ActionSupport {
	List<BlogShow> blogShowLists;
	private int pageIndex = 1;// 页码
	private int pageCount;
	private int maxResult = 5;// 一页最大显示行数
	private String titleString;
	private String contentString;
	private String timeString;
	@Resource
	BlogList blogList;
	@Resource
	BlogService blogSrv;

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public String getContentString() {
		return contentString;
	}

	public void setContentString(String contentString) {
		this.contentString = contentString;
	}

	public String getTitleString() {
		return titleString;
	}

	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}

	public List<BlogShow> getBlogShowLists() {
		return blogShowLists;
	}

	public void setBlogShowLists(List<BlogShow> blogShowLists) {
		this.blogShowLists = blogShowLists;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public String showContent() {	//跳转到内容
		return "blogCotent";
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
			blogShowLists = blogSrv.researchBlog(friend.getUserId(), maxResult, (pageIndex - 1) * maxResult);
			// ac.getSession().put("blogShowLists", blogShowLists);
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			blogShowLists = blogSrv.researchBlog(user.getUserId(), maxResult, (pageIndex - 1) * maxResult);
			// ac.getSession().put("blogShowLists", blogShowLists);
		}
		return SUCCESS;

	}

	public String submitBlog() {
		ActionContext ac = ActionContext.getContext();

		blogList.setContent(titleString + "|_z!5)" + contentString);

		Integer id = blogSrv.insertBlog(blogList);
		if (id > 0) {
			ac.getSession().put("SUBSUCCESS", "提交博文成功");
			return "submitSuccess";
		} else
			this.addFieldError(ERROR, "系统繁忙");
		return "submitFaile";

	}

}
