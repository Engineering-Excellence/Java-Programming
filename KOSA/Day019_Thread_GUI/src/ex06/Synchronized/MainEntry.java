package ex06.Synchronized;

class Atm {

    private int money;

    public Atm(int money) { // 생성자
        this.money = money;
    }

    // 입금함수
    public synchronized void deposit(String name, int money) {
        this.money += money;
        System.out.printf("%s: 입금금액 %d%n", name, money);
    }

    // 출금함수
    public void withdraw(String name, int money) {
        synchronized (this) {
            if (this.money > money) {
                Thread.yield();
                this.money -= money;
                System.out.printf("%s: 출금금액 %d%n", name, money);
            } else {
                System.out.printf("%s: 잔액부족%n", name);
            }
        }   // end synchronized
    }

    // 통장잔고 함수
    public void getMoney() {
        System.out.printf("\t\t\t\t\t\t잔액: %d원%n", money);
    }
}   // Atm end

class UserAtm extends Thread {

    Atm obj;
    boolean flag = false;

    public UserAtm(String name, Atm obj) {
        super(name);
        this.obj = obj;
    }

    @Override
    public void run() { // 스레드 실행부(구현부)
        for (int i = 0; i < 2; i++) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (flag) {
                obj.deposit(getName(), (int) (10 * Math.random() + 2) * 100);
            } else {
                obj.withdraw(getName(), (int) (10 * Math.random() + 2) * 100);
            }   // if end

            flag = true;
            obj.getMoney();
        }   // for end
    }   // run() end
}

public class MainEntry {

    public static void main(String[] args) {

        Atm atm = new Atm(1000);
        UserAtm user1 = new UserAtm("박정희", atm);
        UserAtm user2 = new UserAtm("전우원", atm);
        UserAtm user3 = new UserAtm("노태우", atm);

        user1.start();
        user2.start();
        user3.start();
    }
}
