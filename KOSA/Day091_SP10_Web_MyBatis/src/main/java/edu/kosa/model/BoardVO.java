package edu.kosa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {

    private int seq;
    private String title;
    private String writer;
    private String content;
    private String regDate;
    private int readCount;

    private String condition;
    private String keyword;

    public BoardVO(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public BoardVO(int seq, String title, String writer, String content) {
        this.seq = seq;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    @Override
    public String toString() {
        return "seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
                + ", regDate=" + regDate + ", readCount=" + readCount;
    }
}
