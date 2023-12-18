package com.tjoeun.collectionTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetTest2 {

    public static void main(String[] args) {

        Set<String> hset = new HashSet<>();

        hset.add("홍길동");
        System.out.println(hset.size() + ": " + hset);
        hset.add("임꺽정");
        System.out.println(hset.size() + ": " + hset);
        hset.add("장길산");
        System.out.println(hset.size() + ": " + hset);
        hset.add("일지매");
        System.out.println(hset.size() + ": " + hset);
        hset.add("홍길동");
        System.out.println(hset.size() + ": " + hset);
        System.out.println("========================");

        List<String> list = new ArrayList<>();
//		향상된 for 사용해서 HashSet이나 TreeSet 객체의 데이터를 1개씩 얻어올 수 있다.
        for (String str : hset) {
            list.add("향상된 for 사용 => " + str);
        }
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("========================");

//		Iterator 인터페이스 HashSet이나 TreeSet 같이 입력하는 순서와 저장되는 순서가 달라서
//		get(), set() 메소드를 사용할 수 없는 객체를 분리한다.
//		HashSet이나 TreeSet 객체에 iterator() 메소드를 실행하면 데이터 단위로 분리된다.

//		hasNext() 메소드는 Iterator 인터페이스 객체에 다음에 읽을 데이터가 있으면 true, 없으면
//		false를 리턴한다.
        for (String s : hset) { // Iterator 인터페이스 객체에 데이터가 있는 동안 반복한다.
//			next() 메소드는 Iterator 인터페이스 객체의 다음 데이터를 얻어온다.
//			System.out.println(iterator.next());
            list.add("Iterator 인터페이스 객체 사용 => " + s);
        }
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("========================");

        hset.remove("장길산");
        System.out.println(hset.size() + ": " + hset);

        hset.clear();
        System.out.println(hset.size() + ": " + hset);
    }
}
