package ex04.thread;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GraphicThread extends JFrame implements Runnable {

    int x, y, num;
    Color color;
    Random random;

    public GraphicThread(int num) throws HeadlessException {    // 생성자 함수 - 초기화
        this.num = num;
//        color = Color.RED;
        color = Color.GREEN;
        random = new Random();
        setSize(500, 400);  // 프레임(화면) 크기 - 너비, 높이
        setVisible(true);   // 화면 보여주기

        setLocation(300, 150);  // 프레임(화면)의 위치 조정

//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // 닫기
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    // 닫기
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
//        g.fillRect(x, y, 10, 10);
        g.fillOval(x, y, 10, 10);
    }

    @Override
    public void run() { // 스레드 실행부(구현부)
        Rectangle rect = getBounds();

        for (int i = 0; i < num; i++) {
            x = random.nextInt(rect.width);
            y = random.nextInt(rect.height);

            repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }   // run end

    public static void main(String[] args) {

        /*// 1.
        GraphicThread gt = new GraphicThread(100);
        Thread t1 = new Thread(gt);
        t1.start();*/

        // 2.
        new Thread(new GraphicThread(200)).start();
    }
}
