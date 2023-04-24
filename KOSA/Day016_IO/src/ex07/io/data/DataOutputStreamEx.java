package ex07.io.data;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx {

    public static void main(String[] args) throws IOException { // 예외 처리 위임

        File file = new File("Day016_IO/test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file); // 예외 발생
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        dataOutputStream.writeBoolean(true);    // 예외 발생
        dataOutputStream.writeChar(65); // ASCII code 'A'
        dataOutputStream.writeShort(100);
        dataOutputStream.writeInt(2100000000);
        dataOutputStream.writeLong(1000000000000L);
        dataOutputStream.writeFloat(12.34F);
        dataOutputStream.writeDouble(8.8);
        dataOutputStream.flush();   // buffer 비우기

        System.out.printf("test.txt 파일에 %s byte 저장%n", dataOutputStream.size());
        dataOutputStream.close();
    }
}
