package com.daily.action;

import com.blog.domain.BlogShow;
import com.daily.domain.TDaily;
import com.daily.service.DailyService;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


public class ShowDailyAction {
	
	@Resource
	List<TDaily> tdailys;
	@Resource
	private DailyService dailySrc;
	@Resource
	List<TDaily> tdailys1;
	
	private int pageIndex = 1;
	private int pageCount;
	private int maxResult = 5;
	
	
	
	public String execute(){
		
		ActionContext ac = ActionContext.getContext();
		
		int rows;
		if (ac.getSession().get("friend") != null) {// �жϵ�ǰ�Ƿ���������û���ҳ
//			TUser friend = (TUser) ac.getSession().get("friend");
			System.out.println("showDailyAction�������ͨ��");
			TUser user = (TUser) ac.getSession().get("user");
			rows = dailySrc.dailyRows(user.getUserId());
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			rows = dailySrc.dailyRows(user.getUserId());
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

		
		
		if (ac.getSession().get("friend") != null){
			System.out.println("showDailyAction�������ͨ��1");
		}else{
			System.out.println("maxResult:"+maxResult+"(pageIndex - 1) * maxResult:"+((pageIndex - 1) * maxResult));
			tdailys = dailySrc.showmessage((pageIndex - 1) * maxResult,maxResult);
		}
		ac.getSession().put("dailyLists",tdailys);
		
		return "success";
	}



	public List<TDaily> getTdailys() {
		return tdailys;
	}



	public void setTdailys(List<TDaily> tdailys) {
		this.tdailys = tdailys;
	}



	public DailyService getDailySrc() {
		return dailySrc;
	}



	public void setDailySrc(DailyService dailySrc) {
		this.dailySrc = dailySrc;
	}


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
	
	
	
	
}
