package edu.kosa.view;

import edu.kosa.dao_di.UserDAO;
import edu.kosa.model.UserVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainEntry {

    public static void main(String[] args) throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("edu/kosa/dao_di/ctx.xml");

//        UserDAO dao = new OracleBaseUserDAO();
        UserDAO dao = ctx.getBean("dao", UserDAO.class);
        dao.menu();

        Scanner sc = new Scanner(System.in);

        dao.menu();

        switch (sc.nextLine()) {
            case "1":
                UserVO vo = new UserVO();
                System.out.print("user id: ");
                vo.setId(sc.nextLine());
                System.out.print("user name: ");
                vo.setName(sc.nextLine());
                System.out.print("user pwd: ");
                vo.setPassword(sc.nextLine());
                dao.insert(vo);
                break;

            case "2":
                dao.menu();
                dao.selectAll();
                break;

            case "3":
                System.out.print("user id: ");
                dao.selectByID(sc.nextLine());
                break;

            case "4":
                System.out.print("user id: ");
                String id = sc.nextLine();
                System.out.print("user name: ");
                String name = sc.nextLine();
                System.out.print("user pwd: ");
                String pwd = sc.nextLine();
                dao.update(new UserVO(id, name, pwd));
                break;

            case "5":
                System.out.print("user id: ");
                dao.delete(sc.nextLine());
                break;

            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
    }
}
