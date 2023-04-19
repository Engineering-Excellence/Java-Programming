package ex04.For;

public class ForEx2 {

    public static void main(String[] args) {

        int a = 1, b = 1;

        /*for (; a < 4; ) {   // 초기값, 증감식 생략가능 (단, 조건식 생략시 무한루프)
            System.out.println(a);
            a++;
        }*/

        /*for (; ; ) {  // 무한 루프
            System.out.println(a);
            a++;

            // 탈출 구문
            if (a > 100) break;
        }*/

        for (a = 1, b = 5; ; a++, b += 2) {    // 초기값, 증감식 2개 이상 가능 (단, 조건식은 오직 1개)
//            System.out.println(a);
            System.out.println(b);

            // 탈출 구문
            if (a >= 10) break;
        }
    }
}
