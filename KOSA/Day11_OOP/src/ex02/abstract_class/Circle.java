package ex02.abstract_class;

public class Circle extends Shape { // Sub class

    @Override
    protected double calc(double x) {
        result = x * x * Math.PI;  // 대입
        return result;
    }

    @Override
    protected void show(String name) {
        calc(5.5);  // 대입
        System.out.printf("넓이 %.2f의 %s이(가) 그려졌습니다.%n", result, name);
    }
}
