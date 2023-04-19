package quiz;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScoreArray_Method {

    static String input() { // 성적 입력

        System.out.print("'이름 국어 영어 수학' 순서로 입력하세요.: ");
        return new Scanner(System.in).nextLine().trim();
    }

    static void output(String[] name, int[][] score, int[] tot, double[] avg, char[] grd, int[] rank) { // 성적 출력

        System.out.println("\n학번\t이름\t국어\t영어\t수학\t총점\t평균\t\t학점\t석차\n========================================================================");
        for (int i = 0; i < name.length; i++) {
            System.out.printf("%2d번\t%-3s\t%3d점\t%3d점\t%3d점\t%3d점\t%6.2f점\t%2c\t\t%d/%d%n", i + 1, name[i], score[i][0], score[i][1], score[i][2], tot[i], avg[i], grd[i], rank[i], num);
        }
    }

    static int[] tot(int[][] score) {   // 총점 계산

        int[] tot = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                tot[i] += score[i][j];
            }
        }
        return tot;
    }

    static double[] avg(int[] tot) {    // 평균 계산

        double[] avg = new double[tot.length];
        for (int i = 0; i < tot.length; i++) {
            avg[i] = (double) tot[i] / 3;
        }
        return avg;
    }

    static char[] grd(double[] avg) {   // 학점 계산

        char[] grd = new char[avg.length];
        for (int i = 0; i < avg.length; i++) {
            grd[i] = switch ((int) avg[i] / 10) {
                case 10, 9 -> 'A';
                case 8 -> 'B';
                case 7 -> 'C';
                case 6 -> 'D';
                default -> 'F';
            };
        }
        return grd;
    }

    static int[] rank(double[] avg) {   // 석차 계산

        int[] rank = new int[avg.length];
        Arrays.fill(rank, 1);   // 모든 석차를 1로 초기화
        for (double d : avg) {
            for (int j = 0; j < avg.length; j++) {
                if (d > avg[j]) {
                    rank[j] += 1;   // 점수가 낮은 사람의 석차를 1 증가
                }
            }
        }
        return rank;
    }

    static final int num = 5;   // 학생 수

    public static void main(String[] args) {

        String[] name = new String[num];    // 이름
        int[][] score = new int[num][3];    // 성적
        String temp;    // 키보드 임시 입력값

        // 정규식 패턴
        Pattern pattern = Pattern.compile("^[가-힣]+\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)$");    // 한글 및 공백과 0 이상 100 이하의 숫자로만 이루어진 "한글 숫자 숫자 숫자" 형태의 정규식

        for (int i = 0; i < name.length; i++) {
            temp = input(); // 성적 입력
            boolean flag = false;

            do {
                if (flag) {
                    temp = input();
                    flag = false;
                }
                Matcher matcher = pattern.matcher(temp);
                if (matcher.matches()) {    // 정규식 일치시 이름과 점수를 입력 후 do while 탈출
                    name[i] = temp.split(" ")[0];
                    for (int j = 0; j < 3; j++) {
                        score[i][j] = Integer.parseInt(temp.split(" ")[j + 1]);
                    }
                } else {    // 정규식 불일치시 do while 반복
                    flag = true;
                }
            } while (flag);
        }   // for End

        int[] tot = tot(score); // 총점
        double[] avg = avg(tot);  // 평균
        char[] grd = grd(avg);  // 학점
        int[] rank = rank(avg); // 석차

        output(name, score, tot, avg, grd, rank);   // 성적 출력
    }
}
