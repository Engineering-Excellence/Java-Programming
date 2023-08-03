package ex02.aop.java;

public class CalcImpl implements Calc {

    @Override
    public int add(int... x) {
        int res = 0;
        for (int i : x) {
            res += i;
        }
        return res;
    }

    @Override
    public int mul(int... x) {
        int res = 1;
        for (int i : x) {
            res *= i;
        }
        return res;
    }

    @Override
    public int sub(int x, int... y) {
        int res = x;
        for (int i : y) {
            res -= i;
        }
        return res;
    }
}
