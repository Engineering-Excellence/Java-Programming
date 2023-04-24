package ex01.lambda;

@FunctionalInterface
interface Message4 {

    int something(int x, int y);
}

class Person4 {

    public void greeting(Message4 msg) {
        System.out.printf("Message Interface 4 something: %d%n", msg.something(3, 4));
    }
}

public class MainEntry4 {

    public static void main(String[] args) {

        // Lambda Expression, JDK 1.8↑
        Person4 p = new Person4();

        p.greeting(new Message4() {
            @Override
            public int something(int x, int y) {
                System.out.println("Good afternoon!");
                System.out.println("TGIF");
                return 50;
            }
        });

        System.out.println("-".repeat(60));

        p.greeting((x, y) -> {  // 매개변수가 2개 이상일 때는 괄호 생략 불가!
            System.out.printf("x = %d, y = %d%n", x, y);
            return x + y;
        });
    }
}
