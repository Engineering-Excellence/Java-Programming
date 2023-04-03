package ex03.array;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuizScore_RegEx {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요.: ");
        int student = scanner.nextInt(); // 학생 수
        scanner.nextLine(); // 키보드 버퍼 제거
        String[] name = new String[student];    // 이름
        int[][] score = new int[student][6];  // 점수
        char[] grade = new char[student]; // 학점
        String temp;
        Pattern pattern = Pattern.compile("^[가-힣]+\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)$");    // 공백과 0 이상 100 이하의 숫자를 포함하는 "한글 숫자 숫자 숫자" 형태의 정규식

        for (int i = 0; i < score.length; i++) {
            score[i][0] = i + 1;    // 학번
            System.out.printf("'이름 국어 영어 전산' 순서로 입력하세요.(%d/%d): ", i + 1, student);
            temp = scanner.nextLine().trim();
            boolean flag = false;
            do {
                if (flag) {
                    System.out.printf("한글 이름과 점수의 범위를 확인하신 후, '이름 국어 영어 전산' 순서로 입력하세요.(%d/%d): ", i + 1, student);
                    temp = scanner.nextLine().trim();
                }
                flag = false;
                Matcher matcher = pattern.matcher(temp);
                if (matcher.matches()) {    // 정규식 일치시 이름과 점수를 입력 후 while 탈출
                    name[i] = temp.split(" ")[0];   // 이름
                    score[i][1] = Integer.parseInt(temp.split(" ")[1]); // 국어 점수
                    score[i][2] = Integer.parseInt(temp.split(" ")[2]); // 영어 점수
                    score[i][3] = Integer.parseInt(temp.split(" ")[3]); // 전산 점수
                } else {    // 정규식 불일치시 while 반복
                    flag = true;
                }
            } while (flag);
            score[i][4] = score[i][1] + score[i][2] + score[i][3];  // 총점 계산
            score[i][5] = score[i][4] / 3;  // 평균 계산
            grade[i] = switch (score[i][5] / 10) { // 학점 계산
                case 10, 9 -> 'A';
                case 8 -> 'B';
                case 7 -> 'C';
                case 6 -> 'D';
                default -> 'F';
            };
        }
        scanner.close();
        System.out.println("학번\t이름\t국어\t영어\t전산\t총점\t평균\t학점\n============================================================");
        for (int i = 0; i < score.length; i++) {
            System.out.printf("%2d번\t%3s\t%3d점\t%3d점\t%3d점\t%3d점\t%3d점\t%2c%n", score[i][0], name[i], score[i][1], score[i][2], score[i][3], score[i][4], score[i][5], grade[i]); // 결과 출력
        }
    }
}
