package ex07.io.data;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx {

    public static void main(String[] args) throws IOException { // 예외 처리 위임

        File file = new File("Day016_IO/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file); // 예외 발생
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

        System.out.println(dataInputStream.readBoolean());
        System.out.println(dataInputStream.readChar());
        System.out.println(dataInputStream.readShort());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readLong());
        System.out.println(dataInputStream.readFloat());
        System.out.println(dataInputStream.readDouble());

        dataInputStream.close();
    }
}
