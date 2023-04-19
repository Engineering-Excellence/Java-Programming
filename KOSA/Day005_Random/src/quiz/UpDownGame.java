package quiz;

import java.util.Random;
import java.util.Scanner;

// 1 ~ 100 숫자 중에서 난수 출력을 answer에 저장, 5번의 기회
public class UpDownGame {

    public static void main(String[] args) {

        Random random = new Random();
        int answer = random.nextInt(100) + 1, reply;

        Scanner scanner = new Scanner(System.in);
        int chance = 0;
        while (chance++ < 5) {
            System.out.print("정답을 입력하세요.: ");
            reply = scanner.nextInt();
            if (reply == answer) {
                System.out.printf("%d번째 시도: 맞췄습니다! 정답은 %d입니다!%n", chance, answer);
                return;
            } else {
                System.out.printf("%d번째 시도: %s%n", chance, answer > reply ? "UP↑" : "DOWN↓");
            }
        }
        System.out.printf("틀렸습니다. 정답은 %d입니다.%n", answer);
    }
}
