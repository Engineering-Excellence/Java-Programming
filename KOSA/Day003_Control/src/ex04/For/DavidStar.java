package ex04.For;

public class DavidStar {

    public static void main(String[] args) {

        int i, j;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 10 + i; j++) {
                if (j < 9 - i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 19 - i; j++) {
                if (j < i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

        for (i = 3; i > 0; i--) {
            for (j = 0; j < 19 - i + 1; j++) {
                if (j < i - 1)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

        for (i = 2; i >= 0; i--) {
            for (j = 0; j < 10 + i; j++) {
                if (j < 9 - i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
