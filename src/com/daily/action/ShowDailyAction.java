package com.daily.action;

import com.daily.dao.DailyDao;
import com.daily.domain.TDaily;
import com.daily.service.DailyService;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShowDailyAction {

	@Resource
	List<TDaily> tdailys;
	@Resource
	private DailyService dailySrc;
	@Resource
	List<TDaily> tdailys1;
	int type;
	@Resource
	List<TDaily> tdlist;
	private int pageIndex = 1;
	private int pageCount;
	private int maxResult = 5;

	public String execute() {

		ActionContext ac = ActionContext.getContext();

		if (type == 1) {
			ac.getSession().remove("friend");
		}

		int rows;
		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
			TUser friend = (TUser) ac.getSession().get("friend");
			System.out.println("showDailyAction好友浏览通道");
			rows = dailySrc.dailyRows(friend.getUserId());
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			rows = dailySrc.dailyRows(user.getUserId());
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

		if (ac.getSession().get("friend") != null) {
			System.out.println("showDailyAction好友浏览通道1");
			TUser friend = (TUser) ac.getSession().get("friend");
			tdailys = dailySrc.showmessage(friend, (pageIndex - 1) * maxResult, maxResult);
			ac.getSession().put("dailyLists", tdailys);
			return "fdaily";
		} else {
			System.out
					.println("maxResult:" + maxResult + "(pageIndex - 1) * maxResult:" + ((pageIndex - 1) * maxResult));
			TUser user = (TUser) ac.getSession().get("user");
			tdailys = dailySrc.showmessage(user, (pageIndex - 1) * maxResult, maxResult);
			ac.getSession().put("dailyLists", tdailys);
			return "daily";
		}
	}

	public List<TDaily> getTdailys1() {
		return tdailys1;
	}

	public void setTdailys1(List<TDaily> tdailys1) {
		this.tdailys1 = tdailys1;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public List<TDaily> getTdlist() {
		return tdlist;
	}

	public void setTdlist(List<TDaily> tdlist) {
		this.tdlist = tdlist;
	}

	public String showrecent() {
		List<TDaily> flag;
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		DailyDao dd = (DailyDao) cxt.getBean("dailyDao");

		tdlist = dd.showmessage_recent(pageIndex, maxResult);
		return "recent";
	}
}
