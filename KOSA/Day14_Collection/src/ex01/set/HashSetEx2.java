package ex01.set;

import java.util.HashSet;
import java.util.Set;

class Person extends Object {   // Object를 자동 상속

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        /*if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);*/

        if (o instanceof Person) {
            Person temp = (Person) o;
            return name.equals(temp.name) && age == temp.age;   // 이름과 나이가 모두 같을 때만 동일한 사람으로 판정
        }
        return false;
    }

    @Override
    public int hashCode() {
        /*int result = name.hashCode();
        result = 31 * result + age;
        return result;*/

        return name.hashCode() + age;   // 이름과 나이가 모두 같다면 같은 주소를 가지게 됨 -> 중복 비허용
    }
}

public class HashSetEx2 {

    public static void main(String[] args) {

        Set set = new HashSet<>();

        set.add(new Person("홍길동", 33));
        set.add(new Person("임꺽정", 20));
        set.add(new Person("임꺽정", 20));
        set.add(new Person("임꺽정", 38));
        set.add(new Person("임꺽정", 10));

        set.add(new String("Kyle"));
        set.add(new String("Kyle"));

        System.out.println(set);
    }
}
