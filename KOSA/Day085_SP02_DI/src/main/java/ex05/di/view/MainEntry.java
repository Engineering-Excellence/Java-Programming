package ex05.di.view;

import ex05.di.dao.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {

    public static void main(String[] args) {

        ApplicationContext ctxApplicationContext = new GenericXmlApplicationContext("ex05/di/bean/memberCtx.xml");

        MemberDAO dao = (MemberDAO) ctxApplicationContext.getBean("dao");

        dao.insert();
    }
}
