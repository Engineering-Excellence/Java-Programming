package ex01.lambda;

@FunctionalInterface
interface Message2 {

    int something();
}

class Person2 {

    public void greeting(Message2 msg) {
        System.out.printf("Message Interface 2 something: %d%n", msg.something());
    }
}

public class MainEntry2 {

    public static void main(String[] args) {

        // Lambda Expression, JDK 1.8↑
        Person2 p = new Person2();

        p.greeting(new Message2() {
            @Override
            public int something() {
                System.out.println("Good afternoon!");
                System.out.println("TGIF");
                return 100;
            }
        });

        System.out.println("-".repeat(60));

        p.greeting(() -> {
            System.out.println("Good afternoon!");
            System.out.println("TGIF");
            return 200;
        });
    }
}
