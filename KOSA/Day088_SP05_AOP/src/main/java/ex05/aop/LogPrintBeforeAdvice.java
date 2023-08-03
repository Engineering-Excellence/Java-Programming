package ex05.aop;

import lombok.extern.log4j.Log4j2;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Log4j2
public class LogPrintBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        log.info("before()");

        log.info("보조 업무 구현(주 업무 시작 전)");
    }
}
