package main;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.GenericXmlApplicationContext;
import springConfig.Client;

@Log4j2
public class MainEntry {

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("config/applicationContext.xml");

        Client client = ctx.getBean("client", Client.class);
        client.send();

        Client client2 = ctx.getBean("client", Client.class);
        client2.send(); // Spring은 기본적으로 Singleton Pattern

        log.info("client == client2 ? " + (client.hashCode() == client2.hashCode()));

        ctx.close();
    }
}
