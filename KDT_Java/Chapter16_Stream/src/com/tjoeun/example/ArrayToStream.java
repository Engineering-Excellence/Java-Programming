package com.tjoeun.example;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayToStream {

    public static void main(String[] args) {

        // 문자열 배열객체 생성
        String[] arr = new String[]{"a", "b", "c", "d", "e", "f"};

        // 배열 전체를 Stream 객체로 변환
        Stream<String> stream1 = Arrays.stream(arr);
//        stream1.forEach(System.out::print);
        stream1.forEach(s -> System.out.print(s + "\t"));
        System.out.println();

        // 인덱스 지정해서 변환 (2부터 5전까지)
        Stream<String> stream2 = Arrays.stream(arr, 2, 5);
//        stream2.forEach(System.out::print);
        stream2.forEach(s -> System.out.print(s + "\t"));
        System.out.println();

        // 필터, 조건
        int[] intArr = new int[11];
        Arrays.setAll(intArr, i -> i);
//        System.out.println(Arrays.toString(intArr));
//        IntStream intStream = Arrays.stream(intArr);
        Arrays.stream(intArr).skip(5).filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + "\t"));
    }
}
