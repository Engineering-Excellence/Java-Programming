package ex04.inheritance;

import java.util.Scanner;

public class Circle extends Shape { // Sub class

    public Circle() {
        super(2, 3);    // 반드시 첫 줄에 위치
        System.out.print("Input radius: ");
        this.w = new Scanner(System.in).nextInt();
    }

    @Override
    public double calc() {

        this.result = w * w * Math.PI;
        return result;
    }

    @Override
    public void show() {
        System.out.printf("radius = %d, area = %.2f%n", w, calc());
    }
}
