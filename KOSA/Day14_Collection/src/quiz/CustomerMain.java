package quiz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CustomerMain {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Customer> customerList = new ArrayList<>();

    public static void main(String[] args) {

        String menu;

        do {
            System.out.print("메뉴를 입력하세요(1: 추가, 2: 삭제, 3: 출력, 4: 수정, 5: 종료): ");
            menu = scanner.next();

            switch (menu) {
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
        scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("전화번호: ");
        String tel = scanner.nextLine();
        customerList.add(new Customer(name, address, tel));
    }

    private static void deleteCustomer() {
        System.out.println("삭제할 고객의 전화번호를 입력하세요.");
        String tempTel = scanner.next();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getTel().equals(tempTel)) {
                customerList.remove(i);
                System.out.println("고객정보 삭제 완료");
                return;
            }
        }
        System.out.println("고객정보가 존재하지 않습니다.");
        scanner.nextLine();
    }

    private static void printCustomerList() {
        System.out.println("전체 고객정보 출력\n" + "-".repeat(60));
        IntStream.range(0, customerList.size()).forEach(i -> System.out.println(customerList.get(i)));
    }

    private static void updateCustomer() {
        System.out.println("수정할 고객의 전화번호를 입력하세요.");
        String tempTel = scanner.next();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getTel().equals(tempTel)) {
                System.out.println("수정할 고객정보를 입력하세요.");
                scanner.nextLine();
                System.out.print("이름: ");
                String name = scanner.nextLine();
                System.out.print("주소: ");
                String address = scanner.nextLine();
                System.out.print("전화번호: ");
                String tel = scanner.nextLine();
                customerList.set(i, new Customer(name, address, tel));
                System.out.println("고객정보 수정 완료");
                return;
            }
        }
        System.out.println("고객정보가 존재하지 않습니다.");
        scanner.nextLine();
    }
}
