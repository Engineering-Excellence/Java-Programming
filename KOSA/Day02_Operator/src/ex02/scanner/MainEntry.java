package ex02.scanner;

import java.util.Scanner;
//import java.lang.*; // 내부적으로 자동 import

public class MainEntry {

    public static void main(String[] args) {

        // 표준 입력: System.in
        Scanner sc = new Scanner(System.in);    // 인스턴스 객체 생성, 메모리 할당, 생성자 함수 자동 호출
        System.out.print("정수 데이터 입력: ");
        int su = sc.nextInt();
        sc.close();

        System.out.printf("%n입력 받은 수: %d%n", su);

        /*
            Ctrl + /
            Ctrl + Shift + /: 여러 줄 주석 설정
            Ctrl + Shift + \: 여러 줄 주석 해제
         */
    }
}
