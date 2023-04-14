package ex03.map;

import java.util.*;

public class HashMapEx2 {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("재진", new Integer(90));
        hashMap.put("승현", new Integer(80));
        hashMap.put("승원", new Integer(30));
        hashMap.put("혁진", new Integer(50));
        hashMap.put("지연", new Integer(88));

        // entrySet()
        Set set = hashMap.entrySet();
        System.out.println(set);
        Iterator itr = set.iterator();

        while (itr.hasNext()) {
            Map.Entry e = (Map.Entry) itr.next();
            System.out.printf("Name: %s, Score: %d%n", e.getKey(), e.getValue());
        }

        set = hashMap.keySet();
        System.out.println("참가자 명단: " + set);

        Collection values = hashMap.values();
        itr = values.iterator();

        int tot = 0;
        while (itr.hasNext()) {
            Integer i = (Integer) itr.next();
            tot += i.intValue();
        }
        System.out.println("총점: " + tot);
        System.out.println("평균: " + (float) tot / set.size());
        System.out.println("최고점수: " + Collections.max(values));
        System.out.println("최저점수: " + Collections.min(values));
    }
}
