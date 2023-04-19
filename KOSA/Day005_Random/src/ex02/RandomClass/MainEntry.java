package ex02.RandomClass;

import java.util.Random;

public class MainEntry {

    public static void main(String[] args) {

        Random rand = new Random();

        System.out.println(rand.nextDouble());

        int num = rand.nextInt();
        System.out.println(num);

        System.out.println("-----------------------------------------------------------------------------------------");

        // 0 이상 5 미만의 정수형 난수 생성
        System.out.println(rand.nextInt(5));
        System.out.println(rand.nextInt(5) + 1);
    }
}
