package homework;

public class MainEntry {

    public static void main(String[] args) {

        TV tv = new TV();

        tv.display();   // 초기 상태

        System.out.println("=============================");

        tv.setColor("red");
        tv.setChannel(8);

        tv.display();
    }
}
