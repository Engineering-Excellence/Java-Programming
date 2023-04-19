package ex06.filecopy;

import java.io.*;

public class BinaryCopy {

    public static void main(String[] args) {

        File src = new File("/System/Applications/Time Machine.app/Contents/MacOS/Time Machine");
        File dist = new File("Day16_IO/Time Machine Copy");

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        int c;

        try {
            fileInputStream = new FileInputStream(src); // 파일입력바이트 스트림 연결
            fileOutputStream = new FileOutputStream(dist);  // 파일출력바이트 스트림 연결
            bufferedInputStream = new BufferedInputStream(fileInputStream); // 버퍼입력 스트림 연결
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);// 버퍼출력 스트림 연결

            while ((c = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write((char) c);
            }
            System.out.println("파일 복사 성공!");
        } catch (Exception e) {
            System.out.println("파일 복사 오류 발생");
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                bufferedOutputStream.close();
                fileOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
