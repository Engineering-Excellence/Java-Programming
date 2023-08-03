package ex05.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {

    public static void main(String[] args) {

        ApplicationContext ctx = new GenericXmlApplicationContext("ex05/aop/appCtx.xml");

        Calc proxyCal = ctx.getBean("proxy", Calc.class);

        System.out.println(proxyCal.add(30, 20));
        System.out.println(proxyCal.sub(30, 20));
        System.out.println(proxyCal.mul(30, 20));
    }
}
