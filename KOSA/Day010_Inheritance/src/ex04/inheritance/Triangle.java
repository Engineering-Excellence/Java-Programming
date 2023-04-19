package ex04.inheritance;

import java.util.Scanner;

public class Triangle extends Shape {

    public Triangle() {
        System.out.print("Input width, height: ");
        this.w = new Scanner(System.in).nextInt();
        this.h = new Scanner(System.in).nextInt();
    }

    public Triangle(int w, int h) {
        super(w, h);
    }

    @Override
    public double calc() {
        this.result = (double) (w * h) / 2;
        return result;
    }

    @Override
    public void show() {
        super.show();
        System.out.printf("area = %.2f%n", calc());
    }
}
