package ex01.abstractClass;

abstract class Shape { // 추상 클래스, 부모 클래스

    protected double result = 0;

    protected abstract double calc();  // abstract method

    protected abstract void draw();

    protected void show() {    // 추상 클래스는 일반 메서드도 가질 수 있다.
        System.out.println("Super class Shape");
    }
}   // Shape end

class Circle extends Shape {    // 자손 클래스

    private double r = 5.0;

    @Override
    protected double calc() {
        result = r * r * Math.PI;
        return result;
    }

    @Override
    protected void draw() {
        calc();
        System.out.printf("넓이가 %.2f인 원을 그렸습니다.%n", result);
    }
}   // Circle end

class Rect extends Shape {

    private int w = 3, h = 5;

    @Override
    protected double calc() {
        result = (double) w * h;
        return result;
    }

    @Override
    protected void draw() {
        calc();
        System.out.printf("넓이가 %.2f인 사각형을 그렸습니다.%n", result);
    }
}

class Triangle extends Shape {

    private int w = 3, h = 5;

    @Override
    protected double calc() {
        result = (double) (w * h) / 2;
        return result;
    }

    @Override
    protected void draw() {
        calc();
        System.out.printf("넓이가 %.2f인 삼각형을 그렸습니다.%n", result);
    }
}

public class MainEntry {

    public static void main(String[] args) {

        Circle c = new Circle();
        c.draw();

        Rect r = new Rect();
        r.draw();

//        Shape sh = new Shape(); // 추상 클래스는 자체적으로 객체를 생성할 수 없다.
        Shape sh = new Triangle();    // 상속받은 자손 클래스로 객체 생성 가능
        sh.draw();
    }
}
