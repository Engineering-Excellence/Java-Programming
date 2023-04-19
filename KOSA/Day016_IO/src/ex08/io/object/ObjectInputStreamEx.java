package ex08.io.object;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        InputStream inputStream = new FileInputStream("Day016_IO/grade.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Grade dto = (Grade) objectInputStream.readObject();
        System.out.println("result output: " + dto);

        objectInputStream.close();
    }
}
