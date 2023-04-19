package quiz;

public class Employee {

    // Field
    private int empNo;  // 사번, 급여와 성과급에 무관(private)
    private String name;    // 이름, 급여와 성과급에 무관(private)
    protected String dept; // 부서
    protected String pos;    // 직급: 관리관, 이사관, 서기관, 사무관, 주사, 서기
    private String contact;   // 연락처, 급여와 성과급에 무관(private)

    // Constructor
    public Employee(int empNo, String name, String contact) {
        this.empNo = empNo;
        this.name = name;
        this.contact = contact;
    }

    public Employee(int empNo, String name, String pos, String dept, String contact) {
        this.empNo = empNo;
        this.name = name;
        this.pos = pos;
        this.dept = dept;
        this.contact = contact;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {

        return String.format("사번\t: %010d%n이름\t: %s%n부서\t: %s%n직급\t: %s%n연락처\t: %s%n", empNo, name, dept, pos, contact);
    }
}
