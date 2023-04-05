package ex03.overload;

public class MainEntry {

    public static void main(String[] args) {

        line();

        plus(12.34);
        plus(20, 30);
        plus("Hello");

        line("*1234");
        line(10, "$");
    }

    static void plus(int x) {

        System.out.println(x + 100);
    }

    static void plus(int x, int y) {

        System.out.println(x + y);
    }

    static void plus(double x) {

        System.out.println(x + 100);
    }

    static void plus(String x) {

        System.out.println(x + 100);
    }

    static void line() {

        System.out.println("str");
    }

    static void line(String str) {

        for (int i = 0; i < str.length(); i++) {
            System.out.print(str);
        }
    }

    static void line(int n, String str) {

        for (int i = 0; i < n; i++) {
            System.out.print(str);
        }
    }
}
