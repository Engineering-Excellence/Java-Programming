package ex01.If;

import java.util.Scanner;

public class MainEntry {

    public static void main(String[] args) {

        System.out.print("Integer Data Input: ");
        int su = new Scanner(System.in).nextInt();

        /*
            if (su % 2 == 0) System.out.println("Even");
            else System.out.println("Odd");
        */
        System.out.println(su % 2 == 0 ? "Even" : "Odd");

        System.out.println("------------------------------------------------------------------------------------------");

        // 양수, 음수, 0 판정
        if (su > 0 ) System.out.println("Positive");
        else if (su < 0) System.out.println("Negative");
        else System.out.println(0);
    }
}
