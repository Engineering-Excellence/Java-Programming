package ex01.nonDI;

public class NewRecordView {

    private NewRecord record;

    public NewRecordView(int kor, int eng, int math, int com) {
        record = new NewRecord(kor, eng, math, com);
    }

    public void print() {
        System.out.println("KOR:  " + record.getKor());
        System.out.println(record.total() + "/" + record.average());
        System.out.println("+".repeat(40));
        record.disp();
        System.out.println(record); // toString() 호출
    }
}
