package ex04.api_object;

// Object class

class Point {
}

public class MainEntry {

    public static void main(String[] args) {

        Point pt = new Point();
        System.out.println("Point pt INFO");
        System.out.println("className: " + pt.getClass());
        System.out.println("hashCode: " + pt.hashCode());   // 주소를 10진수 형태로 출력, 1170794006
        System.out.println("pt address: " + pt);    // 45c8e616
        System.out.println("Object String: " + pt.toString());
        System.out.printf("10진수 주소: %d%n", 0x45c8e616);
        System.out.println("-".repeat(50));

        Point pt2 = new Point();
        System.out.println("Point pt2 INFO");
        System.out.println("className: " + pt2.getClass());
        System.out.println("hashCode: " + pt2.hashCode());
        System.out.println("pt2 address: " + pt2);
        System.out.println("Object String: " + pt2.toString());
        System.out.printf("10진수 주소: %d%n", 0x45c8e616);
        System.out.println("#".repeat(50));

        System.out.println("pt2.toString(): toString()의 의미");
        System.out.println(pt2.getClass().getName() + '@' + Integer.toHexString(pt2.hashCode()));

        Point pt3 = new Point();
        if (pt.hashCode() == pt3.hashCode()) {
            System.out.println("같다.");
        } else {
            System.out.println("다르다");
        }

        Point pt4 = new Point();
        if (pt.hashCode() == pt4.hashCode()) {
            System.out.println("같다.");
        } else {
            System.out.println("다르다");
        }
    }
}
