package edu.kosa.mapper;

import edu.kosa.model.BoardVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM MYBATISBOARD WHERE SEQ = #{seq}")
    BoardVO selectOne(int seq);

    @Select("SELECT * FROM MYBATISBOARD ORDER BY SEQ DESC")
    List<BoardVO> selectAll();

    @Insert("INSERT INTO MYBATISBOARD (SEQ, TITLE, WRITER, CONTENT, REGDATE, READCOUNT) " +
            "VALUES (BOARD_SEQ.nextval, #{title}, #{writer}, #{content}, SYSDATE, 0)")
    int insert(BoardVO boardVO);

    @Update("UPDATE MYBATISBOARD SET TITLE = #{title}, WRITER = #{writer}, CONTENT = #{content} WHERE SEQ = #{seq}")
    int update(BoardVO boardVO);

    @Delete("DELETE FROM MYBATISBOARD WHERE SEQ = #{seq}")
    int delete(int seq);

    @SelectProvider(type = BoardSqlProvider.class, method = "selectSearch")
    List<BoardVO> selectSearch(BoardVO boardVO);
}
