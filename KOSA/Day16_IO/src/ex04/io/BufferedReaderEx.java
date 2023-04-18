package ex04.io;

import java.io.*;

public class BufferedReaderEx {

    public static void main(String[] args) throws IOException {

        /*InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);*/

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Character Input: ");
        String s = bufferedReader.readLine();   // 예외 발생

        System.out.println(s);
    }
}
