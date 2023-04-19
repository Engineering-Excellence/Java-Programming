package quiz;

// add(int, int), sum(1, 2, 3), display() {인삿말 출력}
public class QuizEx1 {

    public static void main(String[] args) {

        QuizEx1 quizEx1 = new QuizEx1();

        quizEx1.add(1, 2);
        quizEx1.sum(1, 2, 3);
        quizEx1.display();
    }

    void add(int x, int y) {

        System.out.printf("x + y = %d%n", x + y);
    }

    void sum(int x, int y, int z) {

        System.out.printf("x + y + z = %d%n", x + y + z);
    }

    void display() {

        System.out.println("Hello, world!\n!#/bin/bash");
    }
}
