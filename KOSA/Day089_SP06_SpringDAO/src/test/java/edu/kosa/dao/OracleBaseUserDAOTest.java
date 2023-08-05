package edu.kosa.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class OracleBaseUserDAOTest {

    private OracleBaseUserDAO oracleBaseUserDAO;

    @BeforeEach
    void setUp() {
        oracleBaseUserDAO = new OracleBaseUserDAO();
    }

    @Test
    void testGetConnection() {
        try {
            Connection connection = oracleBaseUserDAO.getConnection();
            assertNotNull(connection, "Connection should not be null");
            assertFalse(connection.isClosed(), "Connection should be open");
            connection.close();
        } catch (Exception e) {
            fail("Exception occurred while testing getConnection: " + e.getMessage());
        }
    }
}
