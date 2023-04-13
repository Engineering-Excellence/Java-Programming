package ex02.list;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx {

    public static void main(String[] args) {

        ArrayList arrayList1 = new ArrayList<>();
        arrayList1.add(new Integer(5));
        arrayList1.add(new Integer(4));
        arrayList1.add(new Integer(2));
        arrayList1.add(new Integer(0));
        arrayList1.add(new Integer(1));
        arrayList1.add(new Integer(3));

        ArrayList arrayList2 = new ArrayList<>(arrayList1.subList(1, 4));
        print(arrayList1, arrayList2);
//        arrayList2.add(33);

        Collections.sort(arrayList1);
        Collections.sort(arrayList2);
        print(arrayList1, arrayList2);

        System.out.println("arrayList1.containsAll(arrayList2): " + arrayList1.containsAll(arrayList2));    // 요소를 모두 포함하면 true

        for (int i = arrayList2.size() - 1; i >= 0; i--) {
            if (arrayList1.contains(arrayList2.get(i))) {
                arrayList2.remove(i);
            }
        }
        print(arrayList1, arrayList2);
    }

    private static void print(ArrayList arrayList1, ArrayList arrayList2) {
        System.out.println("arrayList1: " + arrayList1);
        System.out.println("arrayList2: " + arrayList2);
        System.out.println();
    }
}
