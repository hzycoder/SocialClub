package com.util;

import javax.annotation.Resource;

import com.blog.service.BlogService;
import com.board.service.BoardService;
import com.dao.NoticeDao;
import com.domain.TUser;
import com.domain.UserCount;
import com.friend.service.FriendService;
import com.opensymphony.xwork2.ActionContext;
import com.service.LoginService;

public class RefreshUC {
	@Resource
	UserCount uc;
	@Resource
	LoginService logSrv;
	@Resource
	FriendService friendSrv;
	@Resource
	BlogService blogSrv;
	@Resource
	BoardService boardSrv;
	@Resource
	NoticeDao noticeDao;

	public UserCount refreshUC() {
		ActionContext ac = ActionContext.getContext();
		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
			TUser friend = (TUser) ac.getSession().get("friend");
			uc.setFriendCount(friendSrv.friendCount(friend.getUserId()));
			uc.setBlogCount(blogSrv.blogRows(friend.getUserId()));
			uc.setMessageCount(boardSrv.gerRows());
			uc.setActCount(0);
			ac.getSession().put("uc", uc);
			return uc;
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			System.out.println("ttttttt!!!!!!!!!!!!!!!!");
			System.out.println(user.getUserId());
			uc.setFriendCount(friendSrv.friendCount(user.getUserId()));
			uc.setBlogCount(blogSrv.blogRows(user.getUserId()));
			uc.setMessageCount(boardSrv.gerRows());
			uc.setActCount(0);
			uc.setUnreadNotice(noticeDao.unreadNotice());
			ac.getSession().put("uc", uc);
			return uc;
		}

	}

}
