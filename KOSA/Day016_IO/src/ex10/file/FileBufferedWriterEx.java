package ex10.file;

import java.io.*;
import java.util.Date;

public class FileBufferedWriterEx {

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        String file;
        Date date = new Date();

        sb = sb.append("파일 생성 시간 \r\n").append(date).append("\r\n");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("파일 이름 입력(확장자 포함): ");
        file = br.readLine();
        System.out.print("저장할 문자열 입력: ");
        sb.append(br.readLine());

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(String.valueOf(sb));
        bufferedWriter.close();
        System.out.println(file + " 파일을 성공적으로 저장했습니다.");
    }
}
