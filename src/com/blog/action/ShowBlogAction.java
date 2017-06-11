package com.blog.action;

import java.util.List;

import javax.annotation.Resource;

import com.blog.domain.BlogComment;
import com.blog.domain.BlogList;
import com.blog.domain.BlogShow;
import com.blog.service.BlogService;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.RefreshUC;

public class ShowBlogAction extends ActionSupport {

	private int pageIndex = 1;// ҳ��
	private int pageCount;
	private int maxResult = 5;// һҳ�����ʾ����
	private int blogId;
	private String titleString;
	private String contentString;
	private String timeString;
	private String researchKey;
	private String commentDetail;
	@Resource
	List<BlogShow> blogShowLists;
	// @Resource
	// List<BlogShow> blogShowLists1;// ��ʾ����������
	@Resource
	BlogList blogList;
	@Resource
	BlogService blogSrv;
	@Resource
	RefreshUC ruc;
	@Resource
	List<BlogComment> blogCommentList;

	// public List<BlogShow> getBlogShowLists1() {
	// return blogShowLists1;
	// }
	//
	// public void setBlogShowLists1(List<BlogShow> blogShowLists1) {
	// this.blogShowLists1 = blogShowLists1;
	// }

	public String getResearchKey() {
		return researchKey;
	}

	public List<BlogComment> getBlogCommentList() {
		return blogCommentList;
	}

	public void setBlogCommentList(List<BlogComment> blogCommentList) {
		this.blogCommentList = blogCommentList;
	}

	public String getCommentDetail() {
		return commentDetail;
	}

	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}

	public void setResearchKey(String researchKey) {
		this.researchKey = researchKey;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

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
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			blogShowLists = blogSrv.researchBlog(user.getUserId(), maxResult, (pageIndex - 1) * maxResult);
		}
		ruc.refreshUC();
		return SUCCESS;
	}

	public String showContent() { // ��ת������
//		ActionContext ac = ActionContext.getContext();
		int rows = blogSrv.getCommentCount(blogId);
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
		System.out.println(blogId+"  "+maxResult+"  "+pageIndex+"  "+pageCount);
		blogCommentList = blogSrv.commentList(blogId,maxResult, (pageIndex - 1) * maxResult);
//		ac.getSession().put("blogCommentList", blogCommentList);
		blogShowLists = blogSrv.research(blogId);
		return "blogContent";
	}

	public String comment() {// ����
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		blogSrv.comment(user, blogId, commentDetail);
		return "comment";
	}

	public String research() {
		blogShowLists = blogSrv.research(researchKey);
		return "research";
	}

	public String submitBlog() {
		ActionContext ac = ActionContext.getContext();
		blogList.setContent(titleString + "|_z!5)" + contentString);
		Integer id = blogSrv.insertBlog(blogList);
		if (id > 0) {
			ac.getSession().put("SUBSUCCESS", "�ύ���ĳɹ�");
			return "submitSuccess";
		} else
			this.addFieldError(ERROR, "ϵͳ��æ");
		return "submitFaile";
	}

	public String deleteBlog() {
		blogSrv.deleteBlog(blogId);
		return "delete";
	}

}
