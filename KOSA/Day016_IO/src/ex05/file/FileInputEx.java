package ex05.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class FileInputEx {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OutputStream outputStream = null;

        try {
//            outputStream = new FileOutputStream("test.txt");   // 상대경로
            outputStream = new FileOutputStream("/Users/kyle/test.txt");   // 절대경로
            while (true) {
                System.out.print("문자열 입력: ");
                String str = sc.nextLine() + "\r\n";
                if (str.equalsIgnoreCase("EXIT\r\n")) {
                    System.out.println(str.length() + "byte 만큼 쓰기 완료.");
                    break;
                }
                outputStream.write(str.getBytes()); // 예외 발생
                System.out.println(str);
            }   // while end
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
