package quiz.map;

import static quiz.map.VideoServiceImpl.SCANNER;

// View
public class VideoMain {

    protected static final VideoService SERVICE = VideoServiceImpl.getInstance();

    public static void main(String[] args) {

        String menu;

        do {
            System.out.print("\n메뉴를 입력하세요.(1: 추가, 2: 삭제, 3: 출력, 4: 수정, 5: 종료): ");
            menu = SCANNER.nextLine();

            switch (menu.trim()) {
                case "1" -> {
                    if (SERVICE.addVideo()) System.out.println("대여정보 등록 완료");
                }
                case "2" -> {
                    if (SERVICE.deleteVideo()) System.out.println("대여정보 삭제 완료");
                }
                case "3" -> SERVICE.printVideoMap();
                case "4" -> {
                    if (SERVICE.updateVideo()) System.out.println("대여정보 수정 완료");
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
