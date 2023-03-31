package ex04.For;

import java.util.Scanner;

public class QuizEx2 {

    public static void main(String[] args) {

        // 문제1] 1 ~ 100까지의 수 중에서 짝수만 열로 출력하고, 한 행에 10개씩 출력하는 프로그램
        /*for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) System.out.printf("%4d", i);
            if (i % 20 == 0) System.out.println();
        }*/

        // 문제2] 원하는 단을 입력 받아서 구구단 출력하기
        System.out.print("출력을 원하는 단을 입력하세요.: ");
        int dan = new Scanner(System.in).nextInt();
        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %2d%n", dan, i, dan * i);
        }
    }
}
