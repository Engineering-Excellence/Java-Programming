package ex06.filecopy;

import java.io.*;

public class FileCopy {

    public static void main(String[] args) throws IOException {   // 예외 처리 위임

        // 읽기 객체: FileInputStream
        InputStream inputStream = new FileInputStream("Day16_IO/java.jpeg"); // 상대경로, 예외 발생
        // 텍스트는 캐릭터 단위로 읽을 수 있지만, 그 외에는 바이트 단위로만 읽기 가능

        // 쓰기 객체: FileOutputStream
        OutputStream outputStream = new FileOutputStream("Day16_IO/copy.png");

        byte[] buffer = new byte[1024 * 8];

        long start = System.currentTimeMillis();    // 시작시각 저장

        while (true) {
            int inputData = inputStream.read(buffer);   // buffer 크기 만큼 읽기
            if (inputData == -1) break;
            outputStream.write(buffer, 0, inputData);
        }

        long end = System.currentTimeMillis();  // 종료시각 저장

        System.out.println(end - start);    // 복사(작업)에 걸린 시간

        inputStream.close();
        outputStream.close();

        System.out.println("Copy Success");
    }
}
