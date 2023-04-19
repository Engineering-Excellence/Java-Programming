package ex04.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainEntry {

    public static void main(String[] args) {

        /*int[] arr = new int[100];
        Random random = new Random();
        Arrays.setAll(arr, i -> random.nextInt(10) + 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%2d\t", arr[i]);
            if (i % 10 == 9) System.out.println();
        }*/

        int[] a = new int[30];
        int[][] a2 = new int[2][3]; // 초기화 되어있지 않을 때는 행, 열 크기를 생략할 수 없다.
        int[][] a3 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] a4 = {{1, 2, 3}, {4, 5, 6}};
//        int[][] a5 = {1, 2, 3, 4, 5, 6};    // Error
//        int[][] a6 = new int[2][]{{1, 2, 3}, {4, 5, 6}};    // Error
        int[][] a7 = {{0,}, {0,}};  // {{0}, {0}};

        int[][][] a8 = new int[2][2][3];    // [면][행][열]

        // 배열 길이(크기)
        System.out.println("1차원 배열 길이: " + a.length);
        System.out.println();
        System.out.println("2차원 배열 행 길이: " + a2.length);
        System.out.println("2차원 배열 열 길이: " + a2[0].length);
        System.out.println();
        System.out.println("3차원 배열 면 길이: " + a8.length);
        System.out.println("3차원 배열 행 길이: " + a8[0].length);
        System.out.println("3차원 배열 열 길이: " + a8[0][0].length);
        System.out.println();

        // 임의 데이터 입력 받아서 배열 데이터값 출력하는 프로그램 작성(3차원)
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("배열에 입력할 숫자를 입력하세요.: ");*/
        Random random = new Random();
        for (int i = 0; i < a8.length; i++) {
            for (int j = 0; j < a8[i].length; j++) {
                for (int k = 0; k < a8[i][j].length; k++) {
//                    a8[i][j][k] = scanner.nextInt();
                    a8[i][j][k] = random.nextInt(10) + 1;
                    System.out.printf("%2d\t", a8[i][j][k]);
                }   // k end
                System.out.println();
            }   // j end
            System.out.println();
        }   // i end
        System.out.println(Arrays.deepToString(a8));
    }
}
