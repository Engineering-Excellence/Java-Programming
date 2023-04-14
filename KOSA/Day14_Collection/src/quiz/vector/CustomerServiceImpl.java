package quiz.vector;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

// Controller
public class CustomerServiceImpl implements CustomerService {

    protected static final Scanner SCANNER = new Scanner(System.in);
    private static final List<Customer> CUSTOMER_LIST = new Vector<>();

    // Singleton
    private CustomerServiceImpl() {
    }

    private static class LazyHolder {
        protected static final CustomerService INSTANCE = new CustomerServiceImpl();
    }

    public static synchronized CustomerService getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public boolean addCustomer() {
        System.out.println("\n고객정보를 입력하세요.");
        System.out.print("이름: ");
        String name = SCANNER.nextLine();
        System.out.print("주소: ");
        String addr = SCANNER.nextLine();
        System.out.print("전화번호: ");
        String tel = SCANNER.nextLine();
        CUSTOMER_LIST.add(new Customer(name, addr, tel));
        return true;
    }

    @Override
    public boolean deleteCustomer() {
        System.out.print("\n삭제할 고객의 전화번호를 입력하세요.");
        String tempTel = SCANNER.nextLine();

        for (int i = 0; i < CUSTOMER_LIST.size(); i++) {
            if (CUSTOMER_LIST.get(i).getTel().equals(tempTel)) {
                CUSTOMER_LIST.remove(i);
                return true;
            }
        }
        System.out.println("고객정보가 존재하지 않습니다.");
        return false;
    }

    @Override
    public void printCustomerList() {
        System.out.printf("%n%s 전체 고객 수: %d명 %s%n", "-".repeat(30), CUSTOMER_LIST.size(), "-".repeat(21));
        CUSTOMER_LIST.forEach(System.out::println);
    }

    @Override
    public boolean updateCustomer() {
        System.out.print("\n수정할 고객의 전화번호를 입력하세요.");
        String tempTel = SCANNER.nextLine();
        for (Customer customer : CUSTOMER_LIST) {
            if (customer.getTel().equals(tempTel)) {
                System.out.print("\n수정할 고객정보를 입력하세요.(1: 이름, 2: 주소, 3:전화번호, 그 외: 취소): ");
                String update = SCANNER.nextLine();
                switch (update.trim()) {
                    case "1" -> {
                        System.out.print("이름: ");
                        String name = SCANNER.nextLine();
                        customer.setName(name);
                    }
                    case "2" -> {
                        System.out.print("주소: ");
                        String addr = SCANNER.nextLine();
                        customer.setAddr(addr);
                    }
                    case "3" -> {
                        System.out.print("전화번호: ");
                        String tel = SCANNER.nextLine();
                        customer.setTel(tel);
                    }
                    default -> {
                        System.out.println("고객정보 수정 취소");
                        return false;
                    }
                }
                return true;
            }
        }
        System.out.println("고객정보가 존재하지 않습니다.");
        return false;
    }
}
