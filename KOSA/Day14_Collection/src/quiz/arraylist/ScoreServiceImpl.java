package quiz.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

// Controller
public class ScoreServiceImpl implements ScoreService {

    private static final List<ScoreDTO> SCORE_LIST = new ArrayList<>();
    static final Scanner SCANNER = new Scanner(System.in);

    // RegEx Pattern
    static final Pattern pattern = Pattern.compile("^[가-힣]+\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)$");    // 한글 및 공백과 0 이상 100 이하의 숫자로만 이루어진 "한글 숫자 숫자 숫자" 형태의 정규식

    // Singleton Pattern
    private static final ScoreService INSTANCE = new ScoreServiceImpl();

    private ScoreServiceImpl() {
    }

    public static ScoreService getInstance() {
        return INSTANCE;
    }

    // 성적 등록
    @Override
    public boolean addScore() {
        System.out.print("'이름 국어 영어 수학' 순서로 입력하세요.: ");
        String input = SCANNER.nextLine();
        String[] split = input.split(" ");
        if (pattern.matcher(input).matches()) {
            SCORE_LIST.add(new ScoreDTO(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3])));
            return calRank();
        }
        System.out.println("잘못된 입력입니다.");
        return false;
    }

    // 성적 조회
    @Override
    public void printScoreList() {
        calRank();
        System.out.println("\n학번\t이름\t국어\t영어\t수학\t총점\t평균\t\t학점\t석차\n========================================================================");
        for (ScoreDTO s : SCORE_LIST) {
            if (s != null) {
                System.out.printf("%s/%d%n", s, SCORE_LIST.size());
            } else {
                break;  // 입력한 부분까지 출력 후 반복 탈출
            }
        }
    }

    // 성적 수정
    @Override
    public boolean updateScore() {
        System.out.print("\n수정할 성적정보의 학번을 입력하세요.: ");
        String stdNum = SCANNER.nextLine();
        for (ScoreDTO score : SCORE_LIST) {
            if (score.getStdNum() == Integer.parseInt(stdNum)) {
                System.out.print("\n수정할 성적정보를 입력하세요.(1: 이름, 2: 국어, 3: 영어, 4: 수학, 그 외: 취소): ");
                String update = SCANNER.nextLine();
                switch (update.trim()) {
                    case "1" -> {
                        System.out.print("이름: ");
                        String name = SCANNER.nextLine();
                        score.setName(name);
                    }
                    case "2" -> {
                        System.out.print("국어: ");
                        String kor = SCANNER.nextLine();
                        score.setKor(Integer.parseInt(kor));
                    }
                    case "3" -> {
                        System.out.print("영어: ");
                        String eng = SCANNER.nextLine();
                        score.setEng(Integer.parseInt(eng));
                    }
                    case "4" -> {
                        System.out.print("수학: ");
                        String math = SCANNER.nextLine();
                        score.setMath(Integer.parseInt(math));
                    }
                    default -> {
                        System.out.println("성적정보 수정 취소");
                        return false;
                    }
                }
                return calRank();
            }
        }
        System.out.println("잘못된 입력입니다.");
        return false;
    }

    // 성적 삭제
    @Override
    public boolean deleteScore() {
        System.out.print("\n삭제할 성적정보의 학번을 입력하세요.: ");
        String stdNum = SCANNER.nextLine();
        for (int i = 0; i < SCORE_LIST.size(); i++) {
            if (SCORE_LIST.get(i).getStdNum() == Integer.parseInt(stdNum)) {
                SCORE_LIST.remove(i);
                return calRank();
            }
        }
        System.out.println("학생정보가 존재하지 않습니다.");
        return false;
    }

    // 석차 계산
    @Override
    public boolean calRank() {
        SCORE_LIST.forEach(s -> s.setRank(1));  // 모든 석차를 1로 초기화
        for (ScoreDTO i : SCORE_LIST) {
            for (ScoreDTO j : SCORE_LIST) {
                if (i.getTot() > j.getTot()) {
                    j.setRank(j.getRank() + 1);   // 점수가 낮은 사람의 석차를 1 증가
                }
            }
        }
        return true;
    }
}
