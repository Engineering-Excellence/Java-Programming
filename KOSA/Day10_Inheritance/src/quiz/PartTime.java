package quiz;

// 근무일수 * 시간당 단가, 이름, 임시사번, 부서, 연락처, 월급체계 다름
public class PartTime extends Employee {

    private long pay;
    private int workDay;

    public PartTime(int empNo, String name, String pos, String dept, String contact, int workDay) {
        super(empNo, name, pos, dept, contact);
        setWorkDay(workDay);
        setPay(calTotPay());
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public long getPay() {
        return pay;
    }

    public void setPay(long pay) {
        this.pay = switch (pos) {
            case "기간제근로자" -> 100;
            case "일일근로자" -> 80;
            default -> 0;
        };;
    }

    public long calTotPay() {
        return pay * workDay;
    }

    @Override
    public String toString() {

        return super.toString() + String.format("단가\t: %,8d천원%n근무일\t: %,8d  일%n총지급액\t: %,8d천원", pay, workDay, calTotPay());
    }
}
