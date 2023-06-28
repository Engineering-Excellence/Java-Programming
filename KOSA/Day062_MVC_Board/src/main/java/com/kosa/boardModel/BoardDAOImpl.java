package com.kosa.boardModel;

import com.kosa.util.MyBatisUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardDAOImpl implements BoardDAO {

    private static final BoardDAO INSTANCE = new BoardDAOImpl();

    public static BoardDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public int insert(BoardVO vo) {
        log.info("insert()");

        SqlSession mapper = MyBatisUtil.getSession();
        int num = vo.getNum();
        int ref = vo.getRef();
        int re_step = vo.getRe_step();
        int re_level = vo.getRe_level();
        int number = 0;

        number = (int) mapper.selectOne("selectBoardMaxNum") + 1;
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("re_step", re_step);
        hashMap.put("ref", ref);
        if (mapper.update("updateStepAndRef", hashMap) > 0) {
            re_step++;
            re_level++;
        } else {
            ref = number;
            re_step = 0;
            re_level = 0;
        }
        int res = mapper.insert("insertBoard", vo);
        mapper.close();

        return res;
    }
}
