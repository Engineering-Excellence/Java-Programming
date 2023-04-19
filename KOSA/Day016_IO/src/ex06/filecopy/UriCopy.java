package ex06.filecopy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class UriCopy {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.google.com/images/branding/googlelogo/2x/googlelogo_light_color_272x92dp.png");

        // 읽기 객체
        InputStream inputStream = url.openStream();

        // 쓰기 객체
        OutputStream outputStream = new FileOutputStream("Day16_IO/google.jpeg");

        byte[] buffer = new byte[1024 * 8];

        while (true) {
            int inputData = inputStream.read(buffer);
            if (inputData == -1) break;
            outputStream.write(buffer, 0, inputData);
        }

        outputStream.close();
        inputStream.close();
        System.out.println("웹에서 파일 복사 성공");
    }
}
