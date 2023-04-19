package ex02.default_constructor;

public class MainEntry {

    // 한줄 주석
    /* 여러 줄 주석 */

    /**
     *
     * @author Kyle
     * @param args 메인 메서드는 아무 값도 넘겨받지 않는다.
     * @param x 곱을 구하는 첫번째 정수형 변수
     * @param y 곱을 구하는 두번째 정수형 변수
     * @param gob x와 y의 곱셈 결과를 저장하는 변수
     */

    public static void main(String[] args) {

        int x, y, gob = 1;
        char ch = 'A';
        String msg;

        x = 5; y = 10;
        msg = "Daebo 2th";

        gob = gob(x, y);

        System.out.println(ch);
        System.out.println(msg);
        System.out.printf("%d * %d = %d%n", x, y, gob);
    }

    public static int gob(int x, int y) {
        return x * y;
    }
}
