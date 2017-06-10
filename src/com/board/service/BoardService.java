package com.board.service;

import java.util.List;

import com.board.domain.Board;

public interface BoardService {
	public Integer save(Board board);

	public List showMessage(int maxResult, int firstResult);

	public int gerRows();
}
