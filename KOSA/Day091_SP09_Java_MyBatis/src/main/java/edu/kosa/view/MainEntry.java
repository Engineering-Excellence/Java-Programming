package edu.kosa.view;

import edu.kosa.controller.BoardDAO;
import edu.kosa.model.BoardVO;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.List;

@Log4j2
public class MainEntry {

    @SneakyThrows(IOException.class)
    public static void main(String[] args) {

        BoardDAO boardDAO = new BoardDAO();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            bw.newLine();
            bw.write("1. 추가\t2. 선택 읽기\t3.전체 읽기\t4. 수정\t5. 삭제\t0. 종료");
            bw.newLine();
            bw.write("메뉴를 입력하세요: ");
            bw.flush();

            switch (br.readLine()) {
                case "1":
                    boardDAO.insert(new BoardVO("title", "writer", "content"));
                    break;
                case "2":
                    boardDAO.selectOne(1);
                    break;
                case "3":
                    List<BoardVO> boardList = boardDAO.selectAll();
                    for (BoardVO board : boardList) {
                        System.out.println(board);
                    }
                    break;
                case "4":
                    boardDAO.update(new BoardVO(1, "title", "writer", "content"));
                    break;
                case "5":
                    boardDAO.delete(1);
                    break;
                case "0":
                    bw.write("프로그램을 종료합니다.");
                    bw.newLine();
                    bw.flush();
                    return;
                default:
                    bw.write("잘못된 입력입니다.");
                    bw.newLine();
                    break;
            }
        }
    }
}
