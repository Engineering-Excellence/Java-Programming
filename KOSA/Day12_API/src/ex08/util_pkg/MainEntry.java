package ex08.util_pkg;

import java.util.Calendar;
import java.util.Date;

public class MainEntry {

    public static void main(String[] args) {

//        Calendar calendar = new Calendar();   // 객체 생성 불가
        Calendar calendar = Calendar.getInstance(); // system의 날짜를 얻어옴
//        System.out.println(calendar);

        System.out.print(calendar.get(Calendar.YEAR) + "년");
        System.out.print(calendar.get(Calendar.MONTH) + 1 + "월");   // 0월부터 시작
        System.out.println(calendar.get(Calendar.DATE) + "일");

        System.out.println("=".repeat(60));

        Date date = new Date();
        int hour = date.getHours();
        int min = date.getMinutes();
        int sec = date.getSeconds();
        System.out.printf("현재시각 %02d:%02d:%02d%n", hour, min, sec);

        System.out.println("=".repeat(60));

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

//        c2.set(2018, 11, 20, 0, 0);
        c2.set(2020, Calendar.DECEMBER, 20, 0, 0);

        if (c1.after(c2)) {
            System.out.println("현재 시각은 2018년 1월 1일 이후입니다.");
        } else if (c1.before(c2)) {
            System.out.println("현재 시각은 2018년 1월 1일 이전입니다.");
        } else if (c1.equals(c2)) {
            System.out.println("현재 시각은 2018년 1월 1일입니다.");
        }
    }
}
