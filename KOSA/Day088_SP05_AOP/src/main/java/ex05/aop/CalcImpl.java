package ex05.aop;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CalcImpl implements Calc {

    @Override
    public int add(int... x) {
        // 보조관심(Cross-cutting Concern)
        int res = 0;
        for (int i : x) {
            res += i;
        }
        // 보조관심(Cross-cutting Concern)
        log.info("Add Main Concern");
        return res;
    }

    @Override
    public int mul(int... x) {
        int res = 1;
        for (int i : x) {
            res *= i;
        }
        log.info("Mul Main Concern");
        return res;
    }

    @Override
    public int sub(int x, int... y) {
        int res = x;
        for (int i : y) {
            if (res < i) throw new IllegalArgumentException("차는 음수가 될 수 없습니다.");
            res -= i;
        }
        log.info("Sub Main Concern");
        return res;
    }
}
