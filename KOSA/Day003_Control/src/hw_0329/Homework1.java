package hw_0329;

import java.util.Scanner;

/*
    과제1] 논리연산, 교환알고리즘, if 이용
    숫자 3개를 내림차순으로 출력하는 프로그램
 */
public class Homework1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 3개를 입력하세요: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int temp;
        System.out.printf("입력한 수: %d, %d, %d%n", num1, num2, num3);

        if (num1 < num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        } if (num2 < num3) {
            temp = num2;
            num2 = num3;
            num3 = temp;
        } if (num1 < num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        System.out.printf("%d %c %d %c %d", num1, num1 == num2 ? '=' : '>', num2, num2 == num3 ? '=' : '>', num3);
    }
}
