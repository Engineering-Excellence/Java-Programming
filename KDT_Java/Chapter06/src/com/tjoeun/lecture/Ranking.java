package com.tjoeun.lecture;

import java.util.Arrays;

public class Ranking {

    public static void main(String[] args) {

        int[] score = {80, 100, 70, 100, 90};
//		석차를 기억하는 기억장소는 1로 초기화시킨다.
        int[] rank = new int[score.length];
        /*
            for (int i = 0; i < rank.length; i++) {
                rank[i] = 1;
            }
        */
        Arrays.fill(rank, 1);

        for (int i = 0; i < score.length; i++) {
            for (int k : score) {
//				System.out.println("i = " + i + ", j = " + j);

//				내림차순 석차(큰 점수가 1등)
//				부등호를 ">"로 수정하면 오름차순 석차(작은 점수가 1등)가 계산된다.
                if (score[i] < k) {
                    rank[i]++;
                }

            }
        }

        for (int i = 0; i < score.length; i++) {
            System.out.printf("%3d점은 %d등입니다.%n", score[i], rank[i]);
        }
    }
}
