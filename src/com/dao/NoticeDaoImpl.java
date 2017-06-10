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
	int noticeType;	//��Ϣ����   1Ϊ��Ӻ��� 2Ϊ��������
    boolean noticeState = false; //δ����Ϣ
    Date date = new Date();
	Timestamp timestamp = new Timestamp(date.getTime());//��Ϣʱ��

	@Override
	public void addFriendNotice(TUser friendUser) {
		Notice notice = new Notice();
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		notice.setNoticeContent("�ոչ�ע���㣡");
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
