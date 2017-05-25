package com.board.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.board.dao.BoardDao;
import com.board.domain.Board;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;

@Transactional
public class BoardServiceImpl implements BoardService {
	@Resource
	BoardDao boardDao;

	@Override
	public Integer save(Board board) {
		ActionContext ac = ActionContext.getContext();
		// 获取留言时间
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		board.setMessageTime(timestamp);
		TUser user = (TUser) ac.getSession().get("user");
		board.setSpeakId(user.getUserId());// 留言人的id

		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
			TUser friend = (TUser) ac.getSession().get("friend");
			board.setTUser(friend); // 被留言人ID
		} else {
			board.setTUser(user);//// 被留言人ID
		}
		return boardDao.save(board);
	}

	@Override
	public List showMessage(int maxResult, int firstResult) {
		ActionContext ac = ActionContext.getContext();
		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
			TUser friend = (TUser) ac.getSession().get("friend");
			return boardDao.showMessage(friend.getUserId(),maxResult,firstResult);
		} else {
			TUser user = (TUser) ac.getSession().get("user");
			return boardDao.showMessage(user.getUserId(),maxResult,firstResult);
		}
	}

	@Override
	public int gerRows() {
		ActionContext ac = ActionContext.getContext();
		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
		TUser friend = (TUser) ac.getSession().get("friend");
		return boardDao.getRows(friend.getUserId());
	} else {
		TUser user = (TUser) ac.getSession().get("user");
		return boardDao.getRows(user.getUserId());
	}
	}

}
