package ex06.string;

public class MainEntry {

    public static void main(String[] args) {

        int x = 999;
        String str = "abc";
        System.out.printf("str = %s%n", str);

        char[] data = {'a', 'b', 'c'};
        str = new String(data);
        System.out.printf("str = %s%n", str);
        System.out.println("kbs");

        String msg = "cdefghij";
        System.out.println("Korea " + msg); // Korea cdefghij
        System.out.println(msg);    // cdefghij

        // 문자열 결합
        msg = msg.concat(" Korea");
        System.out.println(msg);    // cdefghij Korea

        // 문자열 추출
        String str2 = "abcdef".substring(2);    // 시작 인덱스부터 끝까지 포함
        System.out.println(str2);   // cdef

        str2 = "abcdefghi1234567890jklmnop".substring(2, 5);    // 시작 인덱스 포함, 끝 인덱스 미포함
        System.out.println(str2);   // cde
    }
}
