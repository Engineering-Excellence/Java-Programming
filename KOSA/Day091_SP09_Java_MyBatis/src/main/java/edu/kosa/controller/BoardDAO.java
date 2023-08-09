package edu.kosa.controller;

import edu.kosa.config.SqlSessionFactoryBean;
import edu.kosa.model.BoardVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BoardDAO {

    public BoardVO selectOne(int seq) {
        try (SqlSession sqlSession = SqlSessionFactoryBean.getSession()) {
            return sqlSession.selectOne("edu.kosa.controller.BoardDAO.selectOne", seq);
        }
    }

    public List<BoardVO> selectAll() {
        try (SqlSession sqlSession = SqlSessionFactoryBean.getSession()) {
            return sqlSession.selectList("edu.kosa.controller.BoardDAO.selectAll");
        }
    }

    public int update(BoardVO boardVO) {
        try (SqlSession sqlSession = SqlSessionFactoryBean.getSession()) {
            int result = sqlSession.update("edu.kosa.controller.BoardDAO.update", boardVO);
//            sqlSession.commit();
            return result;
        }
    }

    public int delete(int seq) {
        try (SqlSession sqlSession = SqlSessionFactoryBean.getSession()) {
            return sqlSession.delete("edu.kosa.controller.BoardDAO.delete", seq);
        }
    }

    public int insert(BoardVO boardVO) {
        try (SqlSession sqlSession = SqlSessionFactoryBean.getSession()) {
            return sqlSession.insert("edu.kosa.controller.BoardDAO.insert", boardVO);
        }
    }
}
