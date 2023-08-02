package ex01.annot.java;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Cats {

    private MyCats myCats;

    public void getMyCatsInfo() {
        System.out.println("*".repeat(30));
        System.out.println("Cats Name: " + myCats.getName());
        System.out.println("Cats Age: " + myCats.getAge());
        System.out.println("Cats Hobbies: " + myCats.getHobbies());
        System.out.println("Cats Weight: " + myCats.getWeight());
        System.out.println("Cats Color: " + myCats.getColor());
        System.out.println("*".repeat(30));
        System.out.println();
    }
}
