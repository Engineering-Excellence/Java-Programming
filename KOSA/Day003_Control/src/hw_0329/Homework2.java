package hw_0329;

import java.util.Scanner;

/*
    과제2] 사칙연산 프로그램(예외 처리)
    숫자 2개와 연산자를 입력받아서 사용
 */
public class Homework2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("첫번째 실수를 입력하세요.: ");
        float num1 = scanner.nextFloat();
        System.out.print("연산자(+, -, *, /)를 입력하세요.: ");
        String oper = scanner.next();   // Scanner는 char를 직접 입력받을 수 없으므로 String으로 받음
        System.out.print("두번째 실수를 입력하세요.: ");
        float num2 = scanner.nextFloat();

        scanner.close();

        if (num2 == 0 && oper.equals("/")) {    // 0으로 나눌 경우 예외 처리
            System.out.println("0으로 나눌 수 없습니다.");
        } else {
            System.out.printf("%.1f %s %.1f = %.1f%n", num1, oper, num2, calculator(num1, oper, num2));
        }
    }

    static float calculator(float num1, String oper, float num2) {

        float answer = 0.f;
        if (oper.equals("+")) answer = num1 + num2; // String은 참조자료형이므로 equals()로 값을 비교
        else if (oper.equals("-")) answer = num1 - num2;
        else if (oper.equals("*")) answer = num1 * num2;
        else if (oper.equals("/")) answer = num1 / num2;
        return answer;
    }
}
