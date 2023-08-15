package com.javassem.dao;

import com.javassem.domain.BoardVO;

import java.util.List;

public interface BoardDAO {
    void insertBoard(BoardVO vo);

    void updateBoard(BoardVO vo);

    void deleteBoard(BoardVO vo);

    BoardVO getBoard(BoardVO vo);

    List<BoardVO> getBoardList(BoardVO vo);
}
