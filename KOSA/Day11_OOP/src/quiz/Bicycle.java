package quiz;

public class Bicycle extends Trans {

    public Bicycle() {
        name = "자전거";
    }

    @Override
    protected void start() {
        System.out.printf("%s가 출발합니다.%n", name);
    }

    @Override
    protected void stop() {
        System.out.printf("%s가 정지합니다.%n", name);
    }
}
