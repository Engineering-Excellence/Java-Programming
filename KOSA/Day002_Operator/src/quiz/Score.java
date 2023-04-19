package quiz;

import java.util.Scanner;

public class Score {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("이름과 국어, 영어, 전산 과목의 점수를 차례대로 입력하세요.: ");
        String name = scanner.next();
        int kor = scanner.nextInt();
        int eng = scanner.nextInt();
        int com = scanner.nextInt();
        scanner.close();

        System.out.printf("***** %s님의 성적표 *****%n", name);
        System.out.printf("국어: %3d, 영어: %3d, 전산: %d%n총점: %3d, 평균: %.1f", kor, eng, com, kor + eng + com, (kor + eng + com) / 3.);
    }
}

/*
    문제] 이름과 국어, 영어, 전산 점수를 입력 받아서 총점, 평균을 구하는 프로그램 작성

    ㅇㅇ님의 성적표 ***************
    국어: 100, 영어: 100, 전산: 100
    총점: 300, 평균: 100.0
*/