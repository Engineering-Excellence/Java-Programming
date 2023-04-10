package quiz;

public class Plane implements Trans {

    @Override
    public void start(String name) {
        System.out.printf("%s가 이륙합니다.%n", name);
    }

    @Override
    public void stop(String name) {
        System.out.printf("%s가 착륙합니다.%n", name);
    }
}
