package ex10.file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx {

    public static void main(String[] args) throws IOException {

//        RandomAccessFile randomAccessFile = new RandomAccessFile("Day016_IO/sawon.txt", "rw");
        RandomAccessFile randomAccessFile = new RandomAccessFile("Day016_IO/sawon.txt", "r");

        /*for (int i = 0; i <= 10; i++) {
            randomAccessFile.seek(i * 100);
//            randomAccessFile.writeInt(i);
            String str = "Hello";
            randomAccessFile.writeUTF(str);
        }*/

        for (int i = 0; i <= 10; i++) {
            randomAccessFile.seek(i * 100);
//            System.out.println(randomAccessFile.readInt());
            System.out.println(randomAccessFile.readUTF());
        }

        System.out.println("String Print Success!");
        randomAccessFile.close();
    }
}
