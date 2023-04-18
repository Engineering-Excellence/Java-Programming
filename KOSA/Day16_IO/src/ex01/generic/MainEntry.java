package ex01.generic;

import java.util.Date;

class Point<T, U> { }

public class MainEntry {

    public static void main(String[] args) {

        GenericEx<String> t1 = new GenericEx<>();
        String[] strings = {"abc", "kbs", "str"};
        t1.set(strings);
        t1.print();

        System.out.println("=".repeat(60));

        GenericEx<Integer> t2 = new GenericEx<>();
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8};
        t2.set(integers);
        t2.print();

        System.out.println("=".repeat(60));

        GenericEx<Double> t3 = new GenericEx<>();
        Double[] doubles = {1., 2., 3., 4., 5., 6., 7., 8.};
        t3.set(doubles);
        t3.print();

        System.out.println("=".repeat(60));

        GenericEx<Object> t4 = new GenericEx<>();
        Object[] objects = {"12.34", new Date(), 47.2, 5.5, "text", 70, new Point<>()};
        t4.set(objects);
        t4.print();
    }
}
