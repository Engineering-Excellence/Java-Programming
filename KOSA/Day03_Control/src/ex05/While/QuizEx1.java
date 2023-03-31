package ex05.While;

import java.util.Scanner;

/*
    숫자 3개(0~100)와 연산자(+, -, *, /)를 입력받아서 연산, 잘못된 입력은 재입력받게 한다.
    결과
    100
    100
    100
    +

    100 + 100 + 100 = 300
 */
public class QuizEx1 {

    public static void main(String[] args) {

        float num1, num2, num3;
        float answer = 0;
        char oper;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("숫자 3개를 순서대로 입력하세요.: ");
            num1 = scanner.nextFloat();
            num2 = scanner.nextFloat();
            num3 = scanner.nextFloat();
        } while (num1 > 100 || num1 < 0);

        do {
            System.out.print("연산자를 입력하세요.: ");
            oper = scanner.next().charAt(0);
        } while (!(oper == '+' || oper == '-' || oper == '*' || oper == '/') || oper == '/' && (num2 == 0 || num3 == 0));

        switch (oper) {
            case '+' -> answer = num1 + num2 + num3;
            case '-' -> answer = num1 - num2 - num3;
            case '*' -> answer = num1 * num2 * num3;
            case '/' -> answer = num1 / num2 / num3;
        }

        System.out.printf("%.1f %c %.1f %c %.1f = %.1f%n", num1, oper, num2, oper, num3, answer);
    }
}
