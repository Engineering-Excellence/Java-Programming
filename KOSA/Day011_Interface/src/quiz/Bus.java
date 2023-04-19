package quiz;

class Bus implements Trans {

    private double speed = 0;

    @Override
    public void start(String name) {
        while (speed < 5) {
            System.out.printf("%s가 버스정류장에서 출발합니다. 속력: %.1f%n", name, speed);
            speed += accelerator * 5;
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   // while end
    }

    @Override
    public void stop(String name) {
        speed = 0;
        System.out.printf("%s가 버스정류장에 정지합니다.%n", name);
    }
}
