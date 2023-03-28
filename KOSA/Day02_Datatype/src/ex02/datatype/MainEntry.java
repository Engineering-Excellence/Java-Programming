package ex02.datatype;

public class MainEntry {

    static int Num; // 전역 변수는 자동으로 초기화 된다.
    static String str;

    public static void main(String[] args) {    // 시작점(진입점)

        int y = 99;  // 지역 변수는 사용하기 전에 반드시 초기화해야 한다.
        System.out.println(y);

        System.out.println("static value: " + Num + ", " + str);

        int su = 30;
        System.out.println(su); // 4 byte
        System.out.println(100);    // 4 byte

        long num = 20;
        System.out.println(num);    // 8 byte
        System.out.println(1000L);   // long

        double d = 12.34;
        System.out.println(d);
        System.out.println(34.56);  // double(디폴트)
        System.out.println(12.34f); // float은 디폴트가 아니므로 f/F를 붙여야 표현 가능

        float f = 12.34f;   // 소수의 default 표현은 double이므로, float을 선언하려면 f/F를 반드시 붙여야 함.
        System.out.println(f);
    }   // end main
}   // class end
