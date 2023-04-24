package ex03.net.tcp;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientChat {

    public static void main(String[] args) throws IOException {

        int port = 8000;
        String ip, str;

        PrintStream ps = new PrintStream(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ps.print("접속할 서버 IP: ");
        ip = br.readLine();
        ps.print("전송할 메시지: ");
        str = "\n" + br.readLine();

        byte[] buffer = str.getBytes(StandardCharsets.UTF_8);
        String message = new String(buffer, StandardCharsets.UTF_8);

        Socket client = new Socket(ip, port);

        OutputStream os = client.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write(message, 0, message.length());
        bw.flush();
        bw.close();
        client.close();
        ps.println(ip + "에 메시지 전송 성공!");
        ps.close();
    }
}
