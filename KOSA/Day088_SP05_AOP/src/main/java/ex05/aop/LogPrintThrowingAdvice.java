package ex05.aop;

import lombok.extern.log4j.Log4j2;
import org.springframework.aop.ThrowsAdvice;

@Log4j2
public class LogPrintThrowingAdvice implements ThrowsAdvice {

    public void afterThrowing(IllegalArgumentException e) {
        System.out.println("afterThrowing Exception: " + e.getMessage());
    }
}
