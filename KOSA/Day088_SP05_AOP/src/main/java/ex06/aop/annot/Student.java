package ex06.aop.annot;

import lombok.Data;

@Data
public class Student {

    private String name;
    private int age, gradeNum, classNum;

    public void getStudentInfo() {
        System.out.printf("이름: %s%n", this.name);
        System.out.printf("나이: %d%n", this.age);
        System.out.printf("학년: %d%n", this.gradeNum);
        System.out.printf("반: %d%n", this.classNum);
    }
}
