package ex01.Interface;

interface A {   // interface: abstract method, final metho만 가짐.

    int x = 90;
    static final int y = 777;
    char ch = 'A';

    // 추상 메서드, abstract 생략 가능(반드시 추상 메서드)
    void show();  // public abstract void show();
    public abstract void disp();
}   // A end

interface B {

    void view();
}   // B end

interface C {

    String name = "happy";

    void draw();
}   // C end

interface D extends B {

    void dView();
}   // D end

class Rect implements D {

    @Override
    public void view() {    // B interface

    }

    @Override
    public void dView() {   // D interface

    }

    int plus(int x, int y) {

        return x + y;
    }
}   // Rect class

class Shape {


}   // Shape class

class Circle implements C {

    @Override
    public void draw() {
//        name = "Kyle";  // interface의 상수는 반드시 final이므로 변경 불가
        System.out.printf("%s님 안녕하세요.", name);
    }
}

class Multi extends Shape implements A, B, C {  // 클래스를 먼저 상속 받은 후 인터페이스를 구현(순서)
//class Multi implements A, B, C extends Shape {

    @Override
    public void show() {    // A

    }

    @Override
    public void disp() {    // A

    }

    @Override
    public void view() {    // B

    }

    @Override
    public void draw() {    // c

    }
}   // Multi class

public class MainEntry {

    public static void main(String[] args) {

//        A a = new A();  // 인터페이스는 객체 생성 불가

    }
}
