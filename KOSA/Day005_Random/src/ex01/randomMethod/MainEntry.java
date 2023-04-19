package ex01.randomMethod;

import java.util.Random;

public class MainEntry {

    public static void main(String[] args) {

        // 0 이상 1 미만의 난수를 생성
        System.out.println(Math.random());

        // 0 이상 5 미만의 난수를 생성
        System.out.println(Math.random() * 5);

        // 1 이상 5 미만의 난수를 생성
        System.out.println(Math.random() * 4 + 1);

        // 1 이상 5 미만의 정수형 난수를 생성
        System.out.println((int) (Math.random() * 4 + 1));

        // 1 이상 5 미만의 정수형 난수를 생성
        Random random = new Random();
        System.out.println(random.nextInt(4) + 1);
    }
}
