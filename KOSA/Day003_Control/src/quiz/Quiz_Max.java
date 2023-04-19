package quiz;

import java.util.Scanner;

// 문제3] 정수 2개를 입력 받아서 큰 수를 출력하는 프로그램
public class Quiz_Max {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 2개를 입력하세요.: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        if (num1 == num2) System.out.println("입력한 두 숫자는 크기가 같습니다.");
        else System.out.printf("두 정수 %d, %d 중에서 더 큰 숫자는 %d입니다.", num1, num2, num1 > num2 ? num1 : num2);
    }
}
