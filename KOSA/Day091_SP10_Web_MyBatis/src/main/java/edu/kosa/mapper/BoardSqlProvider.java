package edu.kosa.mapper;

import edu.kosa.model.BoardVO;
import org.apache.ibatis.jdbc.SQL;

public class BoardSqlProvider {

    public String selectSearch(BoardVO boardVO) {

        SQL sql = new SQL()
                .SELECT("*")
                .FROM("MYBATISBOARD");
        if (boardVO.getCondition() != null) {
            sql.WHERE(boardVO.getCondition() + " LIKE '%' || #{keyword} || '%'");
        }
        return sql.toString();
    }
}
