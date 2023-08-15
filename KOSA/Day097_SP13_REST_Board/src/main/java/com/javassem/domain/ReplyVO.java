package com.javassem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ReplyVO {

    private int rno;            // 댓글번호
    @NonNull
    private int bno;            // 게시글번호 ( 댓글이 달릴 게시글 )
    @NonNull
    private String reply;        // 댓글내용
    @NonNull
    private String replyer;        // 댓글작성자
    private String replydate;    // 댓글작성일
}
