package ex03.io;

import java.io.IOException;

public class InputStreamEx2 {

    public static void main(String[] args) throws IOException { // 예외처리를 JVM에게 위임

        int num = 0;

        System.out.println("데이터 입력 끝은 Ctrl+Z를 누르세요.");

        while ((num = System.in.read()) != -1) {
            System.out.print((char) num + "\t");
        }

        System.out.println();
    }
}
