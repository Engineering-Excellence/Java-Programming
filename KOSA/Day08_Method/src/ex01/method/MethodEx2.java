package ex01.method;

public class MethodEx2 {

    public static void main(String[] args) {

        String str = name(10, "Kyle");
        System.out.println(str);
        System.out.printf("name() call: %s%n",name(99, "Anonymous"));

        System.out.println("==========================================================================================");

        System.out.println(display(10, "&"));
        String star = display(20, "*");
        System.out.println(star);
    }

    // 4) 매개변수 있고, 리턴타입 있는 경우
    static String name(int x, String name) {

        System.out.printf("x = %d%n", x);
        return name;
    }

    static String display(int x, String name) {

        for (int i = 0; i < x; i++) {
            System.out.printf("%s\t", name);
        }
        return name;
    }
}
