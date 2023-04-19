package quiz;

import java.util.Scanner;

// 평점(학점) 구하는 프로그램 작성
public class Quiz_IfSwitch {

    public static void main(String[] args) {

        System.out.print("점수를 입력하세요: ");
        int pt = new Scanner(System.in).nextInt();
        if (pt > 100 || pt < 0) {   // 점수 범위가 0 ~ 100점을 벗어날 경우 예외 처리
            System.out.println("잘못 입력하셨습니다.");
            System.exit(1);
        }

        String grade;
        switch (pt / 5) {  // 5점 단위로 점수 구간 설정
            case 15, 16, 17, 18, 19, 20 -> grade = "상";
            case 12, 13, 14 -> grade = "보통";
            default -> grade = "노력요망";
        }
        System.out.printf("당신의 점수는 %d점이며, 평가결과는 '%s'입니다.%n", pt, grade);
    }
}
