package ex02.jdbc;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MyModel extends AbstractTableModel {

    Object[][] data;
    String[] columnName;
    int rows, cols; // 레코드 행과 열의 개수를 저장하는 변수

    // DB에 저장된 데이터 채움
    public void setData(ResultSet rs) {
        try {
            String title;
            // 데이터에 대한 정보 얻어옴
            ResultSetMetaData rsmd = rs.getMetaData();
            cols = rsmd.getColumnCount();   // 열의 개수 얻어옴
            columnName = new String[cols];

            for (int i = 0; i < cols; i++) {
                columnName[i] = rsmd.getColumnName(i + 1);  // DB 필드번호는 1부터 시작(오라클)
            }

            data = new Object[rows][cols];
            int r = 0;
            while (rs.next()) {
                for (int i = 0; i < cols; i++) {
                    if (i != 1) data[r][i] = rs.getObject(i + 1);   // varchar2 type
                    else data[r][i] = rs.getObject(i + 1);  // number type
                }   // for end
                r++;
            }   // while end
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getRowCount(ResultSet rsScroll) {  // USER Method
        try {
            rsScroll.last();    // 레코드의 마지막 행으로 이동
            rows = rsScroll.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {  // 레코드 행 개수
        return data.length;
    }

    @Override
    public int getColumnCount() {   // 레코드 열 개수
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {   // 원잣값
        return data[rowIndex][columnIndex];
    }
}
