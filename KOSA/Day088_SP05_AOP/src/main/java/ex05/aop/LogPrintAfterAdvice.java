package ex05.aop;

import lombok.extern.log4j.Log4j2;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

@Log4j2
public class LogPrintAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        log.info("afterReturning()");

        log.info("Runs Right After Main Concerns");
        log.info("Method Name: " + method.getModifiers());
        log.info("Return Value: " + o);
        log.info("args: " + Arrays.toString(objects));
    }
}
