package ex04.array;

public class ForEachTest {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 100, 88, 99};

        System.out.println("오름차순 출력");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
            if (i == 3) break;
        }

        // for (자료형 변수명 : 컬렉션명 또는 배열명) {
        for (int i : a) {
            System.out.print(i + "\t");
        }

        System.out.println("\n=========================================================================================");

        System.out.println("내림차순 출력");
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i] + "\t");
//            if (i == 3) break;
        }
    }
}
