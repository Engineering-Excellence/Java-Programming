package edu.kosa.dao;

import java.sql.Connection;

public class DBConnect extends UserDAO {

    @Override
    public Connection getConnection() throws Exception {
        return null;
    }

    public Connection getConnection(String dns) {
        return null;
    }

    public Connection getConnection(String dns, String user, String pwd) {
        return null;
    }
}
