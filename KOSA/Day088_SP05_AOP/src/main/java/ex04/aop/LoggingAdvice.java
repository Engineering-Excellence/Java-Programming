package ex04.aop;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// XML 기반 POJO 방식의 AspectJ를 이용한 AOP 방법
@Log4j2
public class LoggingAdvice {

    /*
        Around 방식의 사전/사후 처리 AOP
        around 방식으로 할 때의 인수는 ProceedingJoinPoint, 리턴 Object 필수
     */
    @SneakyThrows(Throwable.class)
    public Object arround(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getKind();
        String methodName2 = joinPoint.getSignature().getName();

        log.info("Before {}, {}", methodName, methodName2);
        StopWatch sw = new StopWatch();
        sw.start(methodName);

        // 주관심 실행 코드
        Object result = joinPoint.proceed();    // 실제 타겟 메서드가 호출되는 부분

        log.info("After {}, {}", methodName, methodName2);
        log.info("Elapsed Time: {} ms", sw.getTotalTimeMillis());

        return result;
    }
}
