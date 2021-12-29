package org.example.springboard;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity entity);
    List<BoardEntity> selBoardList();
    BoardEntity selBoard(BoardEntity entity);
    int updBoard(BoardEntity entity);
    int delBoard(BoardEntity entity);
}