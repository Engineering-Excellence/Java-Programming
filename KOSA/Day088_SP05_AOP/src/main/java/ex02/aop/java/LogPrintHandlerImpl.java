package ex02.aop.java;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Log4j2
@AllArgsConstructor
public class LogPrintHandlerImpl implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { // 보조 프로그램 구현
        log.info("invoke() start");

        // 보조 업무 구현
        StopWatch sw = new StopWatch();
        sw.start(); // 시간 측정 시작
        log.info("Timer Start");

        // main 관심 실행
        int result = (int) method.invoke(target, args);

        sw.stop();  // 시간측정 끝
        log.info("Timer Stop");
        log.info("Method: " + method.getName());
        log.info("Elapsed Time: " + sw.getTotalTimeSeconds());  // 작업에 걸린 시간

        return result;
    }
}
