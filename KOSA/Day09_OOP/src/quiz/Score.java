package quiz;

import java.util.Scanner;

public class Score /*implements Comparable<Score> */ {

    // Singleton Pattern
    public static final Score instance = new Score();

    // Field
    private String name;  // 이름
    private int stdNum;   // 학번
    private int kor;  // 국어
    private int eng;  // 영어
    private int math; // 수학
    private int tot;  // 총점
    private int rank = 1; // 석차
    private double avg; // 평균
    private char grade; // 학점

    // Constructor
    public Score() {
    }

    public Score(int stdNum, String name, int kor, int eng, int math) {
        this.stdNum = stdNum;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.setTot(kor, eng, math);
        this.setAvg();
        this.setGrade();
    }

    // Getter & Setter
    public static synchronized Score getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStdNum() {
        return stdNum;
    }

    public void setStdNum(int stdNum) {
        this.stdNum = stdNum;
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

    public void setTot(int kor, int eng, int math) {
        this.tot = kor + eng + math;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg() {
        this.avg = (double) this.tot / 3;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade() {
        this.grade = switch ((int) this.getAvg() / 10) { // 학점 계산
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };
    }

    /*@Override
    public int compareTo(Score s) {
        return -Double.compare(this.getAvg(), s.getAvg());
    }*/

    // 학생 수 입력
    public int inputPopulation(Scanner scanner) {
        System.out.print("학생 수를 입력하세요.: ");
        int population = scanner.nextInt(); // 학생 수
        scanner.nextLine(); // 키보드 버퍼 제거
        return population;
    }

    // 성적 입력
    public String inputScore(Scanner scanner) {
        System.out.print("'학번 이름 국어 영어 수학' 순서로 입력하세요.: ");
        return scanner.nextLine().trim();
    }

    // 입력 여부 확인
    public boolean isContinueInput(Scanner scanner) {
        System.out.print("계속 입력하시겠습니까?(y/n): ");
        String ans = scanner.next();
        if (ans.equalsIgnoreCase("n")) {
            return false;
        }
        scanner.nextLine();
        return true;
    }

    // 석차 계산
    public void rank(Score[] score) {
        for (Score o : score) {
            for (Score i : score) {
                if (o.getTot() > i.getTot()) {
                    i.setRank(i.getRank() + 1);   // 점수가 낮은 사람의 석차를 1 증가
                }
            }
        }
    }

    // 결과 출력
    public void display(int population, Score[] score) {
        System.out.println("\n학번\t이름\t국어\t영어\t수학\t총점\t평균\t\t학점\t석차\n========================================================================");
        for (Score s : score) {
            if (s != null) {
                System.out.printf("%2d번\t%-3s\t%3d점\t%3d점\t%3d점\t%3d점\t%6.2f점\t%2c\t\t%d/%d%n", s.getStdNum(), s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getTot(), s.getAvg(), s.getGrade(), s.getRank(), population);
            } else {
                break;  // 입력한 부분까지 출력 후 반복 탈출
            }
        }
    }
}
