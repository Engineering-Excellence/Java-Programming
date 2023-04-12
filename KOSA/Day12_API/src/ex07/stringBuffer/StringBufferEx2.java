package ex07.stringBuffer;

public class StringBufferEx2 {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("This");
        System.out.println(sb);

        sb.append(" is pencil");    // 문자열 추가
        System.out.println(sb);

        System.out.println("=".repeat(40));
        sb.reverse();

        sb.insert(7, " my");    // 문자열 삽입
        System.out.println(sb);

        sb.replace(8, 10, "your");  // 문자열 변경(교체)
        System.out.println(sb);

        sb.delete(0, 5);
        System.out.println(sb.capacity());

        sb.setLength(5);
        System.out.println(sb);
        System.out.println(sb.capacity());

        sb.setLength(20);
        System.out.println(sb);
        System.out.println(sb.capacity());
    }
}
