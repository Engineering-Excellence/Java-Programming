package quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("quiz/appCtx.xml");

        IMessage message = (IMessage) context.getBean("kor");
        message.sayHello();

        System.out.println("=".repeat(20));

        message = (IMessage) context.getBean("eng");
        message.sayHello();
    }
}
