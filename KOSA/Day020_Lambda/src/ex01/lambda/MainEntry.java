package ex01.lambda;

@FunctionalInterface
interface Message {

    void something();
}

class Person {

    public void greeting(Message msg) {
        msg.something();
    }
}

public class MainEntry {

    public static void main(String[] args) {

        // Lambda Expression, JDK 1.8↑
        Person p = new Person();

        p.greeting(new Message() {
            @Override
            public void something() {
                System.out.println("Good afternoon!");
                System.out.println("TGIF");
            }
        });

        System.out.println("-".repeat(60));

        p.greeting(() -> System.out.println("Hello, lambda!"));
    }
}
