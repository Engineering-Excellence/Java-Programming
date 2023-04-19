package ex03.inheritance;

public class Main {

    public static void main(String[] args) {

        Point pt = new Point();
        pt.disp();

        Point pt2 = new Point(100, 300);
        pt2.disp();

        System.out.println("==============================================================");

        Rectangle rectangle = new Rectangle(10, 20, 30, 40);
        rectangle.disp();   // 부모의 output
        rectangle.display();    // 자신의 output
    }
}
