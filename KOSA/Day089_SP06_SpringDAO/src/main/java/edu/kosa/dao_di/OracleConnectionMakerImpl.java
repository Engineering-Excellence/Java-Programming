package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionMakerImpl implements ConnectionMaker {

    @Override
    public Connection makeConnection() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@15.165.146.31:1521:XE";
        String uid = "SCOTT";
        String pwd = "tiger";

        return DriverManager.getConnection(url, uid, pwd);
    }
}
