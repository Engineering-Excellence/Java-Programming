package ex02.scanner;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 인스턴스 객체 생성, 메모리 할당, 생성자 함수 자동 호출

        // next() vs nextLine()
        System.out.print("String Input 1: ");
//        String s1 = sc.next();  // 공백 인식 못 함
        String s1 = sc.nextLine();
        System.out.println(s1);

        System.out.println("------------------------------------------------------------------------------------------");

        System.out.print("Integer, Double Date Input: ");
//        int num = sc.nextInt();
//        double su = sc.nextDouble();
//        System.out.printf("num = %d, su = %f", num, su);

        System.out.printf("num = %d, su = %f", sc.nextInt(), sc.nextDouble());
    }
}
