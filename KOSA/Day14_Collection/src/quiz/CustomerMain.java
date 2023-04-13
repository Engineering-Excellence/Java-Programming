package quiz;

import java.util.List;
import java.util.Scanner;

public class CustomerMain {

    public static final Scanner SCANNER = new Scanner(System.in);
    protected static final List<Customer> CUSTOMER_LIST = CustomerList.getCustomerList();

    public static void main(String[] args) {

        String menu;

        do {
            System.out.print("메뉴를 입력하세요.(1: 추가, 2: 삭제, 3: 출력, 4: 수정, 5: 종료): ");
            menu = SCANNER.nextLine();

            switch (menu.trim()) {
                case "1" -> addCustomer();
                case "2" -> deleteCustomer();
                case "3" -> printCustomerList();
                case "4" -> updateCustomer();
                case "5" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못 입력하셨습니다.");
            }   // switch end
        } while (true);
    }

    private static void addCustomer() {
        System.out.println("고객정보를 입력하세요.");
        System.out.print("이름: ");
        String name = SCANNER.nextLine();
        System.out.print("주소: ");
        String addr = SCANNER.nextLine();
        System.out.print("전화번호: ");
        String tel = SCANNER.nextLine();
        CUSTOMER_LIST.add(new Customer(name, addr, tel));
    }

    private static void deleteCustomer() {
        System.out.println("삭제할 고객의 전화번호를 입력하세요.");
        String tempTel = SCANNER.nextLine();

        for (int i = 0; i < CUSTOMER_LIST.size(); i++) {
            if (CUSTOMER_LIST.get(i).getTel().equals(tempTel)) {
                CUSTOMER_LIST.remove(i);
                System.out.println("고객정보 삭제 완료");
                return;
            }
        }
        System.out.println("고객정보가 존재하지 않습니다.");
    }

    private static void printCustomerList() {
        System.out.println("전체 고객정보 출력\n" + "-".repeat(60));
        CUSTOMER_LIST.forEach(System.out::println);
    }

    private static void updateCustomer() {
        System.out.println("수정할 고객의 전화번호를 입력하세요.");
        String tempTel = SCANNER.nextLine();
        for (Customer customer : CUSTOMER_LIST) {
            if (customer.getTel().equals(tempTel)) {
                System.out.print("수정할 고객정보를 입력하세요.(1: 이름, 2: 주소, 3:전화번호, 그 외: 취소)");
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
                        return;
                    }
                }
                System.out.println("고객정보 수정 완료");
                return;
            }
        }
        System.out.println("고객정보가 존재하지 않습니다.");
    }
}
