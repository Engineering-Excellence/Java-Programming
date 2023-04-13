package ex01.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

// Set: 순서 X, 중복 X
public class MainEntry {

    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<String>();

        hs.add("키보드");
        hs.add("마우스");
        hs.add("컵");
        hs.add("볼펜");
        hs.add("키보드");  // 중복 X

        System.out.println("요소 개수: " + hs.size());
        System.out.println(hs); // 순서 X

//        HashSet<int> hs2 = new HashSet<>(int);    // Generic은 참조 자료형만 가능
        HashSet<Integer> hs2 = new HashSet<>();
        hs2.add(100);
        hs2.add(3);
        hs2.add(1000);
//        hs2.add("String");    // 자료형 제한

        HashSet<Object> hs3 = new HashSet<>();
        hs3.add(100);
        hs3.add(3);
        hs3.add(1000);
        hs3.add("String");

        System.out.println("=".repeat(40));

        Iterator itr = hs.iterator();
        while (itr.hasNext()) {  // 다음 요소가 있다면
            System.out.println(itr.next());  // 요소를 꺼내와서 출력
        }

        System.out.println("=".repeat(40));

        itr = hs3.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("=".repeat(40));

        hs3.forEach(System.out::println);
    }
}
