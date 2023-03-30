package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

//  정수 2개를 입력 받아서 / 연산처리 프로그램 작성(예외 처리)
public class Quiz_ExceptionTryMultiCatch {

    public static void main(String[] args) {

        float x, y, result;

        try {
            System.out.print("x, y = ");
            x = new Scanner(System.in).nextFloat();
            y = new Scanner(System.in).nextFloat();

            result = x / y; // 에러 발생 가능

            System.out.printf("x / y = %.1f%n", result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력가능합니다.");
        } catch (Exception e) {
            System.out.println("예외 발생!");
        } finally {
            System.out.println("finally는 항상 호출됨");
        }
    }
}
