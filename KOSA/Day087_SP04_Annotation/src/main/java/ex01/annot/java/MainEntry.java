package ex01.annot.java;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log4j2
public class MainEntry {

    public static void main(String[] args) {

        log.info("ENTER");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);

        Cats catsInfo = ctx.getBean("catsInfo", Cats.class);
        catsInfo.getMyCatsInfo();

        MyCats cat2 = (MyCats) ctx.getBean("cat2");
        catsInfo.setMyCats(cat2);
        catsInfo.getMyCatsInfo();

        ctx.close();

        log.info("EXIT");
    }
}
