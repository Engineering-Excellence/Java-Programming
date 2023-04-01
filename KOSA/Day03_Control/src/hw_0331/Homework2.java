package hw_0331;

import java.util.Scanner;

// 교대 급수
public class Homework2 {

    public static void main(String[] args) {

        System.out.print("n을 입력하세요.: ");
        int n = new Scanner(System.in).nextInt();

        System.out.print("(-1)");   // 좌변 출력
        for (int i = 2; i <= n; i++) {
            System.out.printf(" + %s%d%s", i % 2 == 1 ? "(-" : "", i, i % 2 == 1 ? ")" : "");
        }

        System.out.printf(" = %d%n", (int) (2 * Math.pow(-1, n) * n + Math.pow(-1, n) - 1) / 4);    // 우변 계산 및 출력
    }
}
