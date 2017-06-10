package com.dao;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.domain.Notice;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;

public class NoticeDaoImpl implements NoticeDao {
	
	@Resource
	private SessionFactory sessionFactory;
	int noticeType;	//消息类型   1为添加好友 2为博文留言
    boolean noticeState = false; //未读消息
    Date date = new Date();
	Timestamp timestamp = new Timestamp(date.getTime());//消息时间

	@Override
	public void addFriendNotice(TUser friendUser) {
		Notice notice = new Notice();
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		notice.setNoticeContent("刚刚关注了你！");
		notice.setNoticeState(noticeState);
		notice.setNoticeTime(timestamp);
		notice.setNoticeType(1);
		notice.setTUserByRecipientId(friendUser);
		notice.setTUserBySenderId(user);
		sessionFactory.getCurrentSession().save(notice);
	}

	@Override
	public void blogCommentNotice() {
		// TODO Auto-generated method stub
		
	}
	
	

}
