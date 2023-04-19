package quiz;

public class Bicycle implements Trans {

    @Override
    public void start(String name) {
        System.out.printf("%s가 출발합니다.%n", name);
    }

    @Override
    public void stop(String name) {
        System.out.printf("%s가 정지합니다.%n", name);
    }
}
