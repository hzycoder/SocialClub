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
	private int pageIndex = 1;// ҳ��
	private int pageCount;
	private int maxResult = 5;// һҳ�����ʾ����

	
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public String execute() {
		ActionContext ac = ActionContext.getContext();
		// ��ȡ����¼��
		int rows = blogSrv.blogRows();
		ac.getSession().put("pageIndex", pageIndex);
		System.out.println("rows===" + rows);
		if (rows % maxResult == 0) {// �����ҳ��
			pageCount = rows / maxResult;
		} else {
			pageCount = rows / maxResult + 1;
		}
		System.out.println("pageCount"+pageCount);
		System.out.println("pageIndex" + pageIndex);

		if (pageIndex < 1) {
			pageIndex = 1;
		} else if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}

		TUser user = (TUser) ac.getSession().get("user");
		Integer userID = user.getUserId();
		blogLists = blogSrv.researchBlog(userID, maxResult, (pageIndex - 1) * maxResult);

		ac.getSession().put("blogLists", blogLists);
		return SUCCESS;

	}

}
