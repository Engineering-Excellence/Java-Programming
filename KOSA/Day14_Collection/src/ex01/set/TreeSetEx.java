package ex01.set;

import java.util.TreeSet;
import java.util.stream.IntStream;

public class TreeSetEx {

    public static void main(String[] args) {

        TreeSet<Object> treeSet = new TreeSet<>();

        int[] score = {85, 95, 50, 35, 45, 65, 10, 65, 100};

        IntStream.range(0, score.length).forEach(i -> treeSet.add(score[i]));

        System.out.println(treeSet);

        System.out.println("50보다 작은 값: " + treeSet.headSet(new Integer(50)));
        System.out.println("50보다 크거나 같은 값: " + treeSet.tailSet(new Integer(50)));
    }
}
