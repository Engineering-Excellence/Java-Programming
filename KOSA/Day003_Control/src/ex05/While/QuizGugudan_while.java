package ex05.While;

public class QuizGugudan_while {

    public static void main(String[] args) {

        int i = 0, j;
        while (i++ < 9) {
            j = 1;
            while (j++ < 9) {
                System.out.printf("%d * %d = %2d\t", j, i, j * i);
            }
            System.out.println();
        }
    }
}
