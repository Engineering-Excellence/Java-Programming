package ex01.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaMain {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        Consumer<Integer> method = n -> System.out.print(n + "\t");
        numbers.forEach(method);

        System.out.println("\n" + "-".repeat(60));

        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + "\t");
        }

        System.out.println("\n" + "-".repeat(60));

        for (int i : numbers) {
            System.out.print(i + "\t");
        }
    }
}
