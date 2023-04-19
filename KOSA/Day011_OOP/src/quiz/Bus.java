package quiz;

class Bus extends Trans {

    public Bus() {
        name = "버스";
    }

    @Override
    protected void start() {
        System.out.printf("%s가 버스정류장에서 출발합니다.%n", name);
    }

    @Override
    protected void stop() {
        System.out.printf("%s가 버스정류장에 정지합니다.%n", name);
    }
}
