package ex02.list;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

// List: 순서 O, 중복 O
public class VectorEx2 {

    public static void main(String[] args) {

        int i;
        Date date = new Date();
        Vector<Object> vector = new Vector<>(3, 5);


        System.out.println("-".repeat(30) + " 3개 객체 추가 " + "-".repeat(30));
        vector.addElement("자바");    // String
        vector.addElement(new Double(10.2));    // Double
        vector.addElement(date);    // Object(Date)
        System.out.println("size: " + vector.size() + ", capacity: " + vector.capacity());

        System.out.println("-".repeat(30) + " 10개 객체 추가 " + "-".repeat(30));
        for (i = 0; i < 10; i++) {
            vector.addElement(new Integer(i));
        }
        System.out.println("size: " + vector.size() + ", capacity: " + vector.capacity());

        System.out.println("-".repeat(30) + " Vector 내용 출력 " + "-".repeat(30));
        Enumeration<Object> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();

        System.out.println("-".repeat(30) + " 객체 내용 포함 확인 " + "-".repeat(30));
        if (vector.contains("자바1")) {
            System.out.println("\"자바\" 문자열 포함");
        } else {
            System.out.println("\"자바\" 문자열 미포함");
        }
        System.out.println("10.2 객체의 위치는? " + vector.indexOf(new Double(10.2)));
        System.out.println("입력 시간: " + date);
        System.out.println(vector.get(vector.indexOf(date)));

        // date 객체 삭제
        vector.removeElementAt(vector.lastIndexOf(date));
        System.out.println("*".repeat(60));
        System.out.println("size: " + vector.size() + ", capacity: " + vector.capacity());
        System.out.println(vector);

        for (i = 0; i < vector.size(); i++) {
//            vector.removeElementAt(i);  // Vector는 가변 길이 배열 -> 지워질 때마다 인덱스가 앞으로 당겨짐!!!
//            vector.remove(0);   // index로 삭제
            vector.remove(10.2);    // 객체명으로 삭제
            vector.remove("자바");
//            vector.removeAllElements(); // 모두 삭제
        }
        System.out.println("*".repeat(60));

        System.out.println("size: " + vector.size() + ", capacity: " + vector.capacity());
        System.out.println(vector);

        for (i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + " ");
        }
        System.out.println();

        System.out.println("*".repeat(60));

        vector.setElementAt("java", 2); // (2 + 1)번째 위치에 "java" 문자열 추가

        enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();

        System.out.println("*".repeat(60));

        System.out.println("size: " + vector.size() + ", capacity: " + vector.capacity());
        vector.trimToSize();    // 크기 조절
        System.out.println("size: " + vector.size() + ", capacity: " + vector.capacity());

        System.out.println("*".repeat(60));

        vector.setSize(2);  // 크기 강제 조절
        enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();
        System.out.println("size: " + vector.size() + ", capacity: " + vector.capacity());
    }
}
