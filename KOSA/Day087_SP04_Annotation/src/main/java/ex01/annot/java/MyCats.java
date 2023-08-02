package ex01.annot.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
@RequiredArgsConstructor
public class MyCats {

    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private List<String> hobbies;
    private double weight;
    private String color;
}
