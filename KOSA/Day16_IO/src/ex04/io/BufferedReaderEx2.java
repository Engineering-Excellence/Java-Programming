package ex04.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderEx2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Character Input: ");
        int num1 = Integer.parseInt(bufferedReader.readLine());
        System.out.print("Character Input: ");
        int num2 = Integer.parseInt(bufferedReader.readLine());

//        System.out.println(s1 + s2);
        System.out.println(num1 + num2);
    }
}
