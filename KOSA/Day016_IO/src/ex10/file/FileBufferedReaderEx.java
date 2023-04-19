package ex10.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileBufferedReaderEx {

    public static void main(String[] args) throws IOException {

        int i;
        String file;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("읽을 파일 이름 입력: ");
        file = bufferedReader.readLine();

        System.out.println(file + " 문서의 내용");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        while ((i = reader.read()) != -1) {
            System.out.print((char) i + "\t");
            if (fileReader.equals("\n")) System.out.println();
        }

        fileReader.close();
    }
}
