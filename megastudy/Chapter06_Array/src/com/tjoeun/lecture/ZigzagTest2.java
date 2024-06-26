package com.tjoeun.lecture;

public class ZigzagTest2 {

    public static void main(String[] args) {

        int[][] a = new int[4][6];
        int n = 0;
        int start = 0; // 2차원 배열에서 숫자가 채워지기 시작하는 열의 인덱스
        int end = a[0].length - 1; // 2차원 배열에서 숫자가 채워지는 마지막 열의 인덱스
        int sw = 1; // start 부터 end 까지 증가치로 사용할 변수

        for (int i = 0; i < a.length; i++) {
//			숫자 채우기
            for (int j = start; j != end + sw; j += sw) {
                a[i][j] = ++n;
            }

            int temp = start;
            start = end;
            end = temp;
            sw *= -1;
        }

        for (int[] i : a) { // 행
            for (int j : i) { // 열
                System.out.printf("%2d ", j);
            }
            System.out.println();
        }
    }
}
