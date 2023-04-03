package ex02.array;

import java.util.Arrays;
import java.util.Random;

public class QuizEx2 {

    public static void main(String[] args) {

        // 문제] 기상청 출근했어요(단, 특정월(4월) 30일 기준) 비가 온 날에 대한 강수량 평균(소숫점 2자리)

        final int day = 30; // 날짜 설정
        int[] rain = new int[day];    // 배열 생성
        Arrays.setAll(rain, i -> new Random().nextInt(50)); // 임의 강수량 채우기
        System.out.printf("월 강수량: %s mm%n평균 강수량: %.2f mm%n", Arrays.toString(rain), Arrays.stream(rain).average().getAsDouble());  // 강수량 평균 출력
    }
}
