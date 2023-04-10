package quiz;

public class Sales extends Regular {

    // Field
    private long com;    // 성과급

    // Constructor
    public Sales(int empNo, String name, String pos, String dept, String contact) {
        super(empNo, name, pos, dept, contact);
        setCom();
    }

    // Getters & Setters
    public long getCom() {
        return com;
    }

    public void setCom() {
        this.com = calCom(pos);
    }

    public long calCom(String pos) {
        return (long) (sal * calSal(pos) * 0.00003);
    }

    @Override
    public String toString() {

        return super.toString() + String.format("성과급\t: %,8d천원%n총급여\t: %,8d천원%n=========================", com, sal + com);
    }
}
