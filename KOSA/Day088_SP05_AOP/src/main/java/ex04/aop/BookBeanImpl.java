package ex04.aop;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BookBeanImpl implements BookBean {

    @Override
    public void testHello(String str) {
        log.info("testHello(): {}", str);
    }

    @Override
    public int korHello() {
        log.info("korHello()");
        return 5;
    }
}
