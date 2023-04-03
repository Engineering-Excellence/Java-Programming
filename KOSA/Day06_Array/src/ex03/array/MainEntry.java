package ex03.array;

import java.util.Arrays;

public class MainEntry {

    public static void main(String[] args) {

        // 1.
        int[][] a = new int[2][3];  // 2행 3열
        a[0][0] = 1;
        a[0][1] = 2;
        a[0][2] = 3;
        a[1][0] = 4;
        a[1][1] = 5;
        a[1][2] = 6;
        System.out.println(Arrays.deepToString(a));

        System.out.println("=========================================================================================");

        // 2.
        int[][] a2 = new int[][]{{1, 2, 3,}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(a2));

        System.out.println("=========================================================================================");

        // 3.
        int[][] a3 = {{1, 2, 3,}, {4, 5, 6}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("a3[%d][%d] = %d%n", i, j, a3[i][j]);
            }
        }

        System.out.println("=========================================================================================");

        System.out.printf("a3[0][2] = %d%n", a3[0][2]);
        System.out.println(Arrays.deepToString(a3));
        Arrays.stream(a3).flatMapToInt(Arrays::stream).forEach(element -> System.out.print(element + "\t"));

        System.out.println("\n=========================================================================================");

        // Quiz
        int[][] intArr = {{3, 8, 5, 10}, {7, 1, 2, 3}, {0, 0, 0, 0}};   // 초깃값 설정
        for (int j = 0; j < intArr[0].length; j++) {
            intArr[2][j] = intArr[0][j] + intArr[1][j]; // 0행과 1행의 요소들의 합을 2행에 대입
        }
        System.out.println(Arrays.deepToString(intArr));    // 결과 출력
//        Arrays.stream(intArr).flatMapToInt(Arrays::stream).skip(8).forEach(j -> System.out.printf("%d\t", j));

        System.out.println("\n=========================================================================================");

        // Quiz
        int[][] intArr2 = {{1, 2, 0}, {5, 7, 0}};   // 초깃값 설정
        for (int i = 0; i < intArr2.length; i++) {
            intArr2[i][2] = intArr2[i][0] * intArr2[i][1];  // i행 2열 = i행 0열 * i행 1열
        }
        System.out.println(Arrays.deepToString(intArr2));    // 결과 출력

        System.out.println("\n=========================================================================================");
    }
}
