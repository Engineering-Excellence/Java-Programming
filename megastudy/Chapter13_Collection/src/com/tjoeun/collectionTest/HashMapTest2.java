package com.tjoeun.collectionTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest2 {

    public static void main(String[] args) {

        Map<String, Integer> hmap = new HashMap<>();

        hmap.put("apple", 1000);
        System.out.println(hmap.size() + ": " + hmap);
        hmap.put("banana", 3500);
        System.out.println(hmap.size() + ": " + hmap);
        hmap.put("orange", 2000);
        System.out.println(hmap.size() + ": " + hmap);
        hmap.put("melon", 20000);
        System.out.println(hmap.size() + ": " + hmap);
        hmap.put("water melon", 15000);
        System.out.println(hmap.size() + ": " + hmap);

//		keySet() 메소드는 HashMap에 저장된 데이터의 key만 얻어온다.
        System.out.println(hmap.keySet());
//		values() 메소드는 HashMap에 저장된 데이터의 value만 얻어온다.
        System.out.println(hmap.values());

//		HashMap에 저장된 데이터의 key만 얻어와서 ArrayList에 저장하기
        List<String> keyList = new ArrayList<>(hmap.keySet());
        System.out.println(keyList);

//		HashMap에 저장된 데이터의 value만 얻어와서 ArrayList에 저장하기
        List<Integer> valueList = new ArrayList<>(hmap.values());
        System.out.println(valueList);

//		HashMap에 저장된 데이터의 key를 이용해서 value를 얻어와서 ArrayList에 저장하기
        List<Integer> valueList2 = new ArrayList<>();
        for (String key : hmap.keySet()) {
            valueList2.add(hmap.get(key));
        }
        System.out.println(valueList2);
    }
}
