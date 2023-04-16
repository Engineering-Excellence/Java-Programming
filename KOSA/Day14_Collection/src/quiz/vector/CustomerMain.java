package quiz.vector;

import static quiz.vector.CustomerServiceImpl.SCANNER;

// View
public class CustomerMain {

    private static final CustomerService SERVICE = CustomerServiceImpl.getInstance();

    public static void main(String[] args) {

        String menu;

        do {
            System.out.print("\n메뉴를 입력하세요.(1: 추가, 2: 삭제, 3: 출력, 4: 수정, 5: 종료): ");
            menu = SCANNER.nextLine();

            switch (menu.trim()) {
                case "1" -> {
                    if (SERVICE.addCustomer()) System.out.println("고객정보 등록 완료");
                }
                case "2" -> {
                    if (SERVICE.deleteCustomer()) System.out.println("고객정보 삭제 완료");
                }
                case "3" -> SERVICE.printCustomerList();
                case "4" -> {
                    if (SERVICE.updateCustomer()) System.out.println("고객정보 수정 완료");
                }
                case "5" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못 입력하셨습니다.");
            }   // switch end
        } while (true);
    }
}
