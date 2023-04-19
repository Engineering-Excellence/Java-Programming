package ex04.api_object;

class Rectangle {

    int x, y;
    public void display() { // 출력함수 따로 생성

        System.out.printf("x = %d, y = %d%n", x, y);
    }

    @Override
    public String toString() {
        return String.format("x = %d, y = %d%n", x, y);
    }
}

public class ToStringMain {

    public static void main(String[] args) {

        Rectangle r = new Rectangle();
        r.display();
        System.out.println(r.toString());
    }
}
