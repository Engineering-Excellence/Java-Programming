package ex02.abstract_class;

public abstract class Shape {   // Super class

    protected double result = 0;

    // abstract method
    protected abstract double calc(double x);

    public abstract void show(String name);

    // 일반 메서드
    public void view() {
        System.out.println("Super class Shape");
    }
}
