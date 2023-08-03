package ex02.aop.java;

import java.lang.reflect.Proxy;

public class MainEntry {

    public static void main(String[] args) {

        Calc c = new CalcImpl();
        Calc proxy = (Calc) Proxy.newProxyInstance(
                Calc.class.getClassLoader(),
                new Class[]{Calc.class},
                new LogPrintHandlerImpl(c)
                /*
                    c.getClass().getClassLoader(),  // loader: 클래스 찾기
                    c.getClass().getInterfaces(),   // interface: 행위(함수)
                    new LogPrintHandlerImpl(c)      // h: 보조업무 구현
                */
        );

        // Proxy를 통해서 실행
        System.out.println(proxy.add(2, 5));
        System.out.println(proxy.mul(5, 3));


        // Class를 통해서 실행
        /*
            System.out.printf("%d + %d = %d%n", 1, 2, c.add(1, 2));
            System.out.printf("%d + %d = %d%n", 10, 22, c.add(10, 22));
            System.out.println();
            System.out.printf("%d × %d = %d%n", 3, 4, c.mul(3, 4));
            System.out.printf("%d × %d × %d = %d%n", 7, 4, 5, c.mul(7, 4, 5));
        */
    }
}
