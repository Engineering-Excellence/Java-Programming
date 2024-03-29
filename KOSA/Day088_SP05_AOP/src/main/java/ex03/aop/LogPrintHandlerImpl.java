package ex03.aop;

import lombok.extern.log4j.Log4j2;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

@Log4j2
public class LogPrintHandlerImpl implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        log.info("LogPrintHandlerImpl: " + methodInvocation.getMethod().getName() + " is called.");
        // 보조 업무
        StopWatch sw = new StopWatch();
        sw.start(); // 시간 측정 시작
        log.info("Timer Start");

        // 주관심 실행 코드
        Object result = methodInvocation.proceed();

        sw.stop();  // 시간측정 끝
        log.info("Timer Stop");
        log.info("LogPrintHandlerImpl: " + methodInvocation.getMethod().getName() + " is finished.");
        log.info("Elapsed Time: " + sw.getTotalTimeMillis());  // 작업에 걸린 시간

        return result;
    }
}
