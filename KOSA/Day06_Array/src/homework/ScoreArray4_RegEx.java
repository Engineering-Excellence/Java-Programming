package homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 7명의 성적 처리 배열 이용하기

class SCORE2 {

    // Field
    private String name;    // 이름
    private int stuNum, kor, eng, math, tot; // 학번, 국어, 영어, 수학, 총점
    private double avg; // 평균
    private char grade; // 학점

    // Getter & Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStuNum() {
        return stuNum;
    }
    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }
    public int getKor() {
        return kor;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public int getEng() {
        return eng;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public int getTot() {
        return tot;
    }
    public void setTot(int tot) {
        this.tot = tot;
    }
    public double getAvg() {
        return avg;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
    public char getGrade() {
        return grade;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }
}

public class ScoreArray4_RegEx {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요.: ");
        int num = scanner.nextInt(); // 학생 수
        scanner.nextLine(); // 키보드 버퍼 제거

        SCORE2[] student = new SCORE2[num];
        String temp;    // 키보드 임시 입력 저장
        Pattern pattern = Pattern.compile("^(100|[1-9]?\\d)\\s[가-힣]+\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)$");    // 한글 및 공백과 0 이상 100 이하의 숫자로만 이루어진 "한글 숫자 숫자 숫자" 형태의 정규식

        for (int i = 0; i < student.length; i++) {
            System.out.printf("'이름 국어 영어 수학' 순서로 입력하세요(%d/%d).: ", i + 1, num);
            temp = scanner.nextLine().trim();
            boolean flag = false;

            student[i] = new SCORE2();
            do {
                if (flag) {
                    System.out.printf("한글 이름과 점수의 범위를 확인하신 후, '번호 이름 국어 영어 수학' 순서로 입력하세요(%d/%d).: ", i + 1, num);
                    temp = scanner.nextLine().trim();
                    flag = false;
                }
                Matcher matcher = pattern.matcher(temp);
                if (matcher.matches()) {    // 정규식 일치시 이름과 점수를 입력 후 while 탈출
                    student[i].setStuNum(Integer.parseInt(temp.split(" ")[0])); // 학번
                    student[i].setName(temp.split(" ")[1]);   // 이름
                    student[i].setKor(Integer.parseInt(temp.split(" ")[2])); // 국어 점수
                    student[i].setEng(Integer.parseInt(temp.split(" ")[3])); // 영어 점수
                    student[i].setMath(Integer.parseInt(temp.split(" ")[4])); // 수학 점수
                } else {    // 정규식 불일치시 while 반복
                    flag = true;
                }
            } while (flag);

            student[i].setTot(student[i].getKor() + student[i].getEng() + student[i].getMath());  // 총점 계산
            student[i].setAvg(student[i].getTot() / 3.);  // 평균 계산
            student[i].setGrade(
                switch ((int) (student[i].getAvg() / 10)) { // 학점 계산
                    case 10, 9 -> 'A';
                    case 8 -> 'B';
                    case 7 -> 'C';
                    case 6 -> 'D';
                    default -> 'F';
                });
            System.out.print("계속 입력하시겠습니까?(y/n): ");
            String ans = scanner.next();
            if (ans.equalsIgnoreCase("n")) break;
            scanner.nextLine();
        }   // for End

        scanner.close();
        System.out.println("\n학번\t이름\t국어\t영어\t수학\t총점\t평균\t학점\n============================================================");
        for (SCORE2 score2 : student) { // 결과 출력
            if (score2 != null) {
                System.out.printf("%2d번\t%-3s\t%3d점\t%3d점\t%3d점\t%3d점\t%2.2f점\t%2c%n", score2.getStuNum(), score2.getName(), score2.getKor(), score2.getEng(), score2.getMath(), score2.getTot(), score2.getAvg(), score2.getGrade());
            }
        }
    }
}
