package ex06.aop.annot;

import lombok.Data;

@Data
public class Worker {

    private String name;
    private int age;
    private String job;

    public void getWorkerInfo() {
        System.out.printf("이름: %s%n", this.name);
        System.out.printf("나이: %d%n", this.age);
        System.out.printf("직업: %s%n", this.job);
    }
}
