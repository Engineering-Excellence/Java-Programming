package com.tjoeun.exercise;

import java.util.Arrays;

// 문자열 배열을 스트림으로 변환하여 forEach 메서드를 통해 출력하는 코드를 작성
public class Exercise2 {

    public static void main(String[] args) {

        // 문자열 배열
        String[] arr = new String[]{"a", "b", "c", "d", "e", "f"};

        // 코드 작성
        Arrays.stream(arr).forEach(s -> System.out.printf("%s\t", s));
//        Arrays.stream(arr).forEach(System.out::print);
    }
}
