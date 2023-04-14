package quiz.arraylist;

// Model
public class ScoreDTO {

    // Field
    private static int seq; // 시퀀스
    private String name;    // 이름
    private final int stdNum;     // 학번
    private int kor;    // 국어
    private int eng;    // 영어
    private int math;   // 수학
    private int tot;    // 총점
    private double avg;     // 평균
    private char grade;     // 학점
    private int rank;   // 석차

    // Constructor
    public ScoreDTO(String name, int kor, int eng, int math) {
        this.name = name;
        this.stdNum = ++seq;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        updateScore();
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStdNum() {
        return stdNum;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
        updateScore();
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
        updateScore();
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
        updateScore();
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int kor, int eng, int math) {
        this.tot = kor + eng + math;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void updateScore() {
        setTot(kor, eng, math);
        setAvg();
        setGrade();
    }
}
