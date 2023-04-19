package quiz;

import java.util.Scanner;

// 평점(학점) 구하는 프로그램 작성
public class Quiz_Switch {

    public static void main(String[] args) {

        System.out.print("점수를 입력하세요: ");
        int pt = new Scanner(System.in).nextInt();
        if (pt > 100 || pt < 0) {   // 점수 범위가 0 ~ 100점을 벗어날 경우 예외 처리
            System.out.println("잘못 입력하셨습니다.");
            System.exit(0);
        }

        char grade;
        switch (pt / 10) {  // 10점 단위로 점수 구간 설정
            case 10, 9 -> grade = 'A';
            case 8 -> grade = 'B';
            case 7 -> grade = 'C';
            case 6 -> grade = 'D';
            default -> grade = 'F';
        }
        System.out.printf("당신의 학점은 %c입니다.%n", grade);
    }
}
