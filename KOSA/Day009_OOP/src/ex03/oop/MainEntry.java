package ex03.oop;

public class MainEntry {

    public static void main(String[] args) {

        // 객체 생성해서 3, 5로 결과 출력하기
        Point point = new Point();

        point.display();

        point.setX(100);
        point.setY(50);
        point.display();

        point.setXY(3, 5);
        point.display();

        System.out.println("-----------------------------------------------------------------------------------------");

        Rectangle rectangle = new Rectangle();

        rectangle.display();

        rectangle.setData(1, 1, 2, 2);
        rectangle.display();
    }
}
