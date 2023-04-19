package ex02.array;

import java.util.Arrays;

public class MainEntry {

    public static void main(String[] args) {

        // 1.
        char[] ch;  // 배열 선언
        ch = new char[4];   // 배열 생성, 메모리에 할당

        // 2.
        char[] ch2 = new char[4];   // 배열 선언 및 생성
        // 배열 초기화
        ch[0] = 'J';
        ch[1] = 'A';
        ch[2] = 'V';
        ch[3] = 'A';

        // 3.
        char[] ch3 = {'J', 'A', 'V', 'A', 'k', 'b', 's', 'm', 'b', 'c'};

        // 배열의 크기(길이)
        System.out.printf("배열의 길이(크기): %d%n", ch2.length);
        System.out.printf("배열의 길이(크기): %d%n", ch3.length);

        // 배열의 내용 출력
        System.out.printf("ch[2]: %c%n", ch[2]);

        System.out.println("=========================================================================================");

        for (int i = 0; i < 4; i++) {
            System.out.printf("ch2[%d] = %c%n", i, ch2[i]);
        }

        System.out.println("=========================================================================================");

        for (int i = 0; i < ch3.length; i++) {
            System.out.printf("ch3[%d] = %c%n", i, ch3[i]);
        }

        System.out.println("=========================================================================================");
    }
}
