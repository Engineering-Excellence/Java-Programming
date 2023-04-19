package ex04.oop;

public class MainEntry {

    public static void main(String[] args) {

        Person person = new Person();

        person.setName("Kyle");
        person.setAge(99);
        System.out.println(person.toString());
        System.out.println(person);
    }
}
