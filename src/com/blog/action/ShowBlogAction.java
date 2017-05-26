package com.blog.action;

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

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
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
		
//		ac.getSession().put("pageIndex", pageIndex);
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
			ac.getSession().put("blogLists", blogShowLists);
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			blogShowLists = blogSrv.researchBlog(user.getUserId(), maxResult, (pageIndex - 1) * maxResult);
			ac.getSession().put("blogShowLists", blogShowLists);
		}
		return SUCCESS;

	}

}
