package ex03.di;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePersonImpl implements Person {

    private String name, gender;
    private int age;
    private List<String> hobbies;

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

    public boolean personShow(EmployeePersonImpl employee) {
        System.out.printf("%s / %d / %s%n", employee.getName(), employee.getAge(), employee.getGender());
        return true;
    }

    public boolean personShow(List<String> hobbies) {
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        return true;
    }
}
