package com.tjoeun.collectionTest;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {

//		TreeSet은 중복되는 데이터 입력을 허용하지 않는다.
//		데이터를 입력하는 순서와 입력된 데이터가 실제로 저장되는 순서가 달라서 get(), set()
//		메소드가 제공되지 않는다.
//		TreeSet은 HashSet과 다르게 입력되는 순서와 관계없이 오름차순으로 정렬되서 저장된다.

        Set<Integer> tset = new TreeSet<>();

//		add(value) 메소드는 TreeSet에 value를 저장한다.
        tset.add(500);
//		size() 메소드는 TreeSet에 저장된 데이터 개수를 얻어온다.
        System.out.println(tset.size() + ": " + tset);
        tset.add(100);
        System.out.println(tset.size() + ": " + tset);
        tset.add(999);
        System.out.println(tset.size() + ": " + tset);
        tset.add(50);
        System.out.println(tset.size() + ": " + tset);
        tset.add(100); // 중복되는 데이터는 저장되지 않는다.
        System.out.println(tset.size() + ": " + tset);

//		remove(value) 메소드는 TreeSet에 저장된 value를 제거한다.
        tset.remove(500);
        System.out.println(tset.size() + ": " + tset);

//		clear() 메소드는 TreeSet에 저장된 모든 데이터를 제거한다.
        tset.clear();
        System.out.println(tset.size() + ": " + tset);
        System.out.println("=======================");

//		로또 1등 번호
        Random random = new Random();

        do {
            int lotto = random.nextInt(45) + 1;
            System.out.println(lotto);
            tset.add(lotto);
//			TreeSet 객체에 중복되지 않는 숫자 6개가 저장되면 무한루프 탈출한다.
        } while (tset.size() != 6);
        System.out.println("1등 번호: " + tset);

//		보너스 번호
        int bonus = 0;
        do {
            bonus = random.nextInt(45) + 1;
            System.out.println(bonus);
            tset.add(bonus);
        } while (tset.size() != 7);
        tset.remove(bonus);
        System.out.println("1등 번호: " + tset + ", 보너스: " + bonus);
        System.out.println("=======================");

        do {
            bonus = random.nextInt(45) + 1;
            System.out.println(bonus);
//			contains() 메소드는 TreeSet 객체에 인수로 지정된 데이터가 포함되어있으면 true,
//			그렇치 않으면 false를 리턴한다.
//			if (tset.contains(bonus) == false) {
        } while (tset.contains(bonus));
        System.out.println("1등 번호: " + tset + ", 보너스: " + bonus);
    }
}
