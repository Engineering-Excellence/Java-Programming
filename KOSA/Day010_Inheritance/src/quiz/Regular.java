package quiz;

public class Regular extends Employee {

    // Field
    protected long sal;    // 기본급

    // Constructor
    public Regular(int empNo, String name, String pos, String dept, String contact) {
        super(empNo, name, pos, dept, contact);
        setSal();
    }

    // Getters & Setters
    public long getSal() {
        return sal;
    }

    public void setSal() {
        this.sal = calSal(pos);
    }

    public long calSal(String pos) {
        return switch (pos) {
            case "관리관" -> 1000;
            case "이사관" -> 8000;
            case "서기관" -> 6000;
            case "사무관" -> 5000;
            case "주사" -> 4000;
            case "서기" -> 3000;
            default -> 0;
        };
    }

    @Override
    public String toString() {

        return super.toString() + String.format("기본급\t: %,8d천원%n", sal);
    }
}
