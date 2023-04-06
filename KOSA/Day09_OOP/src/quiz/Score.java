package quiz;

class Score {

    // Field
    private String name;  // 이름
    private int stuNum;   // 학번
    private int kor;  // 국어
    private int eng;  // 영어
    private int math; // 수학
    private int tot;  // 총점
    private int rank = 1; // 석차
    private double avg; // 평균
    private char grade; // 학점

    // Constructor
    public Score(int stuNum, String name, int kor, int eng, int math) {
        this.stuNum = stuNum;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.setTot(kor, eng, math);
        this.setAvg();
        this.setGrade();
    }

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
        this.avg = tot / 3.;
    }

    public char getGrade() {
        return grade;
    }

    private void setGrade() {
        this.grade = switch ((int) this.getAvg() / 10) { // 학점 계산
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };
    }
}