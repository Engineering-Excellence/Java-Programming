package ex05.wrapper;

class Point { }

public class MainEntry {

    public static void main(String[] args) {

        Integer Ia = new Integer(10);
        Integer Ib = new Integer("10");
        String su = "30";
        Point pt = new Point();

        System.out.println(pt);
        System.out.println(pt.toString());

        System.out.println(Ia);
        System.out.println(Ia.getClass().getName() + '@' + Integer.toHexString(Ia.hashCode())); // Integer 타입은 주소가 아닌 리터럴로 저장

        int x = 77;
        double y = 5.5;
        System.out.printf("x = %d, y = %.1f%n", x, y);
//        y = x;  // 묵시적 형변환
        x = (int) y;    // 명시적 형변환
        System.out.printf("x = %d, y = %.1f%n", x, y);

        // Boxing vs Unboxing
        int c = Ia.intValue();  // JDK 4.x 이전에 사용하던 메서드
        int d = Ib; // JDK 5.x 이후부터 Auto Boxing & Unboxing
        int num = Integer.parseInt(su);
        System.out.println(c + num);
        System.out.println(c + d);
        System.out.println(Ia.MAX_VALUE);
        System.out.println(Ia.MIN_VALUE);

//        Double dd = 12.34;
        Double dd = new Double(12.34);
        System.out.printf("dd = %.2f%n", dd);
        System.out.println(dd.MAX_VALUE);
        System.out.println(dd.MIN_VALUE);

        System.out.println("=".repeat(40));
        c = (int) dd.doubleValue();
        System.out.printf("(int) dd = %d%n", c);

        int e = Integer.parseInt("123");
        int f = Integer.parseInt("1111111", 2);
        System.out.println(f);
        System.out.println(e + 20);

        int xx = 3; // Stack Memory
        Integer yy = new Integer(3);    // Heap Memory

        xx = yy.intValue();
        xx = yy;    // Auto Boxing & Unboxing
    }
}
