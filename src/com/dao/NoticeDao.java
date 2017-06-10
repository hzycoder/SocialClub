package com.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.blog.domain.BlogList;
import com.domain.Notice;
import com.domain.TUser;
@Transactional
public interface NoticeDao {

	public void addFriendNotice(TUser friendUser);

	public void blogCommentNotice(List<BlogList> blogLists);

	public Integer unreadNotice();

	public List noticeList(int maxResult, int firstResult);
	
	public Integer noticeCount();
	
	public Notice showNoticeDetail(int noticeID);

}
