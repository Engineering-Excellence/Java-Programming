package ex01.operator;

public class MainEntry {

    // 최단산쉬관논삼대콤
    public static void main(String[] args) {

        // 최우선 연산자: (), {}, [], •

        // 단항 연산자: 증감
        int x = 10, y;
//        y = x++;    // 후위연산: 대입 먼저, 연산 나중
//        y = ++x;    // 전위연산: 연산 먼저, 대입 나중
//        y = x--;
        x++;    // ++x;
        y = x;
        System.out.println("x = " + x + ", y = " + y);

        System.out.println("------------------------------------------------------------------------------------------");

        // 산술 연산자: +, -, *, /, %
        x = 10; y = 20;
        int gob = x * y;
        System.out.println("x * y = " + gob);
        System.out.println(x + " * " + y + " = " + gob);
        System.out.println("3 + 4 * 5 = " + (3 + 4 * 5));
        System.out.println("(3 + 4) * 5 = " + (3 + 4) * 5);

        // 정수 간 연산의 결과는 정수!!
        System.out.println("\n7 / 3 = " + 7 / 3);   // 몫
        System.out.println("7 % 3 = " + 7 % 3);   // 몫

        // 정수 간 연산의 결과를 실수로 표현
        System.out.println("\n7 / 3 = " + 7 / 3);   // 2
        System.out.println("7 / 3. = " + 7 / 3.);   // 2.333
        System.out.println("7. / 3 = " + 7. / 3);   // 2.333

        System.out.println("------------------------------------------------------------------------------------------");

        //  비트 부정: -(원랫값 + 1)
        y = ~x;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x = " + Integer.toBinaryString(x) + ", y = " + Integer.toBinaryString(y));
    }
}
