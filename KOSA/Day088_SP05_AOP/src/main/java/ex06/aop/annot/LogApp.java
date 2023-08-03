package ex06.aop.annot;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Log4j2
@Aspect
public class LogApp {   // Advice Class - arround 적용

    // @Pointcut("execution(public void get*(..))") // public void인 모든 get메소드
    //@Pointcut("execution(* ex06.aop.annot.*.*())") // kr.edu.kosta 패키지에 파라미터가 없는 모든 메소드
    // @Pointcut("execution(* kr.edu.kosa..*.*())") // kr.edu.kosta 패키지 &
    // kr.edu.kosta 하위 패키지에 파라미터가 없는 모든 메소드
    // @Pointcut("execution(* kr.edu.kosta.Worker.*())") // kr.edu.kosta.Worker 안의
    // 모든 메소드

    // @Pointcut("within(ex06.aop.annot.*)") //kr.edu.kosta 패키지 안에 있는 모든 메소드
    // @Pointcut("within(ex06.aop.annot..*)") //kr.edu.kosta 패키지 및 하위 패키지 안에 있는 모든
    // 메소드
     @Pointcut("within(ex06.aop.annot.Worker)") //kr.edu.kosta.Worker 모든 메소드

    // @Pointcut("bean(student)") //student 빈에만 적용
//    @Pointcut("bean(*ker)") //~ker로 끝나는 빈에만 적용
//    @Pointcut("!bean(student)") // student 빈을 제외한것에 적용
    public void pointcutMethod() {  // 내용은 비어있어야 함
    }

    @Around("pointcutMethod()")
    public Object loggerApp(ProceedingJoinPoint joinPoint) throws Throwable {

        String signatureStr = joinPoint.getSignature().toLongString();
        log.info(signatureStr + " is start");
        long start = System.currentTimeMillis();

        Object obj = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info(signatureStr + " is finished");
        log.info("{} Elapsed Time: {} ms", signatureStr, (end - start));

        return obj;
    }

    @Before("pointcutMethod()")
    public void beforeAdvice() {
        log.info("beforeAdvice()");
        log.info("입학과 입사를 축하합니다.");
    }
}
