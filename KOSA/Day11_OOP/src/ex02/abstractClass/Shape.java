package ex02.abstractClass;

public abstract class Shape {   // Super class

    protected double result = 0;

    // abstract method
    protected abstract double calc(double x);

    protected abstract void show(String name);

    // 일반 메서드
    protected void view() {
        System.out.println("Super class Shape");
    }
}
