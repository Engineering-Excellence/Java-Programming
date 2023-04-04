package ex05.sort;

import java.util.Arrays;

public class SelectionSort {

    /*
        기준이 있다.
        작은 것이 앞으로 온다.
        앞부터 정렬.
     */

    public static void main(String[] args) {

        int[] a = {7, 3, 5, 2, 8};
//        int[] a = {8, 7, 5, 3, 2};
        int temp;

        System.out.printf("선택정렬 전: %s%n", Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {  // 교환: 부등호 방향에 따라 오름차순 또는 내림차순
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            System.out.printf("%d회전 정렬 후: %s%n", i + 1, Arrays.toString(a));
        }
    }
}
