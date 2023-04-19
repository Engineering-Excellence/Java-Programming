package ex02.datatype;

public class DataType {

    public static void main(String[] args) {

        String str = "A";   // 문자열: " "을 사용, 2byte
        char ch = 'A';      // 문자: ' ' 내부에 기재, 1byte
        char ch2 = 67;
        char ch3 = 'b';
        int su = 20; String nickname = "prophet"; double d = 12.34;

        System.out.println(ch); // A
        System.out.println(str);    // A
        System.out.println((int) ch);   // ASCII 65
        System.out.println(ch2 + ch3);  // 67 + 'b' = 67 + 98 = 165
        System.out.println("nickname = " + nickname);
        System.out.println("실수형 데이터: " + d);

        for (int i = 65; i <= 90; i++) {

            System.out.print((char) i + "\t");
        }   // end for

        System.out.println("\n========================================================================================================");

        for (int i = 'a'; i <= 'z'; i++) {

            System.out.print((char) i + "\t");
        }   // end for

        System.out.println("\n\nboolean type");
        boolean flag = true;
//        int b = flag;   // error
        System.out.println(flag);
    }
}
