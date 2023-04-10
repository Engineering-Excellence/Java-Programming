package ex03.inheritance;

public class Point {    // super class

    // Field
    protected int x, y;

    // Constructor
    public Point() {
        x = y = 10;
        System.out.println("Point default Constructor");
    }

    public Point(int x) {
        this(x, 9);
        System.out.println("Point x Constructor");
    }

    public Point(int x, int y) {
//        super();
        this.x = x;
        this.y = y;
        System.out.println("Point xy Constructor");
    }

    // Getters & Setters

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

    public void disp() {
        System.out.printf("(x, y) = (%d, %d)%n", x, y);
    }
}
