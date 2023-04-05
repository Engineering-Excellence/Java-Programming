package ex02.method;

public class MainEntry {

    public static void main(String[] args) {

        if (args.length < 3) {
            System.err.println("using error");
            return; // 제어권 넘김
        }

        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);

        String s1 = args[0];
        String s2 = args[1];
//        int num1 = Integer.parseInt(s1);
//        int num2 = Integer.parseInt(s2);
//        String s1 = args[2];
        System.out.println("==========================================================================================");
        System.out.printf("%s, %s%n", s1, s2);
        System.out.printf("%d + %d = %d%n", Integer.parseInt(s1), Integer.parseInt(s2), Integer.parseInt(s1) + Integer.parseInt(s2));
    }
}
