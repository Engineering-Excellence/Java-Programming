package quiz;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MainEntry {

    public static void main(String[] args) {

        Trans[] trans = new Trans[]{new Subway(), new Bus(), new Bicycle(), new Plane()};
        String[] names = new String[]{"지하철", "버스", "자전거", "비행기"};

//        Arrays.stream(trans).forEach(t -> {t.start(); t.stop(); System.out.println("=".repeat(31));});

        IntStream.range(0, names.length).mapToObj(i -> new Object[]{trans[i], names[i]}).forEach(pair -> {((Trans) pair[0]).start(((String) pair[1])); ((Trans) pair[0]).stop(((String) pair[1]));});
    }
}