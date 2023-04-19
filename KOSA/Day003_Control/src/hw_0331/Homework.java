package hw_0331;

import java.util.Scanner;

public class Homework {

    public static void main(String[] args) {

        System.out.println("num1, num2, num3을 입력하세요.: ");
        int num1 = new Scanner(System.in).nextInt();
        int num2 = new Scanner(System.in).nextInt();
        int num3 = new Scanner(System.in).nextInt();

        Homework homework = new Homework();
        homework.homework1(num1);
        homework.homework2(num2);
        homework.homework3(num3);
    }

    // 과제1
    private void homework1(int n) {

        StringBuilder stringBuilder = new StringBuilder("1");   // 좌변
        for (int i = 2; i <= n; i++) {
            stringBuilder.append(" + (");
            for (int j = 1; j <= i - 1; j++) {
                stringBuilder.append(j).append(" + ");
            }
            stringBuilder.append(i).append(")");
        }
        System.out.printf("%s = %d%n", stringBuilder, n * (n + 1) * (n + 2) / 6);   // 결과 출력
    }

    // 과제2
    private void homework2(int n) {

        StringBuilder stringBuilder = new StringBuilder("(-1)");    // 좌변
        for (int i = 2; i <= n; i++) {
            stringBuilder.append(" + ").append(i % 2 == 1 ? "(-" : "").append(i).append(i % 2 == 1 ? ")" : "");
        }
        System.out.printf("%s = %d%n", stringBuilder, (int) (2 * Math.pow(-1, n) * n + Math.pow(-1, n) - 1) / 4);    // 결과 출력
    }

    // 과제3
    private void homework3(int n) {

        StringBuilder stringBuilder = new StringBuilder();
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(" + ").append(i).append("/").append(i + 1);
            sum += (double) i / (i + 1);
        }
        System.out.printf("%s = %.2f%n", stringBuilder.substring(3), sum);    // 결과 출력
    }
}
