package ex01.lambda;

import java.util.function.IntBinaryOperator;

public class LambdaMain2 {

    public int plus(int x, int y) { // static은 lambda 이용 불가!!
        return x + y;
    }

    public static void main(String[] args) {

        LambdaMain2 lambdaMain2 = new LambdaMain2();
        System.out.println(lambdaMain2.plus(1, 2));

        System.out.println("=".repeat(60));

//        IntBinaryOperator plus = (x, y) -> x + y;
        IntBinaryOperator plus = Integer::sum;
        System.out.println(plus.applyAsInt(1, 2));
    }
}
