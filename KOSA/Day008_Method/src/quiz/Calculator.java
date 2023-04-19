package quiz;

import java.util.Scanner;

// 사칙연산
// plus(+), mul(*): void
// sub(-), div(/): int double
public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print("연산할 두 정수를 입력하세요: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.print("메뉴를 선택하세요(1: +, 2: *, 3: -, 4: /, 0: exit)\n입력: ");
            int choice = scanner.nextInt();

            Calculator calculator = new Calculator();
            switch (choice) {
                // 함수 호출
                case 1 -> calculator.plus(x, y);
                case 2 -> calculator.mul(x, y);
                case 3 -> System.out.printf("%d - %d = %d%n", x, y, calculator.sub(x, y));
                case 4 -> System.out.printf("%d / %d = %.2f%n", x, y, calculator.div(x, y));
                default -> {
                    System.out.println("1, 2, 3, 4 이외의 값이 입력되어 프로그램을 종료합니다.");
                    System.exit(0);
                }
            }
        }
    }

    void plus(int x, int y) {

        System.out.printf("%d + %d = %d%n", x, y, x + y);
    }

    void mul(int x, int y) {

        System.out.printf("%d * %d = %d%n", x, y, x * y);
    }

    int sub(int x, int y) {

        return x - y;
    }

    double div(int x, int y) {

        if (y == 0) System.err.println("0으로 나눌 수 없습니다.");
        return (double) x / y;
    }
}
