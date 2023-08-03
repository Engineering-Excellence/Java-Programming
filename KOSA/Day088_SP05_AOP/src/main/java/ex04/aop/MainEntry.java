package ex04.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ex04/aop/ctx.xml");

        MessageBean msg = ctx.getBean("messageBeanImpl", MessageBean.class);

        msg.sayHello();
        System.out.println();
        msg.engHello();

        System.out.println("-".repeat(100));

        BookBean book = ctx.getBean("bookBeanImpl", BookBean.class);
        book.testHello("Daebo");
        System.out.println();
        book.korHello();
    }
}
