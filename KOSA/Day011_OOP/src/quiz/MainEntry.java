package quiz;

import java.util.Arrays;

public class MainEntry {

    public static void main(String[] args) {

        Trans[] trans = new Trans[]{new Subway(), new Bus(), new Bicycle(), new Plane()};

        Arrays.stream(trans).forEach(t -> {t.start(); t.stop(); System.out.println("=".repeat(31));});
    }
}
