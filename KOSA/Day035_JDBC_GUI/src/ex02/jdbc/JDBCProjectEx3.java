package ex02.jdbc;

import util.ConnectionHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Logger;

public class JDBCProjectEx3 extends JFrame implements ActionListener {

    private static final Logger LOG = Logger.getLogger(JDBCProjectEx3.class.getName());

    // component 객체 선언
    JPanel panWest, panSouth;  // 왼쪽텍스트필드, 아래쪽 버튼
    JPanel p1, p2, p3, p4, p5;
    JTextField txtNo, txtName, txtEmail, txtPhone;
    JButton btnTotal, btnAdd, btnDel, btnUpd, btnSearch, btnCancel;

    JTable table; // 검색과 전체 보기를 위한 테이블 객체 생성
    // 상태변화를 위한 변수 선언
    private static final int NONE = 0;
    private static final int ADD = 1;
    private static final int DELETE = 2;
    private static final int SEARCH = 3;
    private static final int TOTAL = 4;
    private static final int UPDATE = 5;
    int cmd = NONE;

    MyModel model;  // USER Class

    public JDBCProjectEx3() {   // 생성자 함수 - 필드 초기화
        // component 등록
        panWest = new JPanel(new GridLayout(5, 0));
        p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p1.add(new JLabel("번    호"));
        p1.add(txtNo = new JTextField(12));
        panWest.add(p1);

        p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(new JLabel("이    름"));
        p2.add(txtName = new JTextField(12));
        panWest.add(p2);

        p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p3.add(new JLabel("이  메  일"));
        p3.add(txtEmail = new JTextField(12));
        panWest.add(p3);

        p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p4.add(new JLabel("전화번호"));
        p4.add(txtPhone = new JTextField(12));
        panWest.add(p4);

        p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p5.add(new JLabel(""));
        panWest.add(p5);

        add(panWest, "West");

        // button 화면 아래 등록
        panSouth = new JPanel();
        panSouth.add(btnTotal = new JButton("전체보기"));
        panSouth.add(btnAdd = new JButton("추     가"));
        panSouth.add(btnDel = new JButton("삭     제"));
        panSouth.add(btnUpd = new JButton("수     정"));
        panSouth.add(btnSearch = new JButton("검     색"));
        panSouth.add(btnCancel = new JButton("취     소"));
        add(panSouth, "South");

        // event 처리
        btnTotal.addActionListener(this);
        btnAdd.addActionListener(this);
        btnDel.addActionListener(this);
        btnUpd.addActionListener(this);
        btnSearch.addActionListener(this);
        btnCancel.addActionListener(this);

        // 테이블 객체 생성
        add(new JScrollPane(table = new JTable()), "Center");
        //close
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 메인 창 출력
        setBounds(100, 100, 700, 300); // setSize(W,H);   pack();
        setVisible(true);

        dbConnect();
//        total();  // 생성자에 존재시 일부 작동 불가 버그
    } // constuctor end

    // DB setting
    Connection conn;
    Statement stmt;
    PreparedStatement pstmtInsert, pstmtDelete, pstmtUpdate, pstmtTotal, pstmtTotalScroll, pstmtSearch, pstmtSearchScroll;

    private String sqlInsert = "INSERT INTO customers VALUES (?, ?, ?, ?)";
    private String sqlDelete = "DELETE FROM customers WHERE code = ?";
    private String sqlSelect = "SELECT * FROM customers";
    private String sqlSearch = "SELECT * FROM customers WHERE name LIKE '%?%'";
    private String sqlUpdate = "UPDATE customers SET name = ?, email = ?, phone = ? WHERE code = ?";

    public void dbConnect() {
        try {
            conn = ConnectionHelper.getConnection("ORACLE");
            LOG.info("CONNECTION SUCCESS!");

            pstmtInsert = conn.prepareStatement(sqlInsert);
            pstmtDelete = conn.prepareStatement(sqlDelete);
            pstmtUpdate = conn.prepareStatement(sqlUpdate);
            pstmtTotal = conn.prepareStatement(sqlSelect);
            pstmtSearch = conn.prepareStatement(sqlSearch);
            pstmtTotalScroll = conn.prepareStatement(sqlSelect,
                    ResultSet.TYPE_SCROLL_SENSITIVE, // 커서 자유 이동, 업데이트 반영
                    ResultSet.CONCUR_UPDATABLE  // ResultSet 객체 변경 가능
            );
            pstmtSearchScroll = conn.prepareStatement(sqlSelect,
                    ResultSet.TYPE_SCROLL_SENSITIVE, // 커서 자유 이동, 업데이트 반영
                    ResultSet.CONCUR_UPDATABLE  // ResultSet 객체 변경 가능
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {    // 버튼 이벤트 처리
        Object obj = e.getSource();
        if (obj == btnAdd) {
            if (cmd != ADD) {
                setText(ADD);  //user method
                return;
            } // if in
            setTitle(e.getActionCommand());
            add();  // 추가
        } else if (obj == btnDel) {
            if (cmd != DELETE) {
                setText(DELETE);  // user method
                return;
            } // if in
            setTitle(e.getActionCommand());
            del();  // 삭제
        } else if (obj == btnSearch) {
            if (cmd != SEARCH) {
                setText(SEARCH);  // user method
                return;
            } // if in
            setTitle(e.getActionCommand());
            search();  // 검색
        } else if (obj == btnTotal) {
            setTitle(e.getActionCommand());
            total();  // 전체보기
        } else if (obj == btnUpd) {
            if (cmd != UPDATE) {
                setText(UPDATE);
                return;
            }
            setTitle(e.getActionCommand());
            upd();  // 수정
        }
        setText(NONE);
        init(); // 초기화 메소드, user method
    } // actionPerformed end

    // button event - 추가, 삭제, 검색, 전체 보기
    private void add() {
        try {
            String strNo = txtNo.getText();
            String strName = txtName.getText();
            String strEmail = txtEmail.getText();
            String strPhone = txtPhone.getText();
            System.out.printf("%s, %s, %s, %s%n", strNo, strName, strEmail, strPhone);
            if (strNo.length() < 1 || strName.length() < 1) {
                JOptionPane.showMessageDialog(null, "번호와 이름은 필수사항입니다. 입력해주세요.");
                return;
            }
            switch (JOptionPane.showConfirmDialog(null,
                    String.format("%s, %s, %s, %s ", strNo, strName, strEmail, strPhone),
                    "추가하시겠습니까?",
                    JOptionPane.YES_NO_OPTION)) {
                case 0: // 확인
                    pstmtInsert.setInt(1, Integer.parseInt(strNo));
                    pstmtInsert.setString(2, strName);
                    pstmtInsert.setString(3, strEmail);
                    pstmtInsert.setString(4, strPhone);
                    pstmtInsert.executeUpdate();
                    conn.commit();
                    break;
                case 1: // 아니오
                    conn.rollback();
                    return;
            }   // switch end
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "추가됐습니다.");
        total();
        init();
    }   // add() end

    private void del() {
        total();
        String strNo;
        try {
            strNo = txtNo.getText();
            if (strNo.length() < 1) {
                JOptionPane.showMessageDialog(null, "고객번호는 필수 입력사항입니다.");
                return;
            }
            pstmtDelete.setInt(1, Integer.parseInt(strNo));
            /*if (result > 0) {
//                JOptionPane.showMessageDialog(null, "삭제 성공");
                JOptionPane.showConfirmDialog(null, "DELETE SUCCESS!");
            }*/
            switch (JOptionPane.showConfirmDialog(null,
                    String.format("고객번호 %s번 ", strNo),
                    "삭제하시겠습니까?",
                    JOptionPane.YES_NO_OPTION)) {
                case 0: // 확인
                    pstmtDelete.executeUpdate();
                    conn.commit();
                    break;
                case 1: // 아니오
                    conn.rollback();
                    return;
            }   // switch end
        } catch (SQLException e) {
            e.printStackTrace();
        }
        total();
    }   // del() end

    private void search() {
        total();
    }

    private void total() {  // 전체 보기 버튼 이벤트 처리
        try {
            ResultSet rs = pstmtTotal.executeQuery();
            ResultSet rsScroll = pstmtTotalScroll.executeQuery();

            if (model == null) model = new MyModel();
            model.getRowCount(rsScroll);
            model.setData(rs);

//            table.setModel(model);
            table.setModel(new DefaultTableModel(model.data, model.columnName));
            table.updateUI();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }   // total() end

    private void upd() {
        total();
        try {
            String strName = txtName.getText();
            String strEmail = txtEmail.getText();
            String strPhone = txtPhone.getText();
            String strNo = txtNo.getText();
            System.out.printf("%s, %s, %s, %s%n", strName, strEmail, strPhone, strNo);
            if (strNo.length() < 1 || strName.length() < 1) {
                JOptionPane.showMessageDialog(null, "번호와 이름은 필수사항입니다. 입력해주세요.");
                return;
            }
            switch (JOptionPane.showConfirmDialog(null,
                    String.format("%s, %s, %s, %s", strName, strEmail, strPhone, strNo),
                    "수정하시겠습니까?",
                    JOptionPane.YES_NO_OPTION)) {
                case 0: // 확인
                    pstmtUpdate.setString(1, strName);
                    pstmtUpdate.setString(2, strEmail);
                    pstmtUpdate.setString(3, strPhone);
                    pstmtUpdate.setInt(4, Integer.parseInt(strNo));
                    pstmtUpdate.executeUpdate();
                    conn.commit();
                    break;
                case 1: // 아니오
                    conn.rollback();
                    return;
            }   // switch end
        } catch (SQLException e) {
            e.printStackTrace();
        }
        total();
    }

    private void init() {  //초기화 메소드
        txtNo.setText("");
        txtNo.setEditable(false);
        txtName.setText("");
        txtName.setEditable(false);
        txtEmail.setText("");
        txtEmail.setEditable(false);
        txtPhone.setText("");
        txtPhone.setEditable(false);
    }// init() end

    private void setText(int command) {
        switch (command) {
            case ADD:
                txtNo.setEditable(true);
                txtName.setEditable(true);
                txtEmail.setEditable(true);
                txtPhone.setEditable(true);
                break;
            case DELETE:
                txtNo.setEditable(true);
                break;
            case UPDATE:
                txtNo.setEditable(true);
                txtName.setEditable(true);
                txtEmail.setEditable(true);
                txtPhone.setEditable(true);
                break;
            case SEARCH:
                txtName.setEditable(true);
                break;
            default:
                break;
        }// switch end

        setButton(command);  // user method
    }// setText() end

    private void setButton(int command) {
        // cancel button 제외하고 어떤 버튼이 눌리더라도 모든 버튼이 비활성화
        btnTotal.setEnabled(false);
        btnAdd.setEnabled(false);
        btnDel.setEnabled(false);
        btnUpd.setEnabled(false);
        btnSearch.setEnabled(false);

        switch (command) {
            case ADD:
                btnAdd.setEnabled(true);
                cmd = ADD;
                break;
            case DELETE:
                btnDel.setEnabled(true);
                cmd = DELETE;
                break;
            case UPDATE:
                btnUpd.setEnabled(true);
                cmd = UPDATE;
                break;
            case SEARCH:
                btnSearch.setEnabled(true);
                cmd = SEARCH;
                break;
            case TOTAL:
                btnTotal.setEnabled(true);
                cmd = TOTAL;
                break;
            case NONE:
                btnTotal.setEnabled(true);
                btnAdd.setEnabled(true);
                btnDel.setEnabled(true);
                btnUpd.setEnabled(true);
                btnSearch.setEnabled(true);
                btnCancel.setEnabled(true);  //
                cmd = NONE;
                break;
            default:
                break;
        } // switch end
    } // setButton end

    public static void main(String[] args) {
        new JDBCProjectEx3();
    }
}
