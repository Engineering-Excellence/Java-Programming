package ex03.di;

import lombok.Data;

import java.util.List;

@Data
public class StudentPersonImpl implements Person {

    private String name, gender;
    private int age;
    private List<Integer> scores;

    @Override
    public boolean personShow(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        System.out.printf("%s, %d, %s%n", name, age, gender);
        return true;
    }

    @Override
    public boolean personShow(Person person) {
        System.out.printf("%s / %d / %s%n", name, age, gender);
        return true;
    }

    public boolean personShow(StudentPersonImpl student) {
        System.out.printf("%s / %d / %s%n", student.getName(), student.getAge(), student.getGender());
        return true;
    }

    public boolean personShow(List<Integer> scores) {
        for (Integer score : scores) {
            System.out.println(score);
        }
        return true;
    }
}
