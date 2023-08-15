package com.javassem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

//VO(Value Object)

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private int cnt;

    public BoardVO(String title, String writer, String content) {
        super();
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}