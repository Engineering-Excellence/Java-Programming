package com.tjoeun.lecture;

import java.util.Random;

public class DiceTest3 {

    public static void main(String[] args) {

        Random random = new Random();
        int[] count = new int[6];

        for (int i = 0; i < 10; i++) {
//			int dice = random.nextInt(6) + 1;
//			System.out.println(dice);
//			count[dice - 1]++;
            count[random.nextInt(6)]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(i + 1 + "의 개수: " + count[i]);
        }
    }
}















