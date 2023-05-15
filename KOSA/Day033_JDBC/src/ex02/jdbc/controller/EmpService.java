package ex02.jdbc.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public interface EmpService {

    String selectByGno();

    String selectAll() throws SQLException;

    int insert(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno);

    int update(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno);

    int delete(int empno);

    void exit() throws SQLException;

    void menu() throws SQLException, IOException;
}
