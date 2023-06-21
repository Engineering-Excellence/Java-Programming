package kr.or.sw.mapper;

import kr.or.sw.model.GiftVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GiftDAOImpl implements GiftDAO {

    private static final GiftDAO INSTANCE = new GiftDAOImpl();

    public static GiftDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public int register(SqlSession sqlSession, GiftVO giftVO) {
        log.info("register");
        return sqlSession.insert("register", giftVO);
    }

    @Override
    public int search(SqlSession sqlSession, String gName) {
        log.info("search");
        return sqlSession.selectOne("search", gName);
    }
}
