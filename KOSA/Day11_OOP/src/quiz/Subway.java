package quiz;

class Subway extends Trans {

    public Subway() {
        name = "지하철";
    }

    @Override
    protected void start() {
        System.out.printf("%s이 지하철역에서 출발합니다.%n", name);
    }

    @Override
    protected void stop() {
        System.out.printf("%s이 지하철역에 정지합니다.%n", name);
    }
}
