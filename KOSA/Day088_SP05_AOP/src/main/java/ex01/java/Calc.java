package ex01.java;

import lombok.extern.log4j.Log4j2;
import org.springframework.util.StopWatch;

@Log4j2
public class Calc { // 사칙연산 프로그램

    public int add(int x, int y) {

        StopWatch sw = new StopWatch();
        sw.start(); // 시간 측정 시작
        log.info("Timer Start");

        int result = x + y; // 중심(관심, 주가 되는) 코드

        sw.stop();  // 시간측정 끝
        log.info("Timer Stop");
        log.info("Method: add");
        log.info("Elapsed Time: " + sw.getTotalTimeSeconds());  // 작업에 걸린 시간

        return result;
    }

    public int mul(int x, int y) {

        StopWatch sw = new StopWatch();
        sw.start(); // 시간 측정 시작
        log.info("Timer Start");

        int result = x * y; // 중심(관심, 주가 되는) 코드

        sw.stop();  // 시간측정 끝
        log.info("Timer Stop");
        log.info("Method: mul");
        log.info("Elapsed Time: " + sw.getTotalTimeSeconds());  // 작업에 걸린 시간

        return result;
    }
    public int mul(int x, int y, int z) {

        StopWatch sw = new StopWatch();
        sw.start(); // 시간 측정 시작
        log.info("Timer Start");

        int result = x * y * z; // 중심(관심, 주가 되는) 코드

        sw.stop();  // 시간측정 끝
        log.info("Timer Stop");
        log.info("Method: mul");
        log.info("Elapsed Time: " + sw.getTotalTimeSeconds());  // 작업에 걸린 시간

        return result;
    }
}
