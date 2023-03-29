package quiz;

import java.util.Scanner;

public class Quiz_If2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("국어, 영어, 전산 점수를 순서대로 입력하세요.: ");
        int kor = scanner.nextInt();
        int eng = scanner.nextInt();
        int com = scanner.nextInt();
        double avg = (kor + eng + com) / 3.;
        scanner.close();

        if (kor < 40 || eng < 40 || com < 40) {
            System.out.print("불합격(과락)입니다.\n과락 과목: ");
            if (kor < 40) {
                System.out.print("국어 ");
            } if (eng < 40) {
                System.out.print("영어 ");
            } if (com < 40) {
                System.out.print("전산");
            }
            System.out.println();
        } else if (avg < 60) {
            System.out.println("불합격입니다.");
        } else {
            System.out.println("합격입니다.");
        }
        System.out.printf("국어: %3d점%n영어: %3d점%n전산: %3d점%n평균: %.1f점%n총점: %3d점%n", kor, eng, com, avg, kor + eng + com);
    }
}
