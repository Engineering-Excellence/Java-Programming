package ex04.inheritance;

public class Shape {    // Super class

    protected int w, h;
    protected double result;

    // 생성자: 필드 초기화
    public Shape() {
        w = h = 0;
        result = 0;
    }

    public Shape(int w, int h) {
        this.w = w;
        this.h = h;
    }

    // Getter & Setter
    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double calc() {
        return result;
    }

    public void show() {
        System.out.printf("width = %d, height = %d%n", w, h);
    }
}
