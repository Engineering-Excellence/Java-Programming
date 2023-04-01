package hw_0331;

import java.util.Scanner;

public class Homework3 {

    public static void main(String[] args) {

        System.out.print("n을 입력하세요.: ");
        int n = new Scanner(System.in).nextInt();

        System.out.print("1/2");    // 좌변 출력
        for (int i = 2; i <= n; i++) {
            System.out.printf(" + %d/%d", i, i + 1);
        }

        double sum = 0;
        for (double i = 1; i <= n; i++) {   // 우변 계산
            sum += i / (i + 1);
        }

        System.out.printf(" = %.2f%n", sum);    // 우변 출력
    }
}
