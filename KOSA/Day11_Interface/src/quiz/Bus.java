package quiz;

class Bus implements Trans {

    @Override
    public void start(String name) {
        System.out.printf("%s가 버스정류장에서 출발합니다.%n", name);
    }

    @Override
    public void stop(String name) {
        System.out.printf("%s가 버스정류장에 정지합니다.%n", name);
    }
}
