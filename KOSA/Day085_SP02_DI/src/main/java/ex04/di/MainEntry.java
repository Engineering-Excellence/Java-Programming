package ex04.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ex04/di/appCtx.xml");
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("appCtx.xml");
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("appCtx.xml", "test.xml");
        IRecordViewImpl view = ctx.getBean("view", IRecordViewImpl.class);
        view.print();

        /*
            IRecordImpl record = new IRecordImpl();
            IRecordViewImpl view = new IRecordViewImpl();

            view.setRecord(record);
            view.input();
            view.print();
        */
    }
}
