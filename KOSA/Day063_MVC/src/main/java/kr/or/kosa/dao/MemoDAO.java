package kr.or.kosa.dao;

import kr.or.kosa.dto.MemoDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface MemoDAO {

    int insertMemo(SqlSession mapper, MemoDTO dto);

    List<MemoDTO> selectAllMemo(SqlSession mapper);

    MemoDTO selectById(SqlSession mapper, String id);

    String isCheckById(SqlSession mapper, String id);

    int deleteMemo(SqlSession mapper, String id);

    int updateMemo(SqlSession mapper, MemoDTO dto);
}
