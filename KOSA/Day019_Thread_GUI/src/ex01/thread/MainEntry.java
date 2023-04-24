package ex01.thread;

public class MainEntry {

    public static void main(String[] args) {

        /*
            프로세스: 실행중인 프로그램
            프로세서: CPU
         */

//        Thread t1 = new Thread("t1");
        UserThread t1 = new UserThread("t1");
        Thread t2 = new UserThread("t2");
        Thread t3 = new UserThread("t3");

        t1.setPriority(Thread.MIN_PRIORITY);    // 1
        t2.setPriority(Thread.NORM_PRIORITY);   // 5
        t3.setPriority(Thread.MAX_PRIORITY);    // 10

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getState());

//        t1.run();   // X
        t1.start(); // run() 메서드 유도
        t2.start();
        t3.start();
    }
}
