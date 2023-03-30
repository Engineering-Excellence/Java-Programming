package quiz;


import java.util.Scanner;

// 월을 입력받아서 해당 월의 일수를 출력
public class Quiz_Day {

    public static void main(String[] args) {

        System.out.print("월을 입력하세요.: ");
        int month = new Scanner(System.in).nextInt();
        int day = 0;

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> day = 31;
            case 2 -> {
                System.out.print("연도를 입력하세요.: ");
                int year = new Scanner(System.in).nextInt();
                day = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;    // 윤년이면 29일, 평년이면 28일
                System.out.printf("%d년 %d월의 마지막 날은 %d일입니다.%n", year, month, day);
                System.exit(0);
            }
            case 4, 6, 9, 11 -> day = 30;
            default -> {    // 1 ~ 12월이 아닌 값을 입력했을 경우 예외 처리
                System.out.println("잘못 입력하셨습니다. 1 ~ 12월 중에서 입력해주세요.");
                System.exit(1);
            }
        }
        System.out.printf("%d월의 마지막 날은 %d일입니다.", month, day);
    }
}
