package ex04.For;

import java.util.Scanner;

public class QuizEx1 {

    public static void main(String[] args) {

        /*// 문제] 1 ~ 100까지 합을 구하는 프로그램 작성
        System.out.print("숫자 n을 입력하세요.: ");
        int n = new Scanner(System.in).nextInt();
        System.out.printf("1 ~ n 까지의 합: %d", n * (n + 1) / 2);*/

        // 문제]2 1 ~ 100까지 3의 배수의 합과 개수를 구하는 프로그램 작성
        System.out.print("숫자 n을 입력하세요.: ");
        int n = new Scanner(System.in).nextInt();
        /*int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                sum += i;
                cnt++;
            }
        }
        System.out.printf("1 ~ %d까지 3의 배수의 합: %d, 개수: %d%n", n, sum, cnt);*/
        System.out.printf("1 ~ %d까지 3의 배수의 합: %d, 개수: %d%n", n, (n / 3) * (n / 3 + 1) / 2 * 3, n / 3);
    }
}
