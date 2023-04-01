package hw_0331;

import java.util.Scanner;

public class Homework1 {

    public static void main(String[] args) {

        System.out.print("n을 입력하세요.: ");
        int n = new Scanner(System.in).nextInt();

        System.out.print("1");  // 좌변 출력
        for (int i = 2; i <= n; i++) {
            System.out.print(" + (");
            for (int j = 1; j <= i - 1; j++) {
                System.out.printf("%d + ", j);
            }
            System.out.printf("%d)", i);
        }

        System.out.printf(" = %d%n", n * (n + 1) * (n + 2) / 6);    // 우변 계산 및 출력, ∑ {k(k+1)/2} = n * (n + 1) * (n + 2) / 6
    }
}
