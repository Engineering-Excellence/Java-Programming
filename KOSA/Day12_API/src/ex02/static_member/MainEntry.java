package ex02.static_member;

class Atm {

    int count;  // instance member
    static int total;   // static member

    public Atm(int amount) {
        this.count += amount;
        total += amount;
    }

    public static void view() {
        total += 100;
//        count += 100; // static member에서 인스턴스 변수는 사용 불가
    }

    public static void show(int count, int total) {
//        this.count = count;   // static member에서 this 사용 불가
//        this.total = total;
    }

    public void display() {
        count += 50;
        total += 30;
        System.out.printf("count = %d%n", count);
        System.out.printf("total = %d%n", total);
    }
}   // Atm end

public class MainEntry {

    public static void main(String[] args) {    // 시작점(진입점)

        System.out.println(Atm.total);
        Atm atm1 = new Atm(1000);
        atm1.display();  // c: 1000, t: 1000
        System.out.println("-".repeat(40));
        Atm atm2 = new Atm(1000);
        atm2.display();  // c: 1000, t: 2000
        System.out.println("-".repeat(40));
        Atm atm3 = new Atm(1000);
        atm3.display();  // c: 1000, t: 3000
    }
}
