package ex01.java;

public class MainEntry {

    public static void main(String[] args) {

        Calc c = new Calc();

        System.out.printf("%d + %d = %d%n", 1, 2, c.add(1, 2));
        System.out.printf("%d + %d = %d%n", 10, 22, c.add(10, 22));
        System.out.println();
        System.out.printf("%d × %d = %d%n", 3, 4, c.mul(3, 4));
        System.out.printf("%d × %d × %d = %d%n", 7, 4, 5,  c.mul(7, 4, 5));
    }
}
