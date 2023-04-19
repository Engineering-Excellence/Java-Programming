package ex03.multi_implement;

import ex02.Interface.IDraw;
import ex02.abstract_class.Shape;

public class MultiClass extends Shape implements Test, IDraw {

    protected int num;

    void display() {
        System.out.println("MultiClass method");
    }

    @Override
    public void draw() {    // IDraw
        num = 88;
        System.out.println("IDraw interface" + num);
    }

    @Override
    protected double calc(double x) {   // Shape
        System.out.println("Shape abstract class");
        return 5.5;
    }

    @Override
    public void show(String name) {  // Shape

        System.out.println("Shape abstract class");
    }

    @Override
    public void testView() {
        System.out.println("Test interface");
    }
}
