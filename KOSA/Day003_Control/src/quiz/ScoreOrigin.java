package quiz;

import java.util.Scanner;

public class ScoreOrigin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("이름과 국어, 영어, 전산 과목의 점수를 차례대로 입력하세요.: ");
        String name = scanner.next();
        int kor = scanner.nextInt();
        int eng = scanner.nextInt();
        int com = scanner.nextInt();
        scanner.close();

        if (kor > 100 || kor < 0 || eng > 100 || eng < 0 || com > 100 || com < 0) {   // 과목 점수 범위가 0 ~ 100점을 벗어날 경우 예외 처리
            System.out.println("잘못 입력하셨습니다.");
            System.exit(0);
        }

        int tot = kor + eng + com;
        char grade;

        switch (tot / 30) {  // 총점 30점 단위로 점수 구간 설정
            case 10, 9 -> grade = 'A';
            case 8 -> grade = 'B';
            case 7 -> grade = 'C';
            case 6 -> grade = 'D';
            default -> grade = 'F';
        }
        System.out.printf("***** %s님의 성적표 *****%n국어: %3d, 영어: %3d, 전산: %d%n총점: %3d, 평균: %.1f%n당신의 학점은 %c입니다.%n", name, kor, eng, com, tot, tot / 3., grade);
    }
}

/*
    문제] 이름과 국어, 영어, 전산 점수를 입력 받아서 총점, 평균을 구하는 프로그램 작성

    ㅇㅇ님의 성적표 ***************
    국어: 100, 영어: 100, 전산: 100
    총점: 300, 평균: 100.0, 평점(학점): A
*/