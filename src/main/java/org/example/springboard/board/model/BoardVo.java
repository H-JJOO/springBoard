package org.example.springboard.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVo extends BoardEntity {
    private String writerNm;
    private String profileImg;
}
