package ex03.exception;

import java.util.Scanner;

public class MainEntry {

///*
    public static void main(String[] args) {

        int x, y, result;

        try {
            System.out.print("x, y = ");
            x = new Scanner(System.in).nextInt();
            y = new Scanner(System.in).nextInt();
            result = x / y; // 에러 발생 가능
            System.out.println(result);
        } catch (Exception e) {
//            System.out.println("0으로 나눌 수 없습니다.");   // User Message
//            System.out.println(e.getMessage());
            System.out.println("예외 발생!");
            e.printStackTrace();
        }
    }
//*/
}
