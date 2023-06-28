package kr.or.kosa.dao;

import kr.or.kosa.dto.MemoDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemoDAOImpl implements MemoDAO {

    private static final MemoDAO INSTANCE = new MemoDAOImpl();

    public static MemoDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public int insertMemo(SqlSession mapper, MemoDTO dto) {
        log.info("insertMemo(): {}", dto);

        return mapper.insert("insertMemo", dto);
    }

    @Override
    public int deleteMemo(SqlSession mapper, String id) {
        log.info("deleteMemo(): {}", id);

        return mapper.delete("deleteMemo", id);
    }

    @Override
    public int updateMemo(SqlSession mapper, MemoDTO dto) {
        log.info("updateMemo(): {}", dto);

        return mapper.update("updateMemo", dto);
    }

    @Override
    public List<MemoDTO> selectAllMemo(SqlSession mapper) {
        log.info("selectAllMemo()");

        return mapper.selectList("selectAllMemo");
    }

    @Override
    public MemoDTO selectById(SqlSession mapper, String id) {
        log.info("selectById(): {}", id);

        return mapper.selectOne("selectById", id);
    }

    @Override
    public String isCheckById(SqlSession mapper, String id) {
        // ID 유무 확인
        log.info("isCheckById(): {}", id);

        return mapper.selectOne("isCheckById", id);
    }
}
