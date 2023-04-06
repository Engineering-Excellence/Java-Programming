package ex07.argumentVariable;

import java.util.Arrays;

public class MainEntry {

    public static void main(String[] args) {

        System.out.println(plus(1));
        System.out.println(plus(1, 2, 3));
        System.out.println(plus(1, 2, 3, 4, 5));
        System.out.println(plus("A", "B", "C", "D"));
    }

    private static int plus(int... ints) {
        return Arrays.stream(ints).sum();
    }

    private static StringBuilder plus(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(strings).forEach(stringBuilder::append);
        return stringBuilder;
    }
}
