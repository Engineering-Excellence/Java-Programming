package homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 7명의 성적 처리 배열 이용하기

class SCORE1 {

    String name;    // 이름
    int kor, eng, com, tot; // 국어, 영어, 전산, 총점
    double avg; // 평균
    char grade; // 학점
}

public class QuizScore_RegEx {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요.: ");
        int num = scanner.nextInt(); // 학생 수
        scanner.nextLine(); // 키보드 버퍼 제거

        SCORE1[] student = new SCORE1[num];
        String temp;    // 키보드 임시 입력 저장
        Pattern pattern = Pattern.compile("^[가-힣]+\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)$");    // 한글 및 공백과 0 이상 100 이하의 숫자로만 이루어진 "한글 숫자 숫자 숫자" 형태의 정규식

        for (int i = 0; i < student.length; i++) {
            System.out.printf("'이름 국어 영어 전산' 순서로 입력하세요(%d/%d).: ", i + 1, num);
            temp = scanner.nextLine().trim();
            boolean flag = false;

            student[i] = new SCORE1();
            do {
                if (flag) {
                    System.out.printf("한글 이름과 점수의 범위를 확인하신 후, '이름 국어 영어 전산' 순서로 입력하세요(%d/%d).: ", i + 1, num);
                    temp = scanner.nextLine().trim();
                    flag = false;
                }
                Matcher matcher = pattern.matcher(temp);
                if (matcher.matches()) {    // 정규식 일치시 이름과 점수를 입력 후 while 탈출
                    student[i].name = temp.split(" ")[0];   // 이름
                    student[i].kor = Integer.parseInt(temp.split(" ")[1]); // 국어 점수
                    student[i].eng = Integer.parseInt(temp.split(" ")[2]); // 영어 점수
                    student[i].com = Integer.parseInt(temp.split(" ")[3]); // 전산 점수
                } else {    // 정규식 불일치시 while 반복
                    flag = true;
                }
            } while (flag);

            student[i].tot = student[i].kor + student[i].eng + student[i].com;  // 총점 계산
            student[i].avg = student[i].tot / 3.;  // 평균 계산
            student[i].grade = switch ((int) (student[i].avg / 10)) { // 학점 계산
                case 10, 9 -> 'A';
                case 8 -> 'B';
                case 7 -> 'C';
                case 6 -> 'D';
                default -> 'F';
            };
            System.out.print("계속 입력하시겠습니까?(y/n): ");
            String ans = scanner.next();
            if (ans.equalsIgnoreCase("n")) break;
            scanner.nextLine();
        }   // for End

        scanner.close();
        System.out.println("\n학번\t이름\t국어\t영어\t전산\t총점\t평균\t학점\n============================================================");
        for (int i = 0; i < student.length; i++) { // 결과 출력
            if (student[i] != null) {
                System.out.printf("%2d번\t%-3s\t%3d점\t%3d점\t%3d점\t%3d점\t%2.2f점\t%2c%n", i + 1, student[i].name, student[i].kor, student[i].eng, student[i].com, student[i].tot, student[i].avg, student[i].grade);
            }
        }
    }
}
