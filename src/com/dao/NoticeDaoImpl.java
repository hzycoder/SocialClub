package com.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.blog.domain.BlogList;
import com.blog.domain.BlogShow;
import com.domain.Notice;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.util.ChangeBlogShowFormat;
@Transactional
public class NoticeDaoImpl implements NoticeDao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private Notice notice;
	@Resource
	List<Notice> noticeList;
	@Resource
	ChangeBlogShowFormat cbsf;
	
	int noticeType;	//消息类型   1为添加好友 2为博文留言
    boolean noticeState = false; //未读消息
    Date date = new Date();
	Timestamp timestamp = new Timestamp(date.getTime());//消息时间

	@Override
	public void addFriendNotice(TUser friendUser) {
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		notice.setNoticeContent("刚刚关注了你！");
		notice.setNoticeState(noticeState);
		notice.setNoticeTime(timestamp);
		notice.setNoticeType(1);
		notice.setTUserByRecipientId(friendUser);
		notice.setTUserBySenderId(user);
		
		try {			
			sessionFactory.getCurrentSession().save(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void blogCommentNotice(List<BlogList> blogLists) {
		List<BlogShow> blogShowList = cbsf.change(blogLists);
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		TUser friend = (TUser) ac.getSession().get("friend");
		notice.setNoticeContent(blogShowList.get(0).getTitle());
		notice.setNoticeState(noticeState);
		notice.setNoticeTime(timestamp);
		notice.setNoticeType(2);
		notice.setTUserByRecipientId(friend);
		notice.setTUserBySenderId(user);
		try {			
			sessionFactory.getCurrentSession().save(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer unreadNotice() { //未读消息数量
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		long temp = (Long)sessionFactory.getCurrentSession().createQuery("select count(*) from Notice where recipientID=? and noticeState=0")
		.setParameter(0, user.getUserId()).uniqueResult();
		int num = (int) temp;
		return num;
	}

	@Override
	public List noticeList(int maxResult, int firstResult) {
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		noticeList = sessionFactory.getCurrentSession().createQuery("from Notice where recipientID=? order by noticeID DESC")
		.setParameter(0, user.getUserId()).list();
		
		return noticeList;
	}

	@Override
	public Integer noticeCount() {
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		long temp = (Long)sessionFactory.getCurrentSession().createQuery("select count(*) from Notice where recipientID=?")
		.setParameter(0, user.getUserId()).uniqueResult();
		int count = (int)temp;
		return count;
	}

	@Override
	public Notice showNoticeDetail(int noticeID) {
		notice = (Notice) sessionFactory.getCurrentSession().createQuery("from Notice where noticeID=?")
		.setParameter(0, noticeID).uniqueResult();
		sessionFactory.getCurrentSession().createQuery("update Notice set noticeState=1 where noticeID=?").setParameter(0, noticeID).executeUpdate();
		return notice;
	}
	
	
}
