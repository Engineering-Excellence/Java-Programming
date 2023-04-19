package ex06.string;

public class StringMain {

    public static void main(String[] args) {

        int x = 3, y = 5;
        System.out.printf("x = %d, y = %d%n", x, y);
        x = y;
        System.out.printf("x = %d, y = %d%n", x, y);

        System.out.println("-".repeat(60));

        String str1 = "korea";
        String str2 = "happy";
        System.out.printf("str1 = %s, str2 = %s%n", str1, str2);
        System.out.printf("str1.hashCode() = %s%nstr2.hashCode() = %s%n", str1.hashCode(), str2.hashCode());

        System.out.println("-".repeat(60));

        str1 = str2;    // 같은 주소
        System.out.printf("str1 = %s, str2 = %s%n", str1, str2);
        System.out.printf("str1.hashCode() = %s%nstr2.hashCode() = %s%n", str1.hashCode(), str2.hashCode());

        System.out.println("-".repeat(60));

        str2 = "seoul"; // str2 새로운 객체 생성
        System.out.printf("str1 = %s, str2 = %s%n", str1, str2);
        System.out.printf("str1.hashCode() = %s%nstr2.hashCode() = %s%n", str1.hashCode(), str2.hashCode());

        System.out.println("-".repeat(60));

        str2 = "korea"; // 기존에 "korea" 값을 가지는 주소가 존재
        System.out.printf("str1 = %s, str2 = %s%n", str1, str2);
        System.out.printf("str1.hashCode() = %s%nstr2.hashCode() = %s%n", str1.hashCode(), str2.hashCode());

        System.out.println("-".repeat(60));

        String str3 = "korea"; // 기존에 "korea" 값을 가지는 주소가 존재
        System.out.printf("str2 = %s, str3 = %s%n", str1, str2);
        System.out.printf("str2.hashCode() = %s%nstr3.hashCode() = %s%n", str2.hashCode(), str3.hashCode());

        System.out.println("-".repeat(60));

        str3 = "Kyle";  // str3 새로운 객체 생성
        System.out.printf("str2.hashCode() = %s%nstr3.hashCode() = %s%n", str2.hashCode(), str3.hashCode());

        System.out.println("-".repeat(60));

        str1 = "Kyle";  // 기존에 "Kyle" 값을 가지는 주소가 존재
        System.out.printf("str1.hashCode() = %s%nstr3.hashCode() = %s%n", str1.hashCode(), str3.hashCode());
    }
}
