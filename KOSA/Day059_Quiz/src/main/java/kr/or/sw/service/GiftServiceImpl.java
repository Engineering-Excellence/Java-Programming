package kr.or.sw.service;

import kr.or.sw.mapper.GiftDAO;
import kr.or.sw.mapper.GiftDAOImpl;
import kr.or.sw.model.GiftVO;
import kr.or.sw.util.MyBatisUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GiftServiceImpl implements GiftService {

    private static final GiftService INSTANCE = new GiftServiceImpl();

    public static GiftService getInstance() {
        return INSTANCE;
    }

    private final GiftDAO giftDAO = GiftDAOImpl.getInstance();

    @Override
    public boolean register(HttpServletRequest request, HttpServletResponse response) {
        log.info("register");

        SqlSession sqlSession = MyBatisUtil.getSession();
        int success = -1;
        if (search(request, response) == 0) {
            log.info("상품 등록 진행");
            int gNo = Integer.parseInt(request.getParameter("gNo"));
            String gName = request.getParameter("gName");
            int gStart = Integer.parseInt(request.getParameter("gStart"));
            int gEnd = Integer.parseInt(request.getParameter("gEnd"));
            GiftVO giftVO = new GiftVO(gNo, gName, gStart, gEnd);
            success = giftDAO.register(sqlSession, giftVO);
        } else {
            log.info("동일한 상품명이 이미 존재합니다.");
        }
        sqlSession.commit();
        sqlSession.close();
        return success == 1;
    }

    @Override
    public int search(HttpServletRequest request, HttpServletResponse response) {
        log.info("search");

        SqlSession sqlSession = MyBatisUtil.getSession();
        String gName = request.getParameter("gName");
        int match = giftDAO.search(sqlSession, gName);
        sqlSession.close();
        return match;
    }
}
