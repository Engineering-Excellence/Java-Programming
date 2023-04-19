package ex01.constructor;

public class Circle {

    private int x, y, r;

    // Constructor

    public Circle() {
//        x = y = 100;
//        r = 5;
        this(100, 100, 5);
        System.out.println("생성자 0 자동호출");
    }

    public Circle(int r) {
        this.r = r;
        x = y = 9;
        System.out.println("생성자 1 자동호출");
    }

    public Circle(int x, int y) {
        this(x, y, 20);
//        this.x = x;
//        this.y = y;
        System.out.println("생성자 2 자동호출");
    }

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        System.out.println("생성자 3 자동호출");
    }

    public void disp() {
        System.out.printf("(x, y, r) = (%d, %d, %d)%n", x, y, r);
    }
}
