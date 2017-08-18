package com.wjb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjb.db.dao.BoardMapper;
import com.wjb.db.po.Board;
import com.wjb.db.po.BoardExample;
import com.wjb.service.BoardService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardMapper boardMapper;

    @Override
    public void addBoardByBoard(Board board) {
        if (board != null) {
        	boardMapper.insert(board);
        }
    }

    @Override
    public void deleteBoardByBoardName(String boardName) {
    		BoardExample example = new BoardExample();
    		example.createCriteria().andBoardNameEqualTo(boardName);
    		boardMapper.deleteByExample(example);
    }

    @Override
    public List<Board> listAllBoard() {
        return boardMapper.selectByExample(null);
    }

    @Override
    public Board listAllPostOfBoard(int boardId) {
        return null;
    }

    @Override
    public Board intoBoardByBoardId(int boardId) {
        return boardMapper.selectByPrimaryKey(boardId);
    }

    @Override
    public void updatePostNum(Board board ) {
        board.setBoardPostNum(board.getBoardPostNum() + 1);
        boardMapper.updateByPrimaryKeySelective(board);
    }

    @Override
    public Board intoBoardByBoardName(String boardName) {
    	BoardExample example = new BoardExample();
		example.createCriteria().andBoardNameEqualTo(boardName);
		List<Board> boards = boardMapper.selectByExample(example);
        return boards.get(0);
    }

    @Override
    public void updateBoardInfo(Board board) {
    	boardMapper.updateByPrimaryKey(board);
    }

    @Override
    public void deleteBoard(int boardId) {
    	boardMapper.deleteByPrimaryKey(boardId);
    }
}
