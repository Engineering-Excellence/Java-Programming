package quiz.map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Controller
public class VideoServiceImpl implements VideoService {

    static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<Integer, VideoDTO> VIDEO_MAP = new HashMap<>();

    // Singleton Pattern
    private VideoServiceImpl() {
    }

    private static class LazyHolder {
        private static final VideoService INSTANCE = new VideoServiceImpl();

        private LazyHolder() {
        }
    }

    public static synchronized VideoService getInstance() {
        return LazyHolder.INSTANCE;
    }

    // 대여정보 추가
    @Override
    public boolean addVideo() {
        System.out.println("\n대여정보를 입력하세요.");
        System.out.print("비디오번호: ");
        int no = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.print("비디오제목: ");
        String title = SCANNER.nextLine();
        System.out.print("장르: ");
        String category = SCANNER.nextLine();
        System.out.print("고객명: ");
        String lendName = SCANNER.nextLine();
        VIDEO_MAP.put(VideoDTO.getKey(), new VideoDTO(no, title, category, lendName));
        return true;
    }

    // 대여정보 출력
    @Override
    public void printVideoMap() {
        VIDEO_MAP.forEach((integer, videoDTO) -> System.out.println(VIDEO_MAP.get(integer)));
    }

    // 대여정보 수정
    @Override
    public boolean updateVideo() {
        System.out.print("\n수정할 대여정보의 비디오번호를 입력하세요.: ");
        int no = SCANNER.nextInt();
        SCANNER.nextLine();
        for (Map.Entry<Integer, VideoDTO> entry : VIDEO_MAP.entrySet()) {
            VideoDTO videoDTO = entry.getValue();
            if (no == videoDTO.getNo()) {
                System.out.print("\n수정할 대여정보를 입력하세요.(1: 비디오번호, 2: 비디오제목, 3:장르, 4: 대여여부, 5: 고객명, 6: 대여일자, 그 외: 취소): ");
                String update = SCANNER.nextLine();
                switch (update.trim()) {
                    case "1" -> {
                        System.out.print("비디오번호: ");
                        int updateNo = SCANNER.nextInt();
                        SCANNER.nextLine();
                        videoDTO.setNo(updateNo);
                    }
                    case "2" -> {
                        System.out.print("비디오제목: ");
                        String title = SCANNER.nextLine();
                        videoDTO.setTitle(title);
                    }
                    case "3" -> {
                        System.out.print("장르: ");
                        String category = SCANNER.nextLine();
                        videoDTO.setCategory(category);
                    }
                    case "4" -> {
                        System.out.print("대여여부(Y/N): ");
                        String lend = SCANNER.nextLine();
                        videoDTO.setLend(!lend.equalsIgnoreCase("N"));
                    }
                    case "5" -> {
                        System.out.print("고객명: ");
                        String lendName = SCANNER.nextLine();
                        videoDTO.setLendName(lendName);
                    }
                    case "6" -> {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        System.out.print("대여일자(yyyy-MM-dd): ");
                        String lendDate = SCANNER.nextLine();
                        try {
                            videoDTO.setLendDate(sdf.parse(lendDate));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    default -> {
                        System.out.println("대여정보 수정 취소");
                        return false;
                    }
                }   // switch-case end
                return true;
            }   // if end
        }   // for end
        System.out.println("대여정보가 존재하지 않습니다.");
        return false;
    }

    // 대여정보 삭제
    @Override
    public boolean deleteVideo() {
        System.out.print("\n삭제할 대여정보의 비디오번호를 입력하세요.");
        int no = SCANNER.nextInt();
        SCANNER.nextLine();
        for (Map.Entry<Integer, VideoDTO> entry : VIDEO_MAP.entrySet()) {
            if (no == entry.getValue().getNo()) {
                VIDEO_MAP.remove(entry.getKey());
                return true;
            }
        }
        System.out.println("대여정보가 존재하지 않습니다.");
        return false;
    }
}
