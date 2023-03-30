package ex03.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyMain {

    public static void main(String[] args) {

        int x, y, result;

        try {
            System.out.print("x, y = ");
            x = new Scanner(System.in).nextInt();
            y = new Scanner(System.in).nextInt();
            result = x / y; // 에러 발생 가능
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");   // User Message
//            System.out.println(e.getMessage());
//            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력가능합니다.");
        } catch (Exception e) {
            System.out.println("예외 발생!");
        } finally {
            System.out.println("finally는 항상 호출됨");
        }
    }
}
