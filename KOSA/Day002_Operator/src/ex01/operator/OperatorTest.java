package ex01.operator;

public class OperatorTest {

    public static void main(String[] args) {

        // Shift 연산자: <<, >>, <<<
        int x = 8, result;

//        result = x << 2;    // Left Shift: 원랫값 * 2^bit수 = 8 * 4 = 32
        result = x >> 3;    // Right Shift: 원랫값 / 2^bit수 = 8 / 8 = 1
        System.out.printf("%d << 2 = %d%n", x, result);

        System.out.println("------------------------------------------------------------------------------------------");

        // 관계 연산자: >, <, >=, <=, ==, !=
        x = 20; int y = 20;

        if (x != y) System.out.println("같지 않다.");
        else System.out.println("같다.");
    }
}
