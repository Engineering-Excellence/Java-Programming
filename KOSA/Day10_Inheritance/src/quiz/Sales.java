package quiz;

public class Sales extends Regular {

    private long com;    // 커미션

    public Sales(int empNo, String name, String pos, String dept, String contact) {
        super(empNo, name, pos, dept, contact);
        setCom();
    }

    public long getCom() {
        return com;
    }

    public void setCom() {
        this.com = calCom(pos);
    }

    public long calCom(String pos) {
        return (long) (sal * calSal(pos) * 0.000015);
    }

    @Override
    public String toString() {

        return super.toString() + String.format("성과급\t: %,8d천원%n총급여\t: %,8d천원%n=========================", com, sal + com);
    }
}
