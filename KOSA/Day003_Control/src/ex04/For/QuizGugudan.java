package ex04.For;

// 전체 구구단
public class QuizGugudan {

    public static void main(String[] args) {

        for (int i = 2; i < 10; i++) {
            System.out.printf("[%d단]\t\t", i);
        }
        System.out.println();

        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d * %d = %2d\t", j, i, j * i);
            }
            System.out.println();
        }
    }
}
