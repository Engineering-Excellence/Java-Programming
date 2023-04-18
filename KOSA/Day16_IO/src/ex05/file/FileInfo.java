package ex05.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileInfo {

    public static void main(String[] args) throws IOException {

        File file = null;
        byte[] fileName = new byte[100];
        String strName;

        // 상대경로: Day16_IO/src/ex05/file/memo.txt
        // 절대경로: /Users/kyle/Documents/Study/Java/KOSA/Day16_IO/src/ex05/file/memo.txt
        System.out.print("fileName: ");

        System.in.read(fileName);   // 예외 발생
        strName = new String(fileName).trim();  // 읽은 파일명을 문자열로 변환

        file = new File(strName);

        System.out.println("상대경로: " + file.getPath());
        System.out.println("절대경로: " + file.getAbsolutePath());
        System.out.println("표준경로: " + file.getCanonicalPath());
        System.out.println("파일크기: " + file.length());
        System.out.println("최종 수정일: " + new Date(file.lastModified()));
        System.out.println("읽기속성: " + file.canRead());
        System.out.println("쓰기속성: " + file.canWrite());
        System.out.println("숨김속성: " + file.isHidden());
    }
}
