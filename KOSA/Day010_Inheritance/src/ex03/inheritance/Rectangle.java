package ex03.inheritance;

public class Rectangle extends Point {

    // Field
    private int x2, y2;

    // Constructor
    public Rectangle() {
        System.out.println("Rectangle default Constructor");
    }

    public Rectangle(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
        System.out.println("Rectangle xy Constructor");
    }

    public Rectangle(int x, int y, int x2, int y2) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        System.out.println("Rectangle xxyy Constructor");
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void display() {
        System.out.printf("(x, y, x2, y2) = (%d, %d, %d, %d)%n", x, y, x2, y2);
    }
}
