package quiz;

import java.util.*;

// Lotto
public class Lotto {

    static Random random = new Random();

    public static void main(String[] args) {

        System.out.print("로또 구매 개수를 입력하세요.: ");
        int n = new Scanner(System.in).nextInt();
        lotto(n);
    }

    protected static void lotto(int n) {

        for (int i = 1; i <= n; i++) {  // 로또 구매 개수 만큼 반복

            int[] lotto = new int[6];   // 크기 6인 배열 생성
            int size = 0;

            while (size < 6) {  // 6번째 번호가 정해질 때까지 반복

                boolean flag = true;    // 뽑을 때마다 flag 초기화
                int pick = random.nextInt(45) + 1;  // 1 ~ 45 난수 생성

                for (int num : lotto) { // 중복 검사
                    if (num == pick) {
                        flag = false;   // 중복일 경우 flag 변경 후 반복 탈출
                        break;
                    }
                }

                if (flag) lotto[size++] = pick;  // 중복되지 않았을 경우(true)에만 배열에 추가
            }

            Arrays.sort(lotto); // 로또 번호를 오름차순으로 정렬
            System.out.printf("로또 %d세트: %s%n", i, Arrays.toString(lotto)); // 결과 출력
        }
    }
}
