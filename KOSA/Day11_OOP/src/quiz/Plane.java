package quiz;

public class Plane extends Trans {

    public Plane() {
        name = "비행기";
    }

    @Override
    protected void start() {
        System.out.printf("%s가 이륙합니다.%n", name);
    }

    @Override
    protected void stop() {
        System.out.printf("%s가 착륙합니다.%n", name);
    }
}
