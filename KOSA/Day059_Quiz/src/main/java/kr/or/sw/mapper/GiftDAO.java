package kr.or.sw.mapper;

import kr.or.sw.model.GiftVO;
import org.apache.ibatis.session.SqlSession;

public interface GiftDAO {

    int register(SqlSession sqlSession, GiftVO giftVO);

    int search(SqlSession sqlSession, String gName);
}
