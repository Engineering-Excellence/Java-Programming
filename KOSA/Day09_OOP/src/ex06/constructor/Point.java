package ex06.constructor;

public class Point {

    private static final Point instance = new Point();

    // Field
    private int x, y;

    // Constructor
    public Point() {
        this(100, 100); // 반드시 첫 줄에 위치해야 한다.
        System.out.println("생성자 0 자동호출");
        System.out.println("=============================");
    }

    public Point(int x) {
        this(x, 9999);
        System.out.println("생성자 1 자동호출");
        System.out.println("=============================");
        this.x = x;
        y = 999;
    }

    public Point(int x, int y) {
        System.out.println("생성자 2 자동호출");
        System.out.println("=============================");
        this.x = x;
        this.y = y;
    }

    // Getters & Setters
    public static Point getInstance() {
        return instance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Output
    public void display() {
        System.out.printf("x = %d, y = %d%n", x, y);
    }
}
