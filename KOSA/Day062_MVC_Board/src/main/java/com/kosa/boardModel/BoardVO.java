package com.kosa.boardModel;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BoardVO {

    private int num;
    private String writer;
    private String email;
    private String subject;
    private String passwd;
    private java.sql.Timestamp reg_date;
    private int readcount;
    private int ref;
    private int re_step;
    private int re_level;
    private String content;
    private String ip;
}
