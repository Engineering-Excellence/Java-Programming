package quiz.arraylist;

import static quiz.arraylist.ScoreServiceImpl.SCANNER;

// View
public class ScoreMain {

    private static final ScoreService SERVICE = ScoreServiceImpl.getInstance();


    public static void main(String[] args) {

        String menu;

        // 성적 입력
        do {
            System.out.print("\n학사관리 시스템 메뉴를 입력하세요.(1: 등록, 2: 조회, 3: 수정, 4: 삭제, 5: 종료): ");
            menu = SCANNER.nextLine();

            switch (menu.trim()) {
                case "1" -> {
                    if (SERVICE.addScore()) System.out.println("성적 등록 완료");
                }
                case "2" -> SERVICE.printScoreList();
                case "3" -> {
                    if (SERVICE.updateScore()) System.out.println("성적 수정 완료");
                }
                case "4" -> {
                    if (SERVICE.deleteScore()) System.out.println("성적 삭제 완료");
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
