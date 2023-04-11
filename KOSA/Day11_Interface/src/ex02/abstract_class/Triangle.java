package ex02.abstract_class;

public class Triangle extends Shape {

    private int w = 100;

    @Override
    protected double calc(double x) {
        result = x * w / 2.;
        return 0;
    }

    @Override
    public void show(String name) {
        calc(9.0);
        System.out.printf("넓이 %.2f의 %s이(가) 그려졌습니다.%n", result, name);
    }
}
