package quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuizLotto {

    static Random random = new Random();

    public static void init() {

        int[] arr = new int[6];   // 크기 6인 배열 생성
        int size = 0;   // 중복 없이 뽑힌 로또 개수
        while (size < 6) {
            int pick = random.nextInt(45) + 1;  // 1 ~ 45 난수 생성
            if (isCheck(arr, pick)) arr[size++] = pick; // 중복되지 않았을 경우(true)에만 배열에 추가
        }
        Arrays.sort(arr);   // 결과 정렬
        System.out.println(Arrays.toString(arr)); // 결과 출력
    }

    public static void main(String[] args) {

        System.out.print("로또 구매 개수를 입력하세요.: ");
        int n = new Scanner(System.in).nextInt();

        for (int i = 0; i < n; i++) {
            init();
        }
    }

    public static boolean isCheck(int[] arr, int pick) {

        boolean flag = true;    // 뽑을 때마다 flag 초기화
        for (int num : arr) { // 중복 검사
            if (num == pick) {
                flag = false;   // 중복일 경우 flag 변경 후 반복 탈출
                break;
            }
        }
        return flag;
    }
}
