package quiz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 성적 처리 배열, 석차 정렬 이용하기

// 싱글톤 패턴
class SCORE3 {

    // Field
    private String name;    // 이름
    private int stuNum, kor, eng, math, tot, rank; // 학번, 국어, 영어, 수학, 총점, 석차
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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

    public void setGrade() {
        this.grade = switch ((int) this.getAvg() / 10) { // 학점 계산
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };
    }
}

public class ScoreArrayRegEx {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요.: ");
        int num = scanner.nextInt(); // 학생 수
        scanner.nextLine(); // 키보드 버퍼 제거

        SCORE3[] student = new SCORE3[num];
        String temp;    // 키보드 임시 입력 저장

        // 정규식 패턴
        Pattern pattern = Pattern.compile("^(100|[1-9]?\\d)\\s[가-힣]+\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)$");    // 한글 및 공백과 0 이상 100 이하의 숫자로만 이루어진 "숫자 한글 숫자 숫자 숫자" 형태의 정규식

        for (int i = 0; i < student.length; i++) {
            System.out.printf("'학번 이름 국어 영어 수학' 순서로 입력하세요(%d/%d).: ", i + 1, num);
            temp = scanner.nextLine().trim();
            boolean flag = false;

            student[i] = new SCORE3();
            do {
                if (flag) {
                    System.out.printf("한글 이름과 점수의 범위를 확인하신 후, '학번 이름 국어 영어 수학' 순서로 입력하세요(%d/%d).: ", i + 1, num);
                    temp = scanner.nextLine().trim();
                    flag = false;
                }
                Matcher matcher = pattern.matcher(temp);
                if (matcher.matches()) {    // 정규식 일치시 이름과 점수를 입력 후 do while 탈출
                    student[i].setStuNum(Integer.parseInt(temp.split(" ")[0])); // 학번
                    student[i].setName(temp.split(" ")[1]);   // 이름
                    student[i].setKor(Integer.parseInt(temp.split(" ")[2])); // 국어 점수
                    student[i].setEng(Integer.parseInt(temp.split(" ")[3])); // 영어 점수
                    student[i].setMath(Integer.parseInt(temp.split(" ")[4])); // 수학 점수
                } else {    // 정규식 불일치시 do while 반복
                    flag = true;
                }
            } while (flag);

            student[i].setTot(student[i].getKor() + student[i].getEng() + student[i].getMath());  // 총점 계산
            student[i].setAvg(student[i].getTot() / 3.);  // 평균 계산
            student[i].setGrade();
            System.out.print("계속 입력하시겠습니까?(y/n): ");
            String ans = scanner.next();
            if (ans.equalsIgnoreCase("n")) break;
            scanner.nextLine();
        }   // for End

        scanner.close();

        // 석차 계산
        for (int i = 0; i < num; i++) {
            student[i].setRank(1);  // 모든 석차를 1로 초기화
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (student[i].getTot() > student[j].getTot()) {    // 점수가 낮은 사람의 석차를 1 증가
                    student[j].setRank(student[j].getRank() + 1);
                }
            }
        }

        System.out.println("\n학번\t이름\t국어\t영어\t수학\t총점\t평균\t\t학점\t석차\n========================================================================");
        for (SCORE3 score3 : student) { // 결과 출력
            if (score3 != null) {
                System.out.printf("%2d번\t%-3s\t%3d점\t%3d점\t%3d점\t%3d점\t%6.2f점\t%2c\t\t%d/%d%n", score3.getStuNum(), score3.getName(), score3.getKor(), score3.getEng(), score3.getMath(), score3.getTot(), score3.getAvg(), score3.getGrade(), score3.getRank(), num);
            }
        }
    }
}
