package edu.kosa.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class BoardList {

    private final List<BoardDTO> list = new ArrayList<>();
    private int pageSize = 5;
    private int totalCount = 0;
    private int currentPage = 1;
    private int totalPage = 0;
    private int startNo = 0;
    private int endNo = 0;
    private int startPage = 0;
    private int endPage = 0;
    private final int BLOCK = 10;

    public void initBoardList(int pageSize, int totalCount, int currentPage) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        calculator();
    }

    private void calculator() {
        totalPage = (totalCount - 1) / pageSize + 1;
        currentPage = Math.min(currentPage, totalPage);
        startNo = (currentPage - 1) * pageSize + 1;
        endNo = startNo + pageSize - 1;
        endNo = Math.min(endNo, totalCount);
        startPage = (currentPage - 1) / BLOCK * BLOCK + 1;
        endPage = startPage + 9;
        endPage = Math.min(endPage, totalPage);
    }
}
