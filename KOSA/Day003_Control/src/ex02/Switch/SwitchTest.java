package ex02.Switch;

import java.util.Scanner;

public class SwitchTest {

    public static void main(String[] args) {

        System.out.print("Point: ");
        int point = new Scanner(System.in).nextInt();

        String prize = "";

        switch (point) {

            case 1: prize = "집"; break;
            case 2: prize = "피아노"; break;
            case 3: prize = "우산"; break;

            default:
                System.out.println("다음 기회에...");
                System.exit(0);
        }

        System.out.printf("%s 상품에 당첨되셨습니다. 축하합니다!%n", prize);
    }
}
