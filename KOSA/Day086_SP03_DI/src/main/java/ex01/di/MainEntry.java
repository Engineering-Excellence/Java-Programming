package ex01.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ex01/di/playerCtx.xml");

        Player p = ctx.getBean("player", Player.class);
        Player p2 = ctx.getBean("player", Player.class);

        Soccer s = ctx.getBean("soccer", Soccer.class);

        String[] sportNames = {"축구", "농구", "컬링"};
        Object[] classNames = {ctx.getBean("soccer"), ctx.getBean("basketball"), ctx.getBean("curling")};

        for (int i = 0; i < sportNames.length; i++) {
            System.out.println(sportNames[i]);
            p.input();
            p.info();
        }
    }
}
