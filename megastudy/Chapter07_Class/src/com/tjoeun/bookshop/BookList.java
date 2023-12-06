package com.tjoeun.bookshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BookList {

    //	도서 정보를 기억할 ArrayList를 만든다.
    private List<BookVO> bookList = new ArrayList<>();

    //	생성자를 선언하지 않았으므로 자바 컴파일러가 아무런 일도 하지않는 기본 생성자를 만들어준다.
    public BookList() {
    }

    public List<BookVO> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookVO> bookList) {
        this.bookList = bookList;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("====================================================\n");
        str.append(" 도서명  저자  출판사  출판일  가격\n");
        str.append("====================================================\n");

        double total = 0.0;
//		일반 for
//		for (int i=0; i<bookList.size(); i++) {
//			str += bookList.get(i) + "\n";
//			total += bookList.get(i).getPrice();
//		}

//		향상된 for
        for (BookVO vo : bookList) {
            str.append(vo).append("\n");
            total += vo.getPrice();
        }

        DecimalFormat df = new DecimalFormat("$#,##0.00");
        str.append("====================================================\n");
        str.append("  합계 금액: ").append(df.format(total)).append("\n");
        str.append("====================================================\n");
        return str.toString();
    }

    //	BookList 클래스의 bookList ArrayList에 인수로 넘겨받은 도서 정보를 저장하는 메소드
    public void addBook(BookVO book) {
        bookList.add(book);
    }
}
