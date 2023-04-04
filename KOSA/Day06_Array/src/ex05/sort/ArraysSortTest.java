package ex05.sort;

import java.util.Arrays;

public class ArraysSortTest {

    public static void main(String[] args) {

        int[] a = {7, 3, 5, 2, 8};
//        int[] a = {8, 7, 5, 3, 2};

        System.out.printf("정렬 전: %s%n", Arrays.toString(a));

        Arrays.sort(a); // 정렬 알고리즘이 이미 내부적으로 처리되어있는 메서드

        System.out.printf("정렬 후: %s%n", Arrays.toString(a));
    }
}
