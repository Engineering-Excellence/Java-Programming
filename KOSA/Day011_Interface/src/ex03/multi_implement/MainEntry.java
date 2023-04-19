package ex03.multi_implement;

import ex02.Interface.IDraw;
import ex02.abstract_class.Shape;

public class MainEntry {

    public static void main(String[] args) {

        // 1. 자기 자신
        MultiClass mc = new MultiClass();
        mc.view();
        mc.testView();
        mc.draw();
        mc.display();
        System.out.println(mc.num);

        // 2. 부모로 객체 생성
        Shape s = new MultiClass();
        s.show("도형이야");
        s.view();

        System.out.println("-".repeat(40));
        Test t = new MultiClass();
        t.testView();
        System.out.println(t.str);

        System.out.println("-".repeat(40));
        IDraw d = new MultiClass();
        d.draw();
        System.out.println(IDraw.num);
    }
}
