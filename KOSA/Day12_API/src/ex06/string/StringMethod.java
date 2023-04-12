package ex06.string;

import java.util.Arrays;

public class StringMethod {

    public static void main(String[] args) {

        String s1 = "kyle";
        String s2 = "SEOUL";

        System.out.printf("s1 = %s%n", s1);
        System.out.printf("s2 = %s%n", s2);
        System.out.printf("s2.replace(\"EO\", \"korea\") = %s%n", s2.replace("EO", "korea"));
        System.out.printf("s2 = %s%n", s2);
        s2 = s2.replace("EO", "korea");
        System.out.printf("s2 = %s%n", s2);

        System.out.println("=".repeat(40));

        s1 = s1 + s2;
//        s1 = s1.concat(s2);   // 문자열 결합
        System.out.printf("s1 = %s%n", s1);

        System.out.println("=".repeat(40));

        String s3 = new String("    ab    cd    ");
        System.out.printf("s3 = %s%n", s3);
        System.out.printf("s3.length() = %d%n", s3.length());   // 문자열 길이
        s3 = s3.trim(); // 양 옆 공백 제거
        System.out.printf("s3 = %s%n", s3);
        System.out.printf("s3.length() = %d%n", s3.length());

        System.out.println("=".repeat(40));

//        String s4 = new String("ab cdefg 123456 hijklmnop 7890");
        String s4 = new String("ab/cdefg/123456/hijklmnop/7890");
//        String[] s5 = s4.split(" ");  // 기본 구분자 공백
        String[] s5 = s4.split("/");
        System.out.println(Arrays.toString(s5));
        for (int i = 0; i < s5.length; i++) {
            System.out.printf("분리된 %d번째 문자열: %s%n", i, s5[i]);
        }

        System.out.println("=".repeat(40));

        String s6 = "123-4567-8900";
        String[] s7 = s6.split("-");
        System.out.println(Arrays.toString(s7));

        System.out.println("=".repeat(40));

        String s8 = "123235870 asfasfhkasf 2487189 142857 string";
        char ch = s8.charAt(10);
        System.out.println(ch);

        s8 = s8.substring(5, 7);
        System.out.println(s8);

        System.out.println("=".repeat(40));

        System.out.printf("s1 = %s%n", s1);
        System.out.printf("대문자로 출력: %s%n", s1.toUpperCase());
        System.out.printf("s2 = %s%n", s2);
        System.out.printf("소문자로 출력: %s%n", s2.toLowerCase());

        char[] ch2 = s1.toCharArray();
        System.out.printf("ch2 = %s%n", Arrays.toString(ch2));
    }
}
