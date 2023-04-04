package ex05.sort;

import java.util.Arrays;

public class BubbleSort {

    /*
        모든 요소가 기준.
        뒤부터 정렬.
     */

    public static void main(String[] args) {

        int[] a = {7, 3, 5, 2, 8};
//        int[] a = {8, 7, 5, 3, 2};
        int temp;

        System.out.printf("버블정렬 전: %s%n", Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {  // 교환: 부등호 방향에 따라 오름차순 또는 내림차순
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.printf("%d회전 정렬 후: %s%n", i + 1, Arrays.toString(a));
        }
    }
}
