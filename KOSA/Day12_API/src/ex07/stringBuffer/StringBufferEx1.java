package ex07.stringBuffer;

public class StringBufferEx1 {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();

        System.out.println("length\t/\tcapacity\thashCode");
        System.out.printf("%d\t\t/\t%d\t\t\t%d%n", sb.length(), sb.capacity(), sb.hashCode());

        sb.append("Daebo");
        System.out.printf("%d\t\t/\t%d\t\t\t%d%n", sb.length(), sb.capacity(), sb.hashCode());

        sb.append("HappyVirus");
        System.out.printf("%d\t\t/\t%d\t\t\t%d%n", sb.length(), sb.capacity(), sb.hashCode());

        sb.append("12345 67890");
        System.out.printf("%d\t\t/\t%d\t\t\t%d%n", sb.length(), sb.capacity(), sb.hashCode()); // null 문자 2개 포함(16 * 2 + 2)

        sb.append("12345 67890");
        System.out.printf("%d\t\t/\t%d\t\t\t%d%n", sb.length(), sb.capacity(), sb.hashCode()); // null 문자 4개 포함((32 + 2) * 2 + 2)

        sb.trimToSize();    // capacity를 문자열 크기로 조정
        System.out.printf("%d\t\t/\t%d\t\t\t%d%n", sb.length(), sb.capacity(), sb.hashCode());
    }
}
