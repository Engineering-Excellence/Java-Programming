package ex01.memory;

import java.util.Scanner;

public class MainEntry {

    public static void main(String[] args) {

        /*
            ★ 메모리 영역
                Stack
                Heap
                Constructor
                Code
         */

        // Stack: {} 안에서만 생존
        int x = 3, y = 5;
        double d = 12.34;
        char ch = 'A';

        // Stack에 주소 저장
        // Heap에 실젯값 저장: Garbage Collector에 의해 소멸
        String s1 = new String("KOSA");
        String s2 = new String("DAEBO");

        System.out.print("Int Data Input: ");
        Scanner sc = new Scanner(System.in);

        int z = sc.nextInt();
        System.out.println(z);
        System.out.println(x + ", " + y + ", " + d + ", " + ch);

        // C/C++는 배열을 Stack에 저장, Java는 Heap에 저장(객체)
//        int a[];
        int[] a;
    }
}
