package ex04.For;

public class MainEntry {

    public static void main(String[] args) {

        for (int i = 1; i < 11; i++) {
//            System.out.printf("%2d. Daebo%n", i);
//            System.out.println("*");
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print("*");
        }
    }
}
