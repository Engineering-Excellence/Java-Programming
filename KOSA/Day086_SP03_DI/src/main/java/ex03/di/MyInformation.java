package ex03.di;

import lombok.Data;

@Data
public class MyInformation {

    private Person person;  // has-a

    public boolean processMessage(StudentPersonImpl student) {
        return this.person.personShow(student.getName(), student.getAge(), student.getGender());
    }

    public boolean processMessage(EmployeePersonImpl employee) {
        return this.person.personShow(employee);
    }

    public boolean processMessage(String name, int age, String gender) {
        return this.person.personShow(name, age, gender);
    }
}
