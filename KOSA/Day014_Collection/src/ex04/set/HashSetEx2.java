package ex04.set;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class HashSetEx2 {
    public static void main(String[] args) {
        Object[] objArr = {"1", new Integer(1), "3", "3", "4", "2", "2", "4", "4"};
        Set set = new LinkedHashSet();    //  LinkedHashSet순서를 유지한다..
        /*for (int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]);
        }*/
        set.addAll(Arrays.asList(objArr));
        System.out.println(set);
    }
}
