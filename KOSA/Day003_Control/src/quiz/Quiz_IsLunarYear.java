package quiz;

import java.util.Scanner;

// 윤년/평년 판정 프로그램
public class Quiz_IsLunarYear {

    public static void main(String[] args) {

        System.out.print("연도를 입력하세요.: ");
        int year = new Scanner(System.in).nextInt();

        System.out.printf("%d년은 %s입니다.%n", year, year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "윤년" : "평년");
    }
}
