package ex04.array;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {

        // next() vs. nextLine()

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();   // 공백 인식
        sc.next();  sc.next();  // 공백 처리(1개당 1byte → Enter 2byte), next()는 공백을 인식하지 못 함
//        String b = sc.next();
        System.out.println(a);
//        System.out.println(a + ", " + b);

    }
}
