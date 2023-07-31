package ex02.nonDI;

public class NewRecordView {

    private NewRecord record;

    /*
        필요한 객체를 setter 메서드를 통해 주입 받아서 사용
        객체의 생성이 서로 독립적이고 필요시 객체에 주입
     */

    public NewRecordView() {
    }

    public void setRecord(NewRecord record) {
        this.record = record;
    }

    public void print() {
        System.out.println("KOR:  " + record.getKor());
        System.out.println(record.total() + "/" + record.average());
        System.out.println("+".repeat(40));
        record.disp();
        System.out.println(record); // toString() 호출
    }
}
