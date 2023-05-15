package ex02.jdbc.view;

import ex02.jdbc.controller.EmpService;
import ex02.jdbc.controller.EmpServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class EmpCRUD {

    private static final EmpService SERVICE = EmpServiceImpl.getInstance();

    public static void main(String[] args) throws SQLException, IOException {

        SERVICE.menu();
    }
}
