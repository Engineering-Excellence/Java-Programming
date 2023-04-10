package quiz;

class Subway implements Trans {

    @Override
    public void start(String name) {
        System.out.printf("%s이 지하철역에서 출발합니다.%n", name);
    }

    @Override
    public void stop(String name) {
        System.out.printf("지하철이 지하철역에 정지합니다.%n", name);
    }
}
