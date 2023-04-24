package ex07.inner_class;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerEventMain {   // Outer Class

    /*class EventHandler implements ActionListener {  // Inner Class

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ActionEvent 발생 1");
            System.out.println(e.getActionCommand());
            System.out.println(e.getSource());
            System.out.println();
        }
    }*/

    public static void main(String[] args) {

        Frame frame = new Frame("이벤트 처리 - 내부클래스");  // 프레임(화면)
        Button btn = new Button("Button - Start");

        // 1.
        /*EventHandler handler = new InnerEventMain().new EventHandler();
        btn.addActionListener(handler); // 버튼에 액션이벤트 추가*/

        // 2.
        /*btn.addActionListener(new ActionListener() {  // 익명(무명) 클래스
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent 발생 2-1");
                System.out.println(e.getActionCommand());
                System.out.println(e.getSource());
                System.out.println();
            }
        });*/
        btn.addActionListener(e -> {
            System.out.println("ActionEvent 발생 2-2");
            System.out.println(e.getActionCommand());
            System.out.println(e.getSource());
            System.out.println();
        });

        // 3.
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.add(btn); // 프레임(윈도우)에 버튼 컴포넌트를 추가
        frame.setVisible(true); // 화면 표시
        frame.setSize(300, 200);
        frame.setLocation(300, 150);
    }
}
