package ex05.While;

public class DoWhileMain {

    public static void main(String[] args) {

        int a = 1, b = 1;
        do {
            b = 1;  // 다중 while, do~while 문에서는 내부 변수 초기화 필요
            do {
                System.out.print(b + "\t");
                b++;    // 증감식
            } while (b <= 3);   //조건
//            b = 1;  // 변수 초기화
            a++;    // 증감식
            System.out.println();
        } while (a <= 2);   // 문장 종결 필수
    }
}
