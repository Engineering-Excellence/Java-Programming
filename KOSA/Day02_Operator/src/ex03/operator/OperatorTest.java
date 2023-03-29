package ex03.operator;

public class OperatorTest {

    public static void main(String[] args) {

        // 대입 연산자: =, +=, -=, *=, /=, <<=, >>=, ...

        int x = 2, y = 3, result;

        result = x + y;
        System.out.println(result);

//        x = x + y;
        x += y;
        System.out.println(x);

//        x = x * y;
        x *= y;
        System.out.println(x);

//        x = x + 1;
//        x += 1;
        x++;
        System.out.println(x);
    }
}
