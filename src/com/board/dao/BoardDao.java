package com.board.dao;

import java.util.List;

import com.board.domain.Board;

public interface BoardDao {
	public Integer save(Board board);
	public List showMessage(int id, int maxResult, int firstResult);
	public int getRows(int id);
}
