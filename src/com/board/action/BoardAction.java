package com.board.action;

import java.util.List;

import javax.annotation.Resource;

import com.board.domain.Board;
import com.board.service.BoardService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BoardAction extends ActionSupport {
	Board board;
	@Resource
	BoardService boardSrv;
	private int pageIndex = 1;// 页码
	private int pageCount;
	private int maxResult = 5;// 一页最大显示行数
	List<Board> boardList;

	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public String execute() {
		ActionContext ac = ActionContext.getContext();
		boardSrv.save(board);
		System.out.println("boarddeatil:" + board.getMessageDetail());
		ac.getSession().put("LEAVEMESSAGESUCCESS", "留言成功");
		return SUCCESS;
	}

	public String messageList() {
		ActionContext ac = ActionContext.getContext();
		ac.getSession().remove("LEAVEMESSAGESUCCESS");
		int rows = boardSrv.gerRows();
		System.out.println("rows===" + rows);
		if (rows % maxResult == 0) {// 算出总页数
			pageCount = rows / maxResult;
		} else {
			pageCount = rows / maxResult + 1;
		}
		System.out.println("pageCount"+pageCount);
		System.out.println("pageIndex" + pageIndex);

		if (pageIndex < 1) {
			pageIndex = 1;
		} else if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		boardList = boardSrv.showMessage(maxResult, (pageIndex - 1) * maxResult);
		
		ac.getSession().put("boardList", boardList);
		return SUCCESS;
	}

}
