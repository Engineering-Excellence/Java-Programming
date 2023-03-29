package ex01.If;

import java.util.Scanner;

public class Controller_If {

    public static void main(String[] args) {

        String str = "";
        System.out.print("Integer Data Input: ");
        int su = new Scanner(System.in).nextInt();

        if (su % 2 != 0) {
            System.out.println("Odd");
            extracted(su);
        } else {
            System.out.println("Even");
            extracted(su);
        }   // end outer if
    }

    private static void extracted(int su) {
        if (su > 0) {
            System.out.println("Positive");
        } else if (su < 0) {
            System.out.println("Negative");
        } else {
            System.out.println(0);
        }
    }
}
