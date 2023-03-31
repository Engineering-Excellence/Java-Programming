package ex05.While;

import java.util.Scanner;

public class DoWhileTest {

    public static void main(String[] args) {

        int su;
        char grade;

        do {
            System.out.print("점수를 입력하세요.: ");
            su = new Scanner(System.in).nextInt();
        } while (su < 0 || su > 100);

        // switch 예시로 변경
        grade = switch (su / 10) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };
        System.out.printf("당신의 점수는 %d점이며, 학점은 %c입니다.", su, grade);
    }
}
