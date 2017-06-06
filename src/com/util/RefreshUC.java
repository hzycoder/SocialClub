package com.util;

import javax.annotation.Resource;

import com.blog.service.BlogService;
import com.board.service.BoardService;
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
	FriendService friednSrv; 
	@Resource
	BlogService blogSrv;
	@Resource
	BoardService boardSrv;
	public UserCount refreshUC(){
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		uc.setFriendCount(friednSrv.friendCount(user.getUserId()));
		uc.setBlogCount(blogSrv.blogRows(user.getUserId()));
		uc.setMessageCount(boardSrv.gerRows());
		uc.setActCount(0);
		ac.getSession().put("uc", uc);
		return uc;
	}

}
