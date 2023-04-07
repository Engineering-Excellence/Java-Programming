package quiz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainEntry {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Score instance = Score.getInstance();

        int population = instance.inputPopulation(scanner);
        Score[] score = new Score[population];
        String temp;    // 키보드 임시 입 저장

        // 정규식 패턴
        Pattern pattern = Pattern.compile("^(100|[1-9]?\\d)\\s[가-힣]+\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)$");    // 한글 및 공백과 0 이상 100 이하의 숫자로만 이루어진 "숫자 한글 숫자 숫자 숫자" 형태의 정규식

        // 학생 정보 입력
        for (int i = 0; i < score.length; i++) {
            temp = instance.inputScore(scanner);
            boolean flag = false;

            do {
                if (flag) {
                    temp = instance.inputScore(scanner);
                    flag = false;
                }
                Matcher matcher = pattern.matcher(temp);
                if (matcher.matches()) {    // 정규식 일치시 이름과 점수를 입력 후 do while 탈출
                    score[i] = new Score(Integer.parseInt(temp.split(" ")[0]), temp.split(" ")[1], Integer.parseInt(temp.split(" ")[2]), Integer.parseInt(temp.split(" ")[3]), Integer.parseInt(temp.split(" ")[4]));
                } else {    // 정규식 불일치시 do while 반복
                    flag = true;
                }
            } while (flag);

            if (i >= score.length - 1 || !instance.isContinueInput(scanner)) break;
        }   // for End

        scanner.close();

        instance.rank(score);   // 석차 계산

        instance.display(population, score);    // 결과 출력
    }


}
