package ex03.array;

import java.util.Random;

public class QuizScore {


    public static void main(String[] args) {

        int[][] score = new int[7][6];
        Random random = new Random();
        char grade;

        System.out.println("학번\t국어\t영어\t전산\t총점\t평균\t학점");
        for (int i = 0; i < score.length; i++) {
            score[i][0] = i + 1;
            for (int j = 1; j < score[0].length - 2; j++) {
                score[i][j] = random.nextInt(61) + 40;
            }
            score[i][4] = score[i][1] + score[i][2] + score[i][3];
            score[i][5] = score[i][4] / 3;
            grade = switch (score[i][5] / 10) {
                case 10, 9 -> 'A';
                case 8 -> 'B';
                case 7 -> 'C';
                case 6 -> 'D';
                default -> 'F';
            };
            System.out.printf("%2d번\t%d점\t%d점\t%d점\t%d점\t%d점\t%2c%n", i + 1, score[i][1], score[i][2], score[i][3], score[i][4], score[i][5], grade);
        }
    }
}
