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
	@Resource
	BlogService blogSrv;
	private int pageIndex = 1;// ҳ��
	private int pageCount;
	private int maxResult = 5;// һҳ�����ʾ����
	private String titleString;
	private String contentString;

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

	public String showContent() {
		return "blogCotent";
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String execute() {
		int rows;
		// -----��ҳ��ʾ----
		ActionContext ac = ActionContext.getContext();
		// ��ȡ����¼��

		if (ac.getSession().get("friend") != null) {// �жϵ�ǰ�Ƿ���������û���ҳ
			TUser friend = (TUser) ac.getSession().get("friend");
			rows = blogSrv.blogRows(friend.getUserId());
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			rows = blogSrv.blogRows(user.getUserId());
		}

		System.out.println("rows===" + rows);
		if (rows % maxResult == 0) {// �����ҳ��
			pageCount = rows / maxResult;
		} else {
			pageCount = rows / maxResult + 1;
		}
		if (pageIndex < 1) {
			pageIndex = 1;
		} else if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}

		if (ac.getSession().get("friend") != null) {// �жϵ�ǰ�Ƿ���������û���ҳ
			TUser friend = (TUser) ac.getSession().get("friend");
			blogShowLists = blogSrv.researchBlog(friend.getUserId(), maxResult, (pageIndex - 1) * maxResult);
			ac.getSession().put("blogShowLists", blogShowLists);
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			blogShowLists = blogSrv.researchBlog(user.getUserId(), maxResult, (pageIndex - 1) * maxResult);
			ac.getSession().put("blogShowLists", blogShowLists);
		}
		return SUCCESS;

	}

}
