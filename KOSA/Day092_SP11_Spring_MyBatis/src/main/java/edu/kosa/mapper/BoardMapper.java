package edu.kosa.mapper;

import edu.kosa.model.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    @Insert("INSERT INTO SPRING_BOARD (NUM, NAME, EMAIL, PWD, SUBJECT, CONTENT, REGDATE, PARENT, IP) " +
            "VALUES ((SELECT NVL(MAX(NUM), 0) + 1 FROM SPRING_BOARD), #{name}, #{email}, #{pwd}, #{subject}, #{content}, SYSDATE, (SELECT NVL(MAX(NUM), 0) + 1 FROM SPRING_BOARD), #{ip})")
    int insertBoard(BoardDTO boardDTO);

    @Update("UPDATE SPRING_BOARD " +
            "SET HIT = HIT + 1 " +
            "WHERE NUM = #{num}")
    int updateBoardHit(int num);

    @Select("SELECT * " +
            "FROM SPRING_BOARD " +
            "WHERE NUM = #{num}")
    BoardDTO getBoard(int num);

    @Select("SELECT * " +
            "FROM (SELECT A.*, ROWNUM RNUM FROM (SELECT * FROM SPRING_BOARD ORDER BY PARENT DESC, SORT) A) " +
            "WHERE RNUM BETWEEN #{start} AND #{end}")
    List<BoardDTO> getBoardList(Map<String, Integer> map);

    @Select("SELECT COUNT(*) " +
            "FROM SPRING_BOARD")
    int getBoardCount();

    @Update("UPDATE SPRING_BOARD " +
            "SET EMAIL = #{email}, SUBJECT = #{subject}, CONTENT = #{content}, IP = #{ip} " +
            "WHERE NUM = #{num} AND PWD = #{pwd}")
    int updateBoard(BoardDTO boardDTO);

    @Delete("DELETE " +
            "FROM SPRING_BOARD " +
            "WHERE NUM = #{num} AND PWD = #{pwd}")
    int deleteBoard(BoardDTO object);

    @Update("UPDATE SPRING_BOARD " +
            "SET SORT = #{sort} + 1 " +
            "WHERE PARENT = #{parent} AND SORT >= #{sort}")
    int updateSort(BoardDTO boardDTO);

    @Insert("INSERT INTO SPRING_BOARD (NUM, NAME, EMAIL, PWD, SUBJECT, CONTENT, REGDATE, PARENT, SORT, TAB, IP) " +
            "VALUES ((SELECT NVL(MAX(NUM), 0) + 1 FROM SPRING_BOARD), #{name}, #{email}, #{pwd}, #{subject}, #{content}, SYSDATE, #{parent}, #{sort}, #{tab}, #{ip})")
    int insertReply(BoardDTO boardDTO);
}
