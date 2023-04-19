package ex06.constructor;

public class MainEntry {

    public static void main(String[] args) {

        Point instance = Point.getInstance();

        instance.display(); // 초기 상태
        System.out.println(instance);
        System.out.println(instance.hashCode());
        instance.setX(3);
        instance.display();
        instance.setY(5);
        instance.display();

        System.out.println("=============================");

        Point point1 = new Point(1);    // 객체 생성, 메모리에 할당, 생성자 자동 호출
        point1.display();
        System.out.println(point1.toString().hashCode());

        System.out.println("=============================");

        Point point2 = new Point(5, 50);
        point2.display();

        System.out.println("=============================");
    }
}
