package ex04.aop;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MessageBeanImpl implements MessageBean {

    @Override
    public void sayHello() {
        log.info("sayHello()");
    }

    @Override
    @SneakyThrows(InterruptedException.class)
    public void engHello() {
        log.info("engHello()");

        Thread.sleep(2000);
    }
}
