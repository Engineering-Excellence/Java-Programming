package ex03.inheritance;

public class Circle extends Point { // sub class: 생성자를 제외한 나머지를 상속받음

    private int r;

    public Circle() {
        this.r = 5;
        System.out.println("Circle default Constructor");
    }

    public Circle(int x, int y, int r) {
        super(x, y);
//        this.x = x;
//        this.y = y;
        this.r = r;
    }

    @Override
    public void disp() {
        System.out.printf("(x, y, r) = (%d, %d, %d)%n", x, y, r);
    }
}
