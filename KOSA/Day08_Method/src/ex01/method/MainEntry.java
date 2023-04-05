package ex01.method;

public class MainEntry {

    public static void main(String[] args) {

        System.out.println("main start");
        line(); // 메서드 호출
        info();
        line();
        System.out.println("main end");
        line();
        plus(10, 20, "Hello, world!");
    }

    // 1) 매개변수 없고, 리턴타입 없는 경우
    public static void info() {

        System.out.println("Kyle");
        System.out.println("010-1234-5678");
        System.out.println("Seoul");
    }

    // 선 긋기 함수
    static void line() {

        System.out.println("--------------------------------------------------");
    }

    // 2) 매개변수 있고, 리턴타입 없는 경우
    static void plus(int x, int y, String msg) { // 메서드 정의부(구현부)

        int sum = x + y;
        System.out.printf("sum = %d", sum);
        System.out.printf("x = %d, y = %d, msg = %s%n", x, y, msg);
    }

    // 절댓값 출력
    static void abs(int x) {

        if (x < 0) x = -x;
        System.out.printf("%d", x);
    }
}
