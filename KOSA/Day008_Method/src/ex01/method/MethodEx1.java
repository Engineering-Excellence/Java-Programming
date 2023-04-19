package ex01.method;

import java.util.Scanner;

public class MethodEx1 {

    public static void main(String[] args) {

        System.out.println(show());
        int num = show();
        System.out.println(num);
        int show = show();
        System.out.println(show);

        System.out.printf("max = %d", max());
    }

    // 3) 매개변수 없고, 리턴타입 있는 경우
    static int show() {

        return 100;
    }

    static int max() {

        System.out.print("x, y = ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        return x >= y ? x : y;
    }
}
