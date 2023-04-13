package ex01.set;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class HashSetEx {

    public static void main(String[] args) {

        Object[] objArr = {"1", new Integer(1), "2", "3", "3", "4", "4", "4"};  // 자료형이 다르면 다른 데이터

        Set<Object> set = new HashSet<>();

        /*for (int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]);
        }*/

        IntStream.range(0, objArr.length).forEach(i -> set.add(objArr[i]));

        System.out.println(set);
    }
}
