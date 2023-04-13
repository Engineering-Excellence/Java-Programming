package ex02.list;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

// List: 순서 O, 중복 O
public class VectorEx1 {

    public static void main(String[] args) {

        Vector<Integer> vector1 = new Vector<>();

        System.out.println("length\t/\tcapacity");
        System.out.println("-".repeat(60));
        System.out.println(vector1.size() + "\t\t/\t" + vector1.capacity());

        System.out.println("-".repeat(60));

        Vector<Integer> vector2 = new Vector<>(3, 4);   // 초기용량, 증가용량
        System.out.println(vector2.size() + "\t\t/\t" + vector2.capacity());
        vector2.add(2);
        vector2.add(21);
        vector2.add(22);
        System.out.println(vector2.size() + "\t\t/\t" + vector2.capacity());
        vector2.add(100);
        System.out.println(vector2.size() + "\t\t/\t" + vector2.capacity());
        vector2.add(5);
        vector2.add(89);
        vector2.add(3);
        System.out.println(vector2.size() + "\t\t/\t" + vector2.capacity());
        vector2.add(333);
        System.out.println(vector2.size() + "\t\t/\t" + vector2.capacity());
        vector2.add(3);
        vector2.add(21);
        vector2.add(100);
        vector2.add(100);

        System.out.println(vector2.size() + "\t\t/\t" + vector2.capacity());

        System.out.println(vector2);

        System.out.println("-".repeat(30) + "iterator()" + "-".repeat(30));

        Iterator iterator = vector2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-".repeat(30) + "get()" + "-".repeat(30));

        for (int i = 0; i < vector2.size(); i++) {
            System.out.println(vector2.get(i));
        }

        System.out.println("-".repeat(30) + "sort()" + "-".repeat(30));

        Collections.sort(vector2);  // 요소 순서대로 정렬
        for (Integer i : vector2) {
            System.out.println(i);
        }

        System.out.println("-".repeat(30) + "elementAt()" + "-".repeat(30));

        for (int i = 0; i < vector2.size(); i++) {
            Integer num = vector2.elementAt(i); // 요소 객체 알아내기
            System.out.println(num.toString());
        }

        System.out.println("-".repeat(30) + "trimToSize()" + "-".repeat(30));

        System.out.println(vector2.size() + "\t\t/\t" + vector2.capacity());
        vector2.trimToSize();   // capacity 조정
        System.out.println(vector2.size() + "\t\t/\t" + vector2.capacity());
    }
}
