package ex03.io;

import java.io.IOException;
import java.io.InputStream;

public class MainEntry {

    public static void main(String[] args) throws IOException { // 예외처리를 JVM에게 위임

        InputStream inputStream = System.in;    // 표준 입력

//        try {
            System.out.print("단일 문자 입력: ");
            int num = inputStream.read() - 48;   // 예외 발생, '0' ~ '9': 48 ~ 57 (ASCII code)
//            System.out.println((char) num);
            inputStream.read(); /*inputStream.read();*/ // 키보드 버퍼 제거
            int num2 = inputStream.read() - 48;

            System.out.println(num + num2);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }
}
