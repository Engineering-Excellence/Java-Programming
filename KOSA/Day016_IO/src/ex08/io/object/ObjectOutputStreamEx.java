package ex08.io.object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamEx {

    public static void main(String[] args) throws IOException {

        Grade dto = new Grade();

//        dto.setSubject("미술");
//        dto.setScore(80);
        dto.setSubject("전산");
        dto.setScore(95);

        System.out.println(dto);

        OutputStream outputStream = new FileOutputStream("Day016_IO/grade.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(dto);
        objectOutputStream.close();
        System.out.println("파일 쓰기 완료");
    }
}
