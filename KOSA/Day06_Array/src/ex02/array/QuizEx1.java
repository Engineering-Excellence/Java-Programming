package ex02.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuizEx1 {

    public static void main(String[] args) {

        /*// 배열 데이터 5개 선언하고 합을 구하기
        int[] intArr = new int[5];  // 배열 선언
        Arrays.setAll(intArr, i -> new Random().nextInt(10) + 1);   // 랜덤 데이터 채우기
        System.out.printf("배열 %s의 합: %d%n", Arrays.toString(intArr), Arrays.stream(intArr).sum());  // 배열 합 출력*/

        // 배열 여러 데이터 중에서 7의 개수를 찾기
        /*int[] intArr2 = new int[20];  // 배열 선언
        Arrays.setAll(intArr2, i -> new Random().nextInt(10) + 1);   // 랜덤 데이터 채우기
        System.out.printf("배열 %s의 데이터 중에서 7의 개수: %d개%n", Arrays.toString(intArr2), Arrays.stream(intArr2).filter(i -> i == 7).count());  // 7의 개수 출력*/

        // 임의의 데이터 7개 입력 받고, 찾을 데이터도 입력받거나 해서 개수 구하는 프로그램 작성
        int[] intArr3 = new int[7];  // 배열 선언
        Arrays.setAll(intArr3, i -> new Random().nextInt(10));   // 랜덤 데이터 채우기
//        int n = intArr3[new Random().nextInt(7)];   // 임의의 데이터 선택
//        System.out.printf("배열 %s의 데이터 중에서 %d의 개수: %d개%n", Arrays.toString(Arrays.stream(intArr3).sorted().toArray()), n, Arrays.stream(intArr3).filter(i -> i == n).count());  // 선택한 데이터 개수 출력

        // 홀수 인덱스 위치 데이터만 출력
        System.out.printf("배열 %s의 데이터 중에서 홀수 인덱스 위치 데이터만 출력: ", Arrays.toString(Arrays.stream(intArr3).sorted().toArray()));
//        Arrays.stream(intArr3).filter(i -> intArr3[i] % 2 == 1).forEach(i -> System.out.print(i + " "));
    }
}
