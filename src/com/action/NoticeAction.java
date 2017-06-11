package com.action;

import java.util.List;

import javax.annotation.Resource;

import com.dao.NoticeDao;
import com.domain.Notice;
import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport {
	private int pageIndex = 1;// 页码
	private int pageCount;
	private int maxResult = 5;// 一页最大显示行数
	private int noticeID;

	@Resource
	NoticeDao noticeDao;
	@Resource
	List<Notice> noticeList;
	@Resource
	Notice notice;

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
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

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public int getNoticeID() {
		return noticeID;
	}

	public void setNoticeID(int noticeID) {
		this.noticeID = noticeID;
	}

	public List<Notice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}

	public String execute() {
		return SUCCESS;
	}

	public String showNotice() {
		int rows = noticeDao.noticeCount();

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
		noticeList = noticeDao.noticeList(maxResult, (pageIndex - 1) * maxResult);
		return SUCCESS;

	}

	public String showNoticeDetail() {
		notice = noticeDao.showNoticeDetail(noticeID);
		return "detail";
	}
}
