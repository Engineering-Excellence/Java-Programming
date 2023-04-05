package quiz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 성적 처리 배열, 석차 정렬 이용하기

class Score_Class {

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
    public Score_Class(int stuNum, String name, int kor, int eng, int math) {
        this.stuNum = stuNum;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.tot = kor + eng + math;
        this.avg = this.tot / 3.;
        this.setGrade();
    }

    // Getter & Setter
    public String getName() {
        return name;
    }
    public int getStuNum() {
        return stuNum;
    }
    public int getKor() {
        return kor;
    }
    public int getEng() {
        return eng;
    }
    public int getMath() {
        return math;
    }
    public int getTot() {
        return tot;
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

public class ScoreArray_Class {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요.: ");
        int num = scanner.nextInt(); // 학생 수
        scanner.nextLine(); // 키보드 버퍼 제거

        Score_Class[] student = new Score_Class[num];
        String temp;    // 키보드 임시 입력 저장

        // 정규식 패턴
        Pattern pattern = Pattern.compile("^(100|[1-9]?\\d)\\s[가-힣]+\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)\\s(100|[1-9]?\\d)$");    // 한글 및 공백과 0 이상 100 이하의 숫자로만 이루어진 "숫자 한글 숫자 숫자 숫자" 형태의 정규식

        // 학생 정보 입력
        for (int i = 0; i < student.length; i++) {
            System.out.printf("'학번 이름 국어 영어 수학' 순서로 입력하세요(%d/%d).: ", i + 1, num);
            temp = scanner.nextLine().trim();
            boolean flag = false;

            do {
                if (flag) {
                    System.out.printf("한글 이름과 점수의 범위를 확인하신 후, '학번 이름 국어 영어 수학' 순서로 입력하세요(%d/%d).: ", i + 1, num);
                    temp = scanner.nextLine().trim();
                    flag = false;
                }
                Matcher matcher = pattern.matcher(temp);
                if (matcher.matches()) {    // 정규식 일치시 이름과 점수를 입력 후 do while 탈출
                    student[i] = new Score_Class(Integer.parseInt(temp.split(" ")[0]), temp.split(" ")[1], Integer.parseInt(temp.split(" ")[2]), Integer.parseInt(temp.split(" ")[3]), Integer.parseInt(temp.split(" ")[4]));
                } else {    // 정규식 불일치시 do while 반복
                    flag = true;
                }
            } while (flag);

            System.out.print("계속 입력하시겠습니까?(y/n): ");
            String ans = scanner.next();
            if (ans.equalsIgnoreCase("n")) break;
            scanner.nextLine();
        }   // for End

        scanner.close();

        // 석차 계산
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (student[i].getTot() > student[j].getTot()) {
                    student[j].setRank(student[j].getRank() + 1);   // 점수가 낮은 사람의 석차를 1 증가
                }
            }
        }

        // 결과 출력
        System.out.println("\n학번\t이름\t국어\t영어\t수학\t총점\t평균\t\t학점\t석차\n========================================================================");
        for (Score_Class scoreClass : student) {
            if (scoreClass != null) {
                System.out.printf("%2d번\t%-3s\t%3d점\t%3d점\t%3d점\t%3d점\t%6.2f점\t%2c\t\t%d/%d%n", scoreClass.getStuNum(), scoreClass.getName(), scoreClass.getKor(), scoreClass.getEng(), scoreClass.getMath(), scoreClass.getTot(), scoreClass.getAvg(), scoreClass.getGrade(), scoreClass.getRank(), num);
            } else {
                break;  // 입력한 부분까지 출력 후 반복 탈출
            }
        }
    }
}
