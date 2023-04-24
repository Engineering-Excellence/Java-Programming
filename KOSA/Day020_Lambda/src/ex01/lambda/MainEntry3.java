package ex01.lambda;

@FunctionalInterface
interface Message3 {

    int something(int x);
}

class Person3 {

    public void greeting(Message3 msg) {
        System.out.printf("Message Interface 3 something: %d%n", msg.something(3));
    }
}

public class MainEntry3 {

    public static void main(String[] args) {

        // Lambda Expression, JDK 1.8↑
        Person3 p = new Person3();

        p.greeting(new Message3() {
            @Override
            public int something(int x) {
                System.out.println("Good afternoon!");
                System.out.println("TGIF");
                return 50;
            }
        });

        System.out.println("-".repeat(60));

        p.greeting(x -> {
            System.out.println("Good afternoon!");
            System.out.println("TGIF");
            return 100 * x;
        });
    }
}
