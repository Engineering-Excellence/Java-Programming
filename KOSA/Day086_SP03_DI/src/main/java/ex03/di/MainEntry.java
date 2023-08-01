package ex03.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {

    public static void main(String[] args) {

        ApplicationContext ctx = new GenericXmlApplicationContext("ex03/di/ctx.xml");

        EmployeePersonImpl employee = ctx.getBean("employee", EmployeePersonImpl.class);
        employee.personShow(employee);
        employee.personShow(employee.getHobbies());
    }
}
