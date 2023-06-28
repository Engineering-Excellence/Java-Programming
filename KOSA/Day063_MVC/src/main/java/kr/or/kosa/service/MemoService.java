package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MemoService {

    boolean insert(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void seletcAll(HttpServletRequest request, HttpServletResponse response);

    void selectOne(HttpServletRequest request, HttpServletResponse response);

    void idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException;

    boolean delete(HttpServletRequest request, HttpServletResponse response) throws IOException;

    boolean update(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
