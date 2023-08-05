package edu.kosa.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleBaseUserDAO extends UserDAO {

    @Override
    public Connection getConnection() throws Exception {

        // 1. Driver Load - Exception
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2. Connection & Open
        String url = "jdbc:oracle:thin:@15.165.146.31:1521:XE";
        String uid = "SCOTT";
        String pwd = "tiger";

        Connection conn = DriverManager.getConnection(url, uid, pwd);

        return conn;
    }
}
