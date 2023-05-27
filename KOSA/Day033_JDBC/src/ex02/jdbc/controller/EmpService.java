package ex02.jdbc.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public interface EmpService {

    String selectByEmpNo(int n) throws SQLException;

    String selectByNoBtw(int startn, int endn) throws SQLException;

    String selectAll() throws SQLException;

    int insert() throws SQLException, IOException;

    int update() throws IOException;

    int delete(int empno) throws SQLException, IOException;

    void exit() throws SQLException;

    void menu() throws SQLException, IOException;
}
