package quiz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainEntry {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = inputPopulation(scanner);
        Score[] student = new Score[num];
        String temp;    // 키보드 임시 입력 저장

        // 정규식 패턴
        Pattern pattern = Pattern.compile("^(100|[1-9]?\\d)\\s[가-힣]+\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)$");    // 한글 및 공백과 0 이상 100 이하의 숫자로만 이루어진 "숫자 한글 숫자 숫자 숫자" 형태의 정규식

        // 학생 정보 입력
        for (int i = 0; i < student.length; i++) {
            temp = inputScore(scanner);
            boolean flag = false;

            do {
                if (flag) {
                    temp = inputScore(scanner);
                    flag = false;
                }
                Matcher matcher = pattern.matcher(temp);
                if (matcher.matches()) {    // 정규식 일치시 이름과 점수를 입력 후 do while 탈출
                    student[i] = new Score(Integer.parseInt(temp.split(" ")[0]), temp.split(" ")[1], Integer.parseInt(temp.split(" ")[2]), Integer.parseInt(temp.split(" ")[3]), Integer.parseInt(temp.split(" ")[4]));
                } else {    // 정규식 불일치시 do while 반복
                    flag = true;
                }
            } while (flag);

            if (continueInput(scanner)) break;
        }   // for End

        scanner.close();

        rank(num, student);

        display(num, student);
    }

    // 학생 수 입력
    private static int inputPopulation(Scanner scanner) {
        System.out.print("학생 수를 입력하세요.: ");
        int num = scanner.nextInt(); // 학생 수
        scanner.nextLine(); // 키보드 버퍼 제거
        return num;
    }

    // 성적 입력
    private static String inputScore(Scanner scanner) {
        System.out.print("'학번 이름 국어 영어 수학' 순서로 입력하세요.: ");
        return scanner.nextLine().trim();
    }

    // 입력 여부 확인
    private static boolean continueInput(Scanner scanner) {
        System.out.print("계속 입력하시겠습니까?(y/n): ");
        String ans = scanner.next();
        if (ans.equalsIgnoreCase("n")) {
            return true;
        }
        scanner.nextLine();
        return false;
    }

    // 석차 계산
    private static void rank(int num, Score[] student) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (student[i].getTot() > student[j].getTot()) {
                    student[j].setRank(student[j].getRank() + 1);   // 점수가 낮은 사람의 석차를 1 증가
                }
            }
        }
    }

    // 결과 출력
    private static void display(int num, Score[] student) {
        System.out.println("\n학번\t이름\t국어\t영어\t수학\t총점\t평균\t\t학점\t석차\n========================================================================");
        for (Score score : student) {
            if (score != null) {
                System.out.printf("%2d번\t%-3s\t%3d점\t%3d점\t%3d점\t%3d점\t%6.2f점\t%2c\t\t%d/%d%n", score.getStuNum(), score.getName(), score.getKor(), score.getEng(), score.getMath(), score.getTot(), score.getAvg(), score.getGrade(), score.getRank(), num);
            } else {
                break;  // 입력한 부분까지 출력 후 반복 탈출
            }
        }
    }
}
