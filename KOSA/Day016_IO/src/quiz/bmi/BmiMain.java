package quiz.bmi;

import java.io.IOException;

import static quiz.bmi.BmiServiceImpl.br;

public class BmiMain {

    private static final BmiService SERVICE = BmiServiceImpl.getInstance();

    public static void main(String[] args) throws IOException {

        String menu;

        do {
            System.out.print("\n메뉴를 입력하세요.(1: 추가, 2: 출력, 3: 수정, 4: 삭제, 5: 저장, 6: 종료): ");
            menu = br.readLine();

            switch (menu.trim()) {
                case "1" -> {
                    if (SERVICE.addBmi()) System.out.println("체질량지수 등록 완료");
                }
                case "2" -> SERVICE.printBmiMap();
                case "3" -> {
                    if (SERVICE.updateBmi()) System.out.println("체질량지수 수정 완료");
                }
                case "4" -> {
                    if (SERVICE.deleteBmi()) System.out.println("체질량지수 삭제 완료");
                }
                case "5" -> {
                    if (SERVICE.saveBmi()) System.out.println("체질량지수 저장 완료");
                }
                case "6" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못 입력하셨습니다.");
            }   // switch end
        } while (true);
    }
}
