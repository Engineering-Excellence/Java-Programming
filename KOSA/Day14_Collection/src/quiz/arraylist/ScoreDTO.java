package quiz.arraylist;

// Model
public class ScoreDTO implements Comparable<ScoreDTO> {

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
        calScore();
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
        calScore();
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
        calScore();
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
        calScore();
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

    private void calScore() {
        setTot(kor, eng, math);
        setAvg();
        setGrade();
    }

    @Override
    public int compareTo(ScoreDTO s) {
        return -Double.compare(this.getAvg(), s.getAvg());
    }

    @Override
    public String toString() {
        return String.format("%2d번\t%-3s\t%3d점\t%3d점\t%3d점\t%3d점\t%6.2f점\t%2c\t\t%d", stdNum, name, kor, eng, math, tot, avg, grade, rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreDTO scoreDTO = (ScoreDTO) o;

        if (stdNum != scoreDTO.stdNum) return false;
        if (kor != scoreDTO.kor) return false;
        if (eng != scoreDTO.eng) return false;
        if (math != scoreDTO.math) return false;
        if (tot != scoreDTO.tot) return false;
        if (Double.compare(scoreDTO.avg, avg) != 0) return false;
        if (grade != scoreDTO.grade) return false;
        if (rank != scoreDTO.rank) return false;
        return name.equals(scoreDTO.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + stdNum;
        result = 31 * result + kor;
        result = 31 * result + eng;
        result = 31 * result + math;
        result = 31 * result + tot;
        temp = Double.doubleToLongBits(avg);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) grade;
        result = 31 * result + rank;
        return result;
    }
}
