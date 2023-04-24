package quiz.map;

// View
public class VideoMain {

    private static final VideoService SERVICE = VideoServiceImpl.getInstance();

    public static void main(String[] args) {

        String menu;

        do {
            System.out.print("\n메뉴를 입력하세요.(1: 대여, 2: 반납, 3: 출력, 4: 수정, 5: 삭제, 6: 종료): ");
            menu = VideoServiceImpl.SCANNER.nextLine();

            switch (menu.trim()) {
                case "1" -> {
                    if (SERVICE.addVideo()) System.out.println("대여정보 등록 완료");
                }
                case "3" -> SERVICE.printVideoMap();
                case "4" -> {
                    if (SERVICE.updateVideo()) System.out.println("대여정보 수정 완료");
                }
                case "5" -> {
                    if (SERVICE.deleteVideo()) System.out.println("대여정보 삭제 완료");
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
