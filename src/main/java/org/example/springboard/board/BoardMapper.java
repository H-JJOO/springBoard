package org.example.springboard.board;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboard.board.model.BoardEntity;
import org.example.springboard.board.model.BoardVo;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity entity);
    List<BoardVo> selBoardList();
    BoardVo selBoard(BoardEntity entity);
    int updBoard(BoardEntity entity);
    int delBoard(BoardEntity entity);
}