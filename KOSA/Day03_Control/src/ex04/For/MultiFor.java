package ex04.For;

public class MultiFor {

    public static void main(String[] args) {

        // 정사각형
        /*for (int i = 0; i < 5; i++) {   // 열
            for (int j = 0; j < 5; j++) {   // 행
                System.out.print("*");
            }   // j end
            System.out.println();
        }   // i end*/

        // 이등변삼각형
        /*for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/

        // 역이등변삼각형
        /*for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 6-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/

        //
    }
}
