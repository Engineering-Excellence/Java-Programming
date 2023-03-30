package quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz_UpperLower {

    public static void main(String[] args) {

        System.out.print("알파벳을 입력하세요: ");
        char[] alphabet = new Scanner(System.in).next().toCharArray();
        System.out.print(Arrays.toString(alphabet) + " → ");

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] >= 65 && alphabet[i] < 97) {
                alphabet[i] += 32;
                System.out.print(alphabet[i]);
            } else if (alphabet[i] >= 97 && alphabet[i] < 123) {
                alphabet[i] -= 32;
                System.out.print(alphabet[i]);
            } else {
                System.out.println("\n알파벳이 아닌 문자가 입력되어 프로그램을 종료합니다.");
                System.exit(1);
            }
        }
    }
}
