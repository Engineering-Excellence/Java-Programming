package ex02.oop;

class Circle extends Point {

    private int x, y, r;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void display() {
        System.out.printf("x = %d, y = %d, r = %d%n", x, y, r);
    }
}

public class CircleMain {

    public static void main(String[] args) {

        Circle c = new Circle();    // 객체 생성, 메모리 할당, 생성자 함수 자동 호출;

        c.setR(5);
        System.out.println(c.getR());
    }
}
