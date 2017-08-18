package com.wjb.service;

import java.util.List;

import com.wjb.db.po.Board;

public interface BoardService {
	
    public void addBoardByBoard(Board board);

    public void deleteBoardByBoardName(String boardName);

    public List<Board> listAllBoard();

    public Board listAllPostOfBoard(int boardId);

    public Board intoBoardByBoardId(int boardId);

    public Board intoBoardByBoardName(String boardName);

    public void updatePostNum(Board board);

    public void updateBoardInfo(Board board);

    public void deleteBoard(int boardId);
}
