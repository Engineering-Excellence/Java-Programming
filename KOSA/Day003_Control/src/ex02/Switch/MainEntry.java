package ex02.Switch;

import java.util.Scanner;

public class MainEntry {



///*
    public static void main(String[] args) {

        System.out.print("도시를 선택하세요(s, d, b, j): ");
        Scanner sc = new Scanner(System.in);

//        String str = "korea";
//        char ch = str.charAt(3);
//        System.out.println(ch);

        char ch = sc.next().charAt(0);  // 문자 입력 받기

        switch (ch) {
            case 's':
                System.out.print("서울"); break;
            case 'd':
                System.out.print("대구"); break;
            case 'b':
                System.out.print("부산"); break;
            case 'j':
                System.out.print("제주"); break;
            default:
                System.out.print("잘못 입력하셨습니다. s, d, b, j 중에서 선택하세요.");
                System.exit(0); // 프로그램 강제 종
        }   // end switch
        System.out.println("을(를) 선택하셨습니다.");
    }
//*/

/*
    public static void main(String[] args) {

        System.out.print("Point: ");
        double point = new Scanner(System.in).nextDouble();

        switch ((int) point) {    // long을 제외한 정수, 문자, 문자열만 가능

            case 1:     // 값 - 숫자, '문자', "문자열"
                System.out.println("포인트 점수 1점입니다.");
                break;

            case 2:
                System.out.println("포인트 점수 2점입니다.");
                break;

            case 3:
                System.out.println("포인트 점수 3점입니다.");
                break;

            default:
                System.out.println("존재하지 않는 포인트입니다. 1 ~ 3 중에서 선택하세요.");
        }
    }
//*/
}
