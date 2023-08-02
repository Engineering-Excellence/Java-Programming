package main;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.GenericXmlApplicationContext;
import springConfig.Client2;

@Log4j2
public class MainEntry2 {

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("config/applicationContext.xml");

        Client2 client = ctx.getBean("client2", Client2.class);
        Client2 client2 = ctx.getBean("client2", Client2.class);
        client.send();

        log.info("client == client2 ? " + (client.hashCode() == client2.hashCode()));

        ctx.close();
    }
}
