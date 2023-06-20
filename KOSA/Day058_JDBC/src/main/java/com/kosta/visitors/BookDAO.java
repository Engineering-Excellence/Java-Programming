package com.kosta.visitors;

import com.kosta.util.MyBatisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

@Slf4j
public class BookDAO {

    // Connection & Open
    /*public static Connection loadOracleDriver() {
        // MyBatis로 대체
    }*/

    // 전체 레코드 수 구해서 페이지 카운트 하는 함수
    public static int getPageCount(int numPerPage) {

        SqlSession sqlSession = MyBatisUtil.getSession();
        int max = sqlSession.selectOne("getPageCount", numPerPage);
        int pageCount = (int) Math.ceil((double) max / numPerPage); // 20 / 5 = 4
        pageCount = Math.max(pageCount, 1); // max(4, 1);
        return pageCount;
    }

    // SELECT ALL
    public static List<BookVO> selectAll(int myPage, int numPerPage) {

        // ORACLE Paging
        int start = (myPage - 1) * numPerPage;
        int end = myPage * numPerPage;

        SqlSession sqlSession = MyBatisUtil.getSession();
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("start", start);
        hashMap.put("end", end);
        List<BookVO> data = sqlSession.selectList("selectAll", hashMap);
        sqlSession.close();
        return data;
    }

    public static boolean update(BookVO vo) {
        return false;
    }

    public static boolean insert(BookVO vo) {
        return false;
    }
}
