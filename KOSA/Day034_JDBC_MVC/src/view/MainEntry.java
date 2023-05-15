package view;

import controller.GiftService;
import controller.GiftServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class MainEntry {

    private static final GiftService SERVICE = GiftServiceImpl.getInstance();

    public static void main(String[] args) throws SQLException, IOException {

//        ConnectionHelper.getConnection("ORACLE", "KOSA", "java");
        SERVICE.connect("ORACLE", "KOSA", "java");
        SERVICE.menu();
    }
}
