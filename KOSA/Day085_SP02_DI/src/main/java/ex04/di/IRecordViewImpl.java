package ex04.di;

import java.util.Scanner;

public class IRecordViewImpl implements IRecordView {

    private IRecordImpl record;

    // setter로 주입하기
    public void setRecord(IRecordImpl record) {
        this.record = record;
    }

    @Override
    public void input() {

        Scanner sc = new Scanner(System.in);
        System.out.println("KOR: ");
        record.setKor(sc.nextInt());
        System.out.println("ENG: ");
        record.setEng(sc.nextInt());
        System.out.println("COM: ");
        record.setCom(sc.nextInt());
    }

    @Override
    public void print() {

        System.out.println("\n\nKOR: " + record.getKor());
        System.out.println("ENG: " + record.getEng());
        System.out.println("COM: " + record.getCom());
        System.out.println("TOTAL: " + record.total());
        System.out.println("AVERAGE: " + record.average());
    }
}
