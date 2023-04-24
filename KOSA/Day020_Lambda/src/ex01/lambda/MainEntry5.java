package ex01.lambda;

// 람다식에 타입을 써야만 하는 상황이 존재: 매개변수 개수가 같은 함수형 인터페이스가 2개 이상 존재, 모호할 경우
@FunctionalInterface
interface Message5 {

    void something(int x, int y);
}

@FunctionalInterface
interface Talk {
    void something(String x, String y);
}

class Person5 {

    public void greeting(Message5 msg) {
        msg.something(3, 5);
    }
    public void greeting(Talk talk) {
        talk.something("Hello, ", "Daebo!");
    }
}

public class MainEntry5 {

    static int num = 30;

    public static void main(String[] args) {

        // Lambda Expression, JDK 1.8↑
        Person5 p = new Person5();

        p.greeting(new Message5() {
            @Override
            public void something(int x, int y) {
            System.out.printf("x = %d, y = %d%n", x, y);
            }
        });

        System.out.println("-".repeat(60));

        char ch = 'K';

        p.greeting((int x, int y) -> System.out.printf("x = %d, y = %d%n", x, y));

        System.out.println("-".repeat(60));

        p.greeting((String x, String y ) -> {   // 해당되는 함수형 인터페이스가 2개 이상 존재할 경우는 타입 생략 불가!
            System.out.printf("x = %s, y = %s%n", x, y);
//            ch = 'P'; // Lambda는 인스턴스 값 변경 불가 !!
            System.out.println(ch); // 출력은 가능

            num = 500;  // static 값은 변경 가능
            System.out.println(num);
        });
    }
}
